import java.util.*;
public class login {
    public static void main(String[] args) {
        
        ArrayList<String> username_S = new ArrayList<>();
        ArrayList<Integer> password_S = new ArrayList<>();
        ArrayList<String> username_L = new ArrayList<>();
        ArrayList<Integer> password_L = new ArrayList<>();
        ArrayList<String> username_LC = new ArrayList<>();
        ArrayList<Integer> password_LC = new ArrayList<>();
        char choice;

        do{

        Scanner in = new Scanner(System.in);
        
        System.out.println("[A] - Sign in"); // Create
        System.out.println("[B] - Login");   // Read
        System.out.println("[C] - Delete");   // Delete
        System.out.println("[D] - Change Password"); // Update

        System.out.print("What do you want to do? : ");
        choice = in.next().toUpperCase().charAt(0);

        
        switch(choice){
            case 'A': 
            System.out.println("Welcome to Sign in Section!\n");
            System.out.print("Input username (letters only): ");
            username_S.add(in.next());
            System.out.print("Input password (numbers only): ");
            password_S.add(in.nextInt());
            System.out.println("");
            System.out.println("Account successfully created!");

            System.out.println("");

            break;

            case 'B':
            System.out.println("Welcome to Log in Section!\n");
            System.out.print("Input username (letters only): ");
            username_L.add(in.next());
            System.out.print("Input username (numbers only): ");
            password_L.add(in.nextInt());
            System.out.println("");

            if(username_L.equals(username_S)&&password_L.equals(password_S)){
                System.out.println("Login Successfully!");
                System.out.println("");
            }
            else{
                System.out.println("Accound doesn't exist");
                System.out.println("");
            }
            break;

            case 'C':
            System.out.println("Welcome to Delete Section!\n");
            System.out.print("Input username (letters only): ");
            username_LC.add(in.next());
            System.out.print("Input password (numbers only): ");
            password_LC.add(in.nextInt());
            System.out.println("Account Exist\n");
            System.out.println("");

            if(username_L.equals(username_S)&&password_L.equals(password_S)){
                
                System.out.print("Do you want to delete it? [Y - yes | N - no]: ");
                String choice1 = in.next().toUpperCase();

                if(choice1.equals("Y")){
                    username_S.clear();
                    System.out.println("Account Successfuly deleted!");
                }

                else if(choice1.equals("N")){
                    System.out.println("DIWAG!");
                }
                else{
                    System.out.println("Error");
                }
            break;
            
            }
            System.out.println();
        
            case 'D': 
            System.out.println("Welcome to Update Section!\n");
            System.out.print("Input username (letters only): ");
            username_LC.add(in.next());
            System.out.print("Input old password (numbers only): ");
            password_LC.add(in.nextInt());
            System.out.println("Account Exist\n");
            System.out.println("");

        } 

         

 
    } while(choice!=0); 
}
}


