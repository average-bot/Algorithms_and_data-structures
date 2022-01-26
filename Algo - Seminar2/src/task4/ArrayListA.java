package task4;
// Inspired by https://titanwolf.org/Network/Articles/Article?AID=400f1234-15c8-4200-ac1e-3e6a0157bf7d
import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayListA {
        //size = number of people
        //passes = number of times the potato is passed around
        public static int justArrayList(int size, int passes){

            ArrayList<Integer> nodes = new ArrayList<Integer>(size);
            for(int i = 0; i < size; i++){
                nodes.add(i);
            }
            int personIndex = 1;
            while(nodes.size() > 1){
                personIndex = (personIndex + passes - 1) % nodes.size();
                nodes.remove(personIndex);
            }
            return nodes.get(0);
        }

        public  static int arrayListIterator(int size, int passes){
            ArrayList<Integer> nodes = new ArrayList<Integer>(size);
            for(int i = 0; i < size; i++){
                nodes.add(i);
            }
            ListIterator here = nodes.listIterator();
            here.next();
            while (nodes.size() > 1){
                int count = 0;
                while (count != passes){
                    if(!here.hasNext()) {
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

