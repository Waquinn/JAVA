import java.util.*;

public class java{
    public static void main(String[]args){
        
        Scanner in = new Scanner(System.in);
        char choice;

        do {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("[A] - 1d Array");
            System.out.println("[B] - 2d Array");
            System.out.println("[C] - Exit");
            System.out.print("Enter your choice: ");
            choice = Character.toUpperCase(in.next().charAt(0));

            switch (choice) {

                case 'A':
                System.out.println();
    
                // 1 dollar = 57.25
                System.out.println("[1] - Dollar to Peso \n[2] - Peso to Dollar");
                System.out.print("What exchange do you want to execute?: ");
                int option = in.nextInt();
    
                switch(option){
                    
                  
                    case 1 : 
                    double[] dol  = new double[3];
                    
                        for (int i=0; i<3; i++){
                        System.out.print("Input amount in dollars: ");
                        dol[i] = in.nextDouble();
                        System.out.println("Your dollar to peso will be: " + dol[i]*57.21);
                        }
    
                    break;
    
                    case 2 : 
                    double[] peso  = new double[3];
    
                        for (int i=0; i<3; i++){
                        System.out.print("Input amount in peso: ");
                        peso[i] = in.nextDouble();
                        System.out.println("Your dollar to peso will be: " + peso[i]*0.017);
                        }
    
                    break;
    
                case 'B':
                    
                int[][] number = new int[2][3];
                int[] num = new int[6];

                System.out.println("Enter 6 numbers: ");
                for (int i=0, k=0; i<2; i++){
                    for (int j=0; j<3; j++, k++){
                        num[k] =  number[i][j] = in.nextInt();
                    }

                }

                Arrays.sort(num);
                for(int i =0, k=0; i<2; i++){
                    for ()

                }

                    break;

                case 'C':
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please select A, B, or C.");
            }

           
            if (choice != 'C') {
                System.out.print("\nDo you want to go back to the main menu? (yes/no): ");
                String response = in.next().toLowerCase();
                if (!response.equals("yes")) {
                    break; 
                }
            }

            } System.out.println("Program terminated.");
            in.close();

        
        }  while (choice != 'C');
    
}
}




