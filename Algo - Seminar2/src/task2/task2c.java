package task2;// stack of 2 queues
// Source: https://www.geeksforgeeks.org/implement-stack-using-queue/
import java.util.LinkedList;
import java.util.Queue;

class Task2c {
    // Two inbuilt queues
    static Queue<Integer> q1 = new LinkedList<Integer>();
    static Queue<Integer> q2 = new LinkedList<Integer>();

    // To maintain current number of
    // elements
    static int curr_size;

    void Task2c() {
        curr_size = 0;
    }

    static void push(int x) {
        curr_size++;

        // Push x first in empty q2
        q2.add(x);

        // Push all the remaining
        // elements in q1 to q2.
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }
        // swap the names of two queues
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    static int pop() {// if no elements are there in q1
        if (q1.isEmpty()) {
            System.out.println("There are no elements in the stack to pop.");
            return 0;
        }
        int removed = q1.remove();
        curr_size--;
        return removed;
    }

    static int top() {
        if (q1.isEmpty())
            return -1;
        return q1.peek();
    }

    static int size() {
        return curr_size;
    }
}
