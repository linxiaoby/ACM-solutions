import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class Edge implements Comparable<Edge>{
		int u, v, w;
		public Edge(int u, int v, int w) {
			this.u = u;	this.v = v; this.w = w;
		}
		
		public int compareTo(Edge x) {
			return this.w < x.w ? -1 : (this.w == x.w ? 0 : 1);
		}
	}
	
	static List<Edge> list = new ArrayList<Edge>();
	static int[] p = new int[27 + 3];
	
	static int find(int x) {
		return p[x] == -1 ? x : (p[x] = find(p[x]));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n;
		while((n = in.nextInt()) != 0) {
			Arrays.fill(p, -1);
			list.clear();
			while(n-- > 1) {
				int u = in.next().charAt(0) - 64;
				int k = in.nextInt();
				for(int i = 0; i < k; i++) 
					list.add(new Edge(u, in.next().charAt(0) - 64, in.nextInt()));
			}
			
			Collections.sort(list);
			int ans = 0, cnt = 0;
			for (Edge e: list) {
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
