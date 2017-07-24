【DFS】
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int MAXN = 100 + 3;
    static int[][] vis = new int[MAXN][MAXN];
    static char[][] maze = new char[MAXN][MAXN];
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}, dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int m, n, cnt;
    
    static void dfs(int x, int y) { 
        if(x < 0 || x >= m || y < 0 || y >= n || maze[x][y] == '*' || vis[x][y] == 1) 
            return;
        vis[x][y] = 1;
        for(int k = 0; k < 8; k++) 
            dfs(x + dx[k], y + dy[k]);
    }

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true) {
            m = in.nextInt(); n = in.nextInt();
            if(m == 0) break;
            cnt = 0;
            for(int i = 0; i < MAXN; i++) 
                Arrays.fill(vis[i], 0);
            
            for(int i = 0; i < m; i++) {
                String str = in.next();
                maze[i] = str.toCharArray();
            }
            
            for(int x = 0; x < m; x++) {
                for(int y = 0; y < n; y++) {
                    if(vis[x][y] == 0 && maze[x][y] == '@') {
                        cnt++;
                        dfs(x, y);
                    } 
                }
            }
            System.out.println(cnt);
        }
    }
}

===================================
【BFS】

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int MAXN = 100 + 3;
	static int[][] vis = new int[MAXN][MAXN];
	static char[][] maze = new char[MAXN][MAXN];
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}, dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int m, n, cnt;
	
	static void bfs(int x, int y) { 
		int[] q = new int[MAXN * MAXN];
		int font = 0, rear = 0;
		q[rear++] = x * n + y;
		
		while(font < rear) {
			int u = q[font++];
			int tx = u / n, ty = u % n;
			for(int k = 0; k < 8; k++) {
				int nx = tx + dx[k], ny = ty + dy[k];
				if(nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] != '*' && vis[nx][ny] == 0) {
					q[rear++] = nx * n + ny;
					vis[nx][ny] = 1;
				} 
			}
		}
 		
	}

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(true) {
			m = in.nextInt(); n = in.nextInt();
			if(m == 0) break;
			cnt = 0;
			for(int i = 0; i < MAXN; i++) 
				Arrays.fill(vis[i], 0);
			
			for(int i = 0; i < m; i++) {
				String str = in.next();
				maze[i] = str.toCharArray();
			}
			
			for(int x = 0; x < m; x++) {
				for(int y = 0; y < n; y++) {
					if(vis[x][y] == 0 && maze[x][y] == '@') {
						cnt++;
						bfs(x, y);
					} 
				}
			}
			System.out.println(cnt);
		}
	}
}
