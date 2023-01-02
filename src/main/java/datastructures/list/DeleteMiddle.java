package datastructures.list;

/**
 * Input: Delete the node c from the linked list a->b->c->d->e->f
 * Result: nothing is returned, but the new linked list looks like a->b->d->e->f
 **/
public class DeleteMiddle {
    public static void main(String[] args) {
        Node list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(3);
        list.next.next.next = new Node(4);
        list.next.next.next.next = new Node(5);
        list.next.next.next.next.next = new Node(6);
        list.print("Before: ");
        deleteMiddle(list.next.next);
        list.print("After: ");

        System.out.println("----");

        list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(3);
        list.print("Before: ");
        deleteMiddle(list.next);
        list.print("After: ");

        System.out.println("----");
    }

    private static void deleteMiddle(Node middle) {
        if (middle == null || middle.next == null) {
            return;
        }

        middle.val = middle.next.val;
        middle.next = middle.next.next;
        return;
    }
}
