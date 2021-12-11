package nabiel.backtracking;

// resource : https://youtu.be/zg5v2rlV1tM
public class MazeAllDirections {
    public static void main(String[] args) {
        boolean[][] maze = {
                { true, true, true },
                { true, true, true },
                { true, true, true },
        };
        printAllPaths("", maze, 0, 0);
    }

    // directions : DOWN (D), UP (U), LEFT (L), RIGHT (R)
    public static void printAllPaths(String path, boolean[][] maze, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) { // found the bottom right corner
            System.out.println(path);
            return;
        }

        if (!maze[row][col]) { // already visited
            return;
        }

        // mark current cell as visited
        maze[row][col] = false;
        
        // go down
        if (row < maze.length - 1) {
            printAllPaths(path + "D", maze, row + 1, col);
        }

        // go right
        if (col < maze[0].length - 1) {
            printAllPaths(path + "R", maze, row, col + 1);
        }

        // go up
        if (row > 0) {
            printAllPaths(path + "U", maze, row - 1, col);
        }

        // go left
        if (col > 0) {
            printAllPaths(path + "L", maze, row, col - 1);
        }

        maze[row][col] = true; // restore the visited cell for another function calls
    }

    static void allPath(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        // i am considering this block in my path
        maze[r][c] = false;

        if (r < maze.length - 1) {
            allPath(p + 'D', maze, r + 1, c);
        }

        if (c < maze[0].length - 1) {
            allPath(p + 'R', maze, r, c + 1);
        }

        if (r > 0) {
            allPath(p + 'U', maze, r - 1, c);
        }

        if (c > 0) {
            allPath(p + 'L', maze, r, c - 1);
        }

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function
        maze[r][c] = true;
    }
}
