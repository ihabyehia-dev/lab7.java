package lab5;

/** Doubly linked list with head, tail, and two-way node links. */
public class DoubleLinked {
    Node head;
    Node tail;

    public boolean isempty() {
        return head == null;
    }

    void insertatfront(int v) {
        Node n = new Node(v);
        n.next = head;
        if (head != null) head.prev = n;
        else tail = n;
        head = n;
    }

    void insertatback(int v) {
        Node n = new Node(v);
        n.prev = tail;
        if (tail != null) tail.next = n;
        else head = n;
        tail = n;
    }

    void insertatkey(int key, int v) {
        Node current = head;
        while (current != null && current.data != key) current = current.next;
        if (current == null) return;
        if (current == head) {
            insertatfront(v);
            return;
        }
        Node n = new Node(v);
        n.next = current;
        n.prev = current.prev;
        current.prev.next = n;
        current.prev = n;
    }

    void deletefromfront() {
        if (head == null) return;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
    }

    void deletefromback() {
        if (tail == null) return;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
    }

    void deleteByvalue(int key) {
        Node current = head;
        while (current != null && current.data != key) current = current.next;
        if (current == null) return;
        if (current == head) {
            deletefromfront();
            return;
        }
        if (current == tail) {
            deletefromback();
            return;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }

    public int searchrecursive(int key) {
        return recursions(head, key, 0);
    }

    int recursions(Node n, int key, int index) {
        if (n == null) return -1;
        if (n.data == key) return index;
        return recursions(n.next, key, index + 1);
    }

    void displayforward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + ",");
            current = current.next;
        }
        System.out.println();
    }

    void displaybackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + ",");
            current = current.prev;
        }
        System.out.println();
    }

    void reverse() {
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = current.prev;
            current.prev = next;
            current = next;
        }
        Node oldHead = head;
        head = tail;
        tail = oldHead;
    }

}
