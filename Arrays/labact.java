import java.util.*;
public class labact {
    
public static void main(String[] args) {
    
    Scanner in = new Scanner(System.in);
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
}
}

