import java.util.*;
import java.io.*;

public class createtoupdate {

    public static void main(String[] args) {
        try{
            prog();
        }catch(IOException e){
            System.out.println("Error" + e.getMessage());

        }

    }
    public static void prog()throws IOException{
        
        Scanner in = new Scanner(System.in);
        int choice;
        File origFile = new File("Student Records - P.txt");
        File temp = new File("Temp.txt");

        do{

        System.out.println("\n1 - Add student");
        System.out.println("2 - View student");
        System.out.println("3 - Search Student");
        System.out.println("4 - Update ");
        System.out.println("5 - Exit");
        System.out.print("Your choice: ");
        choice = in.nextInt();
        in.nextLine();

        switch(choice){

            case 1:{
                //allows us to create a txt file
                BufferedWriter writer = new BufferedWriter(new FileWriter("Student Records - P.txt", true));
                
                String resp;
                do{
                
                //set of datas na lalagay natin sa txt
                System.out.print("Input student nummber: ");
                writer.write(in.nextInt() + " : ");
                in.nextLine();
                System.out.print("Input student first name: ");
                writer.write(in.nextLine() + " ");
                System.out.print("Input student last name: ");
                writer.write(in.nextLine() + " ");

                writer.flush();
                writer.newLine();

                System.out.println("Do you want to add another?: ");
                resp = in.nextLine();

                }while(resp.equalsIgnoreCase("Y"));{
                    writer.close();
                    System.out.println("Input Success");
                }

                break;
            }

            case 2:{

                BufferedReader reader = new BufferedReader(new FileReader("Student Records - P.txt"));
                String data;

                System.out.println("\nStudent Records\n");
                while((data = reader.readLine()) !=null){
                    System.out.println(data);
                }

                reader.close();

                break;
            }

            case 3:{

               BufferedReader reader = new BufferedReader(new FileReader("Student Records - P.txt"));
               String resp;
               String data;
               boolean found = false;

               do{
               System.out.println("Enter Key: ");
               String key = in.nextLine();

                while((data = reader.readLine()) !=null){
                    if(data.toLowerCase().contains(key.toLowerCase())){
                        System.out.println("Found" + data);
                        found = true;
                    }
                }
                    
                reader.close();

                System.out.println(found? "Records found" : "Records not found");
                
                System.out.println("Search Again: ");
                resp = in.nextLine();

            }while(resp.equalsIgnoreCase("Y"));{
                break;
               }
                
            }

            case 4:{
                BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
                BufferedReader reader = new BufferedReader(new FileReader("Student Records - P.txt"));
                String line;
                boolean found = false;

                System.out.print("Enter Student info: ");
                String key = in.nextLine().toLowerCase();

                while((line = reader.readLine()) !=null){
                    if(line.toLowerCase().contains(key)){

                        System.out.print("New Student Number: ");
                        writer.write(in.next() + " : ");
                        in.nextLine();

                        System.out.print("New Student First Name: ");
                        writer.write(in.nextLine() + " ");

                        System.out.print("New Student Last Name: ");
                        writer.write(in.nextLine() + " ");

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

                System.out.println(found? "Update success" : "Update failed");
                
                break;
                
            }

        
            case 5:{
                System.out.println("Goodbye!");
                return;
            }  

            default:
                    System.out.println("Invalid input");
            break; 

        }
        }while(choice !=5);
    }
}

    

