package indiaproject;

import java.io.*;
import java.awt.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;

public class SendThread_E {

	ChatWindow_E chatWindow_E;
	private String remoteIP = "";
	private int port = 0;
	private String message = "";

	public SendThread_E(int port, ChatWindow_E window) {
		chatWindow_E = window;
	}

	public void notRun() {
		InetSocketAddress isa = new InetSocketAddress(remoteIP, port);
		try {
			Socket socket = new Socket();
			socket.connect(isa);
			OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
			writer.write(message);
			writer.flush();
			writer.close();
			System.out.println("将数据写入到流中");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			message = "";
		}
	}

	public void senMessage(String host, int port, String message) {
		remoteIP = host;
		this.port = port;
		this.message = message;
		notRun();
	}

}