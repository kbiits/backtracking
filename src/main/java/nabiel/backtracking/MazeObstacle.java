package nabiel.backtracking;

// Resource : https://youtu.be/zg5v2rlV1tM
public class MazeObstacle {
    public static void main(String[] args) {
        boolean[][] mazeBooleans = { { true, true, true }, { true, false, true }, { true, true, true } };
        printPathWithObstacle("", mazeBooleans, 0, 0);
        System.out.println(countPathWithObstacle(mazeBooleans, 0, 0));
    }

    public static void printPathWithObstacle(String p, boolean[][] maze, int row, int col) {
        if (!maze[row][col]) { // found obstacle
            return;
        }

        int mazeRows = maze.length;
        int mazeCols = maze[0].length;

        if (row == mazeRows - 1 && col == mazeCols - 1) {
            System.out.println(p);
            return;
        }

        if (row < mazeRows - 1) {
            printPathWithObstacle(p + "D", maze, row + 1, col);
        }

        if (col < mazeCols - 1) {
            printPathWithObstacle(p + "R", maze, row, col + 1);
        }
    }

    public static int countPathWithObstacle(boolean[][] maze, int row, int col) {
        if (!maze[row][col]) { // found obstacle
            return 0;
        }

        int mazeRows = maze.length;
        int mazeCols = maze[0].length;

        if (row == mazeRows - 1 || col == mazeCols - 1) {
            return 1;
        }

        return countPathWithObstacle(maze, row + 1, col) + countPathWithObstacle(maze, row, col + 1);
    }
}
