package abstractionTwo;

public class Frog implements Animal, waterAnimal, landAnimal{

    //public before the method is necessary
    //because the Animal interface is set to public
    
    public void makeSound(){
        System.out.println("Kokak!");
    }
    
    public void swim(){
        System.out.println("Swim!");
    }

    public void walk(){
        System.out.println("Walk!");
    }
}
