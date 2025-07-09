package abstractionOne;

//hide the object
//doesn't allow instantiation for it
//Animal a = new Animal();
public abstract class Animal {

    String name;

    //this will force us to override it, for it's inheritors
    abstract void makeSound();

    void showName(){
        System.out.println("Name " + name);
    }
        
    void setName(String name){
        this.name = name;
    }
    
}
