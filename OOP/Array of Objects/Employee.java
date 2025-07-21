package ArrayOfObjects;

public class Employee {
    
    public String fname, lname;
    String jobTitle;

    public Employee(String fname, String lname, String jobTitle) {

        this.fname = fname;
        this.lname = lname;
        this.jobTitle = jobTitle;
    }

    void introduceSelf(){
        System.out.println("Hello I'm " + fname + " " + lname + " and you are?");
    }
    
}
