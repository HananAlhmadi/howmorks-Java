import java.util.Scanner;

/**
 * Created by user on 07/02/21.
 */
public class Ques3 {
    int arr [] = {1,2,3,4} ;
    int arr2 [] = new int [arr.length-1] ;
    public void print () {
        System.out.println("main array");
        System.out.print("[");
        for (int i = 0; i < arr2.length; i++) {
            if (i == arr2.length - 1)
                System.out.print(arr2[i]);
            else
                System.out.print(arr2[i] + ",");

        }
        System.out.println("]");
    }
    public void  remove (int index){
        int j = 0 ;
        if(arr == null || index<0 || index>arr.length)
            print();

        else
            for (int i = 0 ; i <arr.length ; i++) {
                if (i==index)
                    continue;

                arr2[j++] = arr[i] ;

            }



    }

    public static void main(String[] args) {
        int index ;
        Scanner in = new Scanner(System.in) ;
        System.out.println("enter index to remove");
        index = in.nextInt();

        Ques3 test = new Ques3();
        test.remove(index);
        test.print();
    }
}
