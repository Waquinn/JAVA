import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FlowGUIActivity extends Frame implements ActionListener, WindowListener{
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

   public FlowGUIActivity(){

       this.setLayout(new FlowLayout(1));


       this.lblStudName = new Label("Student Name");
       this.add(this.lblStudName);
       this.tfStudName = new TextField(10);
       this.add(this.tfStudName);

       this.lblCourses = new Label("Courses");
       this.add(this.lblCourses);
       cCourses = new Choice();
       cCourses.add("BSIT");
       cCourses.add("BSDS");
       cCourses.add("BSED");
       cCourses.add("BSBA");
       add(cCourses);

       this.lblLecUnits = new Label("Lecture Units");
       this.add(this.lblLecUnits);
       this.tfLecUnits = new TextField(10);
       this.add(this.tfLecUnits);

       this.lblLabUnits = new Label("Laboratory Units");
       this.add(this.lblLabUnits);
       this.tfLabUnits = new TextField(10);
       this.add(this.tfLabUnits);

       this.bCompute = new Button("                               Compute                                  ");
       add(new Label(""));
       this.add(this.bCompute);
       this.add(new Label(""));
       this.bCompute.addActionListener(this);
       this.addWindowListener(this);

       this.lblTotalUnits = new Label("Total Units");
       this.add(this.lblTotalUnits);
       this.tfTotalUnits = new TextField(10);
       this.tfTotalUnits.setEditable(false);
       this.add(this.tfTotalUnits);

       this.lblLecFee = new Label("Lecture Fee");
       this.add(this.lblLecFee);
       this.tfLecFee = new TextField(10);
       this.tfLecFee.setEditable(false);
       this.add(this.tfLecFee);

       this.lblLabFee = new Label("Laboratory Fee");
       this.add(this.lblLabFee);
       this.tfLabFee = new TextField(10);
       this.tfLabFee.setEditable(false);
       this.add(this.tfLabFee);
      
       this.lblTotalFee = new Label("Total Fee");
       this.add(this.lblTotalFee);
       this.tfTotalFee = new TextField(10);
       this.tfTotalFee.setEditable(false);
       this.add(this.tfTotalFee);

       this.bClear = new Button("                                           Clear                                        ");
       add(new Label(""));
       this.add(this.bClear);
       this.bClear.addActionListener(this);
       this.addWindowListener(this);
       this.setTitle("Input another");
       this.setSize(400, 400);
       this.setVisible(true);

  
       this.setTitle("Student Units Calculator");
       this.setSize(400, 750);
       this.setVisible(true);

   }
   

   public static void main(String[] args){
       new FlowGUIActivity();
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
           System.out.println("Process Another");
           this.tfStudName.setText(" ");
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

  public void windowClosing(WindowEvent arg0) {
     this.setVisible(false);
     System.exit(0);
  }

  public void windowOpened(WindowEvent arg0) {}
  public void windowClosed(WindowEvent arg0) {}
  public void windowIconified(WindowEvent arg0) {}
  public void windowDeiconified(WindowEvent arg0){}
  public void windowActivated(WindowEvent arg0){}
  public void windowDeactivated(WindowEvent arg0){}

}

