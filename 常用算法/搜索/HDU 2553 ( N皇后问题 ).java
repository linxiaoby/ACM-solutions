import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int cnt;
	static int[][] vis = new int[23][23];

	static void search(int N, int cur) {
		if (cur == N) {
			cnt++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (vis[0][i] == 0 && vis[1][cur + i] == 0
					&& vis[2][cur - i + N] == 0) {
				vis[0][i] = vis[1][cur + i] = vis[2][cur - i + N] = 1;
				search(N, cur + 1);
				vis[0][i] = vis[1][cur + i] = vis[2][cur - i + N] = 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N;
		int[] ans = new int[13];
		Arrays.fill(ans, -1);
		while (true) {
			N = in.nextInt();
			if (N == 0)
				break;
			
			if (ans[N] == -1) {
				for (int i = 0; i < vis.length; i++)
					Arrays.fill(vis[i], 0);
				cnt = 0;
				search(N, 0);
				ans[N] = cnt;
			}
			System.out.println(ans[N]);
		}
	}
}