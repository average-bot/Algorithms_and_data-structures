package task3;

public class Main {
    public static void main(String[] args) {
        int R = 4;
        int C = 4;
        char[][] grid = { { 't', 'h', 'i', 's' },
                          { 'w', 'a', 't', 's' },
                          { 'o', 'a', 'h', 'g' },
                          { 'f', 'g', 'd', 't' } };
        WordPuzzle wordPuzzle = new WordPuzzle(R,C);
        wordPuzzle.patternSearch(grid, "this");
        wordPuzzle.patternSearch(grid, "fat");
        wordPuzzle.patternSearch(grid, "that");
        wordPuzzle.patternSearch(grid, "two");
// This code is contributed by rachana soma
    }
}
