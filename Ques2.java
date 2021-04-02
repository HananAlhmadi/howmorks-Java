import java.util.Arrays;

/**
 * Created by user on 21/02/21.
 */
public class Ques2 {
    public <E> void merge(E arr1[] , E arr2[]){
        E mergeArr[] = (E[])new Object[arr1.length+arr2.length];
        int pos = 0 ;
        for (E elemrnt:arr1
             ) {
            mergeArr[pos++] = elemrnt;

        }

        for (E element:arr2
             ) {
            mergeArr[pos++]=element;
        }

        System.out.println(Arrays.toString(mergeArr));
    }

    public static void main(String[] args) {
        Integer arr1[]={1,2,3} ;
        Integer arr2[]={4,5,6,7} ;

        Ques2 q = new Ques2();
        q.merge(arr1,arr2);
    }
}
