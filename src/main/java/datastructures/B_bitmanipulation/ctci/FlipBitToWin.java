package datastructures.B_bitmanipulation.ctci;

public class FlipBitToWin {
    public static void main(String[] args) {
        System.out.println("Longest seq in " + Integer.toBinaryString(125) + " is " + findLongestSequence(125));
        System.out.println("Longest seq in " + Integer.toBinaryString(1275) + " is " + findLongestSequence(1275));
    }

    /**
     * You have an integer and you can flip exactly one bit from a O to a 1. Write code to find the length of the
     * longest sequence of 1s you could create.
     * Example:
     * Input: 1775 (or: 11011101111)
     * Output: 8
     * <p>
     * Approach:
     * We just walk through the integer tracking the current 1s sequence length and the previous 1s sequence length.
     * When we see a zero, update previous length as follows:
     * - If the next bit is a 1, previous Length should be set to current Length.
     * - If the next bit is a 0, then we can't merge these sequences together. So, set previous Length to 0.
     *
     * @param n an integer
     * @return the longest sequence of set bits in {@code n} by flipping only one zero bit
     */
    private static int findLongestSequence(int n) {
        if (n == ~0) { // -0 will be all 11111....'s so ans is 32
            return Integer.BYTES * Byte.SIZE;
        }

        int currentSeq = 0, prevSeq = 0, maxSeq = 0;

        while (n > 0) {
            if ((n & 1) == 0) { // last digit is 0
                prevSeq = (n & 2) == 0 ? 0 : currentSeq; // if the next bit is also 0, set prevOnesLen to 0
                currentSeq = 0;
            } else {
                currentSeq++;
            }
            n >>>= 1; // right shift with 0 filled from front, sign bit is ignored
            maxSeq = Math.max(maxSeq, currentSeq + 1 + prevSeq);
        }

        return maxSeq;
    }
}
