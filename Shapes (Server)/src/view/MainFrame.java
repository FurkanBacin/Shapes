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
import controller.TCPServer;

public class MainFrame extends JFrame {
	
	int portNumber;

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

	public MainFrame() throws IOException {
		JFrame portFrame = new JFrame();
		
		portFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/resources/server.png")));
		portFrame.setBounds(0,0,250,150);
		portFrame.setVisible(true);
		portFrame.setBackground(new Color(48, 51, 107));
		portFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel portPanel = new JPanel();
		
		portPanel.setBounds(0,0,250,150);
		portPanel.setBackground(new Color(149, 175, 192));
		
		JLabel info = new JLabel("Welcome, set your server port number.");
		portPanel.add(info);
		
		JLabel port = new JLabel("Port Number:");
		portPanel.add(port, BorderLayout.WEST);
		
		JTextField textField = new JTextField("", 10);
		portPanel.add(textField, BorderLayout.CENTER);
		
		JButton button = new JButton("Start");
		portPanel.add(button, BorderLayout.PAGE_END);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				portNumber = Integer.parseInt(textField.getText());
				try {
					portFrame.dispose();
					initialize();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		portFrame.add(portPanel);
	}

	private void initialize() throws IOException {
		
		ShapeController shapeController = new ShapeController();
		setVisible(true);
		setTitle("Bouncing Shapes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 700);
		setLayout(new BorderLayout());
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/resources/shapes.png")));

		ControlPanel controlPanel = new ControlPanel(shapeController);
		controlPanel.setBounds(0, 0, 200, 700);
		add(controlPanel, BorderLayout.WEST);

		DrawPanel drawPanel = new DrawPanel(shapeController);
		drawPanel.setBounds(200, 0, 800, 700);
		drawPanel.setBackground(new Color(149, 175, 192));
		add(drawPanel, BorderLayout.CENTER);

		shapeController.setDrawPanel(drawPanel);
		
		TCPServer tcpServer = new TCPServer();
		shapeController.setTcpServer(tcpServer);
		tcpServer.setPORT(portNumber);
		tcpServer.runServer();
	
	}
}
