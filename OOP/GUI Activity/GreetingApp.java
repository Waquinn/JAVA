package greetingapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GreetingApp {

    private JFrame frame;
    private JTextField nameField;
    private JButton greetButton;
    private JLabel greetingLabel;
    
    
    public GreetingApp(){
        frame = new JFrame("My first Swing Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        JLabel nameLabel = new JLabel("Enter your name: ");
        nameField = new JTextField(15);
        greetButton = new JButton("Say Hello");
        greetingLabel = new JLabel("");
        
        greetButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               String name = nameField.getText();
               
               if(!name.isEmpty()){
                   greetingLabel.setText("Hello, " + name + "!");
               }
               
               else{
                   greetingLabel.setText("Please enter your name.");
               }
           } 
            
        });
            
            panel.add(nameLabel);
            panel.add(nameField);
            panel.add(greetButton);
            panel.add(greetingLabel);
            
            frame.add(panel);
            
            frame.pack();
            frame.setVisible(true);
        
    }        
    
    
    
    
    public static void main(String[] args) {
       new GreetingApp();
    }
    
}
