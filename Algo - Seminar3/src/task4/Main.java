package task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Long> elapsed = new ArrayList<Long>();

        int[] inputSizes = new int[]{10, 100, 1000, 10000, 100000, 1000000};
        for (int inputSize : inputSizes){
            for (int i=0; i<5; i++){ //5 cycles
                int[] inputs = getInputs(inputSize);

                //Build all the trees
                BinarySearchTree BST = new BinarySearchTree();
                BST.buildTree(inputs);

                BinaryHeap binaryHeap = new BinaryHeap();
                binaryHeap.buildHeap(inputs);

                RedBlackTree redBlackTree = new RedBlackTree();
                redBlackTree.buildTree(inputs);

                AVLTree avlTree = new AVLTree();
                avlTree.buildTree(inputs);

                long start = System.nanoTime();
                //delete min value
                //BST.deleteKey(BST.minValue(BST.root));
                //binaryHeap.deleteRoot(inputs); //minheap
                //redBlackTree.deleteNode(redBlackTree.minimum(redBlackTree.getRoot()).data);
                //avlTree.deleteNode(avlTree.root, avlTree.minValueNode(avlTree.root).key);

                //insert 1
                //BST.insert(1);
                //binaryHeap.insertNode(inputs,1);
                //redBlackTree.insert(1);
                //avlTree.insert(avlTree.root, 1);

                //insert 1M
                //BST.insert(1000000);
                //binaryHeap.insertNode(inputs,1000000);
                //redBlackTree.insert(1000000);
                //avlTree.insert(avlTree.root, 1000000);

                long timeElapsed = System.nanoTime() - start;
                elapsed.add(timeElapsed);
            }
            OptionalDouble average = elapsed.stream().mapToLong(a -> a).average();
            System.out.println(inputSize+ ": " +average.getAsDouble());
            elapsed.clear();
        }
    }
    public static int[] getInputs(int size) {
        //Retrieve random numbers as input from the numbers.txt file(auto).
        int [] array = new int[size];
        int counter = 0;
        try {
            File f = new File("src/task4/numbers.txt");
            Scanner scanner = new Scanner(f);
            while (scanner.hasNext() && counter < size){
                array[counter] = scanner.nextInt();
                counter++;
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File does not exist.");
        }
        return array;
    }
}
