package datastructures.D_Recursion;

public class StringProblems {
    public static void main(String[] args) {
        System.out.println("abcba is palindrome = " + isPalindrome("abcba", 0, 4));
        System.out.println("racecar is palindrome = " + isPalindrome("racecar", 0, 6));

        System.out.print("Power set of abc = ");
        powerset("abc", 0, "");

        System.out.println("All permutations of `abc`: ");
        permutations("abc", 0, 2);
    }

    private static void powerset(String str, int i, String curr) {
        if (i == str.length()) {
            System.out.print("'" + curr + "' ");
            return;
        }
        powerset(str, i + 1, curr); // don't include new char
        powerset(str, i + 1, curr + str.charAt(i)); // include new char
    }

    private static boolean isPalindrome(String str, int l, int r) {
        if (l >= r)
            return true;
        if (str.charAt(l) != str.charAt(r))
            return false;
        return isPalindrome(str, l + 1, r - 1);
    }

    private static void permutations(String str, int l, int r) {
        if (l == r) {
            System.out.print("'" + str + "' ");
            return;
        }

        for (int i = l; i <= r; i++) {
            // swap l & i
            str = swap(str, l, i);
            permutations(str, l + 1, r);
            // swap l & i again to undo the initial swap
            str = swap(str, l, i);
        }
    }

    private static String swap(String str, int l, int i) {
//        char[] chars = str.toCharArray();
//        char temp = chars[l];
//        chars[l] = chars[i];
//        chars[i] = temp;
//        return new String(chars);

        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(l, str.charAt(i));
        sb.setCharAt(i, str.charAt(l));
        return sb.toString();
    }
}
