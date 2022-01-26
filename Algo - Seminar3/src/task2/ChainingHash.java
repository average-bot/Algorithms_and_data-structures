package task2;

import java.util.LinkedList;

class ChainingHash {
    Record[] array;
    ChainingHash(int size){
        array = new Record[size];
    }

    public int hash(int x){
        return (x%10)%array.length;
    }

    public void add(int input){
        Record record = array[hash(input)];
        if (record == null){
            array[hash(input)] = new Record(input);
        }
        else {
            record.add(input);
        }
    }

    public int size(){
        return array.length;
    }
}

class Record{
    LinkedList<Integer> integers;
    Record(int value){
        integers = new LinkedList<Integer>();
        integers.add(value);
    }
    public void add(int value){
        integers.add(value);
    }
    public int size(){
        return integers.size();
    }
}
