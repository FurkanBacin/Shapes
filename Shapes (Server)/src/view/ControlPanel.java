package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ShapeController;
import controller.ShapeFactory;
import model.Shape;

public class ControlPanel extends JPanel {

	private ShapeController shapeController;
	ShapeFactory shapeFactory = new ShapeFactory();

	public ControlPanel(ShapeController shapeController) {
		
		this.shapeController = shapeController;
		setBackground(new Color(48, 51, 107));
		setBounds(0, 0, 200, 700);
		setLayout(new GridLayout(3, 3, 0, 0)); 

		JButton btnSquarePlus = new JButton("");
		btnSquarePlus.setBackground(new Color(48, 51, 107));
		btnSquarePlus.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/plus.png")));
		btnSquarePlus.setBorderPainted(false);

		btnSquarePlus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Shape squ = shapeFactory.getShape("square");
				shapeController.addShape(squ);

			}
		});

		JButton btnRectanglePlus = new JButton("");
		btnRectanglePlus.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/plus.png")));
		btnRectanglePlus.setBackground(new Color(48, 51, 107));
		btnRectanglePlus.setBorderPainted(false);

		btnRectanglePlus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Shape rect = shapeFactory.getShape("rectangle");
				shapeController.addShape(rect);

			}
		});

		JButton btnCirclePlus = new JButton("");
		btnCirclePlus.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/plus.png")));
		btnCirclePlus.setBackground(new Color(48, 51, 107));
		btnCirclePlus.setBorderPainted(false);

		btnCirclePlus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Shape circ = shapeFactory.getShape("circle");
				shapeController.addShape(circ);

			}
		});

		JLabel squareImage = new JLabel("");
		squareImage.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/square.png")));

		JLabel rectangeleImage = new JLabel("");
		rectangeleImage.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/rectangle.png")));

		JLabel circleImage = new JLabel("");
		circleImage.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/circle.png")));

		JButton btnRectangleMinus = new JButton("");
		btnRectangleMinus.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/minus.png")));
		btnRectangleMinus.setBackground(new Color(48, 51, 107));
		btnRectangleMinus.setBorderPainted(false);

		btnRectangleMinus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				shapeController.rectangleRemove();

			}
		});

		JButton btnCircleMinus = new JButton("");
		btnCircleMinus.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/minus.png")));
		btnCircleMinus.setBackground(new Color(48, 51, 107));
		btnCircleMinus.setBorderPainted(false);

		btnCircleMinus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				shapeController.circleRemove();

			}
		});

		JButton btnSquareMinus = new JButton("");
		btnSquareMinus.setIcon(new ImageIcon(MainFrame.class.getResource("/resources/minus.png")));
		btnSquareMinus.setBackground(new Color(48, 51, 107));
		btnSquareMinus.setBorderPainted(false);

		btnSquareMinus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				shapeController.squareRemove();

			}
		});

		add(btnSquarePlus);
		add(squareImage);
		add(btnSquareMinus);

		add(btnRectanglePlus);
		add(rectangeleImage);
		add(btnRectangleMinus);

		add(btnCirclePlus);
		add(circleImage);
		add(btnCircleMinus);

	}
}
