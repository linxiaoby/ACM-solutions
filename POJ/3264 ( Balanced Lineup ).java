import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static class Node {
		int l, r, min, max;
		public Node(int l, int r) {
			this.l = l; this.r = r;
		}
	}
	
	static class Tree {
		static Node[] no = new Node[MAXN << 2];
		
		static void pushUp(int rt) {
			no[rt].max = Math.max(no[rt << 1].max, no[rt << 1 | 1].max);
			no[rt].min = Math.min(no[rt << 1].min, no[rt << 1 | 1].min);
		}
		
		static void build(int rt, int l, int r) {
			no[rt] = new Node(l, r);
			if(l == r) {
				no[rt].min = no[rt].max = a[l];
				return;
			}
			int m = (l + r) >> 1;
			build(rt << 1, l, m); 
			build(rt << 1 | 1, m + 1, r);
			pushUp(rt);
		}
		
		static void query(int rt, int a, int b) {
			int l = no[rt].l, r = no[rt].r;
			if(a <= l && r <= b) {
				h = Math.max(h, no[rt].max);
				s = Math.min(s, no[rt].min);
				return;
			}
			int m = (l + r) >> 1;
			if(a <= m) 
				query(rt << 1, a, b);
			if(b > m) 
				query(rt << 1 | 1, a, b);
 		}
 	}
	
	static final int MAXN = 50000 + 5;
	static int[] a = new int[MAXN];
	static int h, s;
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.valueOf(str[0]), Q = Integer.valueOf(str[1]);
		for(int i = 1; i <= N; i++)
			a[i] = Integer.valueOf(br.readLine());
		
		Tree.build(1, 1, N);
		while(Q-- > 0) {
			h = Integer.MIN_VALUE; s = Integer.MAX_VALUE;
			
			String[] tmp = br.readLine().split(" ");
			Tree.query(1, Integer.valueOf(tmp[0]), Integer.valueOf(tmp[1]));
			System.out.println(h - s);
		}
	}
}
