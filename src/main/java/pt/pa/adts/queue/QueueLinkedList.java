package pt.pa.adts.queue;

/**
 * This class must implement the Queue interface
 * @param <E>
 */
public class QueueLinkedList<E>  {

    private ListNode header, trailer;
    private int size;

    public QueueLinkedList() {
        //TODO: construtor deve inicializar uma fila vazia
    }

    //TODO: implementar métodos da interface à custa da estrutura de dados fornecida

    private class ListNode {
        private E element;
        private ListNode next;
        private ListNode prev;

        public ListNode(E element, ListNode prev, ListNode next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
