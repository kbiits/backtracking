package nabiel.backtracking;

public class NQueens {

    /**
     * InnerNQueens
     */
    static class NQueensGetAllPath {
        public static void main(String[] args) {

        }

        // public static List<List<String>> nQueens(int n) {

        // }
    }

    public static void main(String[] args) {
        int n = 4;
        // 1,2 (3)
        // 3 - 2 = 1
        // x x x x
        // x x x x  -> 1,2 -> 0,3
        // x x x x
        // x x x x
        boolean[][] board = new boolean[n][n];
        int nWays = nQueens(board, 0);
        System.out.println(nWays);
    }

    private static int nQueens(boolean[][] board, int row) {
        if (row == board.length) {
            displayBoard(board);
            System.out.println();
            return 1;
        }

        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                // mark current cell as visited
                board[row][col] = true;
                count += nQueens(board, row + 1);
                // restore current cell as not visited
                board[row][col] = false;
            }
        }
        return count;
    }

    private static void displayBoard(boolean[][] board) {
        for (boolean[] b : board) {
            for (boolean isThereQueen : b) {
                if (isThereQueen) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    public static boolean isSafe(boolean[][] board, int currentRow, int currentCol) {
        // top direction
        for (int i = 1; i <= currentRow; i++) {
            if (board[currentRow - i][currentCol]) {
                return false;
            }
        }

        // top left direction
        int minLeftIdx = Math.min(currentRow, currentCol);
        for (int i = 1; i <= minLeftIdx; i++) {
            if (board[currentRow - i][currentCol - i]) {
                return false;
            }
        }

        // top right direction
        int minRightIdx = Math.min(currentRow, board.length - 1 - currentCol);
        for (int i = 1; i <= minRightIdx; i++) {
            if (board[currentRow - i][currentCol + i]) {
                return false;
            }
        }
        return true;
    }
}
