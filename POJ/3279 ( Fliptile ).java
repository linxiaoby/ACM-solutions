import java.util.Arrays;
import java.util.Scanner;

public class Main {
	final static int MAXN = 15 + 3, INF = 15 * 15 + 7;
	static int[][] grid = new int[MAXN][MAXN], flip = new int[MAXN][MAXN], 
			        ans = new int[MAXN][MAXN];
	static int[] dx = {0, -1, 1, 0, 0}, dy = {0, 0, 0, -1, 1};
	static int M, N;
	
	static int isBlack(int x, int y) {
		int cnt = 0;
		for(int i = 0; i < 5; i++) {
			int nx = x + dx[i], ny = y + dy[i];
			if(nx >= 0 && nx < M && ny >= 0 && ny < N)
				cnt += flip[nx][ny];
		}
		return (cnt & 1) == 0 ? grid[x][y]: (grid[x][y] ^ 1);
	}
	
	static boolean isLegal() {
		boolean white = true; 
		for(int j = 0; j < N && white; j++) {
			if(isBlack(M - 1, j) == 1) 
				white = false;
		}
		return white;
	}
	
	static void printAns() {
		for(int i = 0; i < M; i++) {
			System.out.print(ans[i][0]);
			for(int j = 1; j < N; j++)
				System.out.print(" " + ans[i][j]);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		M = in.nextInt(); N = in.nextInt();
		for(int i = 0; i < M; i++)
			for(int j = 0; j < N; j++)
				grid[i][j] = in.nextInt();
		
		int min = INF;
		for(int i = 0; i < 1 << N; i++) {
			for(int k = 0; k < M; k++)
				Arrays.fill(flip[k], 0);
			
			for(int j = 0; j < N; j++) 
				flip[0][N - j - 1] = i >> j & 1;
			for(int k = 1; k < M; k++) 
				for(int j = 0; j < N; j++) 
					if(isBlack(k - 1, j) == 1)
						flip[k][j] = 1;
			if(!isLegal()) continue;
			
			int cnt = 0;
			for (int k = 0; k < M; k++)
				for (int j = 0; j < N; j++)
					if (flip[k][j] == 1)
						cnt++;
			if (cnt < min) {
				min = cnt;
				for (int k = 0; k < M; k++)
					ans[k] = flip[k].clone();
			}
		}
		
		if(min < INF) printAns(); 
		else System.out.println("IMPOSSIBLE"); 
	}
}
