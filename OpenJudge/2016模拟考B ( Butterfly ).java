/**
 * 同在一棵树的节点是关系已经确定的节点
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int MAXN = 1000 + 3, MAXM = 100000 + 3;
	static int[] p = new int[MAXN], d = new int[MAXN];
	
	static int find(int x) {
		if(p[x] == -1) 
			return x;
		int tmp = find(p[x]);
		d[x] = (d[x] + d[p[x]]) % 2;
		return p[x] = tmp;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n, m;
		while(in.hasNext()) {
			n = in.nextInt(); m = in.nextInt();
			Arrays.fill(p, 0, n + 7, -1); 
			Arrays.fill(d, 0, n + 7, 0);
			boolean ok = true;
			for(int i = 0; i < m; i++) {
				int a = in.nextInt(), b = in.nextInt(), r = in.nextInt();
				int x = find(a), y = find(b);
				if(x == y) {//如果a和b此前已经确定关系
					if((r == 0 && d[a] != d[b]) || (r == 1 && d[a] == d[b])) {
						ok = false;
						break;
					}
				}
				else {//a和b此前没有确定关系，则将a和b所在的子树合并
					p[x] = y;
					d[x] = ((2 - d[a]) + r + d[b]) % 2;
				}
			}
			System.out.println(ok ? "YES" : "NO");
		}
	}
}
