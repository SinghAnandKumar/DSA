package datastructures.C_mathematics;

/**
 * Calculate GCD of a and b provided a > b.
 */
public class GCD {
    public static void main(String[] args) {
        System.out.println(gcd(12, 10));
        System.out.println(gcd(60, 24));
        System.out.println(gcd(27, 15));
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
