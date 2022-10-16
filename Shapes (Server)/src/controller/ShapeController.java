package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import model.Circle;
import model.Rectangle;
import model.Shape;
import model.Square;
import view.DrawPanel;

public class ShapeController {

	public List<Shape> shapeList = new ArrayList<>();

	private DrawPanel drawPanel;

	private TCPServer tcpServer;

	public ShapeController() {
		
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				
				while (true) {
					
					if (Objects.nonNull(drawPanel)) {
						drawPanel.repaint();
					}
						
					if (Objects.nonNull(tcpServer)) {
						tcpServer.sendList(shapeList);
					}
					
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}

	public void addShape(Shape shape) {
		shapeList.add(shape);
	}

	public void rectangleRemove() {

		Shape deleteShape = null;

		for (Shape shape : shapeList) {
			if (shape instanceof Rectangle) {
				deleteShape = shape;
			}
		}
		
		if (Objects.nonNull(deleteShape)) {
			shapeList.remove(deleteShape);
		}
	}

	public void circleRemove() {
		
		Shape deleteShape = null;

		for (Shape shape :shapeList) {
			if (shape instanceof Circle) {
				deleteShape = shape;
			}
		}
		
		if (Objects.nonNull(deleteShape)) {
			shapeList.remove(deleteShape);
		}
	}

	public void squareRemove() {
		
		Shape deleteShape = null;

		for (Shape shape : shapeList) {
			if (shape instanceof Square) {
				deleteShape = shape;
			}
		}
		
		if (Objects.nonNull(deleteShape)) {
			shapeList.remove(deleteShape);
		}
	}
	
	public void setDrawPanel(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;

	}

	public void setTcpServer(TCPServer tcpServer) {
		this.tcpServer = tcpServer;
		
	}
}
