import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		final int INF = 1000000000, MAXL = 1000000 + 5;
		Scanner in = new Scanner(System.in);
		int m, n;
		int[] dp = new int[MAXL], pre = new int [MAXL], x = new int[MAXL];
		
		while (in.hasNext()) {
			m = in.nextInt(); n = in.nextInt();
			for(int i = 1; i <= n; i++)
				x[i] = in.nextInt();
			Arrays.fill(pre, 0);
			
			int tmp = 0;
			for(int i = 1; i <= m; i++) {
				tmp = -INF;
				for(int j = i; j <= n; j++) {
					dp[j] = Math.max(dp[j - 1], pre[j - 1]) + x[j];
					pre[j - 1] = tmp;
					tmp = Math.max(tmp, dp[j]);
				}
			}
			
			System.out.println(tmp);
		}
	}
}
