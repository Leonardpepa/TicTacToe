package com;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class GamePanel extends JFrame implements ActionListener {

	private static final long serialVersionUID = 614745343616307526L;
	private JPanel infoPanel;
	private JPanel gamePanel;
	private JButton[][] btns;

	private JLabel playersTurnLabel;
	private String player1;
	private String player2;
	private String playersTurn;
	private boolean AI;
	private Random rand;

	public GamePanel(String player1, String player2, boolean ai) {
		this.player1 = player1;
		this.player2 = player2;

		this.AI = ai;
		player1.toUpperCase();
		player2.toUpperCase();
		playersTurn = player1;

		rand = new Random(System.currentTimeMillis());

		infoPanel = new JPanel();
		infoPanel.setBounds(0, 0, 485, 80);
		infoPanel.setBackground(Color.white);
		infoPanel.setBorder(new LineBorder(Color.CYAN, 10));

		playersTurnLabel = new JLabel("player " + player1 + " start");
		playersTurnLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));

		infoPanel.add(playersTurnLabel);

		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(3, 3));
		gamePanel.setBounds(0, 80, 485, 380);

		btns = new JButton[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				btns[i][j] = new JButton();
				btns[i][j].setName(i + "#" + j);
				btns[i][j].setFont(new Font(Font.SANS_SERIF, Font.TYPE1_FONT, 80));
				btns[i][j].setBackground(Color.cyan);
				btns[i][j].setBorder(new MatteBorder(4, 4, 4, 4, Color.BLACK));
				btns[i][j].addActionListener(this);
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gamePanel.add(btns[i][j]);
			}
		}

		this.setLayout(null);
		this.add(infoPanel);
		this.add(gamePanel);

		this.setTitle("Tic Tac Toe");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (AI) {
			vsAi(e);
		} else {
			twoPlayersGame(e);
		}
	}

	public void changeTurn() {
		playersTurn = playersTurn.equals(player1) ? player2 : player1;
		playersTurnLabel.setText("player " + playersTurn + " turn");
	}

	public void vsAi(ActionEvent e) {

		twoPlayersGame(e);

		if (playersTurn.equalsIgnoreCase(player2)) {

			int i = rand.nextInt(3);
			int j = rand.nextInt(3);
			while (!btns[i][j].getText().isEmpty() && !isFull()) {
				i = rand.nextInt(3);
				j = rand.nextInt(3);
			}
			if (playMove(btns[i][j])) {
				checkGameOver();
				changeTurn();
			}
		}

	}

	public void twoPlayersGame(ActionEvent e) {
		JButton btnPressed = (JButton) e.getSource();
		int i = Integer.valueOf(btnPressed.getName().split("#")[0]);
		int j = Integer.valueOf(btnPressed.getName().split("#")[1]);
		if (playMove(btns[i][j])) {
			checkGameOver();
			changeTurn();
		}

	}

	public boolean playMove(JButton btn) {
		if (!btn.getText().equals("")) {
			return false;
		}

		if (playersTurn.equalsIgnoreCase("X")) {
			btn.setForeground(Color.RED);
		}
		btn.setText(playersTurn);
		return true;
	}

	public boolean isWinner(String choise) {

		for (int i = 0; i < 3; i++) {
			if (btns[i][0].getText().equalsIgnoreCase(choise) && btns[i][1].getText().equalsIgnoreCase(choise)
					&& btns[i][2].getText().equalsIgnoreCase(choise)) {
				return true;
			}
		}

		for (int j = 0; j < 3; j++) {
			if (btns[0][j].getText().equalsIgnoreCase(choise) && btns[1][j].getText().equalsIgnoreCase(choise)
					&& btns[2][j].getText().equalsIgnoreCase(choise)) {
				return true;
			}
		}

		for (int i = 0; i < 3; i++) {
			if (!btns[i][i].getText().equalsIgnoreCase(choise)) {
				return false;
			}
		}

		return true;
	}

	public boolean isFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (btns[i][j].getText().equalsIgnoreCase("")) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean checkGameOver() {
		if (isWinner(playersTurn)) {
			JOptionPane.showMessageDialog(null, "game over winer is " + playersTurn);
			this.dispose();
			new GameFrame();
			return true;
		} else if (isFull()) {
			JOptionPane.showMessageDialog(null, "game over its a draw");
			this.dispose();
			new GameFrame();
			return true;
		}
		return false;
	}

}
