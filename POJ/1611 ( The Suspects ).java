import java.util.Scanner;

public class Main {
	static final int MAXN = 30000 + 3;
	static int[] p = new int[MAXN];
	
	static int find(int x) {
		return p[x] == x ? x : (p[x] = find(p[x]));
	}
	
	static void union(int x, int y) {
		int a = find(x), b = find(y);
		if(a != b)
			p[a] = b;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n, m;
		while(true) {
			n = in.nextInt(); m = in.nextInt();
			if(n == 0 && m == 0) break;
			for(int i = 0; i < n; i++)
				p[i] = i;
			
			int k, x, y;
			for(int i = 0; i < m; i++) {
				k = in.nextInt(); x = in.nextInt();
				for(int j = 1; j < k; j++) {
					y = in.nextInt();
					union(x, y);
					x = y;
				}
			}
			
			int ans = 1, a = find(0);
			for(int i = 1; i < n; i++)
				if(find(i) == a) ans++;
			System.out.println(ans);
		}
	}
}