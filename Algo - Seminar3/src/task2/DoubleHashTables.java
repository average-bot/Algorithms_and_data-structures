package task2;

public class DoubleHashTables {
    Hash[] array;
    Hash[] array2;
    DoubleHashTables(int size){
        array = new Hash[size];
        array2 = new Hash[size*2];
    }

    public int hash(int x){
        return (x*(x%10))%array.length;
    }

    //h2(x) = 7 − (x mod 7).
    public int hash2(int x){
        return 7 - (x % 7)% array.length;
    }

    public void add(int input){
        if (array[hash(input)]!= null){
            array2[hash2(hash(input))] = new Hash(input);
        }
        else{
            array[hash(input)] = new Hash(input);
        }
    }
}
