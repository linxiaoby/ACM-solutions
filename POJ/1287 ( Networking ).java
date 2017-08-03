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
	
	static final int MAXN = 50 + 3;
	static int[] p = new int[50 + 3];
	static List<Edge> list = new ArrayList<Edge>();
	static int[][] vis = new int[MAXN][MAXN];
	
	static int find(int x) {
		return p[x] == -1 ? x : (p[x] = find(p[x]));
	}
	
	static void kruskal() {
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n, r;
		while((n = in.nextInt()) != 0) {
			r = in.nextInt();
			list.clear();
			for(int i = 1; i <= n; i++)
				Arrays.fill(vis[i], -1);
			Arrays.fill(p, -1);
			
			int x, y, w, u, v;
			for(int i = 1; i <= r; i++) {
				x = in.nextInt(); y = in.nextInt(); w = in.nextInt();
				u = Math.min(x, y); v = Math.max(x, y);
				if(vis[u][v] != -1 && w < list.get(vis[u][v]).w) 
					list.set(vis[u][v], new Edge(u, v, w));
				else if(vis[u][v] == -1) {
					list.add(new Edge(u, v, w));
					vis[u][v] = list.size() - 1;
				}
			}
			
			Collections.sort(list);
			int cnt = 0, ans = 0;
			for(Edge e : list) {
				int a = find(e.u), b = find(e.v);
				if(a == b) continue;
				p[a] = b;
				ans += e.w;
				cnt++;
				if(cnt == n - 1) break;
			}
			
			System.out.println(ans);
		}
	}
}
