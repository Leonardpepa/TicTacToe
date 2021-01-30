package newTicTacToe;

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

	JPanel infoPanel;
	JPanel gamePanel;
	JButton[][] btns;

	private JLabel playersTurnLabel;
	private String player1;
	private String player2;
	private String playersTurn;
	private boolean AI;
	Random rand;
	
	
	public GamePanel(String player1, String player2, boolean ai) {
		this.player1 = player1;
		this.player2 = player2;
		this.AI = ai;
		player1.toUpperCase();
		player2.toUpperCase();
		playersTurn = player1;
		
		rand= new Random();
		
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
		if(AI) {
			vsAi(e);
		}
		else {
			twoPlayersGame(e);
		}
	}

	
	public void vsAi(ActionEvent e) {
		if (e.getSource() == btns[0][0] && btns[0][0].getText().equals("")) {
			draw(btns[0][0]);
		}
		if (e.getSource() == btns[0][1] && btns[0][1].getText().equals("")) {
			draw(btns[0][1]);
		}
		if (e.getSource() == btns[0][2] && btns[0][2].getText().equals("")) {
			draw(btns[0][2]);
		}
		if (e.getSource() == btns[1][0] && btns[1][0].getText().equals("")) {
			draw(btns[1][0]);
		}
		if (e.getSource() == btns[1][1] && btns[1][1].getText().equals("")) {
			draw(btns[1][1]);
		}
		if (e.getSource() == btns[1][2] && btns[1][2].getText().equals("")) {
			draw(btns[1][2]);
		}
		if (e.getSource() == btns[2][0] && btns[2][0].getText().equals("")) {
			draw(btns[2][0]);
		}
		if (e.getSource() == btns[2][1] && btns[2][1].getText().equals("")) {
			draw(btns[2][1]);
		}
		if (e.getSource() == btns[2][2] && btns[2][2].getText().equals("")) {
			draw(btns[2][2]);
		}
		if(gameOver()) {
			return;
		}
		
		
		if (playersTurn.equalsIgnoreCase(player2)) {
			
			int i = rand.nextInt(3);
			int j = rand.nextInt(3);
			while(!btns[i][j].getText().isEmpty() && !isFull()) {
				 i = rand.nextInt(3);
				 j = rand.nextInt(3);
			}
			
			draw(btns[i][j]);		}
		
		if(gameOver()) {
			return;
		}
		
	}
	
	public void twoPlayersGame(ActionEvent e) {
		
			if (e.getSource() == btns[0][0] && btns[0][0].getText().equals("")) {
				draw(btns[0][0]);
			}
			if (e.getSource() == btns[0][1] && btns[0][1].getText().equals("")) {
				draw(btns[0][1]);
			}
			if (e.getSource() == btns[0][2] && btns[0][2].getText().equals("")) {
				draw(btns[0][2]);
			}
			if (e.getSource() == btns[1][0] && btns[1][0].getText().equals("")) {
				draw(btns[1][0]);
			}
			if (e.getSource() == btns[1][1] && btns[1][1].getText().equals("")) {
				draw(btns[1][1]);
			}
			if (e.getSource() == btns[1][2] && btns[1][2].getText().equals("")) {
				draw(btns[1][2]);
			}
			if (e.getSource() == btns[2][0] && btns[2][0].getText().equals("")) {
				draw(btns[2][0]);
			}
			if (e.getSource() == btns[2][1] && btns[2][1].getText().equals("")) {
				draw(btns[2][1]);
			}
			if (e.getSource() == btns[2][2] && btns[2][2].getText().equals("")) {
				draw(btns[2][2]);
			}
			gameOver();

	}
	
	public void draw(JButton btn) {
		
		if(playersTurn.equalsIgnoreCase("X")) {
			btn.setForeground(Color.RED);
		}
		btn.setText(playersTurn);
		playersTurn = playersTurn.equals(player1) ? player2 : player1;
		playersTurnLabel.setText("player " + playersTurn + " turn");
	}

	public boolean isWinner(String choise) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (btns[i][j].getText().equalsIgnoreCase(choise)) {
					count++;
				} else {
					count = 0;
					break;
				}
				if (count == 3) {
					return true;
				}
			}
		}

		count = 0;
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				if (btns[i][j].getText().equalsIgnoreCase(choise)) {
					count++;
				} else {
					count = 0;
					break;
				}
				if (count == 3) {
					return true;
				}
			}
		}

		count = 0;
		for (int i = 0; i < 3; i++) {
			if (btns[i][i].getText().equalsIgnoreCase(choise)) {
				count++;
			} else {
				count = 0;
				break;
			}
			if (count == 3) {
				return true;
			}
		}
		count = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i + j == 2) {
					if (btns[i][j].getText().equalsIgnoreCase(choise)) {
						count++;
					} else {
						count = 0;
						break;
					}
				}
				if (count == 3) {
					return true;
				}

			}
		}
		return false;
	}
	
	
	public boolean isFull() {
		int count = 0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++ ) {
				if(!btns[i][j].getText().isEmpty()) {
					count++;
				}
			}
		}
		if(count == 9) {
			return true;
		}
		return false;
	}

	
	public boolean gameOver() {
		if(isWinner(playersTurn.equals(player1) ? player2: player1)) {
			JOptionPane.showMessageDialog(null, "game over winer is " + (playersTurn.equals(player1) ? player2: player1));
			this.dispose();
			new GameFrame();
			return true;
		}
		else if(isFull()) {
			JOptionPane.showMessageDialog(null, "game over its a draw");
			this.dispose();
			new GameFrame();
			return true;
		}
		return false;
	}
	

}
