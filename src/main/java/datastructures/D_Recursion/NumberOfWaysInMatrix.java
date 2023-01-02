package datastructures.D_Recursion;

/**
 * Allowed Movements are Bottom or Right side only
 */
public class NumberOfWaysInMatrix {
    public static void main(String[] args) {
        System.out.println("Ways in 1 x 1 matrix = " + getNumberOfWays(1, 1));
        System.out.println("Ways in 1 x 2 matrix = " + getNumberOfWays(1, 2));
        System.out.println("Ways in 2 x 1 matrix = " + getNumberOfWays(2, 1));
        System.out.println("Ways in 2 x 2 matrix = " + getNumberOfWays(2, 2));
        System.out.println("Ways in 2 x 3 matrix = " + getNumberOfWays(2, 3));
        System.out.println("Ways in 3 x 2 matrix = " + getNumberOfWays(3, 2));
        System.out.println("Ways in 3 x 3 matrix = " + getNumberOfWays(3, 3));
        System.out.println("Ways in 3 x 4 matrix = " + getNumberOfWays(3, 4));
        System.out.println("Ways in 4 x 3 matrix = " + getNumberOfWays(4, 3));
        System.out.println("Ways in 4 x 4 matrix = " + getNumberOfWays(4, 4));
        System.out.println("Ways in 4 x 5 matrix = " + getNumberOfWays(4, 5));
        System.out.println("Ways in 5 x 4 matrix = " + getNumberOfWays(5, 4));
        System.out.println("Ways in 5 x 5 matrix = " + getNumberOfWays(5, 5));
    }

    private static int getNumberOfWays(int n, int m) {
        if (n == 1 || m == 1) // base case
            return 1;
        return getNumberOfWays(n, m - 1) + getNumberOfWays(n - 1, m);
    }
}
