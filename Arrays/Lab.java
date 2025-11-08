import java.util.*;


public class Lab {
    public static void main(String[] args) {
       

        Scanner x = new Scanner(System.in);
        ArrayList<Integer> snum = new ArrayList<>();
        ArrayList<String> lname = new ArrayList<>();
        ArrayList<String> fname = new ArrayList<>();
        ArrayList<String> mname = new ArrayList<>();
        ArrayList<String> status = new ArrayList<>();
        ArrayList<Integer> lec = new ArrayList<>();
        ArrayList<Integer> lab = new ArrayList<>();

        ArrayList<Double> tot1 = new ArrayList<>();
        ArrayList<Integer> lt = new ArrayList<>();
        ArrayList<Integer> lb = new ArrayList<>();

        ArrayList<Double> tot2 = new ArrayList<>();

        
        System.out.println("\t\t Student Information System");
        System.out.println("____________________________________________");
        
        for (int i = 0; i < 3; i++) {
        
           
            System.out.print("Student No.: ");
            snum.add(x.nextInt());


            // galing here pwede makapag input user ng more than 1 name
            System.out.print("Lastname: ");
            String Ln = x.next();
            lname.add(Ln);

            System.out.print("Firstname: ");
            String Fn = x.next();
            fname.add(Fn);

            System.out.print("Middlename: ");
            String Mn = x.next();
            mname.add(Mn);


            System.out.print("Input Student Status (R-Regular / I-Irregular): ");
            // di na po dapat nag declare ng string here yung gamit mo nalang din na status sa arraylist dapat bebi
            //status.add(x.next()); ganto po syntax
            status.add(x.next());
            
            String studentStatus = status.get(i);
            // yung arraylist na status na dapat here
            switch (studentStatus) { 
                case "R":
                case "r":
                    System.out.print("Number of Lecture Units to be enrolled: ");
                    // yung array integer na rin po dapat here
                    // lec.add(in.nextInt());

                    lec.add(x.nextInt());

                    // dapat po after na ng user mag input ng lecture and lab units nag computee pero okie din naman s'ya mas hahaba lang po program

                    double amlec = lec.get(i) * 285.75;

                    
                    System.out.print("Number of Laboratory Units to be enrolled: ");
                    // yung array integer na rin po dapat here
                    // lab.add(in.nextInt());

                    
                    

                    lab.add(x.nextInt());
                    double amlab = lab.get(i) * 2500.00;


                    // yung tot1 po int nalang po dapat s'ya para doon na ipapasok computation
                    // pwede na rin direct computation here
                    // tot1 = (lec.get(i)*285.75 + lab.get(i)*2500);
                    

                    double am3 = amlec + amlab; 
                    tot1.add(am3);

                    // print ng tot1
                    // add ng mga details
                    System.out.println("");
                    System.out.println(snum);
                    System.out.println(lname);
                    System.out.println(fname);
                    System.out.println(mname);
                    System.out.println(status);
                    System.out.println(lec);
                    System.out.println(lab);
                    System.out.println(tot1);
                    System.out.println("");
                    
                    System.out.println("Total Amount to be paid: " + am3);

                    System.out.println();

                    break;

                case "I":
                case "i":
                    System.out.print("Number of Lecture Units to be enrolled: ");
                    // yung array integer na rin po dapat here
                    // lec.add(in.nextInt());

                    lt.add(x.nextInt());

                    // dapat po after na ng user mag input ng lecture and lab units nag computee
                    double am2lec = lt.get(i) * 389.79;

                    System.out.print("Number of Laboratory Units to be enrolled: ");
                    // yung array integer na rin po dapat here
                    // lab.add(in.nextInt());

                    lb.add(x.nextInt());
                    double am2lab = lt.get(i) * 3800.00;


                    // yung tot2 po int nalang po dapat s'ya para doon na ipapasok computation
                    // tot2 = (lec.get(i)*389.79 + lab.get(i)*3800);
                    double am6 = am2lec + am2lab; 
                    tot2.add(am6);

                    // print ng tot2
                    System.out.println("");
                    System.out.println(snum);
                    System.out.println(lname);
                    System.out.println(fname);
                    System.out.println(mname);
                    System.out.println(status);
                    System.out.println(lt);
                    System.out.println(lb);
                    System.out.println(tot2);
                    System.out.println("");
                    System.out.println("Total Amount to be paid: " + am6);
                    System.out.println("");
                    break;

                default:
                    System.out.println("Invalid status entered.");

                    break;
                    // add ng break
                    // break;

            }


            /*  lalagay po to sa end ng case 1 and case 2
            System.out.println(snum);
            System.out.println(lname);
            System.out.println(fname);
            System.out.println(mname);
            System.out.println(status);
            System.out.println(lec);
            System.out.println(lab);
            System.out.println(tot1);
            System.out.println(lt);
            System.out.println(lb);
            System.out.println(tot2);
            */
        } 
    }

    }

