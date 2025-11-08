import java.util.*;
import java.io.*;
public class Login {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        BufferedWriter writer = null;
        BufferedReader reader = null;
        try {
            // to do input inside the txt
            writer =  new BufferedWriter(new FileWriter("Account(1).txt"));
            reader =  new BufferedReader(new FileReader("Account(1).txt"));
        } catch (Exception e) {
            System.out.println("File Creation Field");
        }

     

        while(true){
            // allow the program to run continuesly
    
            System.out.println("[A] - Sign in"); // Create
            System.out.println("[B] - Login");   // Read
            /* 
            
            System.out.println("[C] - Forgot Password"); // Update
            System.out.println("[D] - Delete Account");  // Delete
            System.out.println("[E] - Close Program");
            */
            System.out.print("Choice: ");
            char choice = in.next().toUpperCase().charAt(0);
            
            
            switch(choice){
            // function choices
                case 'A':
                signIn(in, writer);
                break;

                case 'B':
                logIn(in, reader);
                break;
    
               
                default:
            }
            }
        }
 
        public static void signIn(Scanner in, BufferedWriter writer){

            try {
                File Account = new File("Account(1).txt");
                Account.createNewFile();
                // creates a txt file for input
    
             } catch (Exception e) {
                 System.out.println("File Creation Field");
                 // incase the file creation failed 
             }
            
                System.out.print("Input Username (Letters only): ");
                String user_n = in.next();

                System.out.print("Input Password (Numbers only: ");
                int pass = in.nextInt();

                try { 
                    writer.write(user_n + " : " + pass);
                    writer.newLine();
                    writer.flush();
                    
               } catch (Exception e) {
                    System.out.println("File Creation Field");
               } 

               System.out.println("Successfully Created!\n");

            }

        public static void logIn(Scanner in, BufferedReader reader){
            boolean found = false;

            System.out.print("Input Username (Letters only): ");
            String username = in.next();

            System.out.print("Input Password (Numbers only): ");
            int password = in.nextInt();

            try {
                String line;
                while((line = reader.readLine()) != null){
                if(line.contains(username + " : " + password)){
                    found = true;
                    break;
                    }
                }
                if (found){
                    System.out.println("Login success!\n");
                } else {
                    System.out.println("Account doesn't exist\n");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } 

        public static void forgotPassword(Scanner in, BufferedReader reader) {

            
        }
 

    }
