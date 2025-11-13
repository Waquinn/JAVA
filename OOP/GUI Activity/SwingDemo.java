package swingdemo;

import javax.swing.*;
import java.awt.*;

public class SwingDemo {
    
    JFrame frame;
    JPanel panel;
    JTextField textField;
    JButton button;
    Container contentPane;
        
        void launchFrame(){
            frame = new JFrame("My first Swing Application");
            panel = new JPanel();
            textField = new JTextField("Default Text");
            button = new JButton("Click Me");
            
            contentPane = frame.getContentPane();
            
            panel.add(textField);
            panel.add(button);
            
            contentPane.add(panel, BorderLayout.EAST);
            frame.pack();
            
            frame.setVisible(true);
            
        }

    public static void main(String[] args) {
        
         SwingDemo sd = new SwingDemo();
         sd.launchFrame();
         
    }
    
}
