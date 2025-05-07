package Lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyboardEvent extends JFrame implements KeyListener, FocusListener, MouseListener {

    static final int SQUARE_SIZE = 40;
    static final int MARGIN = 3;

    Color squareColor;
    int squareTop, squareLeft;
    boolean focused = false;
    DisplayPanel canvas;

    public KeyboardEvent() {
        setTitle("KeyboardEvent");
        setSize(1000, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        squareTop = getHeight() / 2 - SQUARE_SIZE / 2;
        squareLeft = getWidth() / 2 - SQUARE_SIZE / 2;
        squareColor = Color.RED;

        canvas = new DisplayPanel();
        setContentPane(canvas);
        canvas.setBackground(Color.WHITE);
        canvas.setFocusable(true);
        canvas.addFocusListener(this);
        canvas.addKeyListener(this);
        canvas.addMouseListener(this);

        setVisible(true);
    }

    class DisplayPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(focused ? Color.CYAN : Color.LIGHT_GRAY);
            int width = getWidth();
            int height = getHeight();

            for (int i = 0; i < 3; i++) {
                g.drawRect(i, i, width - 1 - 2 * i, height - 1 - 2 * i);
            }

            g.setColor(squareColor);
            g.fillRect(squareLeft, squareTop, SQUARE_SIZE, SQUARE_SIZE);

            if (!focused) {
                g.setColor(Color.MAGENTA);
                g.drawString("Click to activate", 7, 20);
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        canvas.requestFocus();
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public void focusGained(FocusEvent e) {
        focused = true;
        canvas.repaint();
    }

    public void focusLost(FocusEvent e) {
        focused = false;
        canvas.repaint();
    }

    public void keyTyped(KeyEvent e) {
        char ch = Character.toLowerCase(e.getKeyChar());

        switch (ch) {
            case 'b':
                squareColor = Color.BLUE;
                break;
            case 'g':
                squareColor = Color.GREEN;
                break;
            case 'r':
                squareColor = Color.RED;
                break;
            case 'k':
                squareColor = Color.BLACK;
                break;
        }
        canvas.repaint();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        int panelWidth = canvas.getWidth();
        int panelHeight = canvas.getHeight();

        switch (key) {
            case KeyEvent.VK_LEFT:
                squareLeft = Math.max(MARGIN, squareLeft - 8);
                break;
            case KeyEvent.VK_RIGHT:
                squareLeft = Math.min(panelWidth - MARGIN - SQUARE_SIZE, squareLeft + 8);
                break;
            case KeyEvent.VK_DOWN:
                squareTop = Math.min(panelHeight - MARGIN - SQUARE_SIZE, squareTop + 8);
                break;
            case KeyEvent.VK_UP:
                squareTop = Math.max(MARGIN, squareTop - 8);
                break;
        }
        canvas.repaint();
    }

    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        new KeyboardEvent();
    }
}
