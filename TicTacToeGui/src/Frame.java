

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Frame extends JFrame implements ActionListener{
	JLabel label ;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JButton b6;
	JButton b7;
	JButton b8;
	JButton b9;
	int i=1;
	public Frame() {
		label = new JLabel() ;
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
		
		label.setLayout(new GridLayout(3, 3));
		label.add(b1);
		label.add(b2);
		label.add(b3);
		label.add(b4);
		label.add(b5);
		label.add(b6);
		label.add(b7);
		label.add(b8);
		label.add(b9);
		this.setContentPane(label);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(480, 480);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean flagPlays = true;
		String choise = "x";
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
				
	}
	
	public boolean isWinner(String choise) {
		if(b1.getText().equals(choise) && b2.getText().equals(choise) && b3.getText().equals(choise) ) {
			return true;
		}
		if(b1.getText().equals(choise) && b4.getText().equals(choise) && b7.getText().equals(choise) ) {
			return  true;
		}
		
		if(b1.getText().equals(choise) && b5.getText().equals(choise) && b9.getText().equals(choise) ) {
			return true;
		}
		
		
		
		return false;
	}
	
}
