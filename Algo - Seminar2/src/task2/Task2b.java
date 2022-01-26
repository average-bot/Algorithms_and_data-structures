package task2;//Queue of one stack

import java.util.ArrayList;
import java.util.Stack;

public class Task2b {
    Stack<Integer> stackOne = new Stack<Integer>();

    public void enqueue(int number){ // put a number into the queue
        try {
            stackOne.push(number);
        }catch(StackOverflowError e){
        System.out.println("Stack is overflowed.");
        }
    }
    public int dequeue(){ // take a first number from the queue
        int last = -1;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        if (stackOne.size() == 0){
            System.out.println("There is nothing in the queue.");
        }
        else{
            while (stackOne.size() > 0){
                if (last != -1){
                    arrayList.add(last);
                }
                last = stackOne.pop();
            }
            for (Integer i : arrayList){
                stackOne.push(i);
            }
        }
        return last;
    }
    public Integer peek(){
        return stackOne.peek();
    }
    public int lookup(int number){
        return stackOne.search(number);
    }
}
