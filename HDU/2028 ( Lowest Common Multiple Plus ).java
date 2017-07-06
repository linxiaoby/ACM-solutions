import java.util.Scanner;

public class Main {
    
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
    static int lcm(int a, int b) {
        return a/gcd(a, b)*b;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, L;
        while(in.hasNext()) {
            n = in.nextInt();
            L = in.nextInt();
            for(int i = 1; i < n; i++)
                L = lcm(in.nextInt(), L);
            System.out.println(L);
        }
    }
}