import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] dp = new int[100000 + 5];
		int[] a = new int[100000 + 5];
		int[] begin = new int[100000 + 5];
		int T, n, index;
		
		T = in.nextInt();
		for(int t = 1; t <= T; t++) {
			n = in.nextInt();
			for(int i = 1; i <= n; i++)
				a[i] = in.nextInt();
			
			dp[1] = a[1];
			begin[1] = 1;
			index = 1;
			for(int i = 2; i <= n; i++) {
				if(dp[i - 1] >= 0) {
					dp[i] = dp[i - 1] + a[i];
					begin[i] = begin[i - 1];
				}
				else {
					dp[i] = a[i];
					begin[i] = i;
				}
				if(dp[i] > dp[index]) 
					index = i;
			} 
			System.out.println("Case " + t + ":");
			System.out.println(dp[index] + " " + begin[index] + " " + index);
			if(t != T)
				System.out.println();
		}
	}
}
