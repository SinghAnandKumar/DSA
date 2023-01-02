package datastructures.B_bitmanipulation;

/**
 * Find the two non-repeating number in an array where every element repeats twice
 */
public class FindTwoNonRepeatingNumber {
    public static void main(String[] args) {
        int[] input = new int[]{5, 1, 3, 2, 4, 3, 1, 5,};
        getNonRepeatingNumbers(input);

        input = new int[]{89, 43, 56, 123, 56, 98, 89, 123};
        getNonRepeatingNumbers(input);

        input = new int[]{62, 34, 90, 90, 26, 12, 26, 62};
        getNonRepeatingNumbers(input);
    }

    private static void getNonRepeatingNumbers(int[] input) {
        int result = 0;
        for (int num : input) {
            result ^= num;
        }

        // Find the 1st set bit position from right
        int xor = result, setBit = 0;
//        while ((xor & 1) != 1) {
//            xor >>= 1;
//            setBit++;
//        }

//        Instead of changing the original number xor, use temp var m for any manipulation
//        int m = 1;
//        while ((xor & m) != 1) {
//            m <<= 1;
//            setBit++;
//        }

        // Above can be replaced with,
        setBit = xor & ~(xor - 1); // can be replaced with (xor & -xor), because -n = ~(n-1)

        int oddBucket = 0, evenBucket = 0;
        for (int num : input) {
            if ((num & setBit) == 0) {
                oddBucket ^= num;
            } else { // we can ignore the even bucket xor 'ing
                evenBucket ^= num;
            }
        }

        System.out.print("\nTwo non-repeating numbers = ");
        System.out.print((result ^ oddBucket) + " ");
        System.out.print(oddBucket);

//        Print evenBucket AND oddBucket, or result^bucketX AND bucketX
//        System.out.print(evenBucket);
    }

    public static int[] getTwoNonRepeatingElementsInArray(int a[]) {
        int xor = 0, setBit, x = 0, y = 0;
        for (int i = 0; i < a.length; i++) {
            xor ^= a[i]; // XOR all array elements
        }
        setBit = xor & ~(xor - 1); // get the rightmost set bit in XOR
        for (int i = 0; i < a.length; i++) {
            if ((a[i] & setBit) == 0) {
                x ^= a[i]; // one non-repeating element
            } else {
                y ^= a[i]; // other non-repeating element
            }
        }
        return new int[]{x, y};
    }
}
