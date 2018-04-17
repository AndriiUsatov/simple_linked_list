import java.util.Iterator;

public class SimpleLinkedList<T> implements Iterable{
    private int size = 0;
    private SimpleLinkedList.Node<T> first;
    private SimpleLinkedList.Node<T> last;


    public SimpleLinkedList() {
    }

    public void add(T data) {
        Node<T> node = new Node<T>(data);
        if (size == 0) {
            first = node;
            last = node;
            first.next = node;
            first.prev = node;
        } else {
            last.next = node;
            first.prev = node;
            node.next = first;
            node.prev = last;
            last = node;
        }
        size++;
    }

    public T get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException(String.valueOf(index));
        if (index == 0)
            return getFirst();
        else if (index == size - 1)
            return getLast();
        else {
            SimpleLinkedList.Node<T> result = first;
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
            return result.data;
        }
    }

    public void remove(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException(String.valueOf(index));
        if (index == 0) {
            first.next.prev = last;
            first = first.next;
            last.next = first;
        } else if (index == size - 1) {
            first.prev = last.prev;
            last.prev.next = first;
            last = last.prev;
        } else {
            SimpleLinkedList.Node<T> current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    }

    public T getFirst() {
        return first.data;
    }

    public T getLast() {
        return last.data;
    }

    public int size(){
        return size;
    }

    public Iterator iterator() {
        return new SimpleLinkedListIterator();
    }

    private static class Node<T> {
        private SimpleLinkedList.Node<T> next;
        private SimpleLinkedList.Node<T> prev;

        private T data;

        private Node(T data) {
            this.data = data;
        }
    }

    private class SimpleLinkedListIterator implements Iterator {
        private Node current;

        private SimpleLinkedListIterator(){ current = first; }

        public boolean hasNext() {
            return current != last;
        }

        public T next() {
            current = current.next;
            return (T)current.data;
        }

        public void remove() {
            System.out.println("Nope");
        }


    }
}
