import java.util.ArrayDeque;

public class q11 {
    
    static class SimpleStack {
        private ArrayDeque<Integer> stack;

        public SimpleStack() {
            stack = new ArrayDeque<>();
        }

        // Push operation: Adds an element to the top of the stack
        public void push(int value) {
            stack.push(value);
            System.out.println("Pushed: " + value);
        }

        // Pop operation: Removes and returns the top element of the stack
        public int pop() {
            if (!stack.isEmpty()) {
                int value = stack.pop();
                System.out.println("Popped: " + value);
                return value;
            } else {
                System.out.println("Stack is empty!");
                return -1;  // Returning -1 if the stack is empty
            }
        }

        // Peek operation: Returns the top element without removing it
        public int peek() {
            if (!stack.isEmpty()) {
                int value = stack.peek();
                System.out.println("Peeked: " + value);
                return value;
            } else {
                System.out.println("Stack is empty!");
                return -1;  // Returning -1 if the stack is empty
            }
        }

        // Method to check if the stack is empty
        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        SimpleStack stack = new SimpleStack();

        stack.push(10);  
        stack.push(20);  
        stack.push(30);  

        stack.peek();    

        stack.pop();     
        stack.pop();     

        stack.isEmpty(); 
    }
}
