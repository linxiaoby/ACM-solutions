import java.util.Scanner;

public class Main {
    static boolean isFlower(int n) {
        int c = n % 10;
        int b = (n/10)%10;
        int a = n/100;
        return n == a*a*a + b*b*b + c*c*c;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m, n;
        boolean flag;
        while (in.hasNext()) {
            m = in.nextInt();
            n = in.nextInt();
            flag = false;
            for(int i = m; i <= n; i++) {
                if(isFlower(i))    {
                    if(!flag) {
                        flag = true;
                    }
                    else {
                        System.out.print(" ");
                    }
                    System.out.print(i);
                }
            }
            if(!flag) {
                System.out.println("no");
            }
            else {
                System.out.println();
            }
        }
    }
}