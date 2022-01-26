package task3;
// Source: https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/
// Java program to search
// a word in a 2D grid

class WordPuzzle {

    // Rows and columns in the given grid
    int ROWS, COLUMNS;

    // For searching in all 8 direction
    static int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};

    WordPuzzle(int R, int C){
        this.ROWS = R;
        this.COLUMNS = C;
    }

    // This function searches in all
    // 8-direction from point
    // (row, col) in grid[][]
    public boolean search2D(char[][] grid, int row, int column, String word) {
        // If first character of word
        // doesn't match with
        // given starting point in grid.
        if (grid[row][column] != word.charAt(0))
            return false;

        int len = word.length();

        // Search word in all 8 directions
        // starting from (row, col)
        for (int direction = 0; direction < 8; direction++) {
            // Initialize starting point
            // for current direction
            int checked;
            int rowDirection = row + x[direction];
            int columnDirection = column + y[direction];

            // First character is already checked,
            // match remaining characters
            for (checked = 1; checked < len; checked++) {
                // If out of bound break
                if (rowDirection >= ROWS || rowDirection < 0 || columnDirection >= COLUMNS || columnDirection < 0)
                    break;

                // If not matched, break
                if (grid[rowDirection][columnDirection] != word.charAt(checked))
                    break;

                // Moving in particular direction
                rowDirection += x[direction];
                columnDirection += y[direction];
            }

            // If all character matched,
            // then value of must
            // be equal to length of word
            if (checked == len)
                return true;
        }
        return false;
    }

    // Searches given word in a given
    // matrix in all 8 directions
    public void patternSearch(char[][] grid, String word) {
        // Consider every point as starting
        // point and search given word
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                if (search2D(grid, row, column, word))
                    System.out.println(
                            "pattern of '"+word+"' found at " + row + ", " + column);
            }
        }
    }
}