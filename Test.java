/**
 * Created by user on 31/03/21.
 */
public class Test {
    public static void main(String[] args) {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>() ;
        list.addFirst(12);
        list.addFirst(13);
        list.addFirst(14);
        list.addFirst(15);
        System.out.println(list.getSize());
        System.out.println(list.splitList(list));

    }
}
