package Lab06;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class ShapeDraw extends JFrame {
    JMenuBar Menu;
    JMenu Add, Colors, Options, Background_Colors;
    JMenuItem Rectangle, Oval, Round_Rect, Clear;
    JCheckBoxMenuItem Add_Large_Shape, Add_Shapes_with_Border;
    JPopupMenu popup;
    JRadioButtonMenuItem Red, Green, Blue, Cyan, Magenta, Yellow, Black, Gray, White;

    boolean add_large = false, add_shape = false;

    public ShapeDraw() {
        setTitle("Shape Draw");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Use BorderLayout for the canvas

        ShapeCanvas canvas = new ShapeCanvas();
        setContentPane(canvas);

        Menu = new JMenuBar();
        setJMenuBar(Menu);

        // Add menu
        Add = new JMenu("Add");
        Add.setMnemonic('A');

        Rectangle = new JMenuItem("Rectangle"); // Fixed typo: "Rectangale" to "Rectangle"
        Rectangle.setAccelerator(KeyStroke.getKeyStroke("ctrl R"));
        Oval = new JMenuItem("Oval");
        Oval.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        Round_Rect = new JMenuItem("Round Rect");
        Round_Rect.setAccelerator(KeyStroke.getKeyStroke("ctrl D"));

        Add.add(Rectangle);
        Add.add(Oval);
        Add.add(Round_Rect);

        Rectangle.addActionListener(canvas);
        Oval.addActionListener(canvas);
        Round_Rect.addActionListener(canvas);

        // Colors menu
        Colors = new JMenu("Colors");
        Colors.setMnemonic('C');

        ButtonGroup ColorsGroup = new ButtonGroup();

        Red = new JRadioButtonMenuItem("Red");
        ColorsGroup.add(Red);
        Red.setSelected(true);

        Green = new JRadioButtonMenuItem("Green");
        ColorsGroup.add(Green);

        Blue = new JRadioButtonMenuItem("Blue");
        ColorsGroup.add(Blue);

        Cyan = new JRadioButtonMenuItem("Cyan");
        ColorsGroup.add(Cyan);

        Magenta = new JRadioButtonMenuItem("Magenta");
        ColorsGroup.add(Magenta);

        Yellow = new JRadioButtonMenuItem("Yellow");
        ColorsGroup.add(Yellow);

        Black = new JRadioButtonMenuItem("Black");
        ColorsGroup.add(Black);

        Gray = new JRadioButtonMenuItem("Gray");
        ColorsGroup.add(Gray);

        White = new JRadioButtonMenuItem("White");
        ColorsGroup.add(White);

        Colors.add(Red);
        Colors.add(Green);
        Colors.add(Blue);
        Colors.add(Cyan);
        Colors.add(Magenta);
        Colors.add(Yellow);
        Colors.add(Black);
        Colors.add(Gray);
        Colors.add(White);

        // Options menu
        Options = new JMenu("Options");
        Options.setMnemonic('O');

        Clear = new JMenuItem("Clear");
        Clear.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
        Clear.addActionListener(canvas);
        Options.addSeparator();

        Add_Large_Shape = new JCheckBoxMenuItem("Add Large Shape");
        Add_Large_Shape.setSelected(true);
        Add_Large_Shape.addActionListener(e -> add_large = Add_Large_Shape.isSelected());

        Add_Shapes_with_Border = new JCheckBoxMenuItem("Add Shape With Border");
        Add_Shapes_with_Border.setSelected(true);
        Add_Shapes_with_Border.addActionListener(e -> add_shape = Add_Shapes_with_Border.isSelected());
        Options.addSeparator();

        // Background Colors menu
        Background_Colors = new JMenu("Background Colors");
        ButtonGroup bgColorsGroup = new ButtonGroup();

        JRadioButtonMenuItem bgRed = new JRadioButtonMenuItem("Red");
        bgColorsGroup.add(bgRed);
        JRadioButtonMenuItem bgGreen = new JRadioButtonMenuItem("Green");
        bgColorsGroup.add(bgGreen);
        JRadioButtonMenuItem bgBlue = new JRadioButtonMenuItem("Blue");
        bgColorsGroup.add(bgBlue);
        JRadioButtonMenuItem bgCyan = new JRadioButtonMenuItem("Cyan");
        bgColorsGroup.add(bgCyan);
        JRadioButtonMenuItem bgMagenta = new JRadioButtonMenuItem("Magenta");
        bgColorsGroup.add(bgMagenta);
        JRadioButtonMenuItem bgYellow = new JRadioButtonMenuItem("Yellow");
        bgColorsGroup.add(bgYellow);
        JRadioButtonMenuItem bgBlack = new JRadioButtonMenuItem("Black");
        bgColorsGroup.add(bgBlack);
        JRadioButtonMenuItem bgGray = new JRadioButtonMenuItem("Gray");
        bgColorsGroup.add(bgGray);
        JRadioButtonMenuItem bgWhite = new JRadioButtonMenuItem("White");
        bgColorsGroup.add(bgWhite);
        bgWhite.setSelected(true);

        Background_Colors.add(bgRed);
        Background_Colors.add(bgGreen);
        Background_Colors.add(bgBlue);
        Background_Colors.add(bgCyan);
        Background_Colors.add(bgMagenta);
        Background_Colors.add(bgYellow);
        Background_Colors.add(bgBlack);
        Background_Colors.add(bgGray);
        Background_Colors.add(bgWhite);

        bgRed.addActionListener(canvas);
        bgGreen.addActionListener(canvas);
        bgBlue.addActionListener(canvas);
        bgCyan.addActionListener(canvas);
        bgMagenta.addActionListener(canvas);
        bgYellow.addActionListener(canvas);
        bgBlack.addActionListener(canvas);
        bgGray.addActionListener(canvas);
        bgWhite.addActionListener(canvas);

        // Popup menu
        popup = new JPopupMenu();

        JMenuItem deleteShape = new JMenuItem("Delete Shape");
        deleteShape.addActionListener(canvas);
        popup.add(deleteShape);

        JMenuItem bringToFront = new JMenuItem("Bring to Front");
        bringToFront.addActionListener(canvas);
        popup.add(bringToFront);
        popup.addSeparator();

        JMenuItem makeLarge = new JMenuItem("Make Large");
        makeLarge.addActionListener(canvas);
        popup.add(makeLarge);

        JMenuItem makeSmall = new JMenuItem("Make Small");
        makeSmall.addActionListener(canvas);
        popup.add(makeSmall);
        popup.addSeparator();

        JMenuItem addBorder = new JMenuItem("Add Black Border");
        addBorder.addActionListener(canvas);
        popup.add(addBorder);

        JMenuItem removeBorder = new JMenuItem("Remove Black Border");
        removeBorder.addActionListener(canvas);
        popup.add(removeBorder);
        popup.addSeparator();

        JMenuItem setRed = new JMenuItem("Set Colors to Red");
        setRed.addActionListener(canvas);
        popup.add(setRed);

        JMenuItem setGreen = new JMenuItem("Set Colors to Green");
        setGreen.addActionListener(canvas);
        popup.add(setGreen);

        JMenuItem setBlue = new JMenuItem("Set Colors to Blue");
        setBlue.addActionListener(canvas);
        popup.add(setBlue);

        JMenuItem setCyan = new JMenuItem("Set Colors to Cyan");
        setCyan.addActionListener(canvas);
        popup.add(setCyan);

        JMenuItem setMagenta = new JMenuItem("Set Colors to Magenta");
        setMagenta.addActionListener(canvas);
        popup.add(setMagenta);

        JMenuItem setYellow = new JMenuItem("Set Colors to Yellow");
        setYellow.addActionListener(canvas);
        popup.add(setYellow);

        JMenuItem setBlack = new JMenuItem("Set Colors to Black");
        setBlack.addActionListener(canvas);
        popup.add(setBlack);

        JMenuItem setGray = new JMenuItem("Set Colors to Gray");
        setGray.addActionListener(canvas);
        popup.add(setGray);

        JMenuItem setWhite = new JMenuItem("Set Colors to White");
        setWhite.addActionListener(canvas);
        popup.add(setWhite);

        Options.add(Clear);
        Options.add(Add_Large_Shape);
        Options.add(Add_Shapes_with_Border);
        Options.add(Background_Colors);

        Menu.add(Add);
        Menu.add(Colors);
        Menu.add(Options);

        setVisible(true);
    }

    public class ShapeCanvas extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
        ArrayList<Shape> shapes = new ArrayList<>();
        Shape clickedShape = null;
        Shape draggedShape = null;
        int prevDragX, prevDragY;

        public ShapeCanvas() {
            setBackground(Color.white);
            addMouseListener(this);
            addMouseMotionListener(this);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Shape s : shapes) {
                s.draw(g);
            }
        }

        void addShape(Shape shape) {
            if (Red.isSelected())
                shape.setColor(Color.red);
            else if (Blue.isSelected())
                shape.setColor(Color.blue);
            else if (Green.isSelected())
                shape.setColor(Color.green);
            else if (Cyan.isSelected())
                shape.setColor(Color.cyan);
            else if (Magenta.isSelected()) // Fixed: "magenta" to "Magenta"
                shape.setColor(Color.magenta);
            else if (Yellow.isSelected())
                shape.setColor(Color.yellow);
            else if (Black.isSelected())
                shape.setColor(Color.black);
            else if (White.isSelected())
                shape.setColor(Color.white);
            else
                shape.setColor(Color.gray);

            shape.setDrawOutline(Add_Shapes_with_Border.isSelected()); // Fixed: "addBorderedShapes" to "Add_Shapes_with_Border"

            if (Add_Large_Shape.isSelected()) // Fixed: "addLargeShapes" to "Add_Large_Shape"
                shape.reshape(3, 3, 100, 60);
            else
                shape.reshape(3, 3, 50, 30);

            // Randomize position to avoid overlap
            int size = Add_Large_Shape.isSelected() ? 100 : 50;
            int x, y;
            boolean overlap;
            do {
                overlap = false;
                x = (int) (Math.random() * (getWidth() - size));
                y = (int) (Math.random() * (getHeight() - size));
                for (Shape existingShape : shapes) {
                    int dx = Math.abs(existingShape.left - x);
                    int dy = Math.abs(existingShape.top - y);
                    if (dx < size && dy < size) {
                        overlap = true;
                        break;
                    }
                }
            } while (overlap);
            shape.reshape(x, y, shape.width, shape.height);

            shapes.add(shape);
            repaint();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Clear")) {
                shapes.clear();
                repaint();
            } else if (command.equals("Rectangle")) {
                addShape(new RectShape());
            } else if (command.equals("Oval")) {
                addShape(new OvalShape()); // Fixed: Create OvalShape instead of RectShape
            } else if (command.equals("Round Rect")) {
                addShape(new RoundRectShape()); // Fixed: Create RoundRectShape instead of RectShape
            } else if (command.equals("Red")) {
                setBackground(Color.red);
            } else if (command.equals("Green")) {
                setBackground(Color.green);
            } else if (command.equals("Blue")) {
                setBackground(Color.blue);
            } else if (command.equals("Cyan")) {
                setBackground(Color.cyan);
            } else if (command.equals("Magenta")) {
                setBackground(Color.magenta);
            } else if (command.equals("Yellow")) {
                setBackground(Color.yellow);
            } else if (command.equals("Black")) {
                setBackground(Color.black);
            } else if (command.equals("Gray")) {
                setBackground(Color.gray);
            } else if (command.equals("White")) {
                setBackground(Color.white);
            } else if (clickedShape != null) {
                if (command.equals("Delete Shape")) {
                    shapes.remove(clickedShape);
                } else if (command.equals("Bring to Front")) {
                    shapes.remove(clickedShape);
                    shapes.add(clickedShape);
                } else if (command.equals("Make Large")) {
                    clickedShape.setSize(100, 60);
                } else if (command.equals("Make Small")) {
                    clickedShape.setSize(50, 30);
                } else if (command.equals("Add Black Border")) {
                    clickedShape.setDrawOutline(true);
                } else if (command.equals("Remove Black Border")) {
                    clickedShape.setDrawOutline(false);
                } else if (command.equals("Set Colors to Red")) {
                    clickedShape.setColor(Color.red);
                } else if (command.equals("Set Colors to Green")) {
                    clickedShape.setColor(Color.green);
                } else if (command.equals("Set Colors to Blue")) {
                    clickedShape.setColor(Color.blue);
                } else if (command.equals("Set Colors to Cyan")) {
                    clickedShape.setColor(Color.cyan);
                } else if (command.equals("Set Colors to Magenta")) {
                    clickedShape.setColor(Color.magenta);
                } else if (command.equals("Set Colors to Yellow")) {
                    clickedShape.setColor(Color.yellow);
                } else if (command.equals("Set Colors to Black")) {
                    clickedShape.setColor(Color.black);
                } else if (command.equals("Set Colors to Gray")) {
                    clickedShape.setColor(Color.gray);
                } else if (command.equals("Set Colors to White")) {
                    clickedShape.setColor(Color.white);
                }
                repaint();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (draggedShape != null) {
                return;
            }
            int x = e.getX();
            int y = e.getY();
            clickedShape = null;
            for (int i = shapes.size() - 1; i >= 0; i--) {
                Shape s = shapes.get(i);
                if (s.containsPoint(x, y)) {
                    clickedShape = s;
                    break;
                }
            }
            if (clickedShape == null) {
                return;
            }
            if (e.isPopupTrigger()) {
                popup.show(this, x - 10, y - 2);
            } else if (e.isShiftDown()) {
                shapes.remove(clickedShape);
                shapes.add(clickedShape);
                repaint();
            } else {
                draggedShape = clickedShape;
                prevDragX = x;
                prevDragY = y;
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (draggedShape == null) {
                return;
            }
            int x = e.getX();
            int y = e.getY();
            draggedShape.moveBy(x - prevDragX, y - prevDragY);
            prevDragX = x;
            prevDragY = y;
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (draggedShape == null) {
                return;
            }
            int x = e.getX();
            int y = e.getY();
            if (e.isPopupTrigger()) {
                popup.show(this, x - 10, y - 2);
            } else {
                draggedShape.moveBy(x - prevDragX, y - prevDragY);
                if (draggedShape.left >= getSize().width || draggedShape.top >= getSize().height ||
                        draggedShape.left + draggedShape.width < 0 ||
                        draggedShape.top + draggedShape.height < 0) {
                    shapes.remove(draggedShape);
                }
                repaint();
            }
            draggedShape = null;
        }

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mouseMoved(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    }

    // Shape classes
    static abstract class Shape {
        int left, top;
        int width, height;
        Color color = Color.white;
        boolean drawOutline;

        void reshape(int left, int top, int width, int height) {
            this.left = left;
            this.top = top;
            this.width = width;
            this.height = height;
        }

        void setSize(int width, int height) {
            this.width = width;
            this.height = height;
        }

        void moveBy(int dx, int dy) {
            left += dx;
            top += dy;
        }

        void setColor(Color color) {
            this.color = color;
        }

        void setDrawOutline(boolean draw) {
            drawOutline = draw;
        }

        boolean containsPoint(int x, int y) {
            if (x >= left && x < left + width && y >= top && y < top + height)
                return true;
            else
                return false;
        }

        abstract void draw(Graphics g);
    }

    static class RectShape extends Shape {
        void draw(Graphics g) {
            g.setColor(color);
            g.fillRect(left, top, width, height);
            if (drawOutline) {
                g.setColor(Color.black);
                g.drawRect(left, top, width, height);
            }
        }
    }

    static class OvalShape extends Shape {
        void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(left, top, width, height);
            if (drawOutline) {
                g.setColor(Color.black);
                g.drawOval(left, top, width, height);
            }
        }

        boolean containsPoint(int x, int y) {
            double rx = width / 2.0;
            double ry = height / 2.0;
            double cx = left + rx;
            double cy = top + ry;
            if ((ry * (x - cx)) * (ry * (x - cx)) + (rx * (y - cy)) * (rx * (y - cy)) <= rx * rx * ry * ry)
                return true;
            else
                return false;
        }
    }

    static class RoundRectShape extends Shape {
        void draw(Graphics g) {
            g.setColor(color);
            g.fillRoundRect(left, top, width, height, width / 3, height / 3);
            if (drawOutline) {
                g.setColor(Color.black);
                g.drawRoundRect(left, top, width, height, width / 3, height / 3);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShapeDraw());
    }
}