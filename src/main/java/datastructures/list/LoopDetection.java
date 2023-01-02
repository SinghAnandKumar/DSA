package datastructures.list;

import java.util.Hashtable;

public class LoopDetection {
    public static void main(String[] args) {
        Node list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(3);
        list.next.next.next = new Node(4);
        list.next.next.next.next = new Node(5);
        list.next.next.next.next.next = list.next.next; // Points to Node 3, making a circular loop

//        DON'T use the default implementation, goes into INFINITE LOOP
//        list.print("List : ");
        Node loopStart = findLoopStartNode(list);
        System.out.println("Loop Start Node: " + loopStart.val);

        Node loopStartHashing = findLoopStartNodeHashing(list);
        if (loopStartHashing != null) {
            System.out.println("Loop Start Node(Hashing): " + loopStartHashing.val);
        }
    }

    private static Node findLoopStartNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow)
                break;
        }

        /* Error check - no meeting point, and therefore no loop */
        if (fast == null || fast.next == null) {
            return null;
        }

        /* Move slow to Head. Keep fast at Meeting Point. Each are k steps from the
         * Loop Start. If they move at the same pace, they must meet at Loop Start. */
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        /* You can return either as now both point to the start of the loop */
        return fast;
    }

    private static Node findLoopStartNodeHashing(Node list) {
        Hashtable<Node, Boolean> nodeTracker = new Hashtable<>();
        Node current = list;
        while (current != null && (nodeTracker.get(current) != Boolean.TRUE)) {
            nodeTracker.put(current, Boolean.TRUE);
            current = current.next;
        }
        if (current == null) {
            System.out.println("No Loop detected");
        }
        return current;
    }
}
