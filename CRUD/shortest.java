import java.util.*;
import java.io.*;

public class shortest{
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
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
            
            switch(choice){
                case 1 :{
                    String again;
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Student Info.txt", true));
                    do {
                    System.out.print("Student Name: ");
                    writer.write(scanner.nextLine());
                    writer.write(scanner.nextLine() + ":");
                    
                    System.out.print("Student Number: ");
                    writer.write(scanner.next() + ":");
                    
                    System.out.print("Student Age: ");
                    writer.write(scanner.next());
                    
                    writer.newLine();
                    writer.flush();
                    
                    System.out.println("Want to input another record? (Y/N) ");
                    again = scanner.next().toUpperCase();
                    
                    } while (again.equals("Y"));
                    
                    writer.close();
                    break;
                }
                
                case 2 :{
                    String line;
                    BufferedReader reader = new BufferedReader(new FileReader("Student Info.txt"));
                    
                    while((line = reader.readLine()) != null){
                        System.out.println(line);
                    }
                    
                    reader.close();
                    break;
                }
                
                case 3 :{
                    BufferedReader reader = new BufferedReader(new FileReader("Student Info.txt"));
                    String line;
                    boolean found = false;
                    
                    System.out.print("Search a Student By (Name/Number/Age): ");
                    scanner.nextLine();
                    String toSearch = scanner.nextLine();
                    
                    while((line = reader.readLine()) != null){
                        if(line.contains(toSearch)){
                            System.out.println(line);
                            found = true;
                            break;
                        }
                    }
                    
                    if(found){
                        System.out.println("Record Founded");
                    } else {
                        System.out.println("Record Not Found");
                    }
                    
                    reader.close();
                    break;
                }
                
                case 4: {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
                    BufferedReader reader = new BufferedReader(new FileReader("Student Records - P.txt"));
                    String line;
                    boolean found = false;
                    
                    System.out.print("Search a Student By (Name/Number/Age): ");
                    scanner.nextLine();
                    String toUpdate = scanner.nextLine().toLowerCase();
                    
                    while((line = reader.readLine()) != null){
                        if(line.toLowerCase().contains(toUpdate)){
                            System.out.println(line);
                            
                            System.out.println("Input another set of record");
                            
                            System.out.print("Student Name: ");
                            writer.write(scanner.nextLine() + ":");

                            System.out.print("Student Number: ");
                            writer.write(scanner.next() + ":");

                            System.out.print("Student Age: ");
                            writer.write(scanner.next());
                            
                            found = true;
                        } else {
                            writer.write(line + "\n");
                        }
                    }
                    
                    writer.flush();
                    writer.close();
                    reader.close();

                    origFile.delete();
                    temp.renameTo(origFile);

                    System.out.println(found ? "Record has been updated" : "Record Not Found");

                    break;
                }
                
                case 5 :{
                    BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
                    BufferedReader reader = new BufferedReader(new FileReader("Student Info.txt"));
                    String line;
                    boolean found = false;
                    
                    System.out.print("Search a Student By (Name/Number/Age): ");
                    scanner.nextLine();
                    String toDelete = scanner.nextLine().toLowerCase();
                    
                    while((line = reader.readLine()) != null){
                        if(!line.toLowerCase().contains(toDelete)){
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
                    
                    System.out.println(found ? "Record has been deleted" : "Record Not Found");

                    break;
                }
                
                case 6 :{
                    System.out.println("Goodbye");
                    break;
                }
                
                default :{
                    System.out.println("Invalid Input");
                    break;
                }
            }
        } while (choice != 6);
    }
}