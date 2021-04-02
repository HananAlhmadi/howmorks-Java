/**
 * Created by user on 04/03/21.
 */
public class DoublyLinkedList<E> {
    private Node<E>header ;
    private Node<E>trailer;
    private int size = 0;

    public DoublyLinkedList() {
        header= new Node<E>(null,null,null) ;
        trailer= new Node<E>(null,header,null);
        header.setNext(trailer);
    }
    public boolean equals(Object that){
        if (that== null) return false;
        if (!(that instanceof DoublyLinkedList)) return false;
        DoublyLinkedList<E> other = (DoublyLinkedList<E>) that;
        if (header==null &&other.header!=null) return false;
        if (trailer==null&&other.trailer!=null) return false;
        while (header.getNext()!= trailer){
            if (!(header.equals(other.header))) return false;

            header= header.getNext();
            other.header= other.header.getNext();
        }
        return true;
    }
    public DoublyLinkedList<E> clone() throws CloneNotSupportedException{
        DoublyLinkedList<E> other = (DoublyLinkedList<E>) super.clone();
        if (size>0){
            other.header= new Node<E>(null,null,null) ;
            other.trailer = new Node<E>(null,other.header,null) ;
            other.header.setNext(other.trailer);
            Node<E> walk = header.getNext();
            Node<E> otherWalk = other.header;
            for (int i = 0; i <size ; i++) {
                Node<E> newest = new Node<E>(walk.getElement(),null,null);
                otherWalk.setNext(newest);
                otherWalk=newest;
                otherWalk.setPrev(newest);
                walk=walk.getNext();
            }
        }
        return other;
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
