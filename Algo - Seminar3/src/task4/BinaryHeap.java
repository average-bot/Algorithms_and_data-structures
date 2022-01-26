package task4;
//Source: https://www.educative.io/edpresso/how-to-build-a-heap-from-an-array
//translated from python
//Source: https://www.geeksforgeeks.org/insertion-and-deletion-in-heaps/
//deletion in binary heaps and insertion
public class BinaryHeap {

        int size; // size of array
        int smallest;

        public void heapify(int arr[], int i)
        {
            smallest = i; // The node which will be heapified
            int leftChild = 2 * i + 1; // left child node
            int rightChild = 2 * i + 2; // right child node

            // Check if left child is smaller than its parent
            if (leftChild < size && arr[leftChild] < arr[smallest])
                smallest = leftChild;

            // Check if right child is smaller than smallest
            if (rightChild < size && arr[rightChild] < arr[smallest])
                smallest = rightChild;

            // If smallest is not parent
            if (smallest != i) {
                int temp = arr[smallest]; //swap
                arr[smallest] = arr[i];
                arr[i] = temp;

                // Recursively heapify the affected sub-tree
                heapify(arr, smallest);
            }
        }

        // Function to build a Max-Heap from the given array
        public int[] buildHeap(int arr[]) {
            // Perform level order traversal
            // from last non-leaf node and heapify each node
            for (int i = arr.length; i >= 0; i--) {
                heapify(arr, i);
            }
            return arr;
        }

        // Function to insert a new node to the Heap
        void insertNode(int arr[], int Key) {
            // Increase the size of Heap by 1
            size = size + 1;
            // Insert the element at end of Heap
            arr[size-1] = Key;
            // Heapify the new node following a
            // Bottom-up approach
            heapify(arr, size - 1);
        }

        // Function to delete the root from Heap
        public void deleteRoot(int arr[]) {
            // Get the last element
            int lastElement = arr[size - 1];
            // Replace root with first element
            arr[0] = lastElement;
            // Decrease size of heap by 1
            size = size - 1; // new size for the heap
            // heapify the root node
            heapify(arr, 0);
        }

}

