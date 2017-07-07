import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long[] a = new long [51];
        a[1] = 3; a[2] = 6;
        for(int i = 3; i <= 50; i++)
            a[i] =  (long) (a[i - 1] + (3 * Math.pow(2, i - 2) - a[i - 1]) * 2);
        
        Scanner in = new Scanner(System.in);
        int n;
        while(in.hasNext()) {
            n = in.nextInt();
            System.out.println(a[n]);
        }
    }
}