package app;

import java.io.*;
import java.net.*;

public class Rfc865UdpClient {
	public static void main(String[] args) {
		System.out.println("Initialising Client...");
		//
		// 1. Open UDP socket
		//
		final DatagramSocket socket;
		String hostname = args[0];
		int port = 17;

		try {
			InetAddress address = InetAddress.getByName(hostname);
			socket = new DatagramSocket();

			try {
				//
				// 2. Send UDP request to server
				//
				String reqData = "Nigel Ang Wei Jun, TS3, 10.27.87.15";
				byte[] reqPacket = reqData.getBytes();
				System.out.println(reqPacket.length);

				DatagramPacket request = new DatagramPacket(reqPacket, reqPacket.length, address, port);
				socket.send(request);

				//
				// 3. Receive UDP reply from server
				//
				byte[] resBuffer = new byte[512];
				DatagramPacket response = new DatagramPacket(resBuffer, resBuffer.length);
				socket.receive(response);

				String responseStr = new String(resBuffer, 0, response.getLength());
				System.out.println(responseStr);
			} catch (IOException e) {
				System.out.println("I/O Exception: " + e.getMessage());
			}
		} catch (SocketException e) {
			System.out.println("Socket Exception: " + e.getMessage());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}
}