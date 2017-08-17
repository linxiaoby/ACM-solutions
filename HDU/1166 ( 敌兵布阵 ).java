import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static class Node {
		int l, r, sum;

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
			build(rt << 1, l, m);
			build(rt << 1 | 1, m + 1, r);
			pushUp(rt);
		}
		
		static void update(int rt, int i, int j, int op) {
			int l = no[rt].l, r = no[rt].r;
			if(l == r) {
				no[rt].sum = op == 1 ? no[rt].sum + j : no[rt].sum - j;
				return;
			} 
			int m = (l + r) >> 1;	
			if(i <= m) update(rt << 1, i, j, op);
			else update(rt << 1 | 1, i, j, op);
			pushUp(rt);
		}
		
		static int query(int rt, int i, int j) {
			int l = no[rt].l, r = no[rt].r;
			if(i <= l && r <= j) 
				return no[rt].sum;
			int m = (l + r) >> 1;
			int ans = 0;
			if(i <= m) 
				ans += query(rt << 1, i, j);
			if(j > m) 
				ans += query(rt << 1 | 1, i, j);
			return ans;
		}
	}
	
	
	static final int MAXN = 50000 + 5;
	static int[] a = new int[MAXN];
	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.valueOf(br.readLine());
			String[] s = br.readLine().split(" ");
			for(int i = 1; i <= N; i++) 
				a[i] = Integer.valueOf(s[i - 1]);
			
			Tree.build(1, 1, N);
			System.out.println("Case " + t + ":");
			String str;
			while(!(str = br.readLine()).equals("End")) {
				String[] tmp = str.split(" ");
				int a = Integer.valueOf(tmp[1]), b = Integer.valueOf(tmp[2]);
				
				if(tmp[0].equals("Add")) 
					Tree.update(1, a, b, 1);
				else if(tmp[0].equals("Sub")) 
					Tree.update(1, a, b, -1);
				else {
					int ans = Tree.query(1, a, b);
					System.out.println(ans);
				}
			}
		}
	}
}