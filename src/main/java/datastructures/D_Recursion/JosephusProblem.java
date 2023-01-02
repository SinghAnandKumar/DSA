package datastructures.D_Recursion;

public class JosephusProblem {
    public static void main(String[] args) {
        System.out.println("Josephus(5,3) , Last Person = " + josephus(5, 3));
        System.out.println("Josephus(41,3) , Last Person = " + josephus(41, 3));
    }

    private static int josephus(int n, int k) {
        if (n == 1) { // base case, if only 1 person is there then return 0 (0th index person)
            return 0;
        }
        return (josephus(n - 1, k) + k) % n;
    }
}
