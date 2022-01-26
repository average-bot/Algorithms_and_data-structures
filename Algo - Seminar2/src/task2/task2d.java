package task2;// stack of one queue
// my own creation although I am not sure if it is the best implementation

import java.util.ArrayDeque;

class Task2d {

        ArrayDeque<Integer> intQ = new ArrayDeque<>();

        public void push(int number){
            intQ.addFirst(number);
        }
        public int pop(){
            if (intQ.size() > 0) {
                int last = intQ.pollFirst();
                return last;
            }
            else {
                System.out.println("There is nothing in the stack.");
                return -1;
            }
        }
        public int top(){
            if (intQ.size() > 0){
                return intQ.peek();
            }
            return -1;
        }
        public int size(){
            return intQ.size();
        }
}


