import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, min, index;
        int[] a = new int[100 + 5];
        n = in.nextInt();
        
        while(n != 0) {
            min = 1000000;
            index = -1;
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
            for(int i = 0; i < n; i++) {
                if(i != 0) System.out.print(" ");
                System.out.print(a[i]);
            }
            System.out.println();
            n = in.nextInt();
        }
    }
}