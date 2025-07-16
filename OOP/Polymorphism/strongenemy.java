package polymorphism;

public class strongenemy extends enemy {

    //Access attributes from the superclass, and override it

    strongenemy() {
        name = "yey";
        hp = 1000;
    }

    //Access methods from the superclass, and override it

    strongenemy(String name){
        this.name = name;
        hp = 1000;
    }

    void dialogue(){
        System.out.println("I am strong!");
    }

    
}
