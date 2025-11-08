import java.util.*;
public class ArrayListQuiz {
    /**
     * @param args
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        /* 
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Integer> ages = new ArrayList<Integer>();  
        int total =0;*/
        

        /* 
        System.out.println("________________________");
        System.out.println("Name and Age");
        System.out.println("________________________");

        for (int i=0; i<5; i++){
            System.out.print("Input 5 names # " + (i+1) + ":");
            names.add(in.next());
        }
        
        System.out.println();

        for (int x=0; x<5; x++){
            System.out.print("Input 5 age" + (x+1) + ":");
            ages.add(in.nextInt());
            total += ages.get(x);

            }

            

        
        System.out.println();
        System.out.println(ages);
        System.out.println(names);
        System.out.println(total); */


        System.out.println();
        ArrayList<Integer> values1 = new ArrayList<Integer>();
        ArrayList<Integer> values2 = new ArrayList<Integer>();
        int total =0;

        for (int i=0; i<3; i++){
            for (int x=0; x<1; x++){
                System.out.print("Input Value #1: ");
                values1.add(in.nextInt());

                System.out.print("Input Value #2: ");
                values2.add(in.nextInt());

                total = values1.get(i)*values2.get(i);
                System.out.println("Product " + total);


            }

        }
        
        
    }
}
