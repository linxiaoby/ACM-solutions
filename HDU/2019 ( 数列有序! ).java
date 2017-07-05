import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, m, tmp;
        int[] a = new int[100 + 3];
        n = in.nextInt(); 
        m = in.nextInt();
        boolean flag;
        while(n != 0 || m != 0) {
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
            
            for(int i = 0; i < n + 1; i++) {
                if(i != 0) 
                    System.out.print(" ");
                System.out.print(a[i]);
            }
            System.out.println();
            n = in.nextInt(); 
            m = in.nextInt();
        }
    }
}