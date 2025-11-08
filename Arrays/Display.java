import java.util.*;
public class Display {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> things = new ArrayList<>();
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<Float> numbers = new ArrayList<>();
        ArrayList<Float> percentage = new ArrayList<>();

        System.out.print("Input 5 Things: ");
        for(int i=0; i<5; i++){
            things.add(in.next());
        }

        System.out.print("Input 5 Colors: ");
        for(int i=0; i<5; i++){
            colors.add(in.next());
        }

        System.out.println("");

        for(int i=0; i<5; i++){
            System.out.print( "\t\t" +colors.get(i) + "\t" + things.get(i) + "\n");
        }

        System.out.println("");

        System.out.print("Input 3 numbers: ");
        for(int i=0; i<3; i++){
            numbers.add(in.nextFloat());
        }
        System.out.println("");
        
        System.out.println("Percentage:");
        for(int i=0; i<3; i++){
            percentage.add((float) (numbers.get(i) * 0.1));
            System.out.print(percentage.get(i) + "\t");
        }

        System.out.println("");
    }
}
