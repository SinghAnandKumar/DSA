package datastructures.list;

/**
 * Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node. Note that
 * the intersection is defined based on reference, not value. That is, if the kth node of the first linked list is
 * the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.
 *
 * @return the intersecting node, {@code null} otherwise.
 */
public class IntersectingNode {
    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(4);
        l1.next.next.next.next = new Node(5);
        l1.next.next.next.next.next = new Node(5);

        Node l2 = new Node(1);
        l2.next = new Node(4);
        l2.next.next = new Node(2);
        l2.next.next.next = new Node(3);
        l2.next.next.next.next = l1.next.next.next;

        l1.print("List 1: ");
        l2.print("List 2: ");
        Node intersection = findIntersectingNode(l1, l2);
        intersection.print("Intersection: ");

        System.out.println("----- ----- -----");

        l1 = new Node(1);
        l2 = l1;
        l1.print("List 1: ");
        l2.print("List 2: ");
        intersection = findIntersectingNode(l1, l2);
        intersection.print("Intersection: ");

        System.out.println("----- ----- -----");

        l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(4);
        l1.next.next.next.next = new Node(5);
        l1.next.next.next.next.next = new Node(5);
        l2 = new Node(1);
        l2.next = new Node(4);
        l2.next.next = new Node(2);
        l2.next.next.next = new Node(3);
        l1.print("List 1: ");
        l2.print("List 2: ");
        intersection = findIntersectingNode(l1, l2);
        System.out.println("Intersection: " + intersection);
    }

    private static Node findIntersectingNode(Node l1, Node l2) {
        int len1 = 0, len2 = 0;
        Node curr1 = l1;
        Node curr2 = l2;

        // Get length of List1, traverse till second last Node only,
        // NOTE: The last Node pointer in both list can be used to compare and short circuit
        while (curr1 != null && curr1.next != null) {
            len1++;
            curr1 = curr1.next;
        }

        // Get length of List2
        while (curr2 != null && curr2.next != null) {
            len2++;
            curr2 = curr2.next;
        }

        // Short-circuit condition, if Last Node is not same, there is no intersection
        if(curr1 != curr2) {
            return null;
        }

        // jump to head
        curr1 = l1;
        curr2 = l2;

        // Traverse x nodes from the bigger list, where x = difference is length
        int diff = len1 - len2;
        if (len1 > len2) {
            while (diff-- > 0) {
                curr1 = curr1.next;
            }
        } else {
            diff *= -1;
            while (diff-- > 0) {
                curr2 = curr2.next;
            }
        }

        // Move until you find  collision
        while (curr1 != curr2) {
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return curr1;
    }
}
