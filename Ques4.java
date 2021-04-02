import java.util.Random;

/**
 * Created by user on 07/02/21.
 */
public class Ques4 {
    public void randomRemove (int a []) {
        Random random = new Random() ;
        while (a.length>0){
            int index = random.nextInt(a.length);
            System.out.println("index = "+index+"element = "+a[index]);
            int a1 [] = new int [a.length-1] ;
            for (int i = 0; i <index ; i++) {
                a1[i] = a[i] ;
            }
            for (int i = 0; i <a.length-1 ; i++) {
                a1[i] = a[i+1] ;
            }
            a=a1 ;
        }

    }
    public static void main(String[] args) {
        int a [] = {1,2,3,4} ;
        Ques4 test = new Ques4();
        test.randomRemove(a);
    }
}
