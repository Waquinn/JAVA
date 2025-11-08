import java.util.*;
import java.io.*;

public class shortestwmethods{
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int choice;

        File origFile = new File("Student Info.txt");
        File temp = new File("Temp.txt");
        
        do{
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update a Student");
            System.out.println("5. Delete a Student");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch(choice){
                case 1 :
                 {
                    String again;

                    do {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(origFile, true));
                    writeRecord(writer);
                    
                    writer.newLine();
                    writer.flush();
                    writer.close();

                    System.out.println("Want to input another record? (Y/N) ");
                    again = scanner.nextLine().toUpperCase();
                    
                    } while (again.equals("Y"));
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
                    BufferedReader reader = new BufferedReader(new FileReader(origFile));
                    String line;
                    boolean found = false;
                    
                    System.out.print("Search a Student By (Name/Number/Age): ");
                    String toSearch = scanner.nextLine().toLowerCase();
                    
                    while((line = reader.readLine()) != null){
                        if(line.toLowerCase().contains(toSearch)){
                            System.out.println(line);
                            found = true;
                        }
                    }
                    
                    System.out.println(found ? "Record(s) Found" : "Record Not Exist");
                    
                    reader.close();
                    break;
                }
                
                case 4 : 
                {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
                    BufferedReader reader = new BufferedReader(new FileReader(origFile));
                    String line;
                    boolean found = false;
                    
                    System.out.print("Search a Student By (Name/Number/Age): ");
                    String key = scanner.nextLine().toLowerCase();
                    
                    while((line = reader.readLine()) != null){
                        if(line.toLowerCase().contains(key)){
                            System.out.println(line);
                            
                            System.out.println("Input another set of record");
                            
                            writeRecord(writer);
                            
                            found = true;
                        } else {
                            writer.write(line);
                        }
                        writer.newLine();
                    }
                    
                    writer.flush();
                    writer.close();
                    reader.close();

                    origFile.delete();
                    temp.renameTo(origFile);

                    System.out.println(found ? "Record has been updated" : "Record Not Exist");

                    break;
                }
                
                case 5 :
                {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
                    BufferedReader reader = new BufferedReader(new FileReader(origFile));
                    String line;
                    boolean found = false;
                    
                    System.out.print("Search a Student By (Name/Number/Age): ");
                    String key = scanner.nextLine().toLowerCase();
                    
                    while((line = reader.readLine()) != null){
                        if(!line.toLowerCase().contains(key)){
                            writer.write(line);
                        } else {
                            found = true;
                        }
                        writer.newLine();
                    }
                    
                    writer.flush();
                    writer.close();
                    reader.close();
                    
                    origFile.delete();
                    temp.renameTo(origFile);
                    
                    System.out.println(found ? "Record(s) has been deleted" : "Record Not Exist");

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

    public static void writeRecord(BufferedWriter writer) throws IOException{
        
        System.out.print("Student Number: ");
        writer.write(scanner.nextLine() + " : ");

        System.out.print("Student First Name: ");
        writer.write(scanner.nextLine() + " ");

        System.out.print("Student Last Name: ");
        writer.write(scanner.nextLine());
    }
}