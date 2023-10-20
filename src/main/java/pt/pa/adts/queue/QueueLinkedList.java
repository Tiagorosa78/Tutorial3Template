package pt.pa.adts.queue;

/**
 * This class must implement the Queue interface
 * @param <T>
 */
public class QueueLinkedList<T> implements Queue<T>   {

    private ListNode header, trailer;
    private int size;

    public QueueLinkedList() {
        header = new ListNode(null, null, null);
        trailer = new ListNode(null, header, null);
        header.next = trailer;
        size = 0;
    }

    @Override
    public void enqueue(T elem) throws QueueFullException, NullPointerException {
        if (elem == null) {
            throw new NullPointerException("Cannot enqueue null element");
        }

        ListNode newElement = new ListNode(elem, trailer.prev, trailer);
        trailer.prev.next = newElement;
        trailer.prev = newElement;
        size++;
    }

    @Override
    public T dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue is empty");
        }

        T frontElement = header.next.element;
        header.next = header.next.next;
        header.next.prev = header;
        size--;
        return frontElement;
    }

    @Override
    public T front() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue is empty");
        }

        return header.next.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        header.next = trailer;
        trailer.prev = header;
        size = 0;
    }

    private class ListNode {
        private T element;
        private ListNode next;
        private ListNode prev;

        public ListNode(T element, ListNode prev, ListNode next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
