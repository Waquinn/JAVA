package inheritance;

public class kid extends toddler {

    //New attributes
    int gradelevel;

    //We inherit from the toddler class
    kid(String name, String sex, int age, String favgame, int gradelevel){
        super(name, sex, age, favgame);
        this.gradelevel = gradelevel;

    }

    void glevel(){
        System.out.println(name + " grade level is " + gradelevel);
    }
    
}
