import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int MAXN = 500 + 3;
	static boolean[] vis = new boolean[MAXN]; 
	static double[][] cost = new double[MAXN][MAXN];
	static double[] ed = new double[MAXN], lowc = new double[MAXN];
	
	static void prim(int n) {
		Arrays.fill(vis, false);
		vis[0] = true;
		for(int i = 1; i < n; i++) lowc[i] = cost[0][i];
		
		for(int i = 1; i < n; i++) {
			double minc = Double.MAX_VALUE;
			int p = -1;
			for(int j = 1; j < n; j++) 
				if(!vis[j] && lowc[j] < minc) {
					minc = lowc[j];
					p = j;
				}
			
			ed[i - 1] = minc;
			vis[p] = true;
			
			for(int j = 1; j < n; j++) 
				if(!vis[j] && cost[p][j] < lowc[j])
					lowc[j] = cost[p][j];
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(), S, P;
		int[] px = new int[MAXN], py = new int[MAXN];
		while(N-- > 0) {
			S = in.nextInt(); P = in.nextInt();
			for(int i = 0; i < P; i++) {
				px[i] = in.nextInt();
				py[i] = in.nextInt();
			}
			
			for(int i = 0; i < P; i++) 
				for(int j = 0; j < P; j++) 
					cost[i][j] = Math.sqrt((px[i] - px[j]) * (px[i] - px[j]) 
							   + (py[i] - py[j]) * (py[i] - py[j]));
			
			prim(P);
			Arrays.sort(ed, 0, P - 1);
			System.out.printf("%.2f", ed[P - S - 1]);
			System.out.println();
		}
	}
}
