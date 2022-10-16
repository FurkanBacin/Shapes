package model;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public class Square extends Shape implements Serializable{
	
	private static final long serialVersionUID = 1;

	public Square(int x, int y, int width, int height, Color color) {
		
		super(x, y, width, height, color);
		
	}
	
	public Square() {
		
	}

	public void draw(Graphics g) {
		
		g.fillRect(x, y, width, height);
		
	}

}
