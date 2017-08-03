mport java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class Point {
		double x, y, z, r;
		public Point(double x, double y, double z, double r) {
			this.x = x; this.y = y; this.z = z;
			this.r = r;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int u, v;
		double w;
		public Edge(int u, int v, double w) {
			this.u = u;	this.v = v; this.w = w;
		}
		public int compareTo(Edge o) {
			return this.w < o.w ? -1 : (this.w == o.w ? 0 : 1);
		}
	}
	
	static final int MAXN = 100 + 3;
	static int[] p = new int[MAXN];
	static List<Point> pt = new ArrayList<Point>();
	static List<Edge> ed = new ArrayList<Edge>();
	
	static int find(int x) {
		return p[x] == -1 ? x : (p[x] = find(p[x]));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n;
		while((n = in.nextInt()) != 0) {
			Arrays.fill(p, -1); pt.clear(); ed.clear();
			while(n-- > 0) {
				pt.add(new Point(in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble()));	
			}
			
			Point p1, p2;
			double dis, w;
			int cnt = 0;
			for(int i = 0; i < pt.size() - 1; i++) {
				p1 = pt.get(i);
				for(int j = i + 1; j < pt.size(); j++) {
					p2 = pt.get(j);
					dis = Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y) 
							      + (p1.z - p2.z) * (p1.z - p2.z));
					if(dis <= p1.r + p2.r) {
						p[i] = j;
						w = 0;
						cnt ++;
					}
					else 
						w = dis - p1.r - p2.r;
					ed.add(new Edge(i, j, w));	
				}
			}
			
			Collections.sort(ed);
			double ans = 0;
			for(Edge e : ed) {
				int a = find(e.u), b = find(e.v);
				if(a == b) continue;
				p[a] = b;
				ans += e.w;
				cnt++;
				if(cnt == n - 1) break;
			}
			
			System.out.printf("%.3f", ans);
			System.out.println();
		}
	}
}
