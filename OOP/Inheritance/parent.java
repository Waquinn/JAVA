package inheritance;

public class parent {

    String name, sex;
    int age;

    //Superclass constructor:
    parent(String name, String sex, int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
        

    }

    void checkStatus(){
        System.out.println("Name : " + name);
        System.out.println("Sex : " + sex);
        System.out.println("Age : " + age);
    }
    
}
