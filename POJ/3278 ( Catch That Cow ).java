import java.util.Scanner;

public class Main {
	static final int MAXN =  100000 + 7;
	static int[] t = new int[3 * MAXN];
	static int N, K;
	
	static void bfs(int N) {
		int[] q = new int[3 * MAXN],  vis = new int[3 * MAXN];
		int font = 0, rear = 0;
		q[rear++] = N;
		int[] d = {-1, 1, 0};
		
		boolean find = false;
		while(font < rear && !find) {
			int u = q[font++];
			for(int i = 0; i < 3; i++) {
				int nx = u + d[i];
				if(i == 2) nx *= 2;
				if(nx >= 0 && nx <= MAXN && vis[nx] != 1) {
					q[rear++] = nx;
					vis[nx] = 1;
					t[nx] = t[u] + 1;
				}
				if(nx == K) {
					find = true;
					break;
				} 
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		K = in.nextInt();
		
		if(N >= K) t[K] = N - K;
		else bfs(N);
		System.out.println(t[K]);
	}
}
