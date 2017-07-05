import java.util.Scanner;

public class Main {
    static boolean judgePrime(int n) {
        boolean flag = true;
        int[] a = new int[10000];
         for(int i = 2; i <= Math.sqrt(n); i++) {
            if(a[i] != -1 && n % i != 0) {
                for(int j = i + i ; j <= Math.sqrt(n); j += i) {
                    a[j] = -1;
                }    
            }
            else if(a[i] != -1 && n % i == 0) {
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
        x = in.nextInt();
        y = in.nextInt();
        while(x != 0 || y != 0) {
            flag = true;
            for(int i = x + 1; i < y; i++) {
                if(!judgePrime(i * i + i + 41)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                System.out.println("OK");
            }
            else {
                System.out.println("Sorry");
            }
            x = in.nextInt();
            y = in.nextInt();
        }
    }
}