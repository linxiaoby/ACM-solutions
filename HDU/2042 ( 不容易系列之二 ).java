import java.util.Scanner;

public class Main {
    
	public static void main(String[] args) {
		int[] s = new int[30 + 3];
		s[0] = 3;
		for(int i = 1; i <= 30; i++)
			s[i] = (s[i - 1] - 1) * 2;  
		
        Scanner in = new Scanner(System.in);
        int N, a;
        N = in.nextInt();
        for(int i = 0; i < N; i++) {
        	a = in.nextInt();
        	System.out.println(s[a]);
        }
    }
}