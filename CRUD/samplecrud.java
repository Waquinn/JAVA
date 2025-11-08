import java.io.*;
import java.nio.file.Files;
import java.util.*;
public class samplecrud {
    private static final String DIRECTORY = "ToDoListJAVA";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        File dir = new File(DIRECTORY);
        if (!dir.exists()) {
            dir.mkdir();
        }

        while (true) {
            System.out.println("\nTo Do List Manager");
            System.out.println("[1] Create New List");
            System.out.println("[2] Add Task");
            System.out.println("[3] Read List");
            System.out.println("[4] Update Task");
            System.out.println("[5] Delete List or Task");
            System.out.println("[6] Exit");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    createNewList();
                    break;
                case 2:
                    addTask();
                    break;
                case 3:
                    readList();
                    break;
                case 4:
                    updateTask();
                    break;
                case 5:
                    deleteOption();
                    break;
                case 6:
                    System.out.println("Good Bye!");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }


            
            private static void createNewList() {
                System.out.print("Enter the name of the new to do list: ");
                String name = scanner.nextLine();
                File file = new File(DIRECTORY + "/" + name + ".txt");
                if (file.exists()) {
                    System.out.println("To Do List already exists!");
                    return;
                }
                try (PrintWriter writer = new PrintWriter(file)) {
                    writer.println("To Do List: " + name);
                    System.out.println("To do list '" + name + "' created successfully.");
                } catch (IOException e) {
                    System.out.println("Error creating list.");
                }
            }

            private static void addTask() {
                System.out.print("Enter the to do list name to add a task: ");
                String name = scanner.nextLine();
                File file = new File(DIRECTORY + "/" + name + ".txt");
                if (!file.exists()) {
                    System.out.println("To do list does not exist!");
                    return;
                }
                System.out.print("Enter the task: ");
                String task = scanner.nextLine();
                try (FileWriter writer = new FileWriter(file, true)) {
                    writer.write("[ ] " + task + "\n");
                    System.out.println("Task added successfully.");
                } catch (IOException e) {
                    System.out.println("Error adding task.");
                }
            }

            private static void readList() {
                System.out.print("Enter the to do list name to read: ");
                String name = scanner.nextLine();
                File file = new File(DIRECTORY + "/" + name + ".txt");
                if (!file.exists()) {
                    System.out.println("To-do list does not exist!");
                    return;
                }
                try (Scanner fileScanner = new Scanner(file)) {
                    while (fileScanner.hasNextLine()) {
                        System.out.println(fileScanner.nextLine());
                    }
                } catch (IOException e) {
                    System.out.println("Error reading list.");
                }
            }

            private static void updateTask() {
                System.out.print("Enter the to do list name to update: ");
                String name = scanner.nextLine();
                File file = new File(DIRECTORY + "/" + name + ".txt");
                if (!file.exists()) {
                    System.out.println("To do list does not exist!");
                    return;
                }
                try {
                    List<String> lines = new ArrayList<>(Files.readAllLines(file.toPath()));
                    System.out.println("Current tasks:");
                    for (int i = 1; i < lines.size(); i++) {
                        System.out.println((i) + ". " + lines.get(i));
                    }
                    System.out.print("Enter the task number to mark as completed: ");
                    int taskNumber = scanner.nextInt();
                    scanner.nextLine();
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

            private static void deleteOption() {
                System.out.println("[1] Delete entire list");
                System.out.println("[2] Delete specific task");
                System.out.print("Enter your choice:");

        
    }
}
