import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GBCGUIAcitivity extends Frame implements ActionListener, WindowListener{
    private Label lblStudName;
    private Label lblCourses;
    private Label lblLecUnits;
    private Label lblLabUnits;
    private Label lblTotalUnits;
    private Label lblLecFee;
    private Label lblLabFee;
    private Label lblTotalFee;

    private TextField tfStudName;
    private TextField tfLecUnits;
    private TextField tfLabUnits;
    private TextField tfTotalUnits;
    private TextField tfLecFee;
    private TextField tfLabFee;
    private TextField tfTotalFee;

    private Choice cCourses;

    private Button bCompute;
    private Button bClear;

    private double pLecUnitBSIT = 350;
    private double pLecUnitBSDS = 400;
    private double pLecUnitBSED = 300;
    private double pLecUnitBSBA = 300;
    private double pLaboratoryFee = 500;
    private double pLectureUnits;
    private double pLaboratoryUnits;
    private double pLecFee;
    private double pLabFee;
    private double pTotalFee;
    private double pTotalUnits;

    public GBCGUIAcitivity(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Row 0: Student Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        this.lblStudName = new Label("Student Name");
        this.add(this.lblStudName, gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        this.tfStudName = new TextField(20);
        this.add(this.tfStudName, gbc);

        // Row 1: Course
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.3;
        this.lblCourses = new Label("Course");
        this.add(this.lblCourses, gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        cCourses = new Choice();
        cCourses.add("BSIT");
        cCourses.add("BSDS");
        cCourses.add("BSED");
        cCourses.add("BSBA");
        this.add(cCourses, gbc);

        // Row 2: Lecture Units
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.3;
        this.lblLecUnits = new Label("Lecture Units");
        this.add(this.lblLecUnits, gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        this.tfLecUnits = new TextField(20);
        this.add(this.tfLecUnits, gbc);

        // Row 3: Laboratory Units
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.3;
        this.lblLabUnits = new Label("Laboratory Units");
        this.add(this.lblLabUnits, gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        this.tfLabUnits = new TextField(20);
        this.add(this.tfLabUnits, gbc);

        // Row 4: Compute Button (spans both columns)
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        this.bCompute = new Button("COMPUTE");
        this.add(this.bCompute, gbc);
        this.bCompute.addActionListener(this);

        // Reset gridwidth for subsequent components
        gbc.gridwidth = 1;

        // Row 5: Total Units
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0.3;
        this.lblTotalUnits = new Label("Total Units");
        this.add(this.lblTotalUnits, gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        this.tfTotalUnits = new TextField(20);
        this.tfTotalUnits.setEditable(false);
        this.add(this.tfTotalUnits, gbc);

        // Row 6: Lecture Fee
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0.3;
        this.lblLecFee = new Label("Lecture Fee");
        this.add(this.lblLecFee, gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        this.tfLecFee = new TextField(20);
        this.tfLecFee.setEditable(false);
        this.add(this.tfLecFee, gbc);

        // Row 7: Laboratory Fee
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 0.3;
        this.lblLabFee = new Label("Laboratory Fee");
        this.add(this.lblLabFee, gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        this.tfLabFee = new TextField(20);
        this.tfLabFee.setEditable(false);
        this.add(this.tfLabFee, gbc);
        
        // Row 8: Total Fee
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 0.3;
        this.lblTotalFee = new Label("Total Fees");
        this.add(this.lblTotalFee, gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        this.tfTotalFee = new TextField(20);
        this.tfTotalFee.setEditable(false);
        this.add(this.tfTotalFee, gbc);

        // Row 9: Clear Button (spans both columns)
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        this.bClear = new Button("CLEAR");
        this.add(this.bClear, gbc);
        this.bClear.addActionListener(this);
        
        this.addWindowListener(this);
        this.setTitle("Student Units Calculator");
        this.setSize(400, 450);
        this.setVisible(true);
    }
     
    public static void main(String[] args){
        new GBCGUIAcitivity();
    }

    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();
        String selected = cCourses.getSelectedItem(); 

        if(obj == this.bCompute){
            this.pLectureUnits = Double.parseDouble(this.tfLecUnits.getText());
            this.pLaboratoryUnits = Double.parseDouble(this.tfLabUnits.getText());

            this.pTotalUnits = this.pLaboratoryUnits + this.pLectureUnits;
            this.tfTotalUnits.setText(String.valueOf(this.pTotalUnits));

            double lecUnitPrice = 0;
            switch (selected) {
                case "BSIT":
                    lecUnitPrice = this.pLecUnitBSIT;
                    break;
                case "BSDS":
                    lecUnitPrice = this.pLecUnitBSDS;
                    break;
                case "BSED":
                    lecUnitPrice = this.pLecUnitBSED;
                    break;
                case "BSBA":
                    lecUnitPrice = this.pLecUnitBSBA;
                    break;
            }

            this.pLecFee = this.pLectureUnits * lecUnitPrice;
            this.tfLecFee.setText(String.valueOf(this.pLecFee)); 

            this.pLabFee = this.pLaboratoryFee * this.pLaboratoryUnits;
            this.tfLabFee.setText(String.valueOf(this.pLabFee));
            
            this.pTotalFee = this.pLabFee + this.pLecFee;
            this.tfTotalFee.setText(String.valueOf(this.pTotalFee));
        }
        else if(obj == this.bClear){
            System.out.println("Input Another Student");
            this.tfStudName.setText("");
            this.tfLecUnits.setText("");
            this.tfLabUnits.setText("");
            this.tfTotalUnits.setText("");
            this.tfLecFee.setText("");
            this.tfLabFee.setText("");
            this.tfTotalFee.setText("");

            this.pTotalUnits = 0.0;
            this.pLabFee = 0;
            this.pLecFee = 0.0;
            this.pTotalFee = 0.0;
        }
    }

    public void windowOpened(WindowEvent arg0) {}
    public void windowClosing(WindowEvent arg0) {
        this.setVisible(false);
        System.exit(0);
    }
    public void windowClosed(WindowEvent arg0) {}
    public void windowIconified(WindowEvent arg0) {}
    public void windowDeiconified(WindowEvent arg0) {}
    public void windowActivated(WindowEvent arg0) {}
    public void windowDeactivated(WindowEvent arg0) {}
}