package view;

import java.awt.Graphics;

import javax.swing.JPanel;

import controller.ShapeController;

import model.Shape;

public class DrawPanel extends JPanel {

	private ShapeController shapeController;
	
	public DrawPanel(ShapeController shapeController) {
		this.shapeController = shapeController;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		synchronized (shapeController.shapes) {
			for (Shape shape : shapeController.shapes) {
				g.setColor(shape.getColor());
				shape.draw(g);
			}
		}
		
	}
}