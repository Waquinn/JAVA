package circularQueue;

public class circQueue {
    private int size;        // Sets the max number/element our array can hold.
    private char[] que;
    private int front;       // Front of the queue.
    private int rear;        // Back of the queue.


    //Constructor:
    circQueue(int size){
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


    // is Full() - checks if Cicular Queue is Full.
    boolean isFull(){
        // This checks if our front and rear is equal, if it was it means the queue is already full
        return (front == (rear + 1) % size);
       
    }

    // enqueue() - adds a Value on the Rear.
    // The data type our parameter must use is the same with:
    // the data type we used with our queue;
    void enqueue(char data){

        if(isFull()) System.out.println("Full Circular Queue!");

        else if(isEmpty()){
            //First time enqueue
            front = 0;
            rear = 0; 

            que[rear] = data;

            // Awares us that the enqueue is successful
            System.out.println("Enqueued " + data);
        }

    

        else {
            // To avoid out of bounds we use this condition:
            // Where in it sets the location of the front/rear to comeback at index 0 
            // Every time it is already greater than our Queue can handle
            rear = (rear + 1) % size;

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
            System.out.println("Empty Circular Queue!");

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
            // To avoid out of bounds we use this condition:
            // Where in it sets the location of the front/rear to comeback at index 0 
            // Every time it is already greater than our Queue can handle
            front =(front + 1) % size;
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
            // Prints the data inside the Circular Queue in FI-FO format.
            // This tells us that we should print first the data inside front.
            int i = front;
            // As long as the statement is true
            while(true){ 
                // We will print the data inside it
                System.out.println(que[i] + " ");
                // And if our front reaches our rear, it means we have printed all the data.
                if(i==rear) break;
                // To avoid out of bounds we use this condition:
                // Where in it sets the location of the front/rear to comeback at index 0 
                // Every time it is already greater than our Queue can handle
                i = (i+1) % size;
                
            }
        }
    }
}
