package Lab4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider extends JFrame implements ChangeListener {
	JLabel red , blue , green ; 
	JSlider redS , blueS , greenS ; 
	JPanel color;
	
	public Slider() {
		setSize(400,200);
		setTitle("RBG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel editColor = new JPanel(new GridLayout(3,2));
		redS = new JSlider(JSlider.HORIZONTAL , 0 , 255 , 0);
		blueS = new JSlider(JSlider.HORIZONTAL , 0 , 255 , 0);
		greenS = new JSlider(JSlider.HORIZONTAL , 0 , 255 , 0);
		
		red = new JLabel("Red = 0 ");
		red.setBackground(Color.red);
		red.setForeground(Color.white);
		red.setOpaque(true);
		
		blue = new JLabel("Blue = 0 ");
		blue.setBackground(Color.blue);
		blue.setForeground(Color.white);
		blue.setOpaque(true);
		
		green = new JLabel("Green = 0 ");
		green.setBackground(Color.green);
		green.setForeground(Color.white);
		green.setOpaque(true);
		
		editColor.add(redS);
		editColor.add(red);
		editColor.add(blueS);
		editColor.add(blue);
		editColor.add(greenS);
		editColor.add(green);
		add(editColor , BorderLayout.CENTER);
		
		redS.addChangeListener(this);
		blueS.addChangeListener(this);
		greenS.addChangeListener(this);
		
		color = new JPanel();
        color.setBackground(Color.BLACK);
        color.setPreferredSize(new java.awt.Dimension(100, 100));
        add(color, BorderLayout.EAST); 
        
        setVisible(true);
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		int r = redS.getValue();
		int b = blueS.getValue();
		int g = greenS.getValue();
		
		red.setText("R" + r );
		blue.setText("B" + b );
		green.setText("G" + g );
		
		color.setBackground(new Color(r,b,g));
	}
	
	public static void main(String[] args) {
		new Slider();
	}
}
