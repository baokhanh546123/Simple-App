package Lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class SimplePaint extends JFrame {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final int COLOR_PANEL_WIDTH = 56;
    private static final int CLEAR_BUTTON_SIZE = 50;

    private final DrawingCanvas canvas;

    public SimplePaint() {
        setTitle("Simple Paint");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new DrawingCanvas();
        add(canvas);

        setVisible(true);
    }

    public static void main(String[] args) {
        new SimplePaint();
    }

    class DrawingCanvas extends JPanel implements MouseListener, MouseMotionListener {
        private BufferedImage canvasImage;
        private Graphics2D canvasGraphics;
        private boolean dragging = false;
        private int prevX, prevY;
        private int currentColorIndex = 0;

        private final Color[] colorPalette = {
            Color.BLACK, Color.RED, Color.GREEN,
            Color.BLUE, Color.CYAN, Color.MAGENTA, Color.YELLOW
        };

        public DrawingCanvas() {
            addMouseListener(this);
            addMouseMotionListener(this);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (canvasImage == null) {
                createEmptyCanvas();
            }

            g.drawImage(canvasImage, 0, 0, null);
            drawUI(g);
        }

        private void createEmptyCanvas() {
            canvasImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            canvasGraphics = canvasImage.createGraphics();
            canvasGraphics.setColor(Color.WHITE);
            canvasGraphics.fillRect(0, 0, getWidth(), getHeight());
        }

        private void drawUI(Graphics g) {
            int height = getHeight();
            int colorBoxHeight = (height - 56) / colorPalette.length;

            // Draw color boxes
            for (int i = 0; i < colorPalette.length; i++) {
                g.setColor(colorPalette[i]);
                g.fillRect(getWidth() - COLOR_PANEL_WIDTH + 3, 3 + i * colorBoxHeight, 50, colorBoxHeight - 3);
            }

            // Highlight current color
            g.setColor(Color.WHITE);
            g.drawRect(getWidth() - COLOR_PANEL_WIDTH + 2, 2 + currentColorIndex * colorBoxHeight, 52, colorBoxHeight - 1);

            // Draw "Clear" button
            g.setColor(Color.WHITE);
            g.fillRect(getWidth() - COLOR_PANEL_WIDTH + 3, height - CLEAR_BUTTON_SIZE - 3, 50, 50);
            g.setColor(Color.BLACK);
            g.drawRect(getWidth() - COLOR_PANEL_WIDTH + 3, height - CLEAR_BUTTON_SIZE - 3, 50, 50);
            g.drawString("Clear", getWidth() - COLOR_PANEL_WIDTH + 13, height - 23);
        }

        private void changeColor(int y) {
            int colorBoxHeight = (getHeight() - 56) / colorPalette.length;
            int newIndex = y / colorBoxHeight;

            if (newIndex >= 0 && newIndex < colorPalette.length) {
                currentColorIndex = newIndex;
                repaint();
            }
        }

        private void setDrawColor() {
            canvasGraphics.setColor(colorPalette[currentColorIndex]);
        }

        private void clearCanvas() {
            canvasGraphics.setColor(Color.WHITE);
            canvasGraphics.fillRect(0, 0, getWidth(), getHeight());
            repaint();
        }

        

        // Unused but required
        public void mouseMoved(MouseEvent e) {}
        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}

		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			if (!dragging) return;

            int x = Math.max(3, Math.min(e.getX(), getWidth() - COLOR_PANEL_WIDTH - 1));
            int y = Math.max(3, Math.min(e.getY(), getHeight() - 1));

            canvasGraphics.drawLine(prevX, prevY, x, y);
            prevX = x;
            prevY = y;
            repaint();
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			int x = e.getX();
            int y = e.getY();

            if (x > getWidth() - COLOR_PANEL_WIDTH) {
                if (y > getHeight() - CLEAR_BUTTON_SIZE - 3) {
                    clearCanvas();
                } else {
                    changeColor(y);
                }
                return;
            }

            if (x > 3 && x < getWidth() - COLOR_PANEL_WIDTH && y > 3 && y < getHeight() - 3) {
                dragging = true;
                prevX = x;
                prevY = y;
                setDrawColor();
            }
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			 dragging = false;
		}
    }
}
