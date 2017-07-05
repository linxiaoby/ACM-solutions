import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m, n;
        long so,sj;
        while (in.hasNext()) {
            so = 0;
            sj = 0;
            m = in.nextInt();
            n = in.nextInt();
            
            if(n < m) {
                int tmp = n;
                n = m;
                m = tmp;
            }
            
            for(int i = m; i <= n; i++) {
                if(i%2 == 0) {
                    so += Math.pow(i, 2);
                }
                else {
                    sj += Math.pow(i, 3); 
                }
            }
            System.out.println(so + " " + sj);
        }
    }
}