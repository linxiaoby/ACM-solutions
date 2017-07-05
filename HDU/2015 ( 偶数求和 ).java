import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, m;
        int s;
        while(in.hasNext()) {
            n = in.nextInt();
            m = in.nextInt();
            for(int i = 1; i <= n/m; i++) {
                s = 0;
                for(int j = (i - 1)*m + 1; j <= i*m; j++)
                    s += j*2;
                if(i != 1) 
                    System.out.print(" ");
                System.out.print(s/m);
            }
            if(n%m != 0) {
                s = 0;
                for(int i = n - n%m + 1; i <= n; i++) 
                    s += i*2;
                System.out.print(" " + s/(n%m));
            }
            System.out.println();
        }
    }
}
