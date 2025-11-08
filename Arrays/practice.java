import java.util.*;
public class practice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<String> things = new ArrayList<>();
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Float> percentage = new ArrayList<>();

        System.out.print("Input 5 things: ");
        for(int i=0; i<5; i++){
            things.add(in.next());
        }

        System.out.print("Input 5 colors: ");
        for(int i=0; i<5; i++){
            colors.add(in.next());
        }

        System.out.println("");

        
        for(int i=0; i<5; i++){
            System.out.println("\t\t" + colors.get(i) + " " + things.get(i));            
        }

        System.out.print("Input 3 numbers: ");
        for(int i=0; i<3; i++){
            numbers.add(in.nextInt());
        }

        System.out.println("Percentage: ");
        for(int i=0; i<3; i++){
            percentage.add((float) (numbers.get(i) * 0.1));
            System.out.print(percentage.get(i) + "\t");
        }

    }
    
}
