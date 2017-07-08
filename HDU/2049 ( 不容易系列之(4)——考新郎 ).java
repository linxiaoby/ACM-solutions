import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        long[] g = new long[21];
        long[] a = new long[21];
        g[1] = 0;
        g[2] = 1;
        for(int i = 3; i <= 20; i++)
            g[i] = (i - 1) * (g[i - 1] + g[i - 2]);
         a[0] = a[1] = 1;
         for(int i = 2; i <= 20; i++)
             a[i] = a[i - 1] * i;
         
        Scanner in = new Scanner(System.in);
        int C, n, m;
        long ans;
        C = in.nextInt();
        for(int i = 0; i < C; i++) {
            n = in.nextInt();
            m = in.nextInt();
            ans = (a[n] / (a[m] * a[n - m])) * g[m];
            System.out.println(ans);
        }
    }
}