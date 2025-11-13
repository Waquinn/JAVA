package swingtriangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SwingTriangle {

    private JFrame frame;
    private JTextField fldBase, fldHeight;
    private JLabel lblResult;
    
    public SwingTriangle(){
        frame = new JFrame("Triangle Area Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 5, 5));
        
        JLabel lblBase = new JLabel("Enter base(cm):");
        fldBase = new JTextField();
        
        JLabel lblHeight = new JLabel("Enter height(cm):");
        fldHeight = new JTextField();
        
        JButton btnCompute = new JButton("Compute Area");
        lblResult = new JLabel("Area: ");
        
        btnCompute.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                calculateArea();
            }  
        });

        panel.add(lblBase);
        panel.add(fldBase);
        panel.add(lblHeight);
        panel.add(fldHeight);
        panel.add(new JLabel(""));
        panel.add(btnCompute);
        panel.add(new JLabel(""));
        panel.add(lblResult);
        
        frame.add(panel);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
    
    
    private void calculateArea(){
        try{
            double base = Double.parseDouble(fldBase.getText());
            double height = Double.parseDouble(fldHeight.getText());
            
            double area = 0.5 * base * height;
            
            lblResult.setText(String.format("Area: %.2f", area));
            
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(frame, "Please enter valid numbers for the base and height", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args){
        new SwingTriangle();
    }

}
