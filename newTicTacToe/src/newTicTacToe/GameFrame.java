package newTicTacToe;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameFrame extends JFrame {
	private JPanel loginPanel;
	private JButton vsComputer;
	private JButton multiPlayer;
	private JLabel title;
	
	
	GameFrame(){
		loginPanel = new  JPanel();
		loginPanel.setLayout(null);
		
		vsComputer = new JButton("Play vs Computer");
		multiPlayer = new JButton("2 Players");
		title = new JLabel("Tic Tac Toe");
		
		title.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,60));
		title.setBounds(30, 30, 370, 60);
		
		
		vsComputer.setBounds(60, 150, 260, 60);
		multiPlayer.setBounds(60, 250, 260, 60);
		
		
		multiPlayer.addActionListener(e -> {
			String firstPlayersChoice = JOptionPane.showInputDialog("choose X or O");
			while(!firstPlayersChoice.equalsIgnoreCase("x") && !firstPlayersChoice.equalsIgnoreCase("o") ) {
				JOptionPane.showMessageDialog(null, "you can choose only X or O");
				firstPlayersChoice = JOptionPane.showInputDialog("choose X or O");
			}
			String secondPlayerChoice = firstPlayersChoice.equalsIgnoreCase("x") ?  "o":"x";
		    	new GamePanel(firstPlayersChoice, secondPlayerChoice, false);
		    	this.dispose();		    	
		});
		
		vsComputer.addActionListener(e -> {
			String playersChoice = JOptionPane.showInputDialog("choose X or O");
			while(!playersChoice.equalsIgnoreCase("x") && !playersChoice.equalsIgnoreCase("o") ) {
				JOptionPane.showMessageDialog(null, "you can choose only X or O");
				playersChoice = JOptionPane.showInputDialog("choose X or O");
			}
				new GamePanel(playersChoice,playersChoice.equalsIgnoreCase("x") ? "o":"x", true);
				this.dispose();
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
