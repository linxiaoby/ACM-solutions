import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Pair implements Comparable<Pair>{
		int v, w;

		public Pair(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Pair x) {
			return this.w < x.w ? -1 : (this.w == x.w ? 0 : 1);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt(), N = in.nextInt();
		@SuppressWarnings("unchecked")
		List<Pair>[] G = new ArrayList[N + 3];
		int[] d = new int[N + 3];
		for(int i = 0; i < N + 3; i++) {
			G[i] = new ArrayList<Pair>();
			d[i] = Integer.MAX_VALUE;
		} 
		for(int i = 0; i < T; i++) {
			int u = in.nextInt(), v = in.nextInt(), w = in.nextInt();
			G[u].add(new Pair(v, w));
			G[v].add(new Pair(u, w));
		}
		
		d[1] = 0;
		Queue<Pair> q = new PriorityQueue<Pair>();
		q.add(new Pair(1, 0));
		while(!q.isEmpty()) {
			Pair a = q.poll();
			while(!q.isEmpty() && a.w > d[a.v])
				a = q.poll();
			if(a.v == N) break;
			for(int i = 0; i < G[a.v].size(); i++) {
				Pair b = G[a.v].get(i);
				if(d[b.v] > d[a.v] + b.w) {
					d[b.v] = d[a.v] + b.w;
					q.add(new Pair(b.v, d[b.v]));
				}
			}
		}
		System.out.println(d[N]);
	}
}