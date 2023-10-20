import pt.pa.adts.queue.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueLinkedListTest {
    private Queue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new QueueLinkedList<>();
    }

    @Test
    public void testFIFOPrinciple() {
        // Inserindo elementos na fila
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Verificando se o princípio FIFO é mantido
        assertEquals(1, queue.front()); // Primeiro elemento inserido deve ser o próximo a sair
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.front());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.front());
        assertEquals(3, queue.dequeue());

        // A fila deve estar vazia no final
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testDequeueWithEmptyQueue() {
        // Tentar remover de uma fila vazia deve lançar uma exceção QueueEmptyException
        assertThrows(QueueEmptyException.class, () -> queue.dequeue());
    }

    @Test
    public void testFrontWithEmptyQueue() {
        // Tentar acessar o elemento da frente de uma fila vazia deve lançar uma exceção QueueEmptyException
        assertThrows(QueueEmptyException.class, () -> queue.front());
    }

    @Test
    public void testSizeWithEnqueueAndDequeue() {
        // Inserindo elementos na fila e verificando o tamanho
        assertEquals(0, queue.size());
        queue.enqueue(1);
        assertEquals(1, queue.size());
        queue.enqueue(2);
        assertEquals(2, queue.size());
        queue.enqueue(3);
        assertEquals(3, queue.size());

        // Removendo elementos da fila e verificando o tamanho
        queue.dequeue();
        assertEquals(2, queue.size());
        queue.dequeue();
        assertEquals(1, queue.size());
        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Test
    public void testSizeAfterClear() {
        // Inserindo elementos na fila
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Verificando o tamanho após a inserção
        assertEquals(3, queue.size());

        // Realizando a limpeza da fila
        queue.clear();

        // Verificando o tamanho após a limpeza
        assertEquals(0, queue.size());
    }

    @Test
    public void testIsEmptyWithElements() {
        // Verificando se a fila está vazia no início
        assertTrue(queue.isEmpty());

        // Inserindo elementos na fila
        queue.enqueue(1);
        queue.enqueue(2);

        // Verificando que a fila não está vazia após a inserção
        assertFalse(queue.isEmpty());

        // Removendo elementos da fila
        queue.dequeue();
        queue.dequeue();

        // Verificando que a fila está vazia após a remoção
        assertTrue(queue.isEmpty());
    }

    public void testIsEmptyAfterClearWithElements() {
        // Inserindo elementos na fila
        queue.enqueue(1);
        queue.enqueue(2);

        // Verificando que a fila não está vazia antes da limpeza
        assertFalse(queue.isEmpty());

        // Realizando a limpeza da fila
        queue.clear();

        // Verificando que a fila está vazia após a limpeza
        assertTrue(queue.isEmpty());
    }
    

}
