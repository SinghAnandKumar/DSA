package datastructures.C_mathematics;

public class FastPower {
    public static void main(String[] args) {
        System.out.println("3^5 = " + fastPower(3, 5));
        System.out.println("(3987654 ^ 5) % 10^9+7 = " + fastPowerModulo(3987654, 5, 1000000007));
    }

    private static int fastPower(int a, int b) {
        int res = 1;

        while (b > 0) {
            if ((b & 1) != 0) { // Odd number check
                res = res * a;
            }
            a = a * a;
            b = b >> 1; // Divide by 2
        }
        return res;
    }

    private static long fastPowerModulo(long a, long b, long n) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) != 0) { // Odd number check
//                res = res * a; // Error-prone, overflow problem
                res = (res * a % n) % n;
            }
//            a = a * a; // Error-prone, overflow problem
            a = (a % n * a % n) % n;
            b = b >> 1; // Divide by 2
        }
        return res;
    }
}
