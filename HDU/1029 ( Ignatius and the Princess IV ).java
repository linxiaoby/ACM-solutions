import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	final int MAXL = 999999 + 3;
        Scanner in = new Scanner(System.in);
        int N;
        int[] x = new int[MAXL];
        while (in.hasNext()) {
            N = in.nextInt();
            for(int i = 0; i < N; i++) 
            	x[i] = in.nextInt();
            Arrays.sort(x, 0, N);
            System.out.println(x[(N + 1) / 2]);
        }
    }
}