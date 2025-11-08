import java.util.*;
public class hehe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.println("\nMAIN MENU");
            System.out.println("[A] --> 1D Array");
            System.out.println("[B] --> 2D Array");
            System.out.println("[C] --> ArrayList");
            System.out.println("[D] --> Exit");
            System.out.print("\nYour Choice?: ");
            choice = sc.next().toUpperCase().charAt(0);

            switch (choice) {
                case 'A': {
                   double[] rates = {56.0, 0.018}; // USD to PHP, PHP to USD rate (example rates)
                    System.out.println("Currency Converter");
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
        
                    System.out.println("Convert to: (1) Peso (2) Dollar");
                    int option = sc.nextInt();
        
                if (option == 1) {
                      System.out.println("Converted to Peso: PHP " + (amount * rates[0]));
                    } else if (option == 2) {
                    System.out.println("Converted to Dollar: $" + (amount * rates[1]));
                    } else {
                    System.out.println("Invalid option.");
                 }
                        break;
            }
                    

                case 'B': {
                    int[][] array2D = new int[2][4];
                    int value = 6;

                    for (int row = 0; row < 2; row++) {
                        for (int col = 0; col < 4; col++) {
                            array2D[row][col] = value;
                            System.out.print(array2D[row][col] + " ");
                            value -= 2;
                        }
                        System.out.println();
                    }
                    break;
                }

                case 'C': {
                    ArrayList<String> prod = new ArrayList<>();
                    ArrayList<Double> price = new ArrayList<>();
                    ArrayList<Double> discount = new ArrayList<>();

                    System.out.println("Enter 5 Products:");
                    for (int i = 0; i < 5; i++) {
                        System.out.print("Product " + (i + 1) + ": ");
                        prod.add(sc.next());
                    }

                    System.out.println("Enter Prices:");
                    for (int i = 0; i < 5; i++) {
                        System.out.print("Price for " + prod.get(i) + ": ");
                        price.add(sc.nextDouble());
                    }

                    System.out.println("\n\tProduct\tPrice\t50% Discount");
                    for (int i = 0; i < 5; i++) {
                        discount.add(price.get(i) * 0.5);
                        System.out.println("\t" + prod.get(i) + "\t" + price.get(i) + "\t" + discount.get(i));
                    }
                    break;
                }

                case 'D':
                    System.out.println("Thank you for using the program!");
                    break;

                default:
                    System.out.println("INVALID CHOICE! Please enter A, B, C, or D.");
            }  
            
            if (choice != 'D') {
                System.out.print("\nDo you want to go back to the main menu? (yes/no): ");
                String response = sc.next().toLowerCase();
                if (!response.equals("yes")) {
                    break; 
                }

            } System.out.println("Program terminated.");

        } while (choice != 'D');
    }
}
        


