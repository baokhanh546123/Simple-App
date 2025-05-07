package LTGD1;
import javax.swing.*;
import java.awt.*;

public class Form extends JFrame {
    JLabel name, address, sex, hobbies, age;
    JTextField nameField;
    JTextArea addressText;
    JRadioButton maleButton, femaleButton;
    JCheckBox readingCheckBox, sportCheckBox, travellingCheckBox;
    JComboBox<String> ageComboBox;
    JButton ok, cancel;

    public Form() {
        setTitle("Exercise"); // Match the title in the image
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use GridBagLayout for the main form
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        
        name = new JLabel("Name");
        nameField = new JTextField();

        address = new JLabel("Address");
        addressText = new JTextArea(5, 20);

        sex = new JLabel("Sex");
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");

        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        hobbies = new JLabel("Hobbies");
        readingCheckBox = new JCheckBox("Reading");
        sportCheckBox = new JCheckBox("Sports");
        travellingCheckBox = new JCheckBox("Travelling");

        age = new JLabel("Age Group");
        ageComboBox = new JComboBox<>();
        ageComboBox.addItem("1-10");
        ageComboBox.addItem("10-30");
        ageComboBox.addItem("30-50");
        ageComboBox.addItem("50-60");
        ageComboBox.addItem("60-80");
        ageComboBox.addItem("80-90");
        ageComboBox.addItem("90-100");

        ok = new JButton("OK");
        cancel = new JButton("Cancel");

       
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(name, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        add(nameField, gbc);

       
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        add(address, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        add(new JScrollPane(addressText), gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        add(sex, gbc);

        
        JPanel sexPanel = new JPanel(new FlowLayout());
        sexPanel.add(maleButton);
        sexPanel.add(femaleButton);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        add(sexPanel, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        add(hobbies, gbc);

        
        JPanel hobbiesPanel = new JPanel(new FlowLayout());
        hobbiesPanel.add(readingCheckBox);
        hobbiesPanel.add(sportCheckBox);
        hobbiesPanel.add(travellingCheckBox);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        add(hobbiesPanel, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;
        add(age, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        add(ageComboBox, gbc);

        
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(ok, BorderLayout.WEST);
        buttonPanel.add(cancel, BorderLayout.EAST);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        add(buttonPanel, gbc);

        
        setVisible(true);
    }

    public static void main(String[] args) {
        new Form(); 
    }
}