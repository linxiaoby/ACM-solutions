import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        int m;
        int[] a = new int[100 + 5];
        double s, f;
        DecimalFormat df = new DecimalFormat("##0.00");
        Scanner in = new Scanner(System.in);
        
        m = in.nextInt();
        for(int i = 0; i < m; i++) {
            a[i] = in.nextInt();
        }
        
        for(int i = 0; i < m; i++) {
            s = 0;
            f = 1;
            for(int j = 1; j <= a[i]; j++) {
                s += 1.0/j*f;
                f = -f;
            }
            System.out.println(df.format(s));
        }
    }
}