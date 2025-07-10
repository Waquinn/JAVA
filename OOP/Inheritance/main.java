package inheritance;

public class main {
    public static void main(String[] args) {
        System.out.println("\n");


        //Instantiation of the objects:
        
        // parent p = new parent();
        // toddler t = new toddler();


        //Putting values within the objects attributes:
        // p.name = "Mike";
        // p.sex = "Male";
        // p.age = 18;

        /*You will see here that eventhough there's nothing
        inside the toddler class in can still have the functions
        of the parent class, because of the "inheritance or the word extends" */
        // t.name = "Gel";
        // t.sex = "Female";
        // t.age = 18;

        // p.checkStatus();
        // t.checkStatus();

        /*As what you can see her the toddler class is the only one
        who can access the drink method, as it was inside it, and 
        not inside the parent class.*/


        // t.drink(); - prints "Now drinking water"
        // p.drink(); - error

        //Now that we have done calling the super class constructor
        //We can do it like this now:

        parent p1 = new parent("Mike", "Male", 18);
        toddler t1 = new toddler("Angel", "Female", 18, "CODM");
        kid k = new kid("Kin", "Male", 7, "ML", 10);

        /*We can also instantiate the following subclasess using the 
        super class, cause all of them is inheriting from the super class

        parent p1 = new parent("Mike", "Male", 18);
        parent t1 = new toddler("Angel", "Female", 18, "CODM");
        parent k = new kid("Kin", "Male", 7, "ML", 10);
        
        
        */

        p1.checkStatus();
        t1.checkStatus();
        k.checkStatus();
        k.drink();
        //exclusive only for the kid class
        k.glevel();


    }
}