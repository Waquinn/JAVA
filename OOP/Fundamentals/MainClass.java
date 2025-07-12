package fundamentals;
public class MainClass {
    public static void main(String[] args) {
    System.out.println("\n");
    
        //Object that have full details:
        employee n = new employee("Mike","Joequin",
        "Prof","Bul","M",19 );

        //Object that have only important details:
        //this was possible because of overloading method:
        //where in one of our constructors have only this paramaters
        employee n1 = new employee("Mike",
        "Joequin","Prof");

        //Object that doesn't have a data yet:
        employee n2 = new employee();

    }
}
