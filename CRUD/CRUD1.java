import java.util.*;
import java.io.*;

public class CRUD1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
        // allow the program to run continuesly

        System.out.println("[A] - Sign in");
        System.out.println("[B] - Login");
        System.out.println("[C] - Forgot Password");
        System.out.println("[D] - Delete Account");
        System.out.println("[E] - Close Program");
        System.out.print("Choice: ");
        char choice = scanner.next().toUpperCase().charAt(0);
        
        
        switch(choice){
        // function choices
            case 'A':
            signIn(scanner);
            break;

            case 'B':
            login(scanner);
            break;

            case 'C':
            forgotPassword(scanner);
            break;
            
            case 'D':
            deleteAccount(scanner);
            break;
            
            case 'E':
            System.exit(0);
            break;

            default:
        }
        }
    }

            public static void login(Scanner scanner){
            //user input
                boolean found = false;


                    System.out.print("Input Username (Letters only): ");
                    String userName = scanner.next();

                    System.out.print("Input Password (Numbers only): ");
                    int passWord = scanner.nextInt();

                    try {
                        BufferedReader reader = new BufferedReader(new FileReader("Account.txt"));
                        String line;
                        while((line = reader.readLine()) != null){
                            if(line.contains(userName + " : " + passWord)){
                                found = true;
                                break;
                            }
                        }

                        if(found){
                            System.out.println("Login Success!\n");
                        } else {
                            System.out.println("Account doesn't exist\n");
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

            public static void signIn(Scanner scanner) {
                try{
                    File Account = new File("Account.txt");
                    Account.createNewFile();
                } catch (IOException e) {
                    System.out.println("File Creation Failed");
                }

                System.out.print("Input Username (Letters only): ");
                String username = scanner.next();

                System.out.print("Input Password (Numbers only): ");
                int password = scanner.nextInt();
                
                try {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Account.txt", true))) {
                        writer.write(username + " : " + password);
                        writer.newLine();
                    }
                } catch (IOException e) {
                    System.out.println("Account Creation Failed");
                }
                
                System.out.println("Account Successfully Created!\n");
            }

            public static void forgotPassword(Scanner scanner){
                boolean isFound = false;
                boolean changed = false;
                ArrayList<String> newLines = new ArrayList<String>();

                    System.out.print("Input Username (Letters only): ");
                    String inputName = scanner.next();

                    System.out.print("Input Previous Password (Numbers only): ");
                    int inputPass = scanner.nextInt();

                    try {
                        BufferedReader reader = new BufferedReader(new FileReader("Account.txt"));
                        String line;
                        while((line = reader.readLine()) != null){
                            if(line.contains(inputName + " : " + inputPass)){
                                isFound = true;
                                break;
                            }
                        }
                    } catch (IOException e){
                        e.printStackTrace();
                    }

                    if(isFound){
                        System.out.print("Input New Password (Numbers only): ");
                        int newPass = scanner.nextInt();

                        try {
                            BufferedReader reader = new BufferedReader(new FileReader("Account.txt"));
                            String line;
                            while((line = reader.readLine()) != null){
                                if(!line.contains(inputName + " : " + inputPass)){
                                    newLines.add(line);
                                } else {
                                    changed = true;
                                }
                            }
                            reader.close();
            
                            BufferedWriter writer = new BufferedWriter(new FileWriter("Account.txt"));
                            for(String remainingLines : newLines){
                                writer.write(remainingLines);
                                writer.newLine();
                            }
                            writer.write(inputName + " : " + newPass);
                            writer.newLine();
                            writer.close();
            
                            if(changed){
                                System.out.println("Password changed successfully!\n");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Account doesn't exist");
                    }
            }

            public static void deleteAccount(Scanner scanner){
                ArrayList<String> remainingLines = new ArrayList<String>();
                    boolean accountDeleted = false;

                    System.out.print("Input Username (Letters only): ");
                    String deleteName = scanner.next();

                    System.out.print("Input Password (Numbers only): ");
                    int deleteWord = scanner.nextInt();

                    try {
                        BufferedReader reader = new BufferedReader(new FileReader("Account.txt"));
                        String line;
                        while((line = reader.readLine()) != null){
                            if(!line.contains(deleteName + " : " + deleteWord)){
                                remainingLines.add(line);
                            } else {
                                accountDeleted = true;
                            }
                        }
                        reader.close();

                        BufferedWriter writer = new BufferedWriter(new FileWriter("Account.txt"));
                        for(String remainingLine : remainingLines){
                            writer.write(remainingLine);
                            writer.newLine();
                        }
                        writer.close();

                        if(accountDeleted){
                            System.out.println("Account deleted successfully!\n");
                        } else {
                            System.out.println("Account doesn't exist\n");
                        }
                        
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }