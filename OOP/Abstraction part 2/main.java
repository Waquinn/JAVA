package abstractionTwo;

public class main {
    public static void main(String[] args) {

        //Abstract Idea
        //Animal a = new Animal();


        //Use the it's own class name to nstantiate it 
        //when not doing inheritance
        //enable to do all the methods inside it's class
        Dog D = new Dog();
        Bird B = new Bird();
        Frog F = new Frog();

        D.makeSound();
        B.makeSound();
        F.makeSound();

        

    }
}
