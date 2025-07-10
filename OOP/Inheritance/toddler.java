package inheritance;

/*this allows the toddler class to inherit all the methods, etc 
in the parent class*/
public class toddler extends parent {

    //this is only accessible for toddler class
    void drink(){
        System.out.println("Now drinking water");
    }

    //Call the constructor of superclass:
    //We are only required to call the superclass constructor 
    //To enable as us new attributes

    //Let's add new attribute to show you:

    String favgame;

    toddler(String name, String sex, int age, String favgame) {
        super(name, sex, age);

    //This attribute can only be access in toddler class
        this.favgame = favgame;

    }


    //Override:
    void checkStatus(){
        super.checkStatus();
        System.out.println("Favorite game: " + favgame);
    }
        
}
