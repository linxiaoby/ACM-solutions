import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n, k, cnt;
	static char[][] ch = new char[9][9];
	static int[] vis = new int[9];
	
	static void dfs(int cur, int lev) {
		if(cur == k) {
			cnt ++;
			return ;
		}
		if(lev == n)	return;
		for(int i = 0; i < n; i++) {
			if(ch[lev][i] == '#' && vis[i] == 0) {
				vis[i] = 1;
				dfs(cur + 1, lev + 1);
				vis[i] = 0;
			}
		}
		dfs(cur, lev + 1);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(true) {
			n = in.nextInt(); k = in.nextInt();
			if(n == -1 && k == -1) break;
			Arrays.fill(vis, 0);
			cnt = 0;
			
			for(int i = 0; i < n; i++) {
				String str = in.next();
				for(int j = 0; j < n; j++) 
					ch[i][j] = str.charAt(j);
			}
			
			dfs(0, 0);
			System.out.println(cnt);
		}
	}
}

===========================================

import java.util.Scanner;

public class Main {
	static final int MAXN = 8 + 3;
	static int n, k, ans;
	static char[][] G = new char[MAXN][MAXN];
	static int[] c = new int[MAXN];
	
	static void dfs(int cur, int lev) {
		if(cur == k) {
			ans++;
			return;
		}
		if(lev == n) return;
		for(int i = 0; i <= n; i++) {
			if(i == n) {
				dfs(cur, lev + 1);
				continue;
			} 
			if(G[lev][i] == '.') continue;
			boolean ok = true;
			for(int j = 0; j < cur; j++) {
				if(c[j] % n == i) {
					ok = false;
					break;
				}
			}
			if(ok) {
				c[cur] = lev * n + i;
				dfs(cur + 1, lev + 1);
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			n = in.nextInt(); k = in.nextInt();
			if(n == -1 && k == -1) break;
			for(int i = 0; i < n; i++) {
				String tmp = in.next();
				G[i] = tmp.toCharArray();
			}
			ans = 0;
			dfs(0, 0);
			System.out.println(ans);
		}
	}
}
