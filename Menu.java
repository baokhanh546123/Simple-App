package Lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem newItem, openItem, exitItem;

    public Menu() {
        setTitle("Menu");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        // Tạo thanh menu (JMenuBar)
        menuBar = new JMenuBar();

        // Tạo menu File (JMenu)
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F'); // Đặt phím tắt Alt+F để mở menu File

        // Tạo các menu item (JMenuItem)
        newItem = new JMenuItem("New");
        newItem.setAccelerator(KeyStroke.getKeyStroke("ctrl N")); // Đặt phím tắt Ctrl+N cho New

        openItem = new JMenuItem("Open");
        openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O")); // Đặt phím tắt Ctrl+O cho Open

        exitItem = new JMenuItem("Exit");
        exitItem.setAccelerator(KeyStroke.getKeyStroke("ctrl X")); // Đặt phím tắt Ctrl+X cho Exit

        // Thêm các menu item vào menu File
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Thêm menu File vào thanh menu
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Thêm ActionListener cho các menu item
        newItem.addActionListener(this);
        openItem.addActionListener(this);
        exitItem.addActionListener(this);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Menu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newItem) {
            JOptionPane.showMessageDialog(this, "New menu selected!");
        } else if (e.getSource() == openItem) {
            JOptionPane.showMessageDialog(this, "Open menu selected!");
        } else if (e.getSource() == exitItem) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }
}