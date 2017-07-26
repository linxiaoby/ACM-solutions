import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int MAXN = 10000 + 3;
	static boolean[] isPrime = new boolean[MAXN];
	static int[] vis = new int[MAXN], q = new int[MAXN], cost = new int[MAXN];
	static int[] digit = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

	static void primePrint() {
		Arrays.fill(isPrime, true);
		int sq = (int)Math.sqrt(MAXN);
		for(int i = 2; i < sq; i++) {
			for(int j = i + i; j < MAXN; j += i) 
				isPrime[j] = false;
		}
	}
	
	static boolean bfs(int s, int e) {
		if(s == e) return true;
		int front = 0, rear = 0;
		q[rear++] = s;
		vis[s] = 1;
		
		boolean find = false;
		while(front < rear && !find) {
			int u = q[front++];
			for(int i = 0; i < 4; i++) {
				char[] chs = String.valueOf(u).toCharArray();
				for(int j = 0; j <= 9; j++) {
					if(i == 0 && j == 0) continue;
					chs[i] = (char) (digit[j] + 48);
					int x = Integer.valueOf(String.valueOf(chs));
					
					if(vis[x] != 1 && isPrime[x] == true) {
						q[rear++] = x;
						vis[x] = 1;
						cost[x] = cost[u] + 1;
						if(x == e) {
							find = true;
							break;
						} 
					}
				}
			}
		}
		return find;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		primePrint();
		int n = in.nextInt(), s, e;
		
		for(int k = 0; k < n; k++) {
			s = in.nextInt(); e = in.nextInt();
			Arrays.fill(vis, 0);
			Arrays.fill(cost, 0);
			
			System.out.println(bfs(s, e) ? cost[e] : "Impossible");
		}
	}
}