若b为奇数：
    a^b = a^(b - 1) * a;
若b为偶数：
    a^b = (a^(b/2))^2;


import java.util.Scanner;

public class Main {
    static int qmod(int a, int b, int mod) {
        if(b == 1)
            return a % mod;
        else if(b == 0)
            return 1;
        
        int s;
        s = qmod(a, b>>1, mod);
        s = s * s % mod;
        if((b & 1) != 0) 
            s = s * a % mod;
        return s;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A, B;
        while(true) {
            A = in.nextInt();
            B = in.nextInt();
            if(A == 0 && B == 0)
                break;
            System.out.println(qmod(A, B, 1000));
        }
    }
}