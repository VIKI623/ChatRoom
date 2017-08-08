package indiaproject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FirstWindow extends JFrame {
	private JButton EngButton;
	private JButton ChiButton;

	private void Ini() {
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		setSize(400, 120);
		JPanel panel1 = new JPanel(new GridLayout(2, 2));
		panel1.setSize(400, 75);
		panel1.add(new JLabel("Choose a language for frame(选择语言)"));
		panel1.add(new JLabel(" "));
		c.add(panel1, BorderLayout.NORTH);
		JPanel panel2 = new JPanel(new GridLayout(2, 1));
		EngButton = new JButton("English");
		ChiButton = new JButton("Chinese");
		panel2.add(EngButton);
		panel2.add(ChiButton);
		c.add(panel2, BorderLayout.SOUTH);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void ActionInt() {

		EngButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				new ChatWindow_E();
				setVisible(false);
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

		ChiButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				new ChatWindow();
				setVisible(false);
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

	public FirstWindow() {
		Ini();
		ActionInt();
	}

	public static void main(String[] args) {
		new FirstWindow();
		// TODO 自动生成的方法存根

	}
}
