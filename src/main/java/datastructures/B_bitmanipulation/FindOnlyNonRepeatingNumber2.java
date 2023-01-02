package datastructures.B_bitmanipulation;

/**
 * Find the only non-repeating number in an array where every element repeats thrice
 */
public class FindOnlyNonRepeatingNumber2 {
    public static void main(String[] args) {
        int[] input = new int[]{5, 1, 3, 3, 2, 1, 5, 4, 3, 2, 1, 5, 2};
        System.out.println("Only non-repeating number = " + getNonRepeatingNumber(input));

        input = new int[]{89, 43, 56, 43, 89, 43, 56, 123, 56, 123, 98, 89, 123};
        System.out.println("Only non-repeating number = " + getNonRepeatingNumber(input));
    }

    private static int getNonRepeatingNumber(int[] input) {
        int[] bitCounter = new int[32];
        int result = 0;
        for (int num : input) {
            // Count the SET bits at each position in a 32-bit array
            for (int i = 0; i < 32; i++) {
                if ((num & 1) == 1) {
                    bitCounter[i] += 1;
                }
                num >>= 1;
            }
        }

        for (int i = 0; i < bitCounter.length; i++) {
            result += Math.pow(2, i) * (bitCounter[i] % 3);
        }
        return result;
    }
}
