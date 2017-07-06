import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		long[] s = new long[50 + 3];
		s[0] = s[1] = 1;
		for(int i = 2; i <= 50; i++)
			s[i] = s[i - 1] + s[i - 2];
		
        Scanner in = new Scanner(System.in);
        int N, a, b;
        N = in.nextInt();
        for(int i = 0; i < N; i++) {
        	a = in.nextInt();
        	b = in.nextInt();
        	System.out.println(s[b - a]);
        }
    }
}