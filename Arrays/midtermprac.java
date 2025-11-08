import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;




public class midtermprac {
    /**
     * @param args
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        char choice;

        do{
        System.out.println("[A] - 1d Array");
        System.out.println("[B] - 2d Array");
        System.out.println("[C] - Arraylist");
        System.out.println("[D] - Create");
        System.out.println("[E] - Exit\n");
        System.out.print("What do you want to do?: ");
        choice = in.next().toUpperCase().charAt(0);


        switch(choice){
            case 'A':
            System.out.println();

            // 1 dollar = 57.25
            System.out.println("[1] - Dollar to Peso \n[2] - Peso to Dollar");
            System.out.print("What exchange do you want to execute?: ");
            int option = in.nextInt();

            switch(option){
                
                
                case 1 : 
                double[] dol  = new double[3];
                
                    for (int i=0; i<3; i++){
                    System.out.print("Input amount in dollars: ");
                    dol[i] = in.nextDouble();
                    System.out.println("Your dollar to peso will be: " + dol[i]*57.21);
                    }

                break;

                case 2 : 
                double[] peso  = new double[3];

                    for (int i=0; i<3; i++){
                    System.out.print("Input amount in peso: ");
                    peso[i] = in.nextDouble();
                    System.out.println("Your dollar to peso will be: " + peso[i]*0.017);
                    }

                break;

                default:
                    System.out.println("Invalid input");

            }

            break;

              
            case 'B':
                System.out.println();

                double[][] x = new double[2][3];
                double[][] y = new double[2][3];
                double[][] z = new double[2][3];  
                double[][] input = new double[2][3]; 


                for(int i=0; i<2; i++){
                    for(int j=0; j<3; j++){
                    System.out.print("Input value for X: ");
                    x[i][j] = in.nextDouble();

                    System.out.print("Input value for Y: ");
                    y[i][j] = in.nextDouble();

                    System.out.print("Input value for Z: ");
                    z[i][j] = in.nextDouble();
                    
                    System.out.println("Product of X,Y,Z: " + (x[i][j]*y[i][j]*z[i][j]));
                    
                    input[i][j] = (x[i][j]+y[i][j]+z[i][j]/3);

                    System.out.println("Average of X,Y,Z: " + input[i][j]);

                    System.out.println();
                    }

                }
            
            case 'C' :

                ArrayList<Integer> stud_no = new ArrayList<Integer>();
                ArrayList<String> stud_LN = new ArrayList<String>();
                ArrayList<String> stud_FN = new ArrayList<String>();
                ArrayList<String> stud_MN = new ArrayList<String>();
                ArrayList<String> stud_Status = new ArrayList<String>();
                ArrayList<Integer> lec_units = new ArrayList<Integer>();
                ArrayList<Integer> lab_units = new ArrayList<Integer>();
                double total = 0;
    
                System.out.println("\t \t \t \t \t \tStudent Information System");
                System.out.println("_________________________________________________________________________________________________________________________________________________");
                
                for (int i=0; i<3; i++){
                    
                    System.out.print("Student No: ");
                    stud_no.add(in.nextInt());
                    
                    System.out.print("Last Name: ");
                    stud_LN.add(in.next());
                    
                    System.out.print("First Name: ");
                    stud_FN.add(in.next());
                    
                    System.out.print("Middle Name: ");
                    stud_MN.add(in.next());
                    
                    System.out.print("Input Student Status ( R - Regular / I - Irregular): ");
                    stud_Status.add(in.next());
                    
                    System.out.println("");
                    
                    switch(stud_Status.get(i)){
                        
                        case "R" : 
                            System.out.print("No. of Lecture units to be enrolled: ");
                            lec_units.add(in.nextInt());
                            System.out.print("No. of Laboratory units to be enrolled: ");
                            lab_units.add(in.nextInt());
                            
                            
                            total = (lec_units.get(i)*285.75) + (lab_units.get(i)*2500.00);
                            
                            System.out.println(stud_no.get(i));
                            System.out.println(stud_LN.get(i));
                            System.out.println(stud_FN.get(i));
                            System.out.println(stud_MN.get(i));
                            
                            System.out.println();
                            
                            System.out.println("Total amout to be paid: " + total);
                            
                            System.out.println("");
                            
                            break;
                            
                        case "I" : 
                            System.out.print("No. of Lecture units to be enrolled: ");
                            lec_units.add(in.nextInt());
                            System.out.print("No. of Laboratory units to be enrolled: ");
                            lab_units.add(in.nextInt());
                            
                            
                            total = (lec_units.get(i)*389.79) + (lab_units.get(i)*3800.00);
                            
                            System.out.println(stud_no.get(i));
                            System.out.println(stud_LN.get(i));
                            System.out.println(stud_FN.get(i));
                            System.out.println(stud_MN.get(i));
                            
                            System.out.println("");
                            
                            System.out.println("Total amout to be paid: " + total);
                            
                            System.out.println("");
                            
                            break;
                            
                        default:
                            System.out.println("INVALID");
                            
                            System.out.println("");
                            
                            break;

               
        }     
        }

            case 'D': 

            try{
        
                ArrayList<Integer> emp_dets = new ArrayList<>();
                FileWriter FILE = new FileWriter("Employee.txt", true);
                BufferedWriter OUTPUT = new BufferedWriter(FILE);
                
                System.out.print("Employee number: ");
                emp_dets.add(in.nextInt());
                
                System.out.print("Last Name: ");
                emp_dets.add(in.nextInt());
                
                System.out.print("First Name: ");
                emp_dets.add(in.nextInt());
                
                System.out.print("Middle Name: ");
                emp_dets.add(in.nextInt());
                
                OUTPUT.write(emp_dets + "\n");
                OUTPUT.close();
                
                }catch(InputMismatchException e){
                    System.out.println(e.getMessage());
                    System.out.println("HAHAHAHAH BOBO");
                    
                } catch (IOException e){
                    
                } finally {
                    System.out.println("hehe"); 
                }
                
                }

    }while(choice!='E');
}
}


