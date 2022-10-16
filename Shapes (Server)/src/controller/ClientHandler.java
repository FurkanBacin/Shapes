package controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import model.Shape;

public class ClientHandler {

	private Socket client;
	private ObjectOutputStream objectOutputStream;

	public ClientHandler(Socket clientSocket) throws IOException {
		this.client = clientSocket;
		objectOutputStream = new ObjectOutputStream(client.getOutputStream());
	}
	
	public byte[] convertObjectToByte(List<Shape> shapes) throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		objectOutputStream.writeObject(shapes);
		return byteArrayOutputStream.toByteArray();
	}

	public void sendList(List<Shape> shapes) {
		try {
			objectOutputStream.writeObject(convertObjectToByte(shapes));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
