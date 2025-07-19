package stacks;

public class main {
    public static void main (String[] args) {
      System.out.println("");


      //Creates an object stack:
      Stacks myStack = new Stacks(5);

      // Inputs data to the stack:
      System.out.println("Input data's");
      myStack.push('M');
      myStack.push('i');
      myStack.push('k');
      myStack.push('e');
      myStack.push('E');
        
      // Deletes 2 previously inputted data.
      System.out.println("\nDelete 2 previous inputted data");
      myStack.pop();
      myStack.pop();

      // Returns the current top value.
      System.out.println("\nCurrent top element/value:");
      System.out.println(myStack.peek());
      
      // Checks the current number of elements inside the stack.
      System.out.println("\nCurrent stack size:");
      System.out.println(myStack.size());

      // Display the values/elements inside the stack in FI-LO format.
      System.out.println("\nElements inside the stack: ");
      myStack.display();
    }
    
}