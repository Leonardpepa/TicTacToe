package com;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1011954987998509781L;
	private JPanel loginPanel;
	private JButton vsComputer;
	private JButton multiPlayer;
	private JLabel title;

	GameFrame() {
		loginPanel = new JPanel();
		loginPanel.setLayout(null);

		vsComputer = new JButton("Play vs Computer");
		multiPlayer = new JButton("2 Players");
		title = new JLabel("Tic Tac Toe");

		title.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 60));
		title.setBounds(30, 30, 370, 60);

		vsComputer.setBounds(60, 150, 260, 60);
		multiPlayer.setBounds(60, 250, 260, 60);

		multiPlayer.addActionListener(e -> {
			try {
				Object[] options = { "X", "O" };

				int choice = JOptionPane.showOptionDialog(null, "you can choose only X or O", null,
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

				while (choice != 0 && choice != 1) {
					JOptionPane.showMessageDialog(null, "you can choose only X or O");
					choice = JOptionPane.showOptionDialog(null, "you can choose only X or O", null,
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

				}

				String player1 = choice == 0 ? "X" : "O";
				String player2 = choice == 1 ? "X" : "O";

				new GamePanel(player1, player2, false);
				this.dispose();

			} catch (NullPointerException ex) {

			}
		});

		vsComputer.addActionListener(e -> {
			try {
				Object[] options = { "X", "O" };

				int choice = JOptionPane.showOptionDialog(null, "you can choose only X or O", null,
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

				while (choice != 0 && choice != 1) {
					JOptionPane.showMessageDialog(null, "you can choose only X or O");
					choice = JOptionPane.showOptionDialog(null, "you can choose only X or O", null,
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

				}

				String player1 = choice == 0 ? "X" : "O";
				String player2 = choice == 1 ? "X" : "O";

				new GamePanel(player1, player2, true);
				this.dispose();
			} catch (NullPointerException ex) {

			}
		});

		loginPanel.add(title);
		loginPanel.add(vsComputer);
		loginPanel.add(multiPlayer);

		this.setContentPane(loginPanel);
		this.setTitle("Tic Tac Toe");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);

	}

}
