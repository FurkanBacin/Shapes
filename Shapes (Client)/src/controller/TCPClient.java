package controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import model.Shape;

public class TCPClient {
	
	private ObjectInputStream objectInputStream;
	
	public int PORT;
	public String IP;
	
	public List<Shape> shapeList = new ArrayList<>();
	
	byte[] byteArray;
	
	ShapeListener listener = null;
	
	public TCPClient(ShapeListener shapeListener) {
		this.listener = shapeListener;
	}

	public void runClient() throws ClassNotFoundException, UnknownHostException, IOException, InterruptedException {
		
		Socket socket = new Socket(IP, PORT);
		objectInputStream = new ObjectInputStream(socket.getInputStream());
		
		Thread threadOne = new Thread(new Runnable() {
			@Override
			public void run() {
		
				while(true) {
					try {
						byteArray = ((byte[]) objectInputStream.readObject());
						setShapeList((List) convertBytesToObject(byteArray));
						//System.out.println(shapeList);
						Thread threadTwo = new Thread(new Runnable() {

							@Override
							public void run() {
								listener.shapeListRetrieved(shapeList);
							}	
						});
						threadTwo.start();
							
					} catch (ClassNotFoundException | IOException e) {
						e.printStackTrace();
					}				
				}
			}
		});
		threadOne.start();
	}
	
	public static Object convertBytesToObject(byte[] bytes) throws IOException, ClassNotFoundException {
		
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
		ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);		
		return objectInputStream.readObject();	
	}

	public List<Shape> getShapeList() {
		return shapeList;
	}

	public void setShapeList(List<Shape> shapeList) {
		this.shapeList = shapeList;
	}
	
	public void setPORT(int pORT) {
		PORT = pORT;
	}

	public String getIp() {
		return IP;
	}

	public void setIp(String ip) {
		this.IP = ip;
	}
	
}
