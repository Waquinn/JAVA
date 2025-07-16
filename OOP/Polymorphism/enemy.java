package polymorphism;

public class enemy {

    //Base class, all of the methods that subclass can do 
    //have it's foundation here

    String name;
    int hp;

    void dialogue(){
        System.out.println("Please override me");    
    }
    
    void showStats(){
        System.out.println(name + " : " + hp);
    }
}
