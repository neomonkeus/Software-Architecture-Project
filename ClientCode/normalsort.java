/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClientCode;

import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Adrian
 */
public class normalsort {
public static void main(String [] args)
    {
     int [] numbers;
        numbers = new int [20000000];
        Random random;
        random = new Random();
        for(int i=0; i<numbers.length; i++)
        {
            numbers[i] = random.nextInt();
            }
        long a = System.currentTimeMillis();
        long initialtime = System.nanoTime();
        Arrays.sort(numbers);
        long b = System.currentTimeMillis();
        long c = b-a;
        System.out.println("NormalSort: " + c + " milliseconds");
        JOptionPane.showMessageDialog(null, (System.nanoTime()-initialtime) );
}
}