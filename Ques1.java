/**
 * Created by user on 21/02/21.
 */
public class Ques1 {
    public   <E> void reseve(E arr1[] , E arr2[]){
        int j = 0;
        for (int i = arr1.length; i >0 ; i--,j++) {
            arr2[j] = arr1[i-1] ;
        }
    }
    public  <E> void print(E arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Ques1 q = new Ques1();
        Integer arr1[]={1,2,3} ;
        Integer arr2[] = new Integer[3] ;
        q.reseve(arr1 ,arr2);
        q.print(arr2);
    }
}
