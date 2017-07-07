/*
f(n) = 3 * f(n - 1) - (第n - 1个字符为o的数量)
     = 3 * f(n - 1) - (f(n - 1) 减去第n - 1个字符为非o的数量)
     = 3 * f(n - 1) - (f(n - 1) - 2 * f(n - 2))  
     = 2 * (f(n - 1) + f(n - 2))
*/

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        long[] a = new long[41];
        a[0] = 1;
        a[1] = 3;
        for(int i = 2; i <= 40; i++)
            a[i] = 2 * (a[i - 1] + a[i - 2]);  
        
        Scanner in = new Scanner(System.in);
        int n;
        while(in.hasNext()) {
            n = in.nextInt();
            System.out.println(a[n]);
        }
    }
}