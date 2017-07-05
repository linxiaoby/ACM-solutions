import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        int[] a = new int[100 +5];
        n = in.nextInt();
        while(n != 0) {
            for(int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for(int i = 0; i < n -1; i++) {
                for(int j = 0; j < n - i; j++){
                    if(Math.abs(a[j]) < Math.abs(a[j + 1])) {
                        int tmp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = tmp;
                    }
                }
            }
            for(int i = 0; i < n; i++) {
                if(i != 0)
                    System.out.print(" ");
                System.out.print(a[i]);
            }
            System.out.println();
            n = in.nextInt();
        }
    }
}