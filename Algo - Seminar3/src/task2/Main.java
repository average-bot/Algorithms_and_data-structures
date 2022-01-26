package task2;

public class Main {
    public static void main(String[] args) {
        int[] inputs = new int[]{4371, 1323, 6173, 4199, 4344, 9679, 1989};
        ChainingHash chainingHash = new ChainingHash(5);

        for(int input: inputs){
            chainingHash.add(input);
        }
/*        for(Record b : chainingHash.array) {
            if (b != null) {
                System.out.println(b.integers);
            }
        }*/

        LinearProbingHash linearProbingHash = new LinearProbingHash(25);
        for(int input: inputs) {
            linearProbingHash.add(input);
        }
/*        for(Bucket b : linearProbingHash.array) {
            if (b != null) {
                System.out.println(b.value);
            }
        }*/

        QuadraticProbingHash quadraticProbingHash = new QuadraticProbingHash(25);
        for(int input: inputs) {
            quadraticProbingHash.add(input);
        }

/*        for(Bucket b : quadraticProbingHash.array){
            if(b!=null){
                System.out.println(b.value);
            }
        }*/

        DoubleHash doubleHash = new DoubleHash(20);
        for(int input: inputs) {
            doubleHash.add(input);
        }
        DoubleHash doubleHash2 = new DoubleHash(40); //double the size
        for(int input: inputs) {
            doubleHash2.add(input);
        }
/*
        for (Hash h : doubleHash.array){
            if(h!=null){
                System.out.println(h.value);
            }
        }*/

        //EXTRA
        DoubleHashTables doubleHashTables = new DoubleHashTables(20);
        for(int input: inputs) {
            doubleHashTables.add(input);
        }

/*        for (Hash h : doubleHashTables.array){
            if(h!=null){
                System.out.println(h.value);
            }
        }
        for (Hash h : doubleHashTables.array2){
            if(h!=null){
                System.out.println(h.value);
            }
        }*/
    }
}
