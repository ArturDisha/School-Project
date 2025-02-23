import java.util.NoSuchElementException;

public class LinkedQueue<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        E removedElement = head.element;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return removedElement;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void concatenate(LinkedQueue<E> Q2) {
        if (Q2.isEmpty()) {
            return; 
        }
        
        if (isEmpty()) {
            head = Q2.head;
        } else {
            tail.next = Q2.head;
        }
        tail = Q2.tail;
        size += Q2.size;
        
        
        Q2.head = null;
        Q2.tail = null;
        Q2.size = 0;
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue1 = new LinkedQueue<>();
        queue1.enqueue(16);
        queue1.enqueue(72);

        LinkedQueue<Integer> queue2 = new LinkedQueue<>();
        queue2.enqueue(36);
        queue2.enqueue(43);

        System.out.println("Before concatenation:");
        System.out.println("Queue 1: " + queue1.toString());
        System.out.println("Queue 2: " + queue2.toString());

        queue1.concatenate(queue2);

        System.out.println("\nAfter concatenation:");
        System.out.println("Queue 1: " + queue1.toString());
        System.out.println("Queue 2: " + queue2.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.element).append(" ");
            current = current.next;
        }
        return sb.toString();
    }
}
