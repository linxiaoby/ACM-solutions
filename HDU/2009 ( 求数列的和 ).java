import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        double n, ans;
        DecimalFormat df = new DecimalFormat("###.00");
        while (in.hasNext()) {
            n = in.nextInt();
            m = in.nextInt();
            ans = 0;
            for (int i = 0; i < m; i++) {
                ans += n;
                n = Math.sqrt(n);
            }
            System.out.println(df.format(ans));
        }
    }
}