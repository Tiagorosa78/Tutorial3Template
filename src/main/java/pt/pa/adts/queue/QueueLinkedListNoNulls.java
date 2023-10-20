package pt.pa.adts.queue;

public class QueueLinkedListNoNulls<T> extends QueueLinkedList<T> {

    @Override
    public void enqueue(T elem) throws NullNotAllowedException {
        if (elem == null) {
            throw new NullNotAllowedException("Null elements are not allowed.");
        }
        super.enqueue(elem);
    }

}
