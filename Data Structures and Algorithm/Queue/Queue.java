package queue;

public class Queue {

    private int size;        // Sets the max number/element our array can hold.
    private char[] que;
    private int front;       // Front of the queue.
    private int rear;        // Back of the queue.


    //Constructor:
    Queue(int size){
        this.size = size;
        
        // We set the maximum size of array can hold
        // base on the number we input in the variable "size".
        que = new char[size];

        // This tell us our stack starts as empty one.
        front = -1; 
        rear = -1;

    }


    // isEmpty() - checks if Queue is Empty.
    boolean isEmpty(){
        // front and rear equals to " -1 " means stack is empty.
        return front == -1 && rear == -1;
  
    }


    // is Full() - checks if Queue is Full.
    boolean isFull(){
        // We get the current place of our rear then subtract it to:
        // The maximum size of our array can hold.
        // If it returns the value of the last index, it means that it was full.
        // Example how to get the last index:
        // If array size or the max number it can hold is = 5
        // Simply subtract 1 from it, to get the last index.
        // " 5 - 1  = 4 " meaning out last index is equals to  " 4 ".
        
        return rear == size -1;
       
    }

    // enqueue() - adds a Value on the Rear.
    // The data type our parameter must use is the same with:
    // the data type we used with our queue;
    void enqueue(char data){

        if(isFull()) System.out.println("Full Queue!");

        else if(isEmpty()){
            //First time enqueue
            front = 0;
            rear = 0; 

            que[rear] = data;

            // Awares us that the enqueue is successful
            System.out.println("Enqueued " + data);
        }

        else {
            // Move our index location one place ahead.
            ++rear; 

            // We call our queue, then we place put our desired data
            // to the current top index location.
            que[rear] = data;

            // Awares us that the enqueue is successful
            System.out.println("Enqueued " + data);
        }
    }

    // dequeue() - removes a Value on the Front.
    void dequeue(){

        if(isEmpty()){
            //Queue is already EMPTY.
            System.out.println("Empty Queue!");

        }else if((front+1) > rear){
            //Front is greater than Rear. RESET!
            System.out.println("Dequeued " + que[front]);
            que[front] = '\0';
            front = -1;
            rear = -1;
        }else{
            //Normal Dequeue
            System.out.println("Dequeued " + que[front]);
            que[front] = '\0';
            front ++;

        }
            
        
    }

    // peek() - returns the Value on the Front.
    char peek(){
        if (isEmpty()){
            System.out.println("Queue is Empty!");
            return '\0';
        } 
        else{
            return que[front];
        }
    }

    // size() - Returns the Size of the Queue.
    int size(){
        if(isEmpty()) System.out.println("Queue is Empty!");
        return size = (rear - front ) + 1;
    }

    // display() - Displays the Queue.
    void display(){
        if(isEmpty()) System.out.println("Queue is Empty!");

        else{
            // Prints the data inside the Queue in FI-FO format.
            // int i = top; - sets the program to start from top index.
            for(int i=front; i<rear; i++){
                System.out.print(que[i] + " ");
            }
            System.out.println("");
        }

    }

    
}
