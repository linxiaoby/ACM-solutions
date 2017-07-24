import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int MAXN = 200 + 3;
	static int[][]  vis = new int[MAXN][MAXN];
	static char[][] maze = new char[MAXN][MAXN];
	static int[] q = new int[MAXN * MAXN], dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int n, m, cnt;
	
	static void bfs(int x, int y, int[][] t) {
		for(int i = 0; i < MAXN; i++)
			Arrays.fill(vis[i], 0);
		int font = 0, rear = 0, k = 0;
		q[rear++] = x * m + y;
		
		while(font < rear && k < cnt) {
			int u = q[font++];
			int tx = u / m, ty = u % m;
			for(int i = 0; i < 4; i++) {
				int nx = tx + dx[i], ny = ty + dy[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < m 
						   && maze[nx][ny] != '#' && vis[nx][ny] != 1) {
					q[rear++] = nx * m + ny;
					vis[nx][ny] = 1;
					t[nx][ny] = t[tx][ty] + 1;
					if(maze[nx][ny] == '@') k++;
				}
			}
			
			if(k == cnt) break;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] t1 = new int[MAXN][MAXN], t2 = new int[MAXN][MAXN];
		while(in.hasNext()) {
			n = in.nextInt(); m = in.nextInt();
			cnt = 0;
			int sx1 = 0, sy1 = 0, sx2 = 0, sy2 = 0;
			for(int i = 0; i < n; i++) {
				String str = in.next();
				for(int j = 0; j < m; j++) {
					maze[i][j] = str.charAt(j);
					if(maze[i][j] == 'Y') {
						sx1 = i;
						sy1 = j;
					} 
					else if(maze[i][j] == 'M') {
						sx2 = i;
						sy2 = j;
					}
					else if(maze[i][j] == '@') cnt++;
				}
			} 
			
			for(int i = 0; i < MAXN; i++) {
				Arrays.fill(t1[i], 0);
				Arrays.fill(t2[i], 0);
			}
			bfs(sx1, sy1, t1);
			bfs(sx2, sy2, t2);
			
			int min = 500000;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) 
					if(maze[i][j] == '@' && t1[i][j] != 0 && t2[i][j] != 0) 
						min = Math.min(min, t1[i][j] + t2[i][j]);
			}
			
			System.out.println(min * 11);
		}
	}
}