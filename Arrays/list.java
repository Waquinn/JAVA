import java.util.*;
public class list {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        ArrayList<Double> numbers = new ArrayList<>();
        ArrayList<Double> percentage = new ArrayList<>();

        System.out.println("");
        System.out.print("Input 3 numbers: ");
        for (int i=0; i<3; i++){
            numbers.add(in.nextDouble());
        }

        System.out.println("");
        System.out.println("Percentage: ");
        for (int i=0; i<3; i++){
            percentage.add(numbers.get(i)*0.1);
            System.out.print(percentage.get(i) + "\t");
        }

        System.out.println("");


    }
}
