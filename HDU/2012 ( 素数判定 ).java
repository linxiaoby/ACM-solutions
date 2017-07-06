
import java.util.Scanner;

public class Main {
    static boolean judgePrime(int n) {
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x, y;
        boolean flag;
        while (true) {
            x = in.nextInt();
            y = in.nextInt();
            if (x == 0 && y == 0)
                break;
            flag = true;
            for (int i = x; i <= y; i++) {
                if (!judgePrime(i * i + i + 41)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                System.out.println("OK");
            else
                System.out.println("Sorry");
        }
    }
}