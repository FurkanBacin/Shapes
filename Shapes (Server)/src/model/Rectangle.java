package model;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public class Rectangle extends Shape implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2;

	public Rectangle(int x, int y, int width, int height, Color color) {
		
		super(x, y, width, height, color);
		this.maxX = maxX-this.width;
		this.maxY = maxY-this.height;
	}
	
	public Rectangle() {
		
	}

	public void draw(Graphics g) {
		g.fillRect(x, y, width, height);
		
		if(x > maxX || x < 0)
			speedX =- speedX;
		
		if(y > maxY || y < 0)
			speedY =- speedY;
		
		x = x + speedX;
		
		y = y + speedY;
	}	
}
