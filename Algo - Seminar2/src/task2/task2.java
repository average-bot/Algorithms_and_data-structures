package task2;// Source: https://www.geeksforgeeks.org/queue-using-stacks/
// Queue of two stacks
import java.util.Stack;

class Task2a {
    Stack<Integer> stackOne = new Stack<Integer>();
    Stack<Integer> stackTwo = new Stack<Integer>();

    public void enqueue(int number){ // put a number into the queue
        try {
            while (stackOne.size() > 0) { // put everything from the first stack to the second stack
                stackTwo.push(stackOne.pop());
            }
            stackOne.push(number); // put the number into the (now empty) first stack
            while (stackTwo.size() > 0) { // and put everything back to the first stack from the second stack
                stackOne.push(stackTwo.pop());
            }
        }catch(StackOverflowError e){
            System.out.println("Stack is overflowed.");
        }
    }
    public String dequeue(){ // take a first number from the queue
        if (stackOne.size() == 0){
            return "Stack 1 is empty, Underflow";
        }
        else { // if stack one is not empty take the first element from the top of the stack
            int number = stackOne.pop();
            return ""+number;
        }
    }
    public Integer peek(){
        return stackOne.peek();
    }
    public int lookup(int number){
        return stackOne.search(number);
    }
}