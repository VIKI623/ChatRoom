package indiaproject;

import java.io.*;
import java.awt.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;

public class ChatWindow_E extends JFrame {

	private JButton sendButton;
	private JButton cancelButton;
	private JButton receiveButton;
	private JTextArea receiveText;
	private JTextField sendText;

	private JLabel localPort;

	private JTextField remoteAddress;
	private JTextField remotePort;
	private SendThread_E sendThread;
	private ReceiveThread_E receiveThread;

	private void GUIini() {
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		setSize(400, 520);

		// ��һ��panel
		JPanel panel1 = new JPanel(new GridLayout(4, 2));
		// JPanel panel1 = new JPanel(new (4, 2));
		panel1.setSize(400, 75);
		panel1.add(new JLabel("Your computer IP Address is :"));
		try {
			panel1.add(new JLabel(InetAddress.getLocalHost().getHostAddress()));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch blocks
			panel1.add(new JLabel("Your computer IP Address:" + "Unknown"));
		}
		panel1.add(new JLabel("The current conversation port is :"));
		panel1.add(localPort = new JLabel("" + 0));
		panel1.add(new JLabel("Remote Host IP Address:"));
		remoteAddress = new JTextField();
		remoteAddress.setColumns(0);
		panel1.add(remoteAddress);
		panel1.add(new JLabel("Remote Host Port:"));
		remotePort = new JTextField();
		remotePort.setColumns(0);
		panel1.add(remotePort);
		c.add(panel1, BorderLayout.NORTH);

		// �ڶ���panel
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
		panel2.setSize(400, 200);
		panel2.add(new JLabel("Received Content"));
		receiveText = new JTextArea(15, 30);
		receiveText.setEditable(false);
		receiveText.setAutoscrolls(true);
		JScrollPane jsp = new JScrollPane(receiveText);
		panel2.add(jsp);
		// ������panel
		// JPanel panel3 = new JPanel(new GridLayout(2, 1));
		panel2.add(new JLabel("Please enter the contents of sent "));
		sendText = new JTextField(30);
		sendText.setAutoscrolls(true);
		panel2.add(sendText);
		c.add(panel2, BorderLayout.CENTER);
		// c.add(panel3);
		// ���ĸ�panel
		JPanel panel4 = new JPanel(new GridLayout(1, 0));
		panel4.setSize(400, 20);
		sendButton = new JButton("Send");
		cancelButton = new JButton("Clear");
		panel4.add(cancelButton);
		panel4.add(sendButton);
		c.add(panel4, BorderLayout.SOUTH);
		// �ĸ���������������

		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void ActionIni() {

		// ���̶���
		sendText.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (sendText.getText().equals("") != true) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						// �����ı�
						sendThread.senMessage(remoteAddress.getText(), Integer.parseInt(remotePort.getText()),
								sendText.getText());
						receiveText.setText(receiveText.getText() + "Send:" + sendText.getText() + "\n");
						sendText.setText("");
					}
				}
			}
		});

		// ȡ����ť�Ķ���
		cancelButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				receiveText.setText("");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		sendButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// �����ı�
				if (sendText.getText().equals("") != true) {
					sendThread.senMessage(remoteAddress.getText(), Integer.parseInt(remotePort.getText()),
							sendText.getText());
					receiveText.setText(receiveText.getText() + "Send:" + sendText.getText() + "\n");
					sendText.setText("");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	private void ThreadIni() {
		// TODO Auto-generated method stub
		sendThread = new SendThread_E(0, this);
		receiveThread = new ReceiveThread_E(this);
	}

	// ���캯��
	public ChatWindow_E() {
		GUIini();
		ActionIni();
		ThreadIni();
	}

	public void printError(String err) {
		System.out.println("Error occur:" + err);
	}

	// �ص�����,���ڽ��ܴ��߳��з��ص�����
	public void setReceive(String receive) {
		receiveText.setText(receiveText.getText() + "Receive:" + receive + "\n");
	}

	// ���������ݵ��߳̿�ʼ�����Ժ󣬾͵��øûص����������õ�ǰ���촰��ʹ�õĶ˿����ĸ�
	public void setLocalPort(int localPortText) {
		localPort.setText("" + localPortText);
	}
}