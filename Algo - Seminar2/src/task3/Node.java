package task3;

public class Node {
    public String name;
    public String address;
    public Node nextNode;

    public Node(String name, String address, Node nextNode){
        this.name = name;
        this.address = address;
        this.nextNode = nextNode;
    }

    public String toString(){
        return "Name: "+name+". Address: "+address;
    }
}
