

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameFrame extends JFrame implements ActionListener{
	JPanel panel1 ;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JButton b6;
	JButton b7;
	JButton b8;
	JButton b9;
	JButton[][] arr = new JButton[3][3];
	int i=1;
	public GameFrame() {
		panel = new JPanel() ;
		b1 = new JButton();
		b1.setFont(new Font(Font.SANS_SERIF, Font.TYPE1_FONT, 80));
		
		b2 = new JButton();
		b2.setFont(new Font(Font.SANS_SERIF, Font.TYPE1_FONT, 80));
		
		b3 = new JButton();
		b3.setFont(new Font(Font.SANS_SERIF, Font.TYPE1_FONT, 80));
		
		b4 = new JButton();
		b4.setFont(new Font(Font.SANS_SERIF, Font.TYPE1_FONT, 80));
		
		b5 = new JButton();
		b5.setFont(new Font(Font.SANS_SERIF, Font.TYPE1_FONT, 80));
		
		b6 = new JButton();
		b6.setFont(new Font(Font.SANS_SERIF, Font.TYPE1_FONT, 80));
		
		b7 = new JButton();
		b7.setFont(new Font(Font.SANS_SERIF, Font.TYPE1_FONT, 80));
		
		b8 = new JButton();
		b8.setFont(new Font(Font.SANS_SERIF, Font.TYPE1_FONT, 80));
		
		b9 = new JButton();
		b9.setFont(new Font(Font.SANS_SERIF, Font.TYPE1_FONT, 80));
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		for(int i=0; i<3;i++) {
			for(int j=0; j<3; j++) {
				arr[i][j] = new JButton();
			}
		}
		arr[0][0] = b1;
		arr[0][1] = b2;
		arr[0][2] = b3;
		arr[1][0] = b4;
		arr[1][1] = b5;
		arr[1][2] = b6;
		arr[2][0] = b7;
		arr[2][1] = b8;
		arr[2][2] = b9;
		panel.setLayout(new GridLayout(3, 3));
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		panel.add(b7);
		panel.add(b8);
		panel.add(b9);
		this.setContentPane(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(480, 480);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String choise = "";
		if(i==1) {
			choise = "x";
		}
		else if(i==-1) {
			choise = "o";
		}
		
		
				if(e.getSource() == b1 && b1.getText().equals("")) {
					if(i==1) {
						b1.setForeground(Color.BLACK);
					}
					else {
						b1.setForeground(Color.RED);
					}
					b1.setText(choise);
					i=i*-1;
					}
				if(e.getSource() == b2 && b2.getText().equals("")) {
					if(i==1) {
						b2.setForeground(Color.BLACK);
					}
					else {
						b2.setForeground(Color.RED);
					}
					b2.setText(choise);
					i=i*-1;
					}
				if(e.getSource() == b3 && b3.getText().equals("")) {	
					if(i==1) {
						b3.setForeground(Color.BLACK);
					}
					else {
						b3.setForeground(Color.RED);
					}
					b3.setText(choise);
					i=i*-1;
				}
				if(e.getSource() == b4 && b4.getText().equals("")) {
					if(i==1) {
						b4.setForeground(Color.BLACK);
					}
					else {
						b4.setForeground(Color.RED);
					}
					b4.setText(choise);
					i=i*-1;
				}
				if(e.getSource() == b5 && b5.getText().equals("")) {	
					if(i==1) {
						b5.setForeground(Color.BLACK);
					}
					else {
						b5.setForeground(Color.RED);
					}
					b5.setText(choise);
					i=i*-1;
				}
				if(e.getSource() == b6 && b6.getText().equals("")) {	
					if(i==1) {
						b6.setForeground(Color.BLACK);
					}
					else {
						b6.setForeground(Color.RED);
					}
					b6.setText(choise);
					i=i*-1;
				}
				if(e.getSource() == b7 && b7.getText().equals("")) {
					if(i==1) {
						b7.setForeground(Color.BLACK);
					}
					else {
						b7.setForeground(Color.RED);
					}
					b7.setText(choise);
					i=i*-1;
				}
				if(e.getSource() == b8 && b8.getText().equals("")) {	
					if(i==1) {
						b8.setForeground(Color.BLACK);
					}
					else {
						b8.setForeground(Color.RED);
					}
					b8.setText(choise);
					i=i*-1;
				}
				if(e.getSource() == b9 && b9.getText().equals("")) {	
					if(i==1) {
						b9.setForeground(Color.BLACK);
					}
					else {
						b9.setForeground(Color.RED);
					}
					b9.setText(choise);
					i=i*-1;
				}
				
				if(isWinner(choise)) {
					JOptionPane.showMessageDialog(null, "game over winer is " + choise);
					this.dispose();
					System.exit(0);
				}
				else if(isFull()) {
					JOptionPane.showMessageDialog(null, "game over its a draw");
					this.dispose();
					System.exit(0);
				}
				
	}
	public boolean isFull() {
		int count = 0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++ ) {
				if(!arr[i][j].getText().isEmpty()) {
					count++;
				}
			}
		}
		if(count == 9) {
			return true;
		}
		return false;
	}
	
	public boolean isWinner(String choise) {
		int count = 0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(arr[i][j].getText().equals(choise)) {
					count++;
				}
				else {
					count = 0;
					break;
				}
				if(count == 3) {
					return true;
				}
			}
		}
		
		 count = 0;
		for(int j=0; j<3; j++) {
			for(int i=0; i<3; i++) {
				if(arr[i][j].getText().equals(choise)) {
					count++;
				}
				else {
					count = 0;
					break;
				}
				if(count == 3) {
					return true;
				}
			}
		}
		
		count = 0;
	for(int i=0; i<3; i++) {
		if(arr[i][i].getText().equals(choise)) {
			count++;
		}
		else {
			count = 0;
			break;
		}
		if(count == 3) {
			return true;
		}
	}
	count = 0;
	for(int i=0; i<3; i++) {
		for(int j=0; j<3; j++) {
			if(i+j == 2) {
				if(arr[i][j].getText().equals(choise)) {
					count++;
				}
				else {
					count = 0;
					break;
				}
			}
			if(count == 3) {
				return true;
			}
			
		}
	}
		
		
		
		
		
		return false;
	}
	
}
