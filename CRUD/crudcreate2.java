import java.util.*;
import java.io.*;
public class crudcreate2 {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        //Para ulit ulit condition
        while(true){
            System.out.println("[1] - Add Student");
            System.out.println("[2] - View All Student");
            System.out.println("[3] - Exit");
            System.out.print("Your Choice: ");
            int choice = in.nextInt();
            System.out.println("");

            switch(choice){
                case 1:

                    //Input ng info ng students

                    System.out.print("Input Student Number: ");
                    int studNO = in.nextInt();
                    in.nextLine();

                    System.out.print("Input Student First Name: ");
                    String studFN = in.nextLine();
                    

                    System.out.print("Input Student Last Name: ");
                    String studLN = in.next();

                    try {
                        
                        //Creation of txt file, while also allows to write over it
                        BufferedWriter writer = new BufferedWriter(new FileWriter ("Student Records.txt", true));
                        
                        //susulat nya sa loob ng file yung mga info na hiningi sa taas
                        writer.write(studNO + ": " + studFN + " " + studLN + "\n");
                        writer.close();
                        System.out.println("Input Successful!\n");

                    } catch (IOException e) {
                        System.out.println("Input Failed!");
                    }
                    
                break;

                case 2:

                    try{
                    
                    //FileReader opens the file named Student Records.txt.
                    //BufferedReader reads info in the file, binabasa nya line by line.

                    BufferedReader reader = new BufferedReader(new FileReader("Student Records.txt"));

                    //Temporarily holds each line of text read from the file.
                    String data;

                    //Looping sa pag read ng info's sa loob ng file, "reader.readLine()" nirereturn mga info's na nakikita nya sa line and piniprint.
                    while((data = reader.readLine()) != null){
                        
                        System.out.println(data);

                    }
                    reader.close();
                    System.out.println("");

                    } catch (IOException e) {
                        System.out.println("Input Failed!");
                    }


                break;
                
                //Terminates the program

                case 3:
                    
                    

                break;

                case 4:
                    System.out.println("Good Bye!\n");
                return;

                default:
                System.out.println("Invalid choice, please try again.\n");
    
            }
        }
    }
}

