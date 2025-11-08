import java.io.*;
import java.util.*;

public class CRUD{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        File myFile = new File("crud.txt");
        while(true){
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            int option = in.nextInt();

            switch(option){
            case 1:
            System.out.print("Enter Name: ");
            String name = in.next();
               try{
                FileWriter writer = new FileWriter(myFile, true);   
                writer.write(name);
                writer.close();
               } catch(IOException e){
                System.out.println("Error");
               }
            break;
            }
        }
    }
}