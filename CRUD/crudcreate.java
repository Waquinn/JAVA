import java.util.*;
import java.io.*;
public class crudcreate {
    public static void main(String[] args) {

       //File Writer

       Scanner in = new Scanner(System.in);
       File myFile = new File("Student_Info.txt");

       while(true){
            System.out.println("[1] - Add Student");
            System.out.print("Your choice: ");
            int choice = in.nextInt();

        switch(choice){
            case 1: 
                System.out.print("Enter Student ID: ");
                int studNo = in.nextInt();
                in.nextLine();

                System.out.print("Enter Student First name: ");
                String studFN = in.nextLine();

                System.out.print("Enter Student Last name: ");
                String studLN = in.next();

                    try {
                        FileWriter writer = new FileWriter(myFile, true);
                        writer.write(studNo + ": " + studFN + " " + studLN + "\n" );
                        writer.close();
                        System.out.println("Input Success!\n");
                        
                    } catch (IOException e) {
                        System.out.println("Input Failed");
                    }

            break;

           

        }
       }
    }
}
