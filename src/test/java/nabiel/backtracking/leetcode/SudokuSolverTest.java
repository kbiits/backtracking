package nabiel.backtracking.leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SudokuSolverTest {

    @Test
    public void testIsSafeSudoku() {
        char[][] board = SudokuSolver.board;

        // check true
        assertTrue(
                SudokuSolver.isSafe('2', 0, 2, board));

        board[0][2] = '2';

        // check in same cell
        assertFalse(
                SudokuSolver.isSafe('2', 0, 2, board));

        // check in horizontal
        assertFalse(
                SudokuSolver.isSafe('2', 0, 3, board));

        // check in vertical
        assertFalse(
                SudokuSolver.isSafe('6', 0, 7, board));
    }
}
