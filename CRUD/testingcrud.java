import java.util.*;
import java.io.*;

public class testingcrud {
    public static void main(String[] args) {

                
        Scanner in = new Scanner(System.in);

        while(true){
            System.out.println("[1] - Add Student");
            System.out.println("[2] - View All Student");
            System.out.println("[3] - Exit");
            System.out.print("Your Choice: ");
            int choice = in.nextInt();
            System.out.println("");

            switch(choice){

                case 1:

                try {
                    ArrayList<String> stud = new ArrayList<>();
                    
                    FileWriter file = new FileWriter("Stud Rec.txt", true);

                    //Creation of txt file, while also allows to write over it
                    BufferedWriter writer =  new BufferedWriter(file);
                    String ans;

                    do {

                        //Input ng info ng students

                        System.out.print("Input student no. : ");
                        stud.add(in.nextLine());
                        
                        System.out.print("Input student First name: ");
                        stud.add(in.nextLine());

                        System.out.print("Input student Last name. : ");
                        stud.add(in.nextLine());
                        
                        //susulat nya sa loob ng file yung mga info na hiningi sa taas
                        writer.write(stud + "\n");

                        System.out.println("Add another record? (Y/N)");
                        ans = in.next();

                    }while(ans.equalsIgnoreCase ("Y"));
                    writer.close();
                    System.out.println("Success!");

                } catch (IOException e) {
                    System.out.println("Failed!");
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

                case 3:
                    System.out.println("Goodbye!");
                return;

                default:
                System.out.println("Invalid choice, please try again.\n");

            }
        }
    }
}