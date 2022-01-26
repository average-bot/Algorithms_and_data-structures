package task3;


import java.util.ArrayList;

public class LinkedList {
    int numberOfElements;
    ArrayList<Node> nodes;

    LinkedList(){
        numberOfElements = 0;
        nodes =  new ArrayList();
    }

    public void add(String name, String address){
        if(numberOfElements == 0){
            nodes.add(new Node(name, address, null));
        }
        else{
            nodes.add(new Node(name, address, getByIndex(numberOfElements-1)));
        }
        numberOfElements++;
    }
    public void remove(){
        nodes.remove(getByIndex(numberOfElements-1));
        numberOfElements-=1;
    }

    public Node getByIndex(int index){
        return nodes.get(index);
    }

    public void printAll(){
        for(Node node : nodes){
            System.out.println(node.toString());
        }
    }
}
