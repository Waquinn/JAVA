package fundamentals;

public class employee {
    
    private String firstName, lastName;
    private String title, address, sex;
    private int age;


    //Most important details:
    employee(String firstName, 
            String lastName, 
            String title){
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;

    }

    //If the details is not yet obtained:
    //allows us to have a object w/o a arguments
    
    employee(){
    /*usage of "this" here is not needed as it doesn't have 
    a parameter with a same name*/

        firstName = "N/A";
        lastName = "N/A";
        title = "N/A";
        address = "N/A";
        sex = "N/A";
        age = 0;
    }

    //Full details:
    employee(String firstName, String lastName, String title, String address, String sex, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.address = address;
        this.sex = sex;
        this.age = age;
    }

    

}
