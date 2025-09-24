package queue;

public class main {
    public static void main(String[] args) {
        System.out.println("\n");

        Queue myQue = new Queue(5);

        System.out.println("Input Data's:");
        myQue.enqueue('A');
        myQue.enqueue('B');
        myQue.enqueue('C');
        myQue.enqueue('D');
        myQue.enqueue('E');

        System.out.println("\nDelete Data's:");
        myQue.dequeue();
        myQue.dequeue();
       
       

        System.out.println("\nCheck Front Data:");
        System.out.println(myQue.peek());

        System.out.println("\nDisplay Data's:");
        myQue.display();
        
        System.out.println("\nCheck Number of Elements Inside:");
        System.out.println(myQue.size());
        
    }

}