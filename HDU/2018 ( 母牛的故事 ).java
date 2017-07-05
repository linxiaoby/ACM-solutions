import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] large = new int[55 + 3];
        int[] small = new int[55 + 3];
        large[1] = large[2] = large[3] = large[4] = 1;
        small[1] = 0; small[2] = 1; small[3] = 2; small[4] = 3;
        for(int i = 5; i <= 55; i++) {
            large[i] = large[i - 1] + large[i - 3];
            small[i] = small[i - 1] + small[i - 3];
        }
        
        int n;
        n =  in.nextInt();
        while (n != 0) {
            System.out.println(large[n] + small[n]);
            n = in.nextInt();
        }
    }
}