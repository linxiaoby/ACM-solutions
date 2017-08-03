import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class Edge implements Comparable<Edge>{
		int u, v, w;

		public Edge(int u, int v, int w) {
			this.u = u; this.v = v; this.w = w;
		}

		public int compareTo(Edge o) {
			return this.w < o.w ? -1 : (this.w == o.w ? 0 : 1);
		}
	}
	
	static final int MAXN = 100 + 3;
	static int[] p = new int[MAXN];
	static int N, ans, cnt;
	
	static int find(int x) {
		return p[x] == -1 ? x : (p[x] = find(p[x]));
	}
	
	static void union(int x, int y, int w) {
		int a = find(x), b = find(y);
		if(a != b) {
			p[a] = b;
			cnt++;
			ans += w;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Edge> list = new ArrayList<Edge>();
		N = in.nextInt();
		for(int u = 1; u <= N; u++) {
			for(int v = 1; v <= N; v++) {
				int w = in.nextInt();
				if(v > u) 
					list.add(new Edge(u, v, w));
			}
		}
		
		int Q = in.nextInt();
		cnt = 0;
		Arrays.fill(p, -1);
		while(Q-- > 0) {
			int u = in.nextInt(), v = in.nextInt();
			union(u, v, 0);
		}
			
		Collections.sort(list);
		ans = 0;
		for(Edge e : list) {
			if(cnt == N - 1) break;
			union(e.u, e.v, e.w);
		}
		System.out.println(ans);
	}
}


