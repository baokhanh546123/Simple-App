package Lab06;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class AnimatedClock extends JFrame {
    public AnimatedClock() {
        // Set up the JFrame
        setTitle("Display Clock");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Add the custom ClockPanel
        ClockPanel clockPanel = new ClockPanel();
        add(clockPanel);

        // Create a timer to update the clock every second (1000ms)
        Timer timer = new Timer(1000, e -> {
            clockPanel.repaint(); // Redraw the clock
        });
        timer.start(); // Start the timer
    }

    public static void main(String[] args) {
        // Run the application on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            AnimatedClock clock = new AnimatedClock();
            clock.setVisible(true);
        });
    }
}

class ClockPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;
        int radius = Math.min(width, height) / 2 - 20;

        // Draw the clock circle
        g2d.setColor(Color.BLACK);
        g2d.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

        // Draw the numbers (12, 3, 6, 9)
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString("12", centerX - 10, centerY - radius + 20);
        g2d.drawString("3", centerX + radius - 20, centerY + 5);
        g2d.drawString("6", centerX - 5, centerY + radius - 10);
        g2d.drawString("9", centerX - radius + 10, centerY + 5);

        // Get the current time
        Calendar calendar = Calendar.getInstance();
        int hours = calendar.get(Calendar.HOUR); // 12-hour format
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);

        // Calculate angles for the clock hands
        double secondAngle = Math.toRadians((seconds / 60.0) * 360 - 90);
        double minuteAngle = Math.toRadians((minutes / 60.0) * 360 - 90 + (seconds / 60.0) * 6);
        double hourAngle = Math.toRadians((hours % 12 / 12.0) * 360 - 90 + (minutes / 60.0) * 30);

        // Draw the second hand (red)
        int secondHandLength = radius - 10;
        g2d.setColor(Color.RED);
        g2d.drawLine(centerX, centerY,
                (int) (centerX + secondHandLength * Math.cos(secondAngle)),
                (int) (centerY + secondHandLength * Math.sin(secondAngle)));

        // Draw the minute hand (green)
        int minuteHandLength = radius - 20;
        g2d.setColor(Color.GREEN);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(centerX, centerY,
                (int) (centerX + minuteHandLength * Math.cos(minuteAngle)),
                (int) (centerY + minuteHandLength * Math.sin(minuteAngle)));

        // Draw the hour hand (blue)
        int hourHandLength = radius - 40;
        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawLine(centerX, centerY,
                (int) (centerX + hourHandLength * Math.cos(hourAngle)),
                (int) (centerY + hourHandLength * Math.sin(hourAngle)));

        // Display the time in text below the clock
        g2d.setColor(Color.RED);
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));
        String timeText = String.format("Hour: %d Minute: %d Second: %d", hours, minutes, seconds);
        g2d.drawString(timeText, centerX - 70, centerY + radius + 20);
    }
}