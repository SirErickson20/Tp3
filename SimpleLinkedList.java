package EdD.Tp4;
import java.util.Iterator; 
public class SimpleLinkedList<ELEMENT> implements ILinkedList<ELEMENT> {
    //region Node Class
    private class Node<E> {
        public ELEMENT item;
        public Node<ELEMENT> next;
        public Node(ELEMENT item, Node<ELEMENT> next) {
            this.item = item;
            this.next = next;
        }
        @Override
        public String toString() {
            return this.item.toString();
        }
    }
    //region Attributes
    protected Node<ELEMENT> head;
    protected int count;
    protected Node<ELEMENT> tail;
    //region Constructors
    public SimpleLinkedList() {
        this.head = null;
        this.count = 0;
        this.tail = null;
    }
    //region Linked List Methods
    // Returns the number of elements in this list.
    public int size() {
        return this.count;
    }
    // Inserts the specified element at the beginning of this list.
    public void addFirst(ELEMENT item) {
        Node<ELEMENT> temp = new Node<ELEMENT>(item, this.head);
        if (this.count == 0) {
            this.tail = temp;
        }
        this.head = temp;
        ++this.count;
    }
    // Appends the specified element to the end of this list.
    public void addLast(ELEMENT item) {
        Node<ELEMENT> temp = new Node<ELEMENT>(item, null);
        if (this.count == 0) {
            this.head = temp;
        } else {
            this.tail.next = temp;
        }
        this.tail = temp;
        ++this.count;
    }
    // Removes and returns the first element from this list.
    public ELEMENT removeFirst() {
        if (this.count == 0) {
            throw new RuntimeException("La lista está vacía...");
        }
        ELEMENT item = this.head.item;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        }
        --this.count;
        return item;
    }
    // Removes and returns the last element from this list.
    public ELEMENT removeLast() {
        if (this.count == 0) {
            throw new RuntimeException("La lista está vacía...");
        }
        ELEMENT item = this.tail.item;
        if (this.head.next == null) {
            this.head = this.tail = null;
        } else {
            Node<ELEMENT> skip = this.head;
            while (skip.next.next != null) {
                skip = skip.next;
            }
            this.tail = skip;
            this.tail.next = null;
        }
        --this.count;
        return item;
    }
    //region Object Methods
    @Override
    public String toString() {
        if (this.size() <=0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[" + this.head.item.toString());
        for (Node<ELEMENT> skip = this.head.next; skip != null; skip = skip.next) {
            sb.append(", " + skip.item.toString());
        }
        sb.append("]");
        return sb.toString();
    }
    //region Iterable Methods
    @Override
    public Iterator<ELEMENT> iterator() {
        return new SimpleLinkedListIterator(this.head);
    }
    private class SimpleLinkedListIterator implements Iterator<ELEMENT> {
        private Node<ELEMENT> current;
        public SimpleLinkedListIterator(Node<ELEMENT> current) {
            this.current = current;
        }
        @Override
        public boolean hasNext() {
            return this.current != null;
        }
        @Override
        public ELEMENT next() {
            if (!this.hasNext()) {
                throw new RuntimeException("La lista está vacía...");
            }
            ELEMENT item = this.current.item;
            this.current = this.current.next;
            return item;
        }
    }
}
 
