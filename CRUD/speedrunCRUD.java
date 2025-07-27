//Badillo, Mike Joequin L.
//Batch 1

import java.util.*;
import java.io.*;

public class speedrunCRUD{
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int choice;

        File origFile = new File("Student Info's.txt");
        File temp = new File("Temp.txt");
        
        do{
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update a Student");
            System.out.println("5. Delete a Student");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            choice = in.nextInt();
            in.nextLine();
            
            switch(choice){
                case 1 :
                 {
                    String resp;

                    do {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(origFile, true));
                    record(writer);
                    
                    writer.newLine();
                    writer.flush();
                    writer.close();

                    System.out.println("Want to input another record? (Y/N) ");
                    resp = in.nextLine().toUpperCase();
                    
                    } while (resp.equals("Y"));
                    break;
                }
                
                case 2 :
                {
                        String line;
                        BufferedReader reader = new BufferedReader(new FileReader(origFile));
                        
                        while((line = reader.readLine()) != null){
                            System.out.println(line);
                        }
                        reader.close();

                    break;
                }
                
                case 3 :
                {
                    String resp;

                    do{
                        BufferedReader reader = new BufferedReader(new FileReader(origFile));
                        String line;
                        boolean found = false;
                        
                        System.out.print("Search a Student By (Name/Number/Age): ");
                        String toSearch = in.nextLine().toLowerCase();
                        
                            while((line = reader.readLine()) != null){
                                if(line.toLowerCase().contains(toSearch)){
                                    System.out.println(line);
                                    found = true;
                                }
                            }
                        
                        System.out.println(found ? "Record(s) Found" : "Record Not Exist");
                        
                        reader.close();

                        System.out.println("Want to input another record? (Y/N) ");
                        resp = in.nextLine().toUpperCase();
                        
                    }while(resp.equals("Y"));

                    break;
                }
                
                case 4 : 
                {
                   
                    String resp;

                    do{

                        BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
                        BufferedReader reader = new BufferedReader(new FileReader(origFile));
                        String line;
                        boolean found = false;

                        System.out.print("Enter Key: ");
                        String key = in.nextLine().toLowerCase();

                        while((line = reader.readLine())!=null){
                            if(line.toLowerCase().contains(key)){
                                System.out.println(line);
                                System.out.println("Enter new record");
                                record(writer);
                                found = true;
                            }else{
                                writer.write(line);
                            }
                            writer.newLine();
                        }

                        writer.flush();
                        writer.close();
                        reader.close();

                        origFile.delete();
                        temp.renameTo(origFile);

                        System.out.println(found? "Success" : "Failed");

                        System.out.print("Again?: ");
                        resp = in.nextLine().toUpperCase();

                    }while(resp.equals("Y"));

                    break;
                }

                case 5 :
                {
                    String resp;

                    do{
                        BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
                        BufferedReader reader = new BufferedReader(new FileReader(origFile));
                        String line;
                        boolean found = false;

                        System.out.print("Enter Key: ");
                        String key = in.nextLine().toLowerCase();

                        while((line = reader.readLine())!=null){
                            if(line.toLowerCase().contains(key)){
                                writer.write(line);
                                
                            }else{
                                found = true;
                            }
                            writer.newLine();
                        }

                        writer.flush();
                        writer.close();
                        reader.close();

                        origFile.delete();
                        temp.renameTo(origFile);

                        System.out.println(found? "Success" : "Failed");

                        System.out.print("Again?: ");
                        resp = in.nextLine().toUpperCase();

                    }while(resp.equals("Y"));

                    break;
                }
                
                case 6 : 
                {
                    System.out.println("Goodbye");
                    break;
                }
                
                default : 
                {
                    System.out.println("Invalid Input");
                    break;
                }
            }
        } while (choice != 6);
    }

    public static void record(BufferedWriter writer) throws IOException{
        
        System.out.print("Student Number: ");
        writer.write(in.nextLine() + " : ");

        System.out.print("Student First Name: ");
        writer.write(in.nextLine() + " ");

        System.out.print("Student Last Name: ");
        writer.write(in.nextLine());
    }
}