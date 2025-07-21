package ArrayOfObjects;

import java.util.*;
public class Main {
    public static void main (String[] args){
        System.out.println("\n");

        Scanner in = new Scanner(System.in);

        System.out.print("How many students you want to input?: ");
        int size = in.nextInt();
        in.nextLine();
        
        Student studs[] = new Student[size];

        for(int i=0; i<size; i++){

            String fname, lname, course;
            int year;
            char section;

            System.out.println("Student #" + (i+1));

            System.out.print("First Name: ");
            fname = in.nextLine();

            System.out.print("Last Name: ");
            lname = in.nextLine();

            System.out.print("Course: ");
            course = in.nextLine();

            System.out.print("Year: ");
            year = in.nextInt();
            in.nextLine();

            System.out.print("Section: ");
            section = in.nextLine().charAt(0);

            //Follow the sequence you have in your constructor:
            studs[i] = new Student(fname, lname, year, course, section);
            


        }
        
        for(int i=0; i<size; i++){
            studs[i].introduceSelf();
        }
    }  
}
