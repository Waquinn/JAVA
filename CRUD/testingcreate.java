import java.util.*;
import java.io.*;
public class testingcreate {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        File myFile = new File("Student Info.txt");

        while(true){
            System.out.println("[1] - Add Student");
            System.out.println("[2] - View All Student");
            System.out.println("[3] - Search Student");
            System.out.println("[4] - Exit");
            System.out.print("Your Choice: ");
            int choice = in.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Input Student Number: ");
                    int studNO = in.nextInt();
                    in.nextLine();

                    System.out.print("Input Student First Name: ");
                    String studFN = in.nextLine();
                    

                    System.out.print("Input Student Last Name: ");
                    String studLN = in.next();

                    try {
                        
                        FileWriter writer = new FileWriter(myFile, true);
                        writer.write(studNO + ": " + studFN + " " + studLN + "\n");
                        writer.close();
                        System.out.println("Input Successful!");

                    } catch (IOException e) {
                        System.out.println("Input Failed!");
                    }
                    
                break;

                case 2: 
                    System.out.println("\t \t Student Records \n");

                    try {
                        Scanner reader = new Scanner(myFile);
                        while(reader.hasNextLine()){
                            String data = reader.nextLine();
                            System.out.println(data);

                        }
                        reader.close();
                    } catch (Exception e) {
                        System.out.println("Failed to read file");
                    }

                break;

                case 3:

                break;
                
            }


        }
    }
}
