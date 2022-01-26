package task3;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException { //INT ONLY
        //LinkedList3 is the real approach and
        //LinkedList is the more effective approach with arraylist
        LinkedList3 linkedList = new LinkedList3("Mr. Hello", "The world");

        linkedList.add("Vinko", "Zagreb");
        linkedList.add("Sam", "Ireland");
        linkedList.add("Christian", "Broby");
        linkedList.add("Sandra", "Kristianstad");

        linkedList.printAll();
        linkedList.remove();
        System.out.println();
        linkedList.printAll();
        System.out.println();
        System.out.println(linkedList.getByIndex(2));
    }
}
