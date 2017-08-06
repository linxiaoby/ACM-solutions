import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Pair implements Comparable<Pair>{
		int v;
		double w;
		
		public Pair(int v, double w) {
			this.v = v;	this.w = w;
		}
		
		public int compareTo(Pair o) {
			return this.w < o.w ? -1 : (this.w == o.w ? 0 : 1);
		}
	}
	
	static final int MAXN = 200 + 3;
	static double[][] G = new double[MAXN][MAXN];
	static double[] d = new double[MAXN];
	static Queue<Pair> q = new PriorityQueue<Pair>();
	static boolean[] vis = new boolean[MAXN];

	static void dijkstra(int n) {
		Arrays.fill(d, Double.MAX_VALUE);
		Arrays.fill(vis, false);
		d[0] = 0;
		q.add(new Pair(0, 0));
		
		while(!q.isEmpty()) {
			Pair a = q.poll();
			while(a.w > d[a.v] && !q.isEmpty()) a = q.poll();
			vis[a.v] = true;
			for(int i = 0; i < n; i++) {
				double maxw = Math.max(d[a.v], G[a.v][i]);
				if(maxw < d[i]) {
					d[i] = maxw;
					q.add(new Pair(i, maxw));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n, c = 1;
		int[] x = new int[MAXN], y = new int[MAXN];
		while((n = in.nextInt()) != 0) {
			for(int i = 0; i < n; i++) {
				x[i] = in.nextInt(); 
				y[i] = in.nextInt();
			}
			
			for(int i = 0; i < n - 1; i++) 
				for(int j = i + 1; j < n; j++)  {
					double dis = Math.sqrt((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]));
					G[i][j] = G[j][i] = dis;
				}
			
			dijkstra(n);
			System.out.println("Scenario #" + c++);
			System.out.printf("Frog Distance = %.3f\n\n", d[1]);
		}
	}
}
