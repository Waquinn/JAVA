import java.util.*;
public class testingquiz {
    public static void main(String[] args) {
        
    
    Scanner scanner = new Scanner (System.in);

            ArrayList<String> things = new ArrayList<>();
            ArrayList<String> colors = new ArrayList<>();
            ArrayList<Double> numbers = new ArrayList<>();
            ArrayList<Double> percentage = new ArrayList<>();

            System.out.print("Input 5 Things: ");
            for (int i = 0; i < 5; i++){
                things.add(scanner.next());
            }

            System.out.print("Input 5 Colors: ");
            for (int j = 0; j < 5; j++){
                colors.add(scanner.next());
            }

            System.out.println("");
            for (int x = 0; x < 5; x++){
                System.out.print("\t\t" + colors.get(x) + " " + things.get(x) + "\n");
            }

            System.out.println("");
            System.out.print("Input 3 Numbers: ");
            for (int k = 0; k < 3; k++){
                numbers.add(scanner.nextDouble());
            }

            System.out.println("");
            System.out.println("Ten Percent of the numbers: ");
            for (int z = 0; z < 3; z++){
                percentage.add(numbers.get(z) * 0.1);
                System.out.print( "\t\t" + percentage.get(z));
            }

}
}
