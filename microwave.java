package microwave;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;


public class microwave extends JFrame {
	JButton number1 , number2 , number3 , number4 , number5 , number6 , number7 , number8 , number9 , number0 , numberStart , numberStop;

	JTextField text  , label ;; 
	
	public microwave() {
		setSize(300,500);
		setTitle("MicroWave");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(10,10));
		
		text = new JTextField("Food to be placed here");
		text.setEditable(false);
		add(text , BorderLayout.CENTER);
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		
		label = new JTextField("Time to be displayed here");
		label.setHorizontalAlignment(JTextField.CENTER);
		label.setEditable(false);
		
		p.add(label , BorderLayout.NORTH);
		
		
		JPanel buttonPanel = new JPanel(new GridLayout(4 , 3 , 5 , 5));
		
		number1 = new JButton("1");
		number2 = new JButton("2");
		number3 = new JButton("3");
		number4 = new JButton("4");
		number5 = new JButton("5");
		number6 = new JButton("6");
		number7 = new JButton("7");
		number8 = new JButton("8");
		number9 = new JButton("9");
		number0 = new JButton("0");
		numberStart = new JButton("Start");
		numberStop = new JButton("Stop");
		
		buttonPanel.add(number0);
		buttonPanel.add(number1);
		buttonPanel.add(number2);
		buttonPanel.add(number3);
		buttonPanel.add(number4);
		buttonPanel.add(number5);
		buttonPanel.add(number6);
		buttonPanel.add(number7);
		buttonPanel.add(number8);
		buttonPanel.add(number9);
		buttonPanel.add(numberStart);
		buttonPanel.add(numberStop);
		p.add(buttonPanel , BorderLayout.CENTER);
		add(p , BorderLayout.EAST);
		
		setVisible(true);
		
	}
	
	 public static void main(String[] args) {
	        new microwave(); 
	    }
}
