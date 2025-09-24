import java.util.Scanner;

public class WStack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        do{

            System.out.println("\n=== Infix to PostFix Converter ===");
            System.out.println("Note: Infix expression should NOT have spaces!");
            System.out.print("Enter Infix Expression: ");
            String infix = in.nextLine();

        if(infix.contains(" ")) {
            System.out.println("Infix expression should NOT have spaces! Please input another.");
        }

        else{
            String postfix = InfixToPostfix.convert(infix);
            System.out.println("Postfix expression: " + postfix);
        }
        
        }while(true);
    }
}

class InfixToPostfix {
    private static int hierarchy(char given) {
        switch (given) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1; 
    }

    public static String convert(String infix) {
        StringBuilder result = new StringBuilder();
        Stacks stack = new Stacks(infix.length());

        for (int i = 0; i < infix.length(); i++) {
            char given = infix.charAt(i);

            if (Character.isLetter(given)) {
                result.append(given);
            }
        
            else if (given == '(') {
                stack.push(given);
            }
          
            else if (given == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); 
            }
       
            else {
                while (!stack.isEmpty() && hierarchy(given) <= hierarchy(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(given);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static class Stacks{
        private static int top;
        private static char[] stck;
        private static int size;

        Stacks(int size){
            this.size = size;
            stck = new char[size];
            top = -1;
        }

        boolean isEmpty(){
            return top == -1;
        }

        boolean isFull(){
            return top == size - 1;
        }

       void push(char data){

            if(isFull());

            else{
                ++top;
                stck[top] = data;
            }
        }

        char pop(){

            if(isEmpty()); 
            else{
                stck[top] = '\0';
                top--;
                return stck[top];
            } 
            return 0;
        }

        char peek(){
            return stck[top];
        }
    }
}