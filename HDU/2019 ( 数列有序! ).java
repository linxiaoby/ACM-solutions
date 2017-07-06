
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, m, tmp;
        int[] a = new int[100 + 3];
        
        boolean flag;
        while(true) {
            n = in.nextInt(); 
            m = in.nextInt();
            if(n == 0 && m == 0)
                break;
            
            flag = false;
            for(int i = 0; i <= n; i++) {
                tmp = in.nextInt();
                if(tmp > m && !flag) {
                    a[i] = m;
                    a[++i] = tmp;
                    flag = true;
                }
                a[i] = tmp;    
            }
            
            for(int i = 0; i < n; i++)
                System.out.print(a[i] + " ");
            System.out.println(a[n]);
        }
    }
}