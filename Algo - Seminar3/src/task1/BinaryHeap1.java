package task1; //a
// Source: https://www.youtube.com/watch?v=t0Cq6tVNRBA

import java.util.Arrays;

public class BinaryHeap1 {
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];
    boolean[] visited = new boolean[1000];


    private int getLeftChildIndex(int parentIndex){
        return 2*parentIndex +1;
    }
    private int getRightChildIndex(int parentIndex){
        return 2*parentIndex + 2;
    }
    private int getParentIndex(int childIndex){
        return (childIndex-1)/2;
    }


    private boolean hasLeftChild(int index){
        return getLeftChildIndex(index) < size;
    }
    private boolean hasRightChild(int index){
        return getRightChildIndex(index) < size;
    }
    private boolean hasParent(int index){
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index){
        return items[getLeftChildIndex(index)];
    }
    private int rightChild(int index){
        return items[getRightChildIndex(index)];
    }
    private int parent(int index){
        return items[getParentIndex(index)];
    }

    private void swap (int indexOne, int indexTwo){
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }
    private void ensureExtraCapacity(){
        if(size==capacity){
            items = Arrays.copyOf(items, capacity*2);
            capacity *=2;
        }
    }

    public int peek(){
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll(){
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item){
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public void heapifyUp(){
        int index = size -1;
        while(hasParent(index) && parent(index) > items[index]){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
    public void heapifyDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index)< leftChild(index)){
                smallerChildIndex = getRightChildIndex(index);
            }

            if(items[index]< items[smallerChildIndex]){
                break;
            }else{
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }

    }

    public void printLevelOrder(){
        for (int item : items) {
            System.out.print(item + " ");
        }
    }

    public void printPreOrder(int index){ //startIndex will be 0

        int left = getLeftChildIndex(index);
        int right = getRightChildIndex(index);

        if(index > this.size){
            return;
        }
        System.out.print(items[index] + " ");
        printPreOrder(left);
        printPreOrder(right);
    }
    public void printInOrder(int index){
        int left = getLeftChildIndex(index);
        int right = getRightChildIndex(index);

        if(index >= this.size){
            return;
        }
        printPreOrder(left);
        System.out.print(items[index] + " ");
        printPreOrder(right);
    }
    public void printPostOrder(int index){
        int left = getLeftChildIndex(index);
        int right = getRightChildIndex(index);

        if(index > this.size){
            return;
        }
        printPreOrder(left);
        printPreOrder(right);
        System.out.print(items[index] + " ");
    }


    public void removeMin() {
        if (size == 0) throw new IllegalStateException();
        else {
            items[0] = items[size - 1];
            size--;
            if (size > 0)
                siftDown(0);
        }
    }
    private void siftDown(int nodeIndex) {
        int leftChildIndex, rightChildIndex, minIndex, tmp;
        leftChildIndex = getLeftChildIndex(nodeIndex);
        rightChildIndex = getRightChildIndex(nodeIndex);
        if (rightChildIndex >= size) {
            if (leftChildIndex >= size)
                return;
            else
                minIndex = leftChildIndex;
        } else {
            if (items[leftChildIndex] <= items[rightChildIndex])
                minIndex = leftChildIndex;
            else

                minIndex = rightChildIndex;
        }
        if (items[nodeIndex] > items[minIndex]) {
            tmp = items[minIndex];
            items[minIndex] = items[nodeIndex];
            items[nodeIndex] = tmp;
            siftDown(minIndex);
        }
    }

    public void printAll(){
        System.out.println(items);
    }
}
