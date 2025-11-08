import java.io.*;
import java.util.*;

public class lib{
    public static void main(String[] args) {
        File FILE = new File("Books.txt");
        Scanner scanner = new Scanner(System.in);
        int choice; 
        int uniqueId = 20240000;

        if(FILE.exists() && FILE.length() != 0){
            uniqueId = updateUniqueId(uniqueId) + 1;
        }

        do {
        System.out.println("[1] - Add a Book");
        System.out.println("[2] - View All Books");
        System.out.println("[3] - Search for a Book");
        System.out.println("[4] - Update a Book");
        System.out.println("[5] - Delete a Book");
        System.out.println("[6] - Exit");
        System.out.print("Choice: ");
        choice = scanner.nextInt();

        switch(choice){
            case 1:
            addBook(scanner, uniqueId, FILE);
            uniqueId += 1;
            System.out.println("----------------------------------------------------------------------------------------------");
            break;

            case 2:
            viewBook(FILE);
            System.out.println("----------------------------------------------------------------------------------------------");
            break;

            case 3:
            searchBook(scanner, FILE);
            System.out.println("----------------------------------------------------------------------------------------------");
            break;

            case 4:
            updateBook(scanner, FILE);
            System.out.println("----------------------------------------------------------------------------------------------");
            break;

            case 5:
            deleteBook(scanner, FILE);
            System.out.println("----------------------------------------------------------------------------------------------");
            break;

            case 6:
            System.out.println("Thank you for using the book management system!");
            System.out.println("----------------------------------------------------------------------------------------------");
            System.exit(0);
            break;

            default:
            System.out.println("Invalid input. Please enter a valid option.");
            System.out.println("----------------------------------------------------------------------------------------------");
            break;
        }
        } while (choice != 6);
    }

    static void addBook(Scanner scanner, int uniqueId, File FILE){
        System.out.print("Book Title: ");
        String title = scanner.next();

        System.out.print("Author: ");
        String author = scanner.next();

        System.out.print("Publication Year: ");
        String year = scanner.next();

        System.out.print("Status ([1] - Available & [2] - Checked Out): ");
        String status = scanner.next();

        if(status.equals("1")){
            status = "Available";
        } else {
            status = "Checked Out";
        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE, true))){
            writer.write(uniqueId + "," + title + "," + author + "," + year + "," + status);
            writer.newLine();
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    } 

    static void viewBook(File FILE){
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE))){
            String line;

            System.out.println(String.format("%-10s%-20s%-15s%-15s%-10s", "BookID", "Title", "Author", "Year", "Status"));
            System.out.println("----------------------------------------------------------------------------------------------");
            while((line = reader.readLine()) != null){
                String[] book = line.split(",");

                System.out.println(String.format("%-10s%-20s%-15s%-15s%-10s", book[0], book[1], book[2], book[3], book[4]));
            }

            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static int updateUniqueId(int uniqueId){
        int highest = 0;

        try(BufferedReader reader = new BufferedReader(new FileReader("Books.txt"))){
            String line;

            while((line = reader.readLine()) != null){
                String[] book = line.split(",");

                int toInt = Integer.parseInt(book[0]);

                if(highest < toInt){
                    highest = toInt;
                }
            }

            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return highest;
    }

    static void searchBook(Scanner scanner, File FILE){
        boolean found = false;
        System.out.println("Search for a Book: ");
        System.out.println("[1] - By Book ID");
        System.out.println("[2] - By Title");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();

        System.out.println("----------------------------------------------------------------------------------------------");

        switch(choice){
            case 1:
            System.out.print("Enter Book ID: ");
            int bookId = scanner.nextInt();

            try(BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
                String line;

                while((line = reader.readLine()) != null){
                    String[] book = line.split(",");
                    int id = Integer.parseInt(book[0]);
                    
                    if(id == bookId){
                        System.out.println("The following book was found:");
                        System.out.println(String.format("%-10s%-20s%-15s%-15s%-10s", "BookID", "Title", "Author", "Year", "Status"));
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(String.format("%-10s%-20s%-15s%-15s%-10s", book[0], book[1], book[2], book[3], book[4]));
                        found = true;
                        break;
                    }
                }

                if(!found){
                    System.out.println("Book ID does not exist");
                }

                reader.close();
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
            break;

            case 2:
            System.out.print("Enter Book Title: ");
            String title = scanner.next();

            try(BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
                String line;

                while((line = reader.readLine()) != null){
                    String[] book = line.split(",");
                    
                    if(title.equals(book[1])){
                        System.out.println("The following book was found:");
                        System.out.println(String.format("%-10s%-20s%-15s%-15s%-10s", "BookID", "Title", "Author", "Year", "Status"));
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(String.format("%-10s%-20s%-15s%-15s%-10s", book[0], book[1], book[2], book[3], book[4]));
                        found = true;
                        break;
                    }
                }

                if(!found){
                    System.out.println("Book Title does not exist");
                }

                reader.close();
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
            break;

            default:
            System.out.println("Invalid input. Please enter a valid option.");
            break;
        }
    }

    static void updateBook(Scanner scanner, File FILE){
        boolean found = false;
        File tempFile = new File("temp.txt");

            System.out.print("Enter Book ID: ");
            int bookId = scanner.nextInt();

            try(BufferedReader reader = new BufferedReader(new FileReader(FILE)); 
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true))) {
                String line;

                while((line = reader.readLine()) != null){
                    String[] book = line.split(",");
                    int id = Integer.parseInt(book[0]);
                    
                    if(id == bookId){
                        System.out.println("The following book was found:");
                        System.out.println(String.format("%-10s%-20s%-15s%-15s%-10s", "BookID", "Title", "Author", "Year", "Status"));
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(String.format("%-10s%-20s%-15s%-15s%-10s", book[0], book[1], book[2], book[3], book[4]));

                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println("Update Book Information:");

                        System.out.print("Book Title: ");
                        book[1] = scanner.next();

                        System.out.print("Author: ");
                        book[2] = scanner.next();

                        System.out.print("Publication Year: ");
                        book[3] = scanner.next();

                        System.out.print("Status ([1] - Available & [2] - Checked Out): ");
                        book[4] = scanner.next();

                        if(book[4].equals("1")){
                            book[4] = "Available";
                        } else {
                            book[4] = "Checked Out";
                        }

                        writer.write(book[0] + "," + book[1] + "," + book[2] + "," + book[3] + "," + book[4]);
                        writer.newLine();

                        found = true;
                    } else {
                        writer.write(book[0] + "," + book[1] + "," + book[2] + "," + book[3] + "," + book[4]);
                        writer.newLine();
                    }
                }

                writer.flush();
                writer.close();
                reader.close();

                if(!found){
                    System.out.println("Book ID does not exist");
                } else {
                    System.out.println("Book Information has been updated");
                }
            } catch (IOException e){
                System.out.println(e.getMessage());
            }

            FILE.delete();
            tempFile.renameTo(FILE);
    }

    static void deleteBook(Scanner scanner, File FILE){
        boolean found = false;
        File tempFile = new File("temp.txt");

            System.out.print("Enter Book ID: ");
            int bookId = scanner.nextInt();

            try(BufferedReader reader = new BufferedReader(new FileReader(FILE)); 
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true))) {
                String line;

                while((line = reader.readLine()) != null){
                    String[] book = line.split(",");
                    int id = Integer.parseInt(book[0]);
                    
                    if(id == bookId){
                        found = true;
                        continue;
                    } else {
                        writer.write(book[0] + "," + book[1] + "," + book[2] + "," + book[3] + "," + book[4]);
                        writer.newLine();
                    }
                }

                writer.flush();
                writer.close();
                reader.close();

                if(!found){
                    System.out.println("Book ID does not exist");
                } else {
                    System.out.println("Book Successfully Deleted");
                }
            } catch (IOException e){
                System.out.println(e.getMessage());
            }

            FILE.delete();
            tempFile.renameTo(FILE);
    }
}