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
	private JPanel container;

	public GamePanel(String player1, String player2, boolean ai) {
		this.player1 = player1;
		this.player2 = player2;

		this.AI = ai;
		player1.toUpperCase();
		player2.toUpperCase();
		playersTurn = player1;

		container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

		infoPanel = new JPanel();
		infoPanel.setBackground(Color.white);
		infoPanel.setBorder(new LineBorder(Color.CYAN, 10));

		playersTurnLabel = new JLabel("player " + player1 + " start");
		playersTurnLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));

		infoPanel.add(playersTurnLabel);

		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(3, 3));

		btns = new JButton[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				btns[i][j] = new JButton();
				btns[i][j].setPreferredSize(new Dimension(161, 119));
				btns[i][j].setSize(new Dimension(161, 119));
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

		container.add(infoPanel, BoxLayout.X_AXIS);
		container.add(gamePanel, BoxLayout.Y_AXIS);
		this.setContentPane(container);
		this.setTitle("Tic Tac Toe");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
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

			int bestScore = Integer.MIN_VALUE;
			int[] move = new int[2];

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (btns[i][j].getText().equalsIgnoreCase("")) {
						btns[i][j].setText(player2);
						int score = minimax(btns, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, false);
						btns[i][j].setText("");
						if (score > bestScore) {
							bestScore = score;
							move[0] = i;
							move[1] = j;
						}
					}
				}
			}
			if (playMove(btns[move[0]][move[1]]) && !checkGameOver()) {
				changeTurn();
			}
		}

	}

	public int eval(int depth, int alpha, int beta, boolean isMax) {
		int bestScore = isMax ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (btns[i][j].getText().equalsIgnoreCase("")) {
					btns[i][j].setText(isMax ? player2 : player1);
					int score = minimax(btns, depth + 1, alpha, beta, isMax ? false : true);
					bestScore = isMax ? Math.max(score, bestScore) : Math.min(score, bestScore);
					btns[i][j].setText("");
					if (isMax) {
						alpha = Math.max(alpha, score);
					} else {
						beta = Math.min(beta, score);
					}
					if (beta <= alpha) {
						return bestScore;
					}
				}
			}
		}
		return bestScore;
	}

	private int minimax(JButton[][] board, int depth, int alpha, int beta, boolean isMax) {

		int result = checkWinner(isMax ? player2 : player1);
		if (result != -100) {
			return result;
		}
		return eval(depth, alpha, beta, isMax);
	}

	private int checkWinner(String player) {
		if (isWinner(player)) {
			return player.equalsIgnoreCase(player2) ? 10 : -10;
		} else if (isFull()) {
			return 0;
		}
		return -100;
	}

	public void twoPlayersGame(ActionEvent e) {
		JButton btnPressed = (JButton) e.getSource();
		int i = Integer.valueOf(btnPressed.getName().split("#")[0]);
		int j = Integer.valueOf(btnPressed.getName().split("#")[1]);
		if (playMove(btns[i][j]) && !checkGameOver()) {
			changeTurn();
		}

	}

	public boolean playMove(JButton btn) {
		if (!btn.getText().equalsIgnoreCase("")) {
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

		if (btns[0][2].getText().equalsIgnoreCase(choise) && btns[1][1].getText().equalsIgnoreCase(choise)
				&& btns[2][0].getText().equalsIgnoreCase(choise)) {
			return true;
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

	public int minmax() {

		return 0;
	}

	public boolean checkGameOver() {
		if (isWinner(playersTurn)) {
			playersTurnLabel.setText("winer is " + playersTurn);
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
