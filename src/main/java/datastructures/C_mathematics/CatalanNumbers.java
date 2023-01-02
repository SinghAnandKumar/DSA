package datastructures.C_mathematics;

/**
 * *** Problems Solved by Catalan Numbers ***
 * 1. Count the number of expressions containing n pairs of parentheses that are correctly matched.
 * For n = 3, possible expressions are ((())), ()(()), ()()(), (())(), (()()).
 * 2. Count the number of possible Binary Search Trees with n keys (See this)
 * 3. Count the number of full binary trees (A rooted binary tree is full if every vertex has
 * either two children or no children) with n+1 leaves.
 * 4. Given a number n, return the number of ways you can draw n chords in a circle with 2 x n points
 * such that no 2 chords intersect.
 */
public class CatalanNumbers {

    // The first few Catalan numbers for n = 0, 1, 2, 3, … are : 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …
    public static void main(String[] args) {
        System.out.println("First 10 Catalan numbers = ");
        printFirstNCatalanNum(10);
    }

    private static void printFirstNCatalanNum(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" " + catalanDP(i));
        }
    }

    private static int catalan(int n) {
        int res = 0;
        if (n <= 1) // base case
            return 1;
        for (int i = 0; i < n; i++) {
            res += catalan(i) * catalan(n - i - 1);
        }
        return res;
    }

    private static int catalanDP(int n) {
        // Table to store results of sub problem
        int catalan[] = new int[n + 2];

        // Initialize first two values in table
        catalan[0] = 1;
        catalan[1] = 1;

        // Fill entries in catalan[] using recursive formula
        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }

        return catalan[n];
    }
}
