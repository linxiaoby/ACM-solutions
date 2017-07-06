import java.util.Scanner;

public class Main {
    
	public static void main(String[] args) {
		int[] a = new int[40 + 3];
		a[0] = a[1] = 1;
		for(int i = 2; i <= 40; i++)
			a[i] = a[i - 1] + a[i - 2];
		
        Scanner in = new Scanner(System.in);
        int N, M;
        N = in.nextInt();
        for(int i = 0; i < N; i++){
        	M = in.nextInt();
        	System.out.println(a[M - 1]);
        } 
    }
}