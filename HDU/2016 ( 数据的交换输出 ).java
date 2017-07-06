
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, min, index = 0;
        int[] a = new int[100 + 5];
        while(true) {
            n = in.nextInt();
            if(n == 0)
                break;
            
            min = 1000000;
            for(int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                if(a[i] < min) {
                    min = a[i];
                    index = i;
                } 
            }
            if(index != 0) {
                int tmp = a[index];
                a[index] = a[0];
                a[0] = tmp;
            }
            for(int i = 0; i < n - 1; i++)
                System.out.print(a[i] + " ");
            System.out.println(a[n - 1]);
        }
    }
}