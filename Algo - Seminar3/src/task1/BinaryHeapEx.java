package task1;
// "Figure 6.4 Class skeleton for priority queue" from the textbook

import java.nio.BufferUnderflowException;

public class BinaryHeapEx<AnyType extends Comparable<? super AnyType>>{

        public BinaryHeapEx(){
            /* See online code */
        }
        public BinaryHeapEx(int capacity){
            /* See online code */
        }
        public BinaryHeapEx(AnyType [] items){
            /* Figure 6.14 */
            currentSize = items.length;
            array = (AnyType[]) new Comparable[ ( currentSize + 2 ) * 11 / 10 ];

            int i = 1;
            for( AnyType item : items )
                array[ i++ ] = item;
            buildHeap( );
        }
        public void insert(AnyType x) {
            /* Figure 6.8 */
            /*Insert into the priority queue, maintaining heap order.
            Duplicates are allowed.
            @param x the item to insert.*/
                if( currentSize == array.length - 1 )
                enlargeArray( array.length * 2 + 1 );
                // Percolate up
                int hole = ++currentSize;
                for( array[ 0 ] = x; x.compareTo( array[ hole / 2 ] ) < 0; hole /= 2 )
                    array[ hole ] = array[ hole / 2 ];
                array[ hole ] = x;

        } //UNCOMMENT
/*        public AnyType findMin(){
            *//* See online code *//*
        }
        public AnyType deleteMin(){
            *//* Figure 6.12 *//*
            if( isEmpty( ) )
                throw new BufferUnderflowException(); //UnderflowException

            AnyType minItem = findMin( );
            array[ 1 ] = array[ currentSize-- ];
            percolateDown( 1 );
            return minItem;
        }*/
        public boolean isEmpty(){
            /* See online code */
            if (array.length == 0){
                return true;
            }
            return false;
        }
        public void makeEmpty(){
            /* See online code */
        }

        private static final int DEFAULT_CAPACITY = 10;
        private int currentSize; // Number of elements in heap
        private AnyType [] array; // The heap array

        private void percolateDown(int hole){
            /* Figure 6.12 */
            int child;
            AnyType tmp = array[ hole ];
            for(; hole * 2 <= currentSize; hole = child){
                child = hole * 2;
                if( child != currentSize &&
                    array[ child + 1 ].compareTo( array[ child ] ) < 0 )
                    child++;
                if( array[ child ].compareTo( tmp ) < 0 )
                    array[ hole ] = array[ child ];
                else
                    break;
                }
            array[ hole ] = tmp;
        }
        private void buildHeap() {
            /* Figure 6.14 */
            for( int i = currentSize / 2; i > 0; i-- )
                percolateDown( i );
        }
        private void enlargeArray(int newSize){
            /* See online code */
        }
}

