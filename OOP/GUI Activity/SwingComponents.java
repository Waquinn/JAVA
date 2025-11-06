import java.awt.*;
import javax.swing.*;

public class SwingComponents {
    public static void main(String[]args){
        
        // Create the main window (frame)
        JFrame frame = new JFrame("Java Swing Components Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        // Create a panel with a GridLayout to organize components neatly
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2, 10, 10)); // 10 rows, 2 columns, 10px gaps

        // === Add various Swing components ===

        // JLabel
        panel.add(new JLabel("This is a JLabel:"));
        panel.add(new JLabel("Hello, Swing!"));

        // JButton
        panel.add(new JLabel("JButton:"));
        panel.add(new JButton("Click Me"));

        // JTextField
        panel.add(new JLabel("JTextField:"));
        panel.add(new JTextField("Type something here", 15));

        // JPasswordField
        panel.add(new JLabel("JPasswordField:"));
        panel.add(new JPasswordField("secret", 10));

        // JCheckBox
        panel.add(new JLabel("JCheckBox:"));
        JPanel checkPanel = new JPanel(); // nested panel for grouping
        checkPanel.add(new JCheckBox("Option 1"));
        checkPanel.add(new JCheckBox("Option 2"));
        panel.add(checkPanel);

        // JRadioButton (grouped)
        panel.add(new JLabel("JRadioButton:"));
        JPanel radioPanel = new JPanel();
        ButtonGroup group = new ButtonGroup();
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        group.add(male);
        group.add(female);
        radioPanel.add(male);
        radioPanel.add(female);
        panel.add(radioPanel);

        // JComboBox
        panel.add(new JLabel("JComboBox:"));
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        panel.add(new JComboBox<>(colors));

        // JList
        panel.add(new JLabel("JList:"));
        String[] fruits = {"Apple", "Banana", "Orange", "Mango"};
        JList<String> fruitList = new JList<>(fruits);
        panel.add(new JScrollPane(fruitList)); // wrapped in scroll pane

        // JTextArea
        panel.add(new JLabel("JTextArea:"));
        JTextArea textArea = new JTextArea("This is a multi-line text area.", 3, 15);
        panel.add(new JScrollPane(textArea)); // scrollable
        
        // Add the panel to the frame
        frame.add(new JScrollPane(panel)); // scrollable in case of overflow
        // Center the frame and make it visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



    }
}
