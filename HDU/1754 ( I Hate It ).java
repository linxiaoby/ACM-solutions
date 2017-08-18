import java.util.Scanner;

public class Main {
	static final int MAXN = 200000 + 5;
	static int[] no = new int[MAXN << 2];
	static Scanner in = new Scanner(System.in);
	
	static void pushUp(int rt) {
		no[rt] = Math.max(no[rt << 1], no[rt << 1 | 1]);
	}

	static void build(int rt, int l, int r) {
		if (l == r) {
			no[rt] = in.nextInt();
			return;
		}
		int m = (l + r) >> 1;
		build(rt << 1, l, m);
		build(rt << 1 | 1, m + 1, r);
		pushUp(rt);
	}

	static void update(int rt, int a, int b, int l, int r) {
		if (l == r) {
			no[rt] = b;
			return;
		}
		int m = (l + r) >> 1;
		if (a <= m)
			update(rt << 1, a, b, l, m);
		else
			update(rt << 1 | 1, a, b, m + 1, r);
		pushUp(rt);
	}

	static int query(int rt, int a, int b, int l, int r) {
		if (a <= l && r <= b) {
			return no[rt];
		}

		int m = (l + r) >> 1;
		int ans = Integer.MIN_VALUE;
		if (a <= m)
			ans = Math.max(ans, query(rt << 1, a, b, l, m));
		if (m < b)
			ans = Math.max(ans, query(rt << 1 | 1, a, b, m + 1, r));
		return ans;
	}
	
	public static void main(String[] args)  {
		
		int N, M;
		while(in.hasNext()) {
			N = in.nextInt(); M = in.nextInt();
			
			build(1, 1, N);
			while(M-- > 0) {
				char op = in.next().charAt(0);
				int a = in.nextInt(), b = in.nextInt();
				if(op == 'U')
					update(1, a, b, 1, N);
				else {
					System.out.println(query(1, a, b, 1, N));
				}
			}
		}
	}
}
