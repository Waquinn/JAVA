package abstractionOne;

public class main {
    public static void main(String[] args) {
        System.out.println("\n");
    
        
        //Concrete idea
        Animal d = new dog();
        Animal c = new cat();

        d.makeSound();
        c.makeSound();

        d.setName("Mingming");
        c.setName("Browny");

        d.showName();
        c.showName();
        
}
}