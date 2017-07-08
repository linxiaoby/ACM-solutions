import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = 100000;
        int[] a = new int[len + 3];
        for(int i = 1; i <= len; i++) 
            for(int j = i; j <= len; j += i)
                a[j] = (a[j] == 0) ? 1 : 0;
        
        int n;
        while(in.hasNext()) {
            n = in.nextInt();
            System.out.println(a[n]);
        }
    }
}
