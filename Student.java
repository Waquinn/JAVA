package ArrayOfObjects;

public class Student {

    private String fname, lname;
    private int year;
    private String course;
    private char section;

    Student(String fname, 
            String lname, 
            int year, 
            String course, 
            char section){

        this.fname = fname;
        this.lname = lname;
        this.year = year;
        this.course = course;
        this.section = section;

    }

    void introduceSelf(){
        System.out.println("Full Name    : " + fname + " " + lname);
        System.out.println("Course/Yr/Sec: " + course + " - " + year + section);
 
    }

}
