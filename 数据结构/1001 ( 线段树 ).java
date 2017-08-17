https://vjudge.net/solution/9873861/T6qytlRkWiTgkd1lNCvK
http://blog.csdn.net/zearot/article/details/48299459

【POJ 3468】
import java.util.Scanner;

public class Main {
	
	static class Node {
		int l, r;
		long sum, inc;
		public Node(int l, int r) {
			this.l = l; this.r = r;
		}
	}
	
	static class Tree {
		static Node[] no = new Node[MAXN << 2];
		
		static void pushUp(int rt) {
			no[rt].sum = no[rt << 1].sum + no[rt << 1 | 1].sum;
		}
		
		static void build(int rt, int l, int r) {
			no[rt] = new Node(l, r);
			if(l == r) {
				no[rt].sum = a[l];
				return;
			}
			int m = (l + r) >> 1;
			build(rt << 1, l, m); build(rt << 1 | 1, m + 1, r);
			pushUp(rt);
		}
		
		static void update(int rt, int a, int b, long c) {
			int l = no[rt].l, r = no[rt].r;
			if(a <= l && r <= b) {
				no[rt].sum += c * (r - l + 1);
				no[rt].inc += c;
				return;
			}
			int m = (l + r) >> 1;
			pushDown(rt, m - l + 1, r - m); 
			if(a <= m) update(rt << 1, a, b, c);
			if(b > m) update(rt << 1 | 1, a, b, c);
			pushUp(rt);
		}
		
		static void pushDown(int rt, int ln, int rn) {
			long c = no[rt].inc;
			if(c == 0) return;
			no[rt << 1].sum += c * ln;
			no[rt << 1].inc += c;
			no[rt << 1 | 1].sum += c * rn;
			no[rt << 1 | 1].inc += c;
			no[rt].inc = 0;
		}
		
		static long query(int rt, int a, int b) {
			int l = no[rt].l, r = no[rt].r;
			if(a <= l && r <= b) {
				return no[rt].sum;
			}
			int m = (l + r) >> 1;
			pushDown(rt, m - l + 1, r - m);
			long ans = 0;
			if(a <= m) ans += query(rt << 1, a, b);
			if(b > m) ans += query(rt << 1 | 1, a, b);
			return ans;
		}

	}
	
	static final int MAXN = 100000 + 5;
	static int[] a = new int[MAXN];
	
	public static void main(String[] args)  {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(), Q = in.nextInt();
		for(int i = 1; i <= N; i++) 
			a[i] = in.nextInt();
		
		Tree.build(1, 1, N);
		while(Q-- > 0) {
			char op = in.next().charAt(0);
			if(op == 'C') 
				Tree.update(1, in.nextInt(), in.nextInt(), in.nextLong());
			else 
				System.out.println(Tree.query(1, in.nextInt(), in.nextInt()));
		}
	}
}