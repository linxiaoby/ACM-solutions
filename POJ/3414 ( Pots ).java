import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int MAXN = 100 + 3;
	static String[] optName = {"FILL(1)", "FILL(2)", "DROP(1)", "DROP(2)", "POUR(1,2)", "POUR(2,1)"};	 
	static int[][] vis = new int[MAXN][MAXN], cost = new int[MAXN][MAXN], 
					fa = new int[MAXN][MAXN], opt = new int[MAXN][MAXN];
	static int[] q = new int[MAXN * MAXN], path = new int[MAXN * MAXN];
	static int A, B, C, R;
	
	
	static boolean bfs(int x, int y) {
		int front = 0, rear = 0;
		q[rear++] = 0;
		vis[0][0] = 1; 
		
		boolean find = false;
		while(front < rear && !find) {
			int u = q[front++];
			int a = u / R, b = u % R;
			for(int i = 0; i < 6; i++) {
				int na = a, nb = b;
				switch (i) {
				case 0: na = A; break;
				case 1: nb = B; break;
				case 2: na = 0; break;
				case 3: nb = 0; break;
				case 4: int ta1 = na, tb1 = nb; 
						na = na > (B - nb) ? na - (B - nb) : 0;
						nb = ta1 + tb1 - na; 
						break;
				default:int ta2 = na, tb2 = nb; 
						nb = nb > (A - na) ? nb - (A - na) : 0;
						na = ta2 + tb2 - nb; 
						break;
				}
				
				if(na >= 0 && na <= A && nb >= 0 && nb <= B && vis[na][nb] != 1) {
					q[rear++] = na * R + nb;
					cost[na][nb] = cost[a][b] + 1;
					fa[na][nb] = a * R  + b;
					opt[na][nb] = i;
					vis[na][nb] = 1;
					if(na == C || nb == C) {
						find = true;
						printAns(na, nb);
						break;
					}
				}
				
			}
		}
		return find;
	}
	
	static void printAns(int x, int y) {
		System.out.println(cost[x][y]);
		int i = 0;
		while(true) {
			path[i++] = x * R  + y;
			int fx = fa[x][y] / R, fy = fa[x][y] % R;
			if(fx == 0 && fy == 0) break;
			x = fx; y = fy;
		}
		while(i >= 1) {
			i -= 1;
			int tx = path[i] / R, ty = path[i] % R;
			System.out.println(optName[opt[tx][ty]]);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		A = in.nextInt(); B = in.nextInt(); C = in.nextInt();
		R = B + 1;
		for(int i = 0; i < MAXN; i++) {
			Arrays.fill(cost[i], 0);
			Arrays.fill(vis[i], 0);
		}
		if(!bfs(0, 0))
			System.out.println("impossible");
	}
}