import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,tmp,a,b,c,d,e,sum = 0;
        n = in.nextInt();
        while(n != 0) {
            sum = 0;
            for(int i = 0; i < n; i++) {
                tmp = in.nextInt();
                a = tmp%100;
                b = a%50;
                c = b%10;
                d = c%5;
                e = d%2;
                sum += tmp/100 + a/50 + b/10 + c/5 + d/2 + e;
            }
            System.out.println(sum);
            n = in.nextInt();
        }
    }
}