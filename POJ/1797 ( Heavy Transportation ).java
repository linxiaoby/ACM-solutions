import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int MAXN = 1000 + 3;
	static int[][] G = new int[MAXN][MAXN];
	static boolean[] vis = new boolean[MAXN];
	static int[] hignc = new int[MAXN], s = new int[MAXN];

	static void prim(int n) {
		Arrays.fill(s, 0);
		Arrays.fill(vis, false);
		vis[1] = true;
		for(int i = 2; i <= n; i++) hignc[i] = G[1][i];
		
		int k = 0;
		for(int i = 2; i <= n; i++) {
			int maxc = Integer.MIN_VALUE, p = -1;
			for(int j = 2; j <= n; j++) 
				if(!vis[j] && hignc[j] > maxc) {
					maxc = hignc[j];
					p = j;
				}
			vis[p] = true;
			s[k++] = maxc;
			if(p == n) {
				Arrays.sort(s, 0, k);
				break;
			}
				
			for(int j = 2; j <= n; j++)
				if(!vis[j] && G[p][j] > hignc[j]) 
					hignc[j] = G[p][j];
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int c = in.nextInt();
		int n, m;
		for(int k = 1; k <= c; k++) {
			n = in.nextInt(); m = in.nextInt();
			for(int i = 1; i <= n; i++)
				Arrays.fill(G[i], 1, n + 1, 0);
			
			for(int i = 0; i < m; i++) {
				int a = in.nextInt(), b = in.nextInt(), w = in.nextInt();
				G[a][b] = G[b][a] = w;
			}
			
			prim(n);
			System.out.println("Scenario #" + k + ":\n" + s[0] + "\n");
		}
	}
}
