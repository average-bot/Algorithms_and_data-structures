package task2;

public class LinearProbingHash {
        Bucket[] array;
        LinearProbingHash(int size){
            array = new Bucket[size];
        }

        public int hash(int x){
            return (x*(x%10))%array.length;
        }
        //In case of a collision find the next available spot
        public void add(int input){
            int counter = 0;
            while(array[hash(input)+counter% array.length]!= null){
                counter++;
            }
            array[hash(input)+counter] = new Bucket(input);
        }
}

    class Bucket{
        int value;
        Bucket(int value){
            this.value = value;
        }
}
