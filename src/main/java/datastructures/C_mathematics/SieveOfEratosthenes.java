package datastructures.C_mathematics;

import java.util.Arrays;

/**
 * Find Prime Numbers between 1 and N
 */
public class SieveOfEratosthenes {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sieveOfEratosthenes(12)));
    }

    private static boolean[] sieveOfEratosthenes(int n) {
        // Create array for n+1 (0 based indexing), 0th position won't be used
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false; // Not used
        isPrime[1] = false; // 1 is a Prime number

        for (int i = 2; i * i < n; i++) {
            // Mark the 2nd,3rd,4th... multiples of i as FALSE
            // eg:- 3 and 5 are prime but 6,9,12,... and 10,15,20.. are not
            for (int j = 2 * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }
}
