package polymorphism;

public class weakenemy extends enemy{

    //Access attributes from the superclass, and override it

    weakenemy(){
        name = "hehe";
        hp = 200;
    }

    //Access methods from the superclass, and override it

    void dialogue(){
        System.out.println("I am weak :<");
    }

}
