package abstractionTwo;

public interface airAnimal extends landAnimal {
    
    void fly();


    //for us to put a body inside a method 
    //when declaring inside the interface "default" keyword must be use
    default void talk(){
        System.out.println("Hello!");
    }
}
