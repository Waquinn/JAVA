package fundamentals;

public class student {

    //Attributes of our subject student:
    //Global variables:
    int year;
    double mterm, fterm;
    String fname, lname, course, section;

    //Our constructor:
    //Initialization:
    //yung nasa loob ng parenthesis and after ng equals/= is arguments
    //the word "this" enables us to use the global variables inside our student class

    student(String fname, String lname, String course, String section,
    int year, double mterm, double fterm){
        this.fname = fname;
        this.lname = lname;
        this.course = course;
        this.section = section;
        this.year = year;
        this.mterm = mterm;
        this.fterm = fterm;
    }

    void introduceSelf(){
        System.out.println("Hello! I am " + fname + " " + lname + "," + "\nfrom " 
        + course + " " + section + " currently,\n" + year + "nd student " 
        + "nice to meet you!" );
    }
    
    void gradeEval(){
        double ave = (mterm + fterm)/2;
        System.out.println("Hello your average is " + 
        ave + "\n");
        
        String remark = " ";

        if(ave>100) remark = "Invalid grade";
        else if(ave>=98) remark = "Congratulations! With Highest Honors";
        else if(ave>=95) remark = "Congratulations! With High Honors";
        else if(ave>=90) remark = "Congratulations! With Honors";
        else if(ave>=75) remark = "Congratulations! Passed";
        else if(ave<=74) remark = "I'm sorry! Failed :<";
        else remark = "Invalid input!";
        
        System.out.println(remark);
    }
}
