/**
 * Created by user on 04/03/21.
 */
public class CircularDoublyLinkedList<E> {
    private Node<E>header ;
    private Node<E>trailer;
    private int size = 0;

    public CircularDoublyLinkedList() {
        header= new Node<E>(null,null,null) ;
        trailer= new Node<E>(null,header,header);
        header.setNext(trailer);
    }
    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public E first(){
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }

    public E last(){
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();
    }

    private void addBetween(E element,Node<E> p ,Node<E> s){
        Node<E> newest= new Node<E>(element,p,s) ;
        p.setNext(newest);
        s.setPrev(newest);
        size++ ;
    }

    public void addFirst(E element){
        addBetween(element,header,header.getNext());
    }

    public void addLast(E element){
        addBetween(element,trailer.getPrev(),trailer);
    }

    private E remove(Node<E> x){
        Node<E> p = x.prev;
        Node<E> s = x.next;

        p.setNext(s);
        s.setPrev(p);
        size--;

        return x.element;
    }

    public E removeFirst(){
        if (isEmpty()) return null;
        return remove(header.next) ;
    }

    public E removeLast(){
        if (isEmpty()) return null;
        return remove(trailer.prev) ;
    }
    public void rotate(){
        if (trailer!=null)
            trailer=trailer.getNext();
    }
    public void rotateBackword(){
        if (trailer!=null)
            trailer=trailer.getPrev();
    }
    private static class Node<E>{
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
