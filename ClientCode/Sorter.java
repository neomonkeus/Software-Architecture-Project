 import java.util.Random;
import java.util.Arrays;
import java.util.Timer;
import javax.swing.JOptionPane;

public class Sorter implements Runnable {

    static int[] numbers;
    static Random random;

    public void run() {
        /* sort upper half */
        Arrays.sort(numbers, numbers.length/2, numbers.length);
    }

    public static void main(String args[]) throws InterruptedException {

        numbers = new int[20000000];
        random = new Random();
        

        for(int i=0; i<numbers.length; i++) {
            numbers[i] = random.nextInt();
        }

        Thread t = new Thread(new Sorter());
        t.start();

        long a = System.currentTimeMillis();
        long initialtime = System.nanoTime();
        Arrays.sort(numbers, 0, numbers.length/2);

        t.join();

        int j = 0;
        int k = numbers.length/2;
        int[] tmp = new int[numbers.length];
        for (int i=0; i<tmp.length; i++){
            if (j < numbers.length/2) {
                if (k < numbers.length) {//if odd array
                    if (numbers[j] < numbers[k]) { //if
                        tmp[i] = numbers[j++];
                    } else {
                        tmp[i] = numbers[k++];
                    }
                } else {
                    //reached end of second half, copy first
                    tmp[i] = numbers[j++];
                }
            } else {
                //reached end of 1st half, copy 2nd
                tmp[i] = numbers[k++];
            }
        }

        numbers = tmp;
         long b = System.currentTimeMillis();
        long c = b-a;
        System.out.println("ThreadSort: " + c + " milliseonds");
         JOptionPane.showMessageDialog(null, (System.nanoTime()-initialtime) );
    
            //System.out.println(numbers[50]);
            //System.out.println(numbers[60]);
            //System.out.println(numbers[150]);
            //System.out.println(numbers[199]);
    }
}



