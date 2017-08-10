import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Pair implements Comparable<Pair>{
		int v, w;

		public Pair(int v, int w) {
			this.v = v; this.w = w;
		}

		@Override
		public int compareTo(Pair o) {
			return this.w < o.w ? -1 : (this.w == o.w ? 0 : 1);
		}
		
	}
	
	static final int MAXN = 1000 + 3;
	static int[][] G = new int[MAXN][MAXN];
	static int[] d1 = new int[MAXN], d2 = new int[MAXN];
	
	static void dijkstra1(int n, int s) {
		Arrays.fill(d1, 0, n + 3,Integer.MAX_VALUE);
		d1[s] = 0;
		Queue<Pair> q = new PriorityQueue<Pair>();
		q.add(new Pair(s, 0));
		while(!q.isEmpty()) {
			Pair a = q.poll();
			while(d1[a.v] < a.w && !q.isEmpty())
				a = q.poll();
			for(int i = 1; i <= n; i++) {
				if(G[a.v][i] != Integer.MAX_VALUE && d1[a.v] + G[a.v][i] < d1[i]) {
					d1[i] = d1[a.v] + G[a.v][i];
					q.add(new Pair(i, d1[i]));
				}
			}
		}
	}
	
	static void dijkstra2(int n, int s) {
		Arrays.fill(d2, 0, n + 3,Integer.MAX_VALUE);
		d2[s] = 0;
		Queue<Pair> q = new PriorityQueue<Pair>();
		q.add(new Pair(s, 0));
		while(!q.isEmpty()) {
			Pair a = q.poll();
			while(d2[a.v] < a.w && !q.isEmpty())
				a = q.poll();
			for(int i = 1; i <= n; i++) {
				if(G[i][a.v] != Integer.MAX_VALUE && d2[a.v] + G[i][a.v] < d2[i]) {
					d2[i] = d2[a.v] + G[i][a.v];
					q.add(new Pair(i, d2[i]));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(), M = in.nextInt(), X = in.nextInt();
		for(int i = 1; i <= N; i++)
			Arrays.fill(G[i], 1, N + 3, Integer.MAX_VALUE);
		
		while(M-- > 0) 
			G[in.nextInt()][in.nextInt()] = in.nextInt();
		
		dijkstra1(N, X);
		dijkstra2(N, X);
		
		int maxc = Integer.MIN_VALUE, tmp;
		for(int i = 1; i <= N; i++) {
			tmp = d1[i] + d2[i];
			maxc = Math.max(tmp, maxc);
		}
		
		System.out.println(maxc);
	}
}