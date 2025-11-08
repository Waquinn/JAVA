    import java.util.*;
    public class Arraylistprac{
        public static void main(String[] Args){
            ArrayList<String> fifthsector = new ArrayList<String>();

            System.out.println();
            fifthsector.add ("1");
            fifthsector.add ("2");
            fifthsector.add ("3");
            fifthsector.add ("4");
            fifthsector.add ("5");

            System.out.println(fifthsector);

            System.out.println(fifthsector.size());

            fifthsector.remove(4);
            System.out.println(fifthsector);

            System.out.println(fifthsector.get(1));

            fifthsector.clear();
            System.out.println(fifthsector);


        }
    }
