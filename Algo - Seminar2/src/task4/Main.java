package task4;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        int[] sizearray = new int[]{10,100,1000,10000, 100000};
        ArrayList<Long> times = new ArrayList<Long>();
        int final_time;

        for (int s : sizearray) {

            times.clear();
            final_time = 0;
            int p=s/3;
            for(int i=0; i<5; i++) {
                ArrayListA a = new ArrayListA();
                //LinkedListIterator b = new LinkedListIterator();
                long start = System.nanoTime();
                //a.justArrayList(s, p);
                a.arrayListIterator(s, p);
                //b.linkedListIterator(s, p);
                long elapsedTime = System.nanoTime() - start;
                times.add(elapsedTime);
            }

            for (long time: times){
                final_time += time;
            }
            System.out.println(final_time);
        }

        //System.out.println("arraylist arraylistWithIterator linkedlistWithIterator");
        //System.out.println("different sizes:");
        //ArrayList<Long> times = runMethods(1, 2);

    }
/*    static ArrayList<Long> runMethods(int size, int passes){
        ArrayList<Long> times = new ArrayList<Long>();
        ArrayListA a = new ArrayListA();
        LinkedListIterator b = new LinkedListIterator();

        long start = System.nanoTime();
        a.justArrayList(size, passes);
        long elapsedTime = System.nanoTime() - start;
        times.add(elapsedTime);

        start = System.nanoTime();
        a.arrayListIterator(size, passes);
        elapsedTime = System.nanoTime() - start;
        times.add(elapsedTime);

        start = System.nanoTime();
        b.linkedListIterator(size, passes);
        elapsedTime = System.nanoTime() - start;
        times.add(elapsedTime);
        return times;
    }*/
}

