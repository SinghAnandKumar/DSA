package datastructures.C_mathematics;

public class NumOfTrailingZerosInFactorialN {
    public static void main(String[] args) {
        System.out.println("Number of trailing 0's in factorial(10) = " + getTrailingZeros(10));
        System.out.println("Number of trailing 0's in factorial(13) = " + getTrailingZeros(13));
        System.out.println("Number of trailing 0's in factorial(37) = " + getTrailingZeros(37));
        System.out.println("Number of trailing 0's in factorial(129) = " + getTrailingZeros(129));
    }

    private static int getTrailingZeros(int num) {
        int result = 0;
        for (int i = 5; i <= num; i = i * 5) {
            result += num / i;
        }
        return result;
    }
}
