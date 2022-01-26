package task3;


public class LinkedList3 {
    Node head;
    int numberOfElements;

    LinkedList3(String name, String address){
        head = new Node(name, address, null);
        numberOfElements = 1;
    }

    public void add(String name, String address){
        Node tail = head;
        while (tail.nextNode != null){
            tail = tail.nextNode;
        }
        tail.nextNode = new Node(name, address, null);
        numberOfElements++;

    }
    public void remove(){
        Node tail = head;
        int counter = 1;
        while (tail.nextNode != null && counter < numberOfElements-1){
            tail = tail.nextNode;
            counter++;
        }
        tail.nextNode = null;
        numberOfElements--;
    }

    public Node getByIndex(int index){
        Node tail = head;
        int counter = 1;
        while (tail.nextNode!= null && index >= counter){
            tail = tail.nextNode;
            counter++;
        }
        return tail;
    }

    public void printAll(){
        Node tail = head;
        System.out.println(tail);
        while (tail.nextNode != null){
            tail = tail.nextNode;
            System.out.println(tail.toString());
        }
    }
}
