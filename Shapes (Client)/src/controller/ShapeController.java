package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import model.Shape;
import view.DrawPanel;


public class ShapeController implements ShapeListener{
	
	public List<Shape> shapes = new ArrayList<>();
	
	private DrawPanel drawPanel;
	
	private TCPClient tcpClient;
	
	private boolean settingShapes = false;

	public ShapeController() {
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					
					if (Objects.nonNull(drawPanel)) {
						drawPanel.repaint();			
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

	public List<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(List<Shape> shapes) {
		this.shapes = shapes;
	}

	public void setDrawPanel(DrawPanel drawPanel) {
		this.drawPanel= drawPanel;
	}
	
	public void setTcpClient(TCPClient tcpClient) {
		this.tcpClient = tcpClient;	
	}
	
	@Override
	public void  shapeListRetrieved(List<Shape> shapeList) {
		if (!settingShapes) {
			settingShapes = true;
			synchronized (shapeList) {
				setShapes(shapeList);
			}		
			settingShapes = false;
		}
	}
}
