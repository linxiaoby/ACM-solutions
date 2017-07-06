
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        int m, n;
        double s, f;
        Scanner in = new Scanner(System.in);
        
        m = in.nextInt();
        for(int i = 0; i < m; i++) {
            s = 0;
            f = 1;
            n = in.nextInt();
            for(int j = 1; j <= n; j++) {
                s += 1.0/j*f;
                f = -f;
            }
            System.out.printf("%.2f", s);
            System.out.println();
        }
    }
}