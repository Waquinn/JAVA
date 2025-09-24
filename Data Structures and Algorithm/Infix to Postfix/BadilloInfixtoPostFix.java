import java.util.Scanner;
import java.util.Stack;

public class BadilloInfixtoPostFix {
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
        // Call the static method correctly
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
        Stack<Character> stack = new Stack<>();

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
}
