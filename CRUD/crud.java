import java.util.*;
import java.io.*;
public class crud {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        int choice;
        
        File origFile = new File("StudentInfo.txt");
        File temp = new File("temp.txt");
        
        do{
            System.out.println("1 Add Student");
            System.out.println("2 View Student");
            System.out.println("3 Search Student");
            System.out.println("4 Update a Student");
            System.out.println("5 Delete a Student");
            System.out.println("6 Exit");
            System.out.print("Your Choice?: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch(choice){
                case 1 : {
                String again;
                    do{
                        BufferedWriter writer = new BufferedWriter(new FileWriter (origFile, true));
                        writeRecord(writer);
                        
                        writer.newLine();
                        writer.flush();
                        writer.close();
                        
                        System.out.print("Do you want to input another record? (Y/N) : ");
                        again = scanner.nextLine().toUpperCase();
                        
                    }while(again.equals("Y"));
                    break;
                }
                case 2: {
                    String line;
                    BufferedReader reader = new BufferedReader(new FileReader(origFile));
                    
                    while((line = reader.readLine()) !=null){
                        System.out.println(line);
                    }
                    reader.close();
                    break;
                }
                case 3 : {
                    String again;
                    do{
                        BufferedReader reader = new BufferedReader(new FileReader(origFile));
                        String line;
                        boolean found = false;
                        
                        System.out.print("Search a student by (name/number/age) : ");
                        scanner.next();
                        String toSearch = scanner.nextLine().toLowerCase();
                        
                        while((line = reader.readLine()) != null){
                            if(line.toLowerCase().contains(toSearch)){
                                System.out.println(line);
                                found = true;
                            }
                        }
                        reader.close();
                        System.out.println(found ? "Record(s) Found" : "Record not exist");
                        System.out.print("Search again?: ");
                        again = scanner.next();
                        
                        
                    }while(again.equalsIgnoreCase("Y"));
                            break;
                    }
                case 4 :{
                    boolean found = false;
                    BufferedWriter writer = new BufferedWriter(new FileWriter (temp));
                    BufferedReader reader = new BufferedReader(new FileReader(origFile));
                    
                    System.out.println("Update a student: ");
                    scanner.nextLine();
                    String update = scanner.nextLine().toLowerCase();
                    
                    String line;
                    while((line = reader.readLine()) != null){
                        if(line.toLowerCase().contains(update)){
                            System.out.println("Input new records");
                            writeRecord(writer);
                            writer.newLine();
                            found = true;
                        }else{
                            writer.write(line + "\n");
                        }
                    }
                            writer.flush();
                            writer.close();
                            reader.close();
                            
                            origFile.delete();
                            temp.renameTo(origFile);
                            
                    System.out.println(found ? "Record has been updated" : "Record not exist");
                    
                    break;
                }
                case 5 : {
                     boolean found = false;
                    BufferedWriter writer = new BufferedWriter(new FileWriter (temp));
                    BufferedReader reader = new BufferedReader(new FileReader(origFile));
                    
                    System.out.println("Delete a student: ");
                    scanner.nextLine();
                    String update = scanner.nextLine().toLowerCase();
                    
                    String line;
                    while((line = reader.readLine()) != null){
                        if(!line.toLowerCase().contains(update)){
                            writer.write(line + "\n");
                        }else{
                            found = true;
                        }
                    }
                            writer.flush();
                            writer.close();
                            reader.close();
                            
                            origFile.delete();
                            temp.renameTo(origFile);
                            
                    System.out.println(found ? "Record has been deleted" : "Record not exist");
                    
                    break;
                }
                case 6 : {
                    System.out.println("Thankyou, Goodbye!");
                    break;
                }
                default : {
                    System.out.println("Invalid Input");
                    break;
                }
            }
        }while (choice !=6);
    }
    public static void writeRecord(BufferedWriter writer) throws IOException{
        
        System.out.print("Student Name: ");
        writer.write(scanner.nextLine());
        writer.write(scanner.nextLine() + ":");
        
        System.out.print("Student Number: ");
        writer.write(scanner.nextLine() + ":");
        
        System.out.print("Student Age: ");
        writer.write(scanner.nextLine());
    }
}