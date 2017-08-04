import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int MAXN = 750 + 3;
	static boolean[] vis = new boolean[MAXN]; 
	static double[][] cost = new double[MAXN][MAXN];
	static double[] ed = new double[MAXN], lowc = new double[MAXN];
	static int[] s = new int[MAXN], u = new int[MAXN], v = new int[MAXN];
	
	static int prim(int n) {
		Arrays.fill(vis, 0, n + 1, false);
		vis[1] = true;
		Arrays.fill(s, 0, n + 1, 1);
		for(int i = 2; i <= n; i++) lowc[i] = cost[1][i];
		
		int cnt = 0;
		for(int i = 2; i <= n; i++) {
			double minc = Double.MAX_VALUE;
			int p = -1;
			for(int j = 2; j <= n; j++) {
				if(!vis[j] && lowc[j] < minc) {
					minc = lowc[j];
					p = j;
				}
			}
			
			vis[p] = true;
			if(minc != 0) {
				u[cnt] = s[p];
				v[cnt++] = p;	
			}
			
			for(int j = 2; j <= n; j++) 
				if(!vis[j] && lowc[j] > cost[p][j]) {
					lowc[j] = cost[p][j];
					s[j] = p;
				}
		}
		
		return cnt;
	} 
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] px = new int[N + 3], py = new int[N + 3];
		for(int i = 1; i <= N; i++) {
			px[i] = in.nextInt();
			py[i] = in.nextInt();
		}
		
		for(int i = 1; i <= N; i++) 
			for(int j = 1; j <= N; j++)
				cost[i][j] = Math.sqrt((px[i] - px[j]) * (px[i] - px[j]) 
						   + (py[i] - py[j]) * (py[i] - py[j]));
		
		int M = in.nextInt();
		for(int i = 0; i < M; i++) {
			int a = in.nextInt(), b = in.nextInt();
			cost[a][b] = cost[b][a] = 0;
		}
		
		int cnt = prim(N);
		for(int i = 0; i < cnt; i++) 
			System.out.println(u[i] + " " + v[i]);
	}
}