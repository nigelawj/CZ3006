package app;

import java.io.*;
import java.net.*;

public class Rfc865UdpServer {
	public static void main(String[] args) {
		System.out.println("Initialising Server...");
		//
		// 1. Open UDP socket at well-known port
		//

		final DatagramSocket socket;
		try {
			socket = new DatagramSocket(17);

			while (true) {
				try {
					//
					// 2. Listen for UDP request from client
					//
					byte[] reqBuffer = new byte[512];
					DatagramPacket request = new DatagramPacket(reqBuffer, reqBuffer.length);
					socket.receive(request);

					// Print req data into string
					String requestStr = new String(reqBuffer, 0, request.getLength());
					System.out.println(requestStr);

					String data = "nice QOTD boi";
					byte[] resBuffer = data.getBytes();

					InetAddress clientAddress = request.getAddress();
					int clientPort = request.getPort();

					//
					// 3. Send UDP reply to client
					//
					DatagramPacket response = new DatagramPacket(resBuffer, resBuffer.length, clientAddress, clientPort);
					socket.send(response);
				} catch (IOException e) {
					System.out.println("I/O error: " + e.getMessage());
				}
			}
		} catch (SocketException e) {
			System.out.println("Socket Error: " + e.getMessage());
		}
	}
}