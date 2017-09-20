import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int MAXN = 20 + 3;
	static int[] q = new int[MAXN * MAXN];
	static char[][] G = new char[MAXN][MAXN];
	static int[][] vis = new int[MAXN][MAXN];
	static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
	static int w, h;
	
	static int bfs(int sx, int sy) {
		for(int i = 0; i < MAXN; i++) 
			Arrays.fill(vis[i], 0);
		
		int front = 0, rear = 0;
		q[rear++] = sx * w + sy;
		vis[sx][sy] = 1;
		int cnt = 1;
		while(front < rear) {
			int u = q[front++];
			int ux = u / w, uy = u % w;
			for(int i = 0; i < 4; i++) {
				int nx = ux + dx[i], ny = uy + dy[i];
				if(nx >= 0 && nx < h && ny >= 0 && ny < w 
						&& G[nx][ny] != '#' && vis[nx][ny] != 1) {
					q[rear++] = nx * w + ny;
					vis[nx][ny] = 1;
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sx = 0, sy = 0;
		while(true) {
			w = in.nextInt(); h = in.nextInt();
			if(w == 0 && h == 0) break;
			for(int i = 0; i < h; i++) {
				String str = in.next();
				for(int j = 0; j < w; j++) {
					G[i][j] = str.charAt(j);
					if(G[i][j] == '@') {
						sx = i;
						sy = j;
					}
				}
			}
			
			System.out.println(bfs(sx, sy));
		}
	}
}

===================================================

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int MAXN = 20 + 3;
	static char[][] G = new char[MAXN][MAXN];
	static int[][] vis = new int[MAXN][MAXN];
	static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
	static int w, h, ans;
	
	static void dfs(int sx, int sy) {
		int nx, ny;
		for(int i = 0; i < 4; i++) {
			nx = sx + dx[i]; ny = sy + dy[i];
			if(nx >= 0 && nx < h && ny >= 0 && ny < w
					&& G[nx][ny] != '#' && vis[nx][ny] != 1) {
				vis[nx][ny] = 1;
				ans += 1;
				dfs(nx, ny);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sx = 0, sy = 0;
		while(true) {
			w = in.nextInt(); h = in.nextInt();
			if(w == 0 && h == 0) break;
			for(int i = 0; i < h; i++) {
				String str = in.next();
				for(int j = 0; j < w; j++) {
					G[i][j] = str.charAt(j);
					if(G[i][j] == '@') {
						sx = i;
						sy = j;
					}
				}
			}
			ans = 1;
			for(int i = 0; i < h; i++) 
				Arrays.fill(vis[i], 0);
			vis[sx][sy] = 1;
			dfs(sx, sy);
			System.out.println(ans);
		}
	}
}