import java.util.*;
public class JavaApplication25 {
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
int choice;

do {
 
 System.out.print("[1]2d Array input multiplication table \n[2]2d Array 2x5 and 3x9 \n[3] Exit Program \nWhat do you want to do?: ");
    choice = in.nextInt();
    
    switch (choice){
        case 1 : 
            System.out.println(" ");
            int rows, columns;
            
            System.out.print("Desired rows: ");
            rows = in.nextInt();
            
            System.out.print("Desired rows: ");
            columns = in.nextInt();
            
            int[][] table = new int[rows][columns];
            
            for (int i=0; i<rows; i++){
                for(int j=0; j<columns; j++){
                    table[i][j]= (i+1)*(j+1);
                    System.out.print(table[i][j] + "\t");
                }
                System.out.println(" ");
            }
            break;
            
        case 2 : 
            System.out.println(" ");
            int[][]table1 = new int[2][5];
            int number = 100;
    
            for (int row=0; row<2; row++){
                for (int col=0; col<5; col++){

                    table1[row][col]= number;
                    number -=10;
                    System.out.print(table1[row][col] + "\t");
                }
                System.out.println(" ");
            }
    
            System.out.println(" ");

            int[][]table2 = new int[3][9];
            int number1 = -30;

            for (int row=0; row<3; row++){
                for (int col=0; col<9; col++){

                    table2[row][col]= number1;
                    number1 +=10;
                    System.out.print(table2[row][col] + "\t");
                }
                System.out.println(" ");
            }
            break;
            
        case 3 : System.out.println("hehe done na");
        break;
            
        default: System.out.println("Wrong Input");
        break;
    }
 }while(choice!=3);
}
}
