package stacks;

public class Stacks {
    
    private int size;       // Sets the max number/element our array can hold.
    private char[] stck;
    private int top;        // Top is equivalent to our current index location.


    //Constructor:
    Stacks(int size){
        this.size = size;
        
        // We set the maximum size of array can hold
        // base on the number we input in the variable "size".
        stck = new char[size];

        // This tell us our stack starts as empty one.
        top = -1; 

    }
    
    // isEmpty() - checks if Stack is Empty.
    boolean isEmpty(){
        // index equals to " -1 " means stack is empty.
        return top == -1;
    }


    // isFull() - checks if Stack is Full/
    boolean isFull(){
        // We get the current place of our index then subtract it to:
        // The maximum size of our array can hold.
        // If it returns the value of the last index, it means that it was full.
        // Example how to get the last index:
        // If array size or the max number it can hold is = 5
        // Simply subtract 1 from it, to get the last index.
        // " 5 - 1  = 4 " meaning out last index is equals to  " 4 ".
        
        return top == size -1;

    }

    // push(x) - adds a Value on Top
    // The data type our parameter must use is the same with:
    // the data type we used with our stack;
    void push(char data){

        if(isFull()) System.out.println("Stack Overflow!");

        else {
            // Move our index location one place ahead.
            ++top; 

            // We call our stack, then we place put our desired data
            // to the current top index location.
            stck[top] = data;

            // Awares us that the push is successful
            System.out.println("Pushed " + data);
        }
    }

    // pop() - removes a Value on Top
    void pop(){

        if(isEmpty()) System.out.println("Stack Underflow!");

        else{
            // Removes the value in our top index.
            System.out.println("Popped " + stck[top]);

            // the function of ' \ ' here tells that the next character is special 
            stck[top] = '\0';
            top--;

        }

    }

    // peek() - returns the Value on Top
    char peek(){
        return stck[top];
    }

    // size() - returns the Size of the Stack
    int size(){
        return size = top + 1;
    }

    // display() - displays the Stack
    void display(){
        if(isEmpty()) System.out.println("Stack is Empty!");

        else{
            // Prints the data inside the stack in FI-LO format.
            // int i = top; - sets the program to start from top index.
            for(int i=top; i>=0; i--){
                System.out.println(stck[i]);
            }
        }
    }

}
