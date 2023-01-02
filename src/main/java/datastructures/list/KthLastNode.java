package datastructures.list;

public class KthLastNode {
    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(4);
        l1.next.next.next.next = new Node(5);
        l1.next.next.next.next.next = new Node(6);

        l1.print("List: ");
        Node kthLast = findKthLast(l1, 4);
        System.out.println("4th last from End:" + kthLast.val);
        kthLast = findKthLast(l1, 1);
        System.out.println("1st last from End:" + kthLast.val);
        kthLast = findKthLast(l1, 7);
        System.out.println("7th last from End:" + kthLast);
    }

    public static Node findKthLast(Node head, int k) {
        Node fast = head;
        Node slow = head;
        int i = 0;
        while (i < k) {
            if (fast == null)
                return null;
            fast = fast.next;
            i++;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
