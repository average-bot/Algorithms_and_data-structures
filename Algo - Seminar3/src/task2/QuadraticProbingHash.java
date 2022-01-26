package task2;

public class QuadraticProbingHash {
    Bucket[] array;
    QuadraticProbingHash(int size){
        array = new Bucket[size];
    }

    public int hash(int x){
        return (x%10)%array.length;
    }
    //In case of a collision find the next available spot
    public void add(int input){
        int counter = 0;
        while(array[hash(input)+counter% array.length]!= null){
            if(counter == 0){
                counter = 1;
            }
            counter*=counter;
        }
        array[hash(input)+counter] = new Bucket(input);
    }
}