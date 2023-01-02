package datastructures.list;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public void print(String prefix) {
        System.out.print(prefix);
        print();
    }
    public void print() {
        Node curr = this;
        while (curr.next != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println(curr.val);
    }
}
