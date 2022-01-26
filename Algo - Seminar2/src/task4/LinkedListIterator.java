package task4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

// linked list with iterator
public class LinkedListIterator {

    Integer linkedListIterator(int size, int passes){
        LinkedList<Integer> nodes = new LinkedList<Integer>();
        for (int i = 0; i < size; i++) {
            nodes.add(i);
        }
        ListIterator here = nodes.listIterator();
        here.next();
        while (nodes.size() > 1) {
            int count = 0;
            while (count != passes) {
                if (!here.hasNext()) {
                    here = nodes.listIterator();// start the iterator again
                }
                here.next();
                count++;
            }
            here.remove();
        }
        return nodes.get(0);
    }
}
