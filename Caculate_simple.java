package Lab3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Caculate_simple extends JFrame implements ActionListener{
	JLabel x , y  ;
	JTextField x_f , y_f , result_f ; 
	JButton plus , minus , multiply , divided ;
	
	public Caculate_simple() {
		setSize(300,150);
		setTitle("Caculate Simple");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel input = new JPanel(new GridLayout(2,2));
		x = new JLabel("x");
		input.add(x);
		x_f = new JTextField("0");
		input.add(x_f);
		y = new JLabel("y");
		input.add(y);
		y_f = new JTextField("0");
		input.add(y_f);
		add(input, BorderLayout.NORTH);
		
		JPanel buttonPanel = new JPanel(new FlowLayout());
		plus = new JButton("+");
		minus = new JButton("-");
		multiply = new JButton("*");
		divided = new JButton("/");
		
		buttonPanel.add(plus,FlowLayout.LEFT);buttonPanel.add(minus);buttonPanel.add(multiply);buttonPanel.add(divided);
		
		add(buttonPanel, BorderLayout.CENTER);
		
		result_f = new JTextField("Result : ");
		result_f.setHorizontalAlignment(SwingConstants.CENTER);
		add(result_f, BorderLayout.SOUTH);
		
		plus.addActionListener(this);
        minus.addActionListener(this);
        multiply.addActionListener(this);
        divided.addActionListener(this);
        
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		double x = Double.parseDouble(x_f.getText());
		double y = Double.parseDouble(y_f.getText());
		double result = 0 ;
		if (e.getSource() == plus) {
			result = x + y;
			String result_str = Double.toString(result);
			result_f.setText(result_str);
		}else if (e.getSource() == minus) {
			result = x - y;
			String result_str = Double.toString(result);
			result_f.setText(result_str);
		}else if (e.getSource() == multiply) {
			result = x * y ;
			String result_str = Double.toString(result);
			result_f.setText(result_str);
		}else if (e.getSource() == divided) {
			try {
				if (y == 0) {
					result_f.setText("Cannot divide by zero.");
                    return;
				}else {
					result =  x / y ;
					String result_str = Double.toString(result);
					result_f.setText(result_str);
				}
			}catch (NumberFormatException ex) {
				result_f.setText("Please enter valid numbers.");
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		new Caculate_simple();
	}

	
}
