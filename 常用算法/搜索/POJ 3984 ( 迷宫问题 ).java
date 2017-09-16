import java.util.Scanner;

public class Main {
	static final int MAXN = 5;
	static int[][] maze = new int[MAXN][MAXN], vis = new int[MAXN][MAXN],
				     fa = new int[MAXN][MAXN];
	static int[] q = new int[MAXN * MAXN];
	static int sx = 0, sy = 0, ex = 4, ey = 4;
	
	static void bfs(int sx ,int sy) {
		int font = 0, rear = 0;
		q[rear++] = sx * MAXN + sy; 
		vis[0][0] = 1; 
		
		int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
		while(font < rear) {
			int u = q[font++];
			int x = u / MAXN, y = u % MAXN;
			for(int i = 0; i < 4; i++) {
				int tx = x + dx[i], ty = y + dy[i];
				if(tx >= 0 && tx <= MAXN - 1 && ty >= 0 && ty <= MAXN - 1 
						   && maze[tx][ty] == 0 && vis[tx][ty] == 0) {
					q[rear++] = tx * MAXN + ty;
					vis[tx][ty] = 1;
					fa[tx][ty] = x * MAXN + y;
				}
			}
		}
	}
	
	/*static void print(int x, int y) {
		if(x == sx && y == sy) {
			System.out.println("(" + x + ", " + y + ")");
			return;
		}
		int fx = fa[x][y] / MAXN, fy = fa[x][y] % MAXN;
		print(fx, fy);
		System.out.println("(" + x + ", " + y + ")");
			
	}*/
	
	static void print(int x, int y) {
		int[] path = new int[MAXN * MAXN];
		int t = 0;
		path[t++] = x * MAXN + y;
		while(true) {
			if(x == sx && y == sy) break;
			path[t++] = fa[x][y];
			int fx = fa[x][y] / MAXN, fy = fa[x][y] % MAXN;
			x = fx; y = fy;
		}
		for(int i = t - 1; i >= 0; i--)
			System.out.println("(" + path[i] / MAXN + ", " + path[i] % MAXN + ")");
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for(int i = 0; i < MAXN; i++) 
			for(int j = 0; j < MAXN; j++) 
				maze[i][j] = in.nextInt();
		bfs(sx, sy);
		print(ex, ey);
	}
}