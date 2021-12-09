package dsa.backtracking;

// Resource : https://youtu.be/zg5v2rlV1tM
public class Simple {

    public static void main(String[] args) {
        // System.out.println(countPathWithDiagonal(3, 3));
        printPathWithDiagonal("", 3, 3);
    }

    // only can move down or right
    public static int simpleCountPath(int row, int col) {
        if (row == 1 || col == 1) {
            return 1;
        }

        return simpleCountPath(row - 1, col) + simpleCountPath(row, col - 1);
    }

    // only can move down or right
    public static void simplePrintPath(String p, int row, int col) {
        if (row == 1 && col == 1) {
            System.out.println(p);
            return;
        }

        if (row > 1) {
            simplePrintPath(p + "D", row - 1, col);
        }
        if (col > 1) {
            simplePrintPath(p + "R", row, col - 1);
        }
    }

    // only can move to down, right or down + right (south east diagonal)
    public static int countPathWithDiagonal(int row, int col) {
        if (row == 1 || col == 1) {
            return 1;
        }

        return countPathWithDiagonal(row - 1, col) + countPathWithDiagonal(row, col - 1)
                + countPathWithDiagonal(row - 1, col - 1);
    }

    // only can move to down, right or down + right (south east diagonal)
    // V mean vertical, H mean horizontal and D mean diagonal
    public static void printPathWithDiagonal(String p, int row, int col) {
        if (row == 1 && col == 1) {
            System.out.println(p);
            return;
        }

        if (row > 1) {
            printPathWithDiagonal(p + "V", row - 1, col);
        }

        if (col > 1) {
            printPathWithDiagonal(p + "H", row, col - 1);
        }

        if (row > 1 && col > 1) {
            printPathWithDiagonal(p + "D", row - 1, col - 1);
        }
    }
}
