package model;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public class Circle extends Shape implements Serializable{
	
	private static final long serialVersionUID = 3;

	public Circle(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);

	}
	
	public Circle() {
		
	}

	public void draw (Graphics g) {

		g.fillOval(x, y, width ,height);
		
	}	

}
