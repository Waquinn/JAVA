import java.util.*;
import java.io.*;
import java.nio.file.Files;

public class CPFproject {
    public static void main(String[] args) {
        try {
            prog();
        } catch (IOException e) {
            System.out.println("Error process" + e.getMessage());
        }
        
    }

    public static void prog() throws IOException{
        Scanner in = new Scanner(System.in);
        int choice;

        do{

            System.out.println("\n[1] - Add Student");
            System.out.println("[2] - View Records");
            System.out.println("[3] - Search Student");
            System.out.println("[4] - Update Student Info");
            System.out.println("[5] - Delete Records/Student");
            System.out.println("[6] - Exit/Close Program");
            System.out.print("What do you want to do?: ");
            choice = in.nextInt();

            switch(choice){
                
                case 1:{
                
                        BufferedWriter writer = new BufferedWriter(new FileWriter("Student Records - P.txt", true));
                        String resp;

                            do{
                            
                            System.out.print("Input Student Number: ");
                            writer.write(in.nextInt() + ": ");
                            in.nextLine();

                            System.out.print("Input Student First Name: ");
                            writer.write(in.nextLine() + " ");

                            System.out.print("Input Student Last Name: ");
                            writer.write(in.nextLine());

                            writer.newLine();
                            writer.flush();

                            System.out.print("Do you want to add another record? [Y - Yes | N - No]: ");
                            resp = in.next();
                            
                                }while(resp.equalsIgnoreCase("Y"));{
                                    writer.close();
                                    System.out.println("Input Successful!");
                                }

                break;
                }

                case 2:{
                
                        BufferedReader reader = new BufferedReader(new FileReader("Student Records - P.txt"));
                        String data;

                        System.out.println("\nStudent Lists:\n");
                        while((data = reader.readLine()) !=null){
                            System.out.println(data + "");
                        }

                        reader.close();
                        
                break;
                }

                case 3: {

                    String  resp;

                    do{

                    System.out.print("Enter keyword to search (Student Number or Name): ");
                    in.nextLine();
                    String keyword = in.nextLine();

                            BufferedReader reader = new BufferedReader(new FileReader("Student Records - P.txt"));
                            String line;
                            boolean found = false;

                            System.out.println("\nStudent Records:\n");
                            while ((line = reader.readLine()) != null) {
                                if (line.toLowerCase().contains(keyword.toLowerCase())) {
                                    System.out.println(line);
                                    found = true;
                                }
                            }   

                            reader.close();
                                                        //true                  false
                            System.out.println(found? "Records found\n" : "Error loading records\n");
                        
                            System.out.print("Do you want to search another record? [Y - Yes | N - No]: ");
                            resp = in.next();

                        }while(resp.equalsIgnoreCase("Y"));{
                        }
                            
                break;
                }

                case 4:{

                    String resp;

                    do{

                    System.out.print("Enter Student Number/Key to update: ");
                    in.nextLine();
                    String studKey = in.nextLine();

                            BufferedReader reader = new BufferedReader(new FileReader("Student Records - P.txt"));
                            StringBuilder updatedData = new StringBuilder();
                            String line;
                            boolean updated = false;

                            while ((line = reader.readLine()) != null) {
                                if (line.toLowerCase().contains(studKey.toLowerCase())) {
                                    System.out.println("Record Found: " + line);
            
                                    System.out.print("Enter new student number: ");
                                    String sNum = in.nextLine();

                                    System.out.print("Enter new First Name: ");
                                    String nFname = in.nextLine();

                                    System.out.print("Enter new Last Name: ");
                                    String nLname = in.nextLine();

                                    updatedData.append(sNum + ": " + nFname + " " + nLname + "\n");
                                    updated = true;
                                } else {
                                    updatedData.append(line + "\n");
                                }
                            }   

                            reader.close();

                            if (updated) {
                                BufferedWriter writer = new BufferedWriter(new FileWriter("Student Records - P.txt"));
                                writer.write(updatedData.toString());
                                writer.close();
                                System.out.println("Record updated successfully.");
                            } else {
                                System.out.println("Student Number not found.");
                            }

                            System.out.print("Do you want to update another record? [Y - Yes | N - No]: ");
                            resp = in.next();

                    }while(resp.equalsIgnoreCase("Y"));{

                    }

                break;
                }
                    
               
                case 5:{
                    
                    File file = new File("Student Records - P.txt");
                    
                        List<String> lines = new ArrayList<>(Files.readAllLines(file.toPath()));

                        System.out.println("\nStudent Records:");
                        for (int i = 0; i < lines.size(); i++) {
                            System.out.println((i + 1) + ". " + lines.get(i));
                        }

                        System.out.print("Enter the student number to delete (by list number): ");
                        int index = in.nextInt();
                        in.nextLine();

                        if (index > 0 && index <= lines.size()) {
                            lines.remove(index - 1); 
                            Files.write(file.toPath(), lines);
                            System.out.println("Student record deleted successfully.");
                        } else {
                            System.out.println("Invalid student number.");
                        }

                break;
                }

                case 6:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid input");
                break;    

            }

        }while(choice != 6); 

    }           
    }
