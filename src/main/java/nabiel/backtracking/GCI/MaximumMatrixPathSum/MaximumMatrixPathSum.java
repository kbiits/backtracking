package nabiel.backtracking.GCI.MaximumMatrixPathSum;

import java.util.ArrayList;
import java.util.List;

public class MaximumMatrixPathSum {
    public static void main(String[] args) {
        int[][] matrix = {
                { 10, 10, 2, 0, 20, 4 },
                { 1, 0, 0, 30, 2, 5 },
                { 0, 10, 4, 0, 2, 0 },
                { 1, 0, 2, 20, 0, 4 },
        };

        int result = solve(matrix, matrix.length, matrix[0].length);
        System.out.println(result);
    }

    public static int solve(int[][] matrix, int nRow, int nCol) {
        int max = -1;
        for (int i = 0; i < nCol; i++) {
            List<Integer> temp = new ArrayList<>();
            int res = solve(matrix, temp, 0, i, nRow, nCol);
            if (res > max) {
                max = res;
            }
        }

        return max;
    }

    public static int solve(int[][] matrix, List<Integer> list, int row, int col, int nRow, int nCol) {
        if (row >= nRow || col >= nCol || row < 0 || col < 0) {
            return 0;
        }

        int curr = matrix[row][col];

        // move down
        int tempRes1 = solve(matrix, list, row + 1, col, nRow, nCol);

        // move down right
        int tempRes2 = solve(matrix, list, row + 1, col + 1, nRow, nCol);

        // move down left
        int tempRes3 = solve(matrix, list, row + 1, col - 1, nRow, nCol);

        int res1 = curr + tempRes1;
        int res2 = curr + tempRes2;
        int res3 = curr + tempRes3;

        return Math.max(Math.max(res1, res2), res3);
    }

}
