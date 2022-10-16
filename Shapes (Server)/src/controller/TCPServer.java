package controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import model.Shape;

public class TCPServer { 
	
	Object clientlock= new Object();

	public int PORT;
	
	List<ClientHandler> clientHandlers;

	public void runServer() throws IOException {
		
		clientHandlers = new ArrayList<>();
		
		ServerSocket serverSocket = new ServerSocket(PORT);

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {

				while (true) {
					try {
						Socket socket = serverSocket.accept();
						synchronized (clientlock) {
							clientHandlers.add(new ClientHandler(socket));
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}				
			}
		});
		thread.start();
	}

	public void sendList(List<Shape> shapes) {
		synchronized (clientlock) {
			for (ClientHandler clientHandler : clientHandlers) {
				clientHandler.sendList(shapes);
			}
		}
	}

	public int getPORT() {
		return PORT;
	}

	public void setPORT(int pORT) {
		PORT = pORT;
	}
	
}
