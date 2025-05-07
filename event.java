package Lab3;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class event extends JFrame implements ActionListener{
	JRadioButton red , blue , green , black ;
	JLabel label ; 
	
	public event() {
		// TODO Auto-generated constructor stub
		setSize(500,250);
		setTitle("Event");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(5,1));
		
		ButtonGroup colorGrop = new ButtonGroup();
		
		red = new JRadioButton("Red");
		colorGrop.add(red);
		red.addActionListener(this);
		add(red);
		
		blue = new JRadioButton("Blue");
		colorGrop.add(blue);
		blue.addActionListener(this);
		add(blue);
		
		green = new JRadioButton("Green");
		colorGrop.add(green);
		green.addActionListener(this);
		add(green);
		
		black = new JRadioButton("Black");
		colorGrop.add(black);
		black.addActionListener(this);
		add(black);
		
		red.setSelected(true);
		
		
		label = new JLabel("Red is selected" , JLabel.CENTER);
		label.setForeground(Color.white);
		label.setBackground(Color.red);
		label.setOpaque(true);
		add(label);
		
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == red) {
			label.setBackground(Color.red);
			label.setText("Red is MU");
		}else if(e.getSource() == blue) {
			label.setBackground(Color.blue);
			label.setText("Blue is MC");
		}else if(e.getSource() == green) {
			label.setBackground(Color.green);
			label.setText("Green is green");
		}else if(e.getSource() == black) {
			label.setBackground(Color.black);
			label.setText("Green is black");
		}
		
	}
	public static void main(String[] args) {
		new event();
	}
	
}
