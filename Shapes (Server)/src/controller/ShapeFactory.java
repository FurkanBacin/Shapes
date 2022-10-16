package controller;

import java.awt.Color;

import model.Circle;
import model.Rectangle;
import model.Shape;
import model.Square;

public class ShapeFactory {
	
	public Shape getShape(String shapeType) {

		int squareSize = 30 + (int) (Math.random() * 250);

		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("circle")) {
			return new Circle((int) (Math.random() * 400), (int) (Math.random() * 400),
					50 + (int) (Math.random() * 200), +50 + (int) (Math.random() * 200), getRandomColor());
		} else if (shapeType.equalsIgnoreCase("rectangle")) {
			return new Rectangle((int) (Math.random() * 200), (int) (Math.random() * 300),
					100 + (int) (Math.random() * 300), 50 + (int) (Math.random() * 200), getRandomColor());
		} else if (shapeType.equalsIgnoreCase("square")) {
			return new Square((int) (Math.random() * 200), (int) (Math.random() * 400), squareSize, squareSize,
					getRandomColor());
		}
		return null;
	}

	public Color getRandomColor() {
		int r = (int) (Math.random() * 256);
		int g = (int) (Math.random() * 256);
		int b = (int) (Math.random() * 256);

		return new Color(r, g, b);
	}

}
