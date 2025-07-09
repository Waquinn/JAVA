package abstractionTwo;

public class Bird implements Animal, airAnimal{
    
    //public before the method is necessary
    //because the Animal interface is set to public
    
    public void makeSound(){
        System.out.println("Chip!");
    }

    public void fly(){
        System.out.println("Fly!");
    }

    public void walk(){
        System.out.println("Walk!");
    }
    
}