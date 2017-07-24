import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int MAXN = 30 + 3;
	static int[][][] maze = new int[MAXN][MAXN][MAXN], vis = new int[MAXN][MAXN][MAXN], 
					    t = new int[MAXN][MAXN][MAXN];
	static int[] dx = {0, 1, 0, -1, 0, 0}, dy = {1, 0, -1, 0, 0, 0}, 
			     dz = {0, 0, 0, 0, 1, -1}; //ESWNUD
	static int[] q = new int[MAXN * MAXN * MAXN];
	static int L, R, C;
	
	static boolean bfs(int sx, int sy, int sz) {
		int font = 0, rear = 0;
		q[rear++] = sx * C + sy + sz * R * C;
		
		boolean find = false;
		while(font < rear) {
			int u = q[font++];
			int tx = u % (R * C) / C, ty = u % C, tz = u / (R * C);
			
			for(int i = 0; i < 6; i++) {
				int nx = tx + dx[i];
				int ny = ty + dy[i];
				int nz = tz + dz[i];
				if(nx >= 0 && nx < R && ny >= 0 && ny < C && nz >= 0 && nz < L
						   && maze[nx][ny][nz] != '#' && vis[nx][ny][nz] != 1) {
					q[rear++] = nx * C + ny + nz * R * C;
					vis[nx][ny][nz] = 1;
					t[nx][ny][nz] = t[tx][ty][tz] + 1;
					if(maze[nx][ny][nz] == 'E') {
						find = true;
						break;
					} 
				}
			}
			
			if(find) break;
		}
		return find;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			L = in.nextInt();
			R = in.nextInt();
			C = in.nextInt();
			if (L == 0 && R == 0 && C == 0) break;
			for (int i = 0; i < MAXN; i++)
				for (int j = 0; j < MAXN; j++) {
					Arrays.fill(vis[i][j], 0);
					Arrays.fill(t[i][j], 0);
				}
			
			int sx = 0, sy = 0, sz = 0, ex = 0, ey = 0, ez = 0;
			for (int z = 0; z < L; z++) {
				for (int x = 0; x < R; x++) {
					String str = in.next();
					for (int y = 0; y < C; y++) {
						maze[x][y][z] = str.charAt(y);
						if(maze[x][y][z] == 'S') {
							sx = x; 
							sy = y; 
							sz = z;
						}
						else if(maze[x][y][z] == 'E') {
							ex = x; 
							ey = y; 
							ez = z;
						}
					}
				}
			}
			
			boolean find = bfs(sx, sy, sz);
			System.out.println(find ? "Escaped in " + t[ex][ey][ez] + " minute(s)." : "Trapped!");
		}
	}
}
