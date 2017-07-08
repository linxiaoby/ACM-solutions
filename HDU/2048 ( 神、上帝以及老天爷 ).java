import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        long[] g = new long[21];
        long[] a = new long[21];
        g[1] = 0;
        g[2] = 1;
        for(int i = 3; i <= 20; i++)
            g[i] = (i - 1) * (g[i - 1] + g[i - 2]);
        a[1] = 1;
        for(int i = 2; i <= 20; i++)
            a[i] = a[i - 1] * i;
        
        
        Scanner in = new Scanner(System.in);
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMinimumFractionDigits(2);
        int C, n;
        double e;
        C = in.nextInt();
        for(int t = 0; t < C; t++) {
            n = in.nextInt();
            e = g[n] * 1.0 /a[n];
            System.out.println(nf.format(e));
        }
    }
}