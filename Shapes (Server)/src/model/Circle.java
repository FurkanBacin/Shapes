package model;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public class Circle extends Shape implements Serializable{

	private static final long serialVersionUID = 3;

	public Circle(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
		this.maxX = maxX-this.width;
		this.maxY = maxY-this.height;

	}
	
	public Circle() {
		
	}

	public void draw (Graphics g) {
		
		g.fillOval(x, y, width ,height);
		
		if(x > maxX || x < 0)
			speedX =- speedX;
		
		if(y > maxY || y < 0)
			speedY =- speedY;
		
		x = x + speedX;
		
		y = y + speedY;
	}	
}
	