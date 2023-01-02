package datastructures.B_bitmanipulation;

/** Find the only non-repeating number in an array where every element repeats twice */
public class FindOnlyNonRepeatingNumber {
    public static void main(String[] args) {
        int[] input = new int[]{5, 1, 3, 2, 4, 3, 1, 5, 2};
        System.out.println("Only non-repeating number = " + getNonRepeatingNumber(input));

        input = new int[]{89, 43, 56, 123, 56, 98, 89, 123, 43};
        System.out.println("Only non-repeating number = " + getNonRepeatingNumber(input));
    }

    private static int getNonRepeatingNumber(int[] input) {
        int result = 0;
        for (int num : input) {
            result ^= num; // Formula
        }
        return result;
    }
}
