import java.util.*;
import java.io.*;
public class crud3 {
    public static void main(String[] args) {
        


		Scanner scanner = new Scanner(System.in);
		String choice;
		int userChoice;
		
		do {
		System.out.println("Student Information System.");
		System.out.println("1. Add Student");
		System.out.println("2. View Student");
		System.out.println("3. Exit");
		System.out.print("Choice: ");
		userChoice = scanner.nextInt();
		
		switch(userChoice){
		  case 1:
		  do {
		  try(BufferedWriter writer = new BufferedWriter(new FileWriter("Student Info.txt", true))){
		    System.out.print("Input Student No.: ");
		    writer.write(scanner.next() + ", ");
            
		    
		    System.out.print("Input Student Last Name: ");
		    writer.write(scanner.nextLine() + ", ");
            writer.write(scanner.nextLine());
		    
		    System.out.print("Input Student First Name: ");
		    writer.write(scanner.next());
           
		    
		    writer.newLine();
		    writer.flush();
		    writer.close();
		  } catch (IOException e) {
		    System.out.println(e.getMessage());
		  }
		  
		  System.out.print("Add another record (Y/N): ");
		  choice = scanner.next().toUpperCase();
		  } while (choice.equals("Y"));
		  break;
		  
		  case 2:
		  try(BufferedReader reader = new BufferedReader(new FileReader("Student Info.txt"))){
		    String line;
		    
		    while((line = reader.readLine()) != null){
		      System.out.println(line);
		    }
		  } catch (IOException e) {
		    System.out.println(e.getMessage());
		  }
		  break;
		  
		  case 3:
		  System.exit(0);
		  break;
		  
		  default:
		  System.out.println("Invalid Input");
		  break;
		}
		
		} while(userChoice != 3);
	}
}
