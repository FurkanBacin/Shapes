package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ShapeController;
import controller.TCPClient;

public class MainFrame extends JFrame {
	
	int portNumber;
	String ipNumber;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() throws ClassNotFoundException, IOException, InterruptedException{
		JFrame portFrame = new JFrame();
		
		portFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/resources/client.png")));
		portFrame.setBounds(0,0,250,150);
		portFrame.setVisible(true);
		portFrame.setBackground(new Color(149, 175, 192));
		portFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel portPanel = new JPanel();
		
		portPanel.setBounds(0,0,250,150);
		portPanel.setBackground(new Color(149, 175, 192));
		
		JLabel info = new JLabel("Set your client port and ip number");
		portPanel.add(info);
		
		JLabel port = new JLabel("Port Number:         ");
		portPanel.add(port, BorderLayout.WEST);
		
		JTextField portTextField = new JTextField("", 10);
		portPanel.add(portTextField, BorderLayout.CENTER);
		
		JLabel ip = new JLabel("IP:                            ");
		portPanel.add(ip, BorderLayout.WEST);
		
		JTextField ipTextField = new JTextField("", 10);
		portPanel.add(ipTextField, BorderLayout.CENTER);
		
		JButton button = new JButton("Start");
		portPanel.add(button, BorderLayout.PAGE_END);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				portNumber = Integer.parseInt(portTextField.getText());
				ipNumber = ipTextField.getText();
				
					portFrame.dispose();
					try {
						initialize();
					} catch (ClassNotFoundException | IOException | InterruptedException e1) {
						e1.printStackTrace();
					}
			}
		});
		portFrame.add(portPanel);
	}
	
	private void initialize() throws ClassNotFoundException, IOException, InterruptedException{
		
		ShapeController shapeController = new ShapeController();
		
		setVisible(true);
		setTitle("Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 700);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/resources/shapes.png")));
		
		DrawPanel drawPanel = new DrawPanel(shapeController);
		drawPanel.setBounds(0, 0, 800, 700);
		drawPanel.setBackground(new Color(149, 175, 192));
		
		add(drawPanel);	
		
		shapeController.setDrawPanel(drawPanel);
		
		TCPClient tcpClient = new TCPClient(shapeController);
		tcpClient.setPORT(portNumber);
		tcpClient.setIp(ipNumber);
		tcpClient.runClient();
		
	}
}
