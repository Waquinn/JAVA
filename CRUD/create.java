import java.util.*;
import java.io.*;
import java.nio.file.Files;

public class create {
    // dito nacocompile mga txt na ginagawa
    private static final String ToDo_Folder = "ToDoListJAVA";

    private static Scanner in = new Scanner(System.in);
       public static void main(String[] args) {

        //printing of functions in the program
        while(true){
        System.out.println("\nWelcome!");
        System.out.println("[A] - Create List");
        System.out.println("[B] - Add Task");
        System.out.println("[C] - Read List");
        System.out.println("[D] - Update Task");
        System.out.println("[F] - Delete List/Task");
        System.out.println("[E] - Exit Program");
        System.out.print("\nWhat do you want to do? : ");
        char choice = in.next().toUpperCase().charAt(0);
        in.nextLine();


            switch(choice){
                case 'A':
                    createTodoList();
                    break;

                case 'B':
                    addTask();
                    break;

                case 'C':
                    ReadList();
                    break;

                case 'D':
                    updateTask();
                    break;

                case 'F':
                    delete_List_Task();
                break;

                case 'E':
                    System.out.println("Good Bye!");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            
            }
        }  
    }

    //program sa pag create ng file
    private static void createTodoList(){
        
        System.out.print("Enter name of the new to do list: ");
        String name =  in.nextLine();

        //naglolocate ng file sa "ToDo Folder"
        File file = new File(ToDo_Folder + "/" + name + ".txt" );

            //para malaman if existing na yung file
            if(file.exists()){
                System.out.println("This list already exist!");
                return;
            }

            //pag di pa nag e-exist file baba dito para mag create ng bago
            try(PrintWriter writer = new PrintWriter(file)) {
                writer.println("To Do List: " + name);
                System.out.println("To do list '" + name + "' created successfully.");

            }catch (Exception e) {
                System.out.println("Creation failed");

            }    

    }

    // program sa pag add ng task sa loob ng file
    private static void addTask(){

        System.out.print("Enter the name of the To-Do list, to add task: ");
        String name =  in.nextLine();

        //naglolocate ng file sa "ToDo Folder"
        File file = new File(ToDo_Folder + "/" + name + ".txt");

        // checheck if nag e-exist ba yung file name sa folder
        if(!file.exists()){
            System.out.println("ToDo list does not exist :<");
            return;
        }

        //if nag e-exist prooced sa add ng task section

        System.out.print("Add task: ");
        String task = in.nextLine();


        try(FileWriter writer = new FileWriter(file, true)) {
            writer.write("[ ]" + task + "\n");
            System.out.println("Task Added Successfully!");
            
        } catch (Exception e) {
            System.out.println("Error adding task.");
        }
    }

    //program for reading the task inside the list available
    private static void ReadList(){
        System.out.print("Enter the name of To-Do list to open: ");
        String name = in.nextLine();

         //naglolocate ng file sa "ToDo Folder"
         File file = new File(ToDo_Folder + "/" + name + ".txt");

         //checheck if nag e-exist ba yung file name sa folder
         if(!file.exists()){
            System.out.println("To-Do list does not exist :<");
            return;
        }
        
        //pag nag e-exist yung file o-open ng scanner
        try (Scanner fileScanner = new Scanner(file)) {

            //p-print lahat ng laman ng file
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }

        } catch (IOException e) {
            System.out.println("Error reading list.");
        }
    }

    private static void updateTask(){
        System.out.print("Enter the name of ToDo list: ");
        String name = in.nextLine();

         //naglolocate ng file sa "ToDo Folder"
         File file = new File(ToDo_Folder + "/" + name + ".txt");

         //checheck if nag e-exist ba yung file name sa folder
         if(!file.exists()){
            System.out.println("ToDo list does not exist :<");
            return;
        }

        try {
            List<String> lines = new ArrayList<>(Files.readAllLines(file.toPath()));
            System.out.println("Current tasks:");

            for (int i = 1; i < lines.size(); i++) {
                System.out.println((i) + ". " + lines.get(i));
            }

            System.out.print("Enter the task number to mark as completed: ");
            int taskNumber = in.nextInt();
            in.nextLine();

            if (taskNumber > 0 && taskNumber < lines.size()) {
                lines.set(taskNumber, lines.get(taskNumber).replace("[ ]", "[X]"));
                Files.write(file.toPath(), lines);
                System.out.println("Task updated successfully.");
                
            } else {
                System.out.println("Invalid task number.");
            }

        } catch (IOException e) {
            System.out.println("Error updating task.");
        }

    }  

    private static void delete_List_Task(){
        System.out.println("[1] Delete entire list");
        System.out.println("[2] Delete specific task");
        System.out.print("Enter your choice: ");
        int choice = in.nextInt();
        in.nextLine();

        switch(choice){

            case 1:
                deleteTodoList();
            break;

            case 2:
                deleteTask();
            break;


        }

    }

    private static void deleteTodoList() {
        System.out.print("Enter the name of the To-Do list to delete: ");
        String name = in.nextLine();
    
        File file = new File(ToDo_Folder + "/" + name + ".txt");
    
        if (!file.exists()) {
            System.out.println("To-Do list does not exist :<");
            return;
        }
    
        if (file.delete()) {
            System.out.println("To-Do list '" + name + "' deleted successfully.");
        } else {
            System.out.println("Failed to delete the To-Do list.");
        }
    }

    private static void deleteTask() {
        System.out.print("Enter the name of the To-Do list: ");
        String name = in.nextLine();
    
        File file = new File(ToDo_Folder + "/" + name + ".txt");
    
        if (!file.exists()) {
            System.out.println("To-Do list does not exist :<");
            return;
        }
    
        try {
            List<String> lines = new ArrayList<>(Files.readAllLines(file.toPath()));
    
            if (lines.size() <= 1) { 
                System.out.println("No tasks found in the To-Do list.");
                return;
            }
    
            System.out.println("Current tasks:");
            for (int i = 1; i < lines.size(); i++) {
                System.out.println(i + ". " + lines.get(i));
            }
    
            System.out.print("Enter the task number to delete: ");
            int taskNumber = in.nextInt();
            in.nextLine(); 
    
            if (taskNumber > 0 && taskNumber < lines.size()) {
                lines.remove(taskNumber);
                Files.write(file.toPath(), lines);
                System.out.println("Task deleted successfully.");
            } else {
                System.out.println("Invalid task number.");
            }
    
        } catch (IOException e) {
            System.out.println("Error deleting task.");
        }
    }
    
    
}


