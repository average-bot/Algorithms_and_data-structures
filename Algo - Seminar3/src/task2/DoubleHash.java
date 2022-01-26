package task2;

public class DoubleHash {
    Hash[] array;
    DoubleHash(int size){
        array = new Hash[size];
    }

    public int hash(int x){
        return (x%10)%array.length;
    }

    //h2(x) = 7 − (x mod 7).
    public int hash2(int x){
        return 7 - (x % 7)% array.length;
    }

    public void add(int input){
        if (array[hash(input)]!= null){
            array[hash2(array[hash(input)].value)] = new Hash(input);
        }
        else{
            array[hash(input)] = new Hash(input);
        }
    }
}

class Hash{
    int value;
    Hash(int value){
        this.value = value;
    }
}

