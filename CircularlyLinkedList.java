/**
 * Created by fatima on 20/02/2021.
 */
public class CircularlyLinkedList<E> {
    Node<E> head1  ;
    Node<E> head2  ;
    private Node<E> tail = null;
    private int size = 0;

    public CircularlyLinkedList() {
    }
    public int getSize() {
        Node<E> h = tail.getNext() ;
        Node<E> t= tail ;
        int size = 0 ;
        while (h!=t){
            size++;
            h=h.getNext();
        }
        return size ;
    }

    public CircularlyLinkedList splitList(CircularlyLinkedList list){
        CircularlyLinkedList<E> m = new CircularlyLinkedList<E>();
        Node<E> temp = list.tail ;
        for (int i = 0; i < list.size()/2 ; i++) {
            temp = temp.getNext();
        }
        m.tail = temp.getNext();
        temp.setNext(list.tail);
        for (int i = 0; i < list.size()/2 ; i++) {
            temp= temp.getNext();
        }
        temp.setNext(m.tail);
        return m ;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }

    public E first() {
        if (isEmpty()) return null;
        return tail.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void addFirst(E element) {
        if (size == 0) {
            tail = new Node<E>(element, null);
            tail.setNext(tail);
        } else {
            Node<E> n = new Node<E>(element, tail.getNext());
            tail.setNext(n);
        }
        size++;
    }
    public void addLast(E element)
    {
       addFirst(element);
        tail=tail.getNext();
    }
    public E removeFirst()
    {
        if (isEmpty())return null;
        Node<E> deleted= tail.getNext();
        if(deleted==tail)
            tail=null;
        else
        tail.setNext(deleted.getNext());
        size--;
        return deleted.getElement();
    }
public void rotate()
{
    if(tail!=null)
    tail=tail.getNext();

}
    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
