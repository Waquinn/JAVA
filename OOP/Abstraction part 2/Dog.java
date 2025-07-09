package abstractionTwo;

public class Dog implements Animal, landAnimal{

    //public before the method is necessary
    //because the Animal interface is set to public
    
    public void makeSound(){
        System.out.println("Arf!");
    }

    public void walk(){
         System.out.println("Walk!");
    }
    
}