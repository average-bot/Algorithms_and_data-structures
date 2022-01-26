package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{10, 12, 1, 14, 6, 5, 8, 15, 3, 9, 7, 4, 11, 13, 2};
        //binaryHeapOne(array);
        //System.out.println();
        //binaryHeapTwo(array);
        //taskD();
        //taskE();
    }
    //taskD
    public static void taskD(){
        ArrayList<Long> elapsed = new ArrayList<Long>();

        int[] inputSizes = new int[]{10, 100, 1000, 10000, 100000, 1000000};
        for (int inputSize : inputSizes){
            for (int i=0; i<5; i++){ //5 cycles
                int[] inputs = getInputs(inputSize);
                long start = System.nanoTime();
                binaryHeapOne(inputs);
                //binaryHeapTwo(inputs);
                long timeElapsed = System.nanoTime() - start;
                elapsed.add(timeElapsed);
            }
            OptionalDouble average = elapsed.stream().mapToLong(a -> a).average();
            System.out.println(inputSize+ ": " +average.getAsDouble());
            elapsed.clear();
        }
    }

    //taskD
    public static void taskE(){ // take the time for insertion & deletion of min element
        ArrayList<Long> elapsed = new ArrayList<Long>();

        int[] inputSizes = new int[]{10, 100, 1000, 10000, 100000, 1000000};
        for (int inputSize : inputSizes){
            for (int i=0; i<5; i++){ //5 cycles
                int[] inputs = getInputs(inputSize);

                //creating binaryHeap1
                BinaryHeap1 binaryHeap1 = new BinaryHeap1();
                for (int element : inputs) {
                    binaryHeap1.add(element);
                }

                //creating binaryHeap2
                //BinaryHeap2 binaryHeap2 = new BinaryHeap2();
                //binaryHeap2.size = inputs.length;
                //binaryHeap2.buildHeap(inputs);

                long start = System.nanoTime();
                //add and remove operations
                //binaryHeap1
                //binaryHeap1.add(1); //done
                //binaryHeap1.add(1000000);
                binaryHeap1.removeMin();

                //binaryHeap2
                //binaryHeap2.insertNode(inputs, 1);
                //binaryHeap2.insertNode(inputs, 1000000);
                //binaryHeap2.deleteRoot(inputs);

                long timeElapsed = System.nanoTime() - start;
                elapsed.add(timeElapsed);
            }
            OptionalDouble average = elapsed.stream().mapToLong(a -> a).average();
            System.out.println(inputSize+ ": " +average.getAsDouble());
            elapsed.clear();
        }
    }

    //taskA
    public static void binaryHeapOne(int[] array){
        BinaryHeap1 binaryHeap1 = new BinaryHeap1();
        for (int element : array) {
            binaryHeap1.add(element);
        }
        System.out.println("levelorder");
        binaryHeap1.printLevelOrder();
        System.out.println();
        System.out.println("preorder");
        binaryHeap1.printPreOrder(0);
        System.out.println();
        System.out.println("postorder");
        binaryHeap1.printPostOrder(0);
        System.out.println();
        System.out.println("inorder");
        binaryHeap1.printInOrder(0);

/*        System.out.println(); //Removing the minimum value
        binaryHeap1.removeMin();
        for (int b : binaryHeap1.items) {
            System.out.print(b + " ");
        }
        System.out.println();
        binaryHeap1.add(16); //Inserting a value to the heap
        for (int b : binaryHeap1.items) {
            System.out.print(b + " ");*/

        //binaryHeap1.printPreOrder(0);
        //binaryHeap1.printInOrder(0);
        //binaryHeap1.printPostOrder(0);
    }

    //taskB
    public static void binaryHeapTwo(int[] arr){
        BinaryHeap2 binaryHeap2 = new BinaryHeap2();

        // calculating size of array
        binaryHeap2.size = arr.length / 1; //arr[0].length??

        // call the buildHeap method on the array
        binaryHeap2.buildHeap(arr);

        // print the heap level order
        System.out.println("levelorder");
        binaryHeap2.printLevelOrder(arr);
        System.out.println();
        System.out.println("preorder");
        binaryHeap2.printPreOrder(0, arr);
        System.out.println();
        System.out.println("postorder");
        binaryHeap2.printPostOrder(0, arr);
        System.out.println();
        System.out.println("inorder");
        binaryHeap2.printInOrder(0, arr);

        //delete min, inser
/*        binaryHeap2.deleteRoot(arr); // same as delete min since its a minheap and the smallest element is at the top
        System.out.println();
        for (int i = 0; i < binaryHeap2.size; ++i)
            System.out.print(arr[i] + " ");
        binaryHeap2.insertNode(arr, 16);
        System.out.println();
        for (int i = 0; i < binaryHeap2.size; ++i)
            System.out.print(arr[i] + " ");*/
    }



    public static int[] getInputs(int size) {
        //Retrieve random numbers as input from the numbers.txt file(auto).
        int [] array = new int[size];
        int counter = 0;
        try {
            File f = new File("src/task1/numbers.txt");
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
