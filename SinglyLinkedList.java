/**
 * Created by user on 03/03/21.
 */
public class SinglyLinkedList<E> {
    public Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0  ;

    public boolean isEmpty (){
        return size== 0 ;
    }
    public int size(){
        return size;
    }
    public E first(){
        if (isEmpty()) return null;
        return head.getElement();
    }
    public E last(){
        if (isEmpty()) return null;
        return tail.getElement();
    }
    public void addFirst(E element ){
        head = new Node<E>(element,head) ;
        if (isEmpty())
            tail=head;
        size++ ;
    }
    public void addLast(E element){
        Node<E> newest = new Node<E>(element,null);
        if (isEmpty())
            head=newest;
        else
            tail.setNext(newest);
        tail=newest;
        size++;
    }
    public E removeFirst(){
        if (isEmpty())
            return null;
        E deleted = head.getElement();
        head=head.getNext();
        size--;
        if(isEmpty())
            tail= null;
        return deleted;
    }
    public String print(){
        Node<E> i = head;
        String all="" ;
        while (i!=null){
            all=all+i.getElement().toString()+"\n" ;
            i = i.getNext();
        }
        return all;
    }

    public E findSecondLastNode(Node ptr){
        Node temp = ptr;
        if (temp==null || temp.getNext()==null){
            return null ;
        }
        while (temp.getNext().getNext() != null){
            temp = temp.getNext();
        }
        return (E) temp.getElement();
    }

    public void rotate(int k){
        if(k == 0) return;

        Node current = head;
        int count = 1;
        while (count< k && current!= null){
            current=current.getNext();
            count++;
        }
        if (current== null) return;

        Node kthNode = current;

        while (current.getNext()!=null){
            current=current.getNext();
        }
        current.next = head;
        head =kthNode.next;
        kthNode.next= null;

    }

    public int newSize(){
        Node tem = head;
        int size = 0 ;
        if(head==null) return size;

        else size++;

        while (tem.getNext()!=null){
      tem=tem.next;
            size++;
        }
        return size;
    }

    public void concatTwoLists(SinglyLinkedList l,SinglyLinkedList m){
        Node node=l.head;

        while (node.getNext() !=null){
            node=node.getNext();
        }
        node.setNext(m.head);
        l.size = l.size+m.size;
    }

    public Node reverse (Node node){
        Node prev = null;
        Node current = node;
        Node nextN = null;

        while (current!=null){
            nextN = current.next;
            current.next=prev;
            prev=current;
            current=nextN;

        }
        node = prev;
        return node;

    }


    private static class Node<E> {
        private E element ;
        private Node<E> next ;

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
