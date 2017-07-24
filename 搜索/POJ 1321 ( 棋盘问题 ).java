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
		for(int i = 0; i <= n; i++) {
			if(i == n) {
				dfs(cur, lev + 1);
				continue;
			}
			if(ch[lev][i] != '#') continue;
			if(vis[i] == 0) {
				vis[i] = 1;
				dfs(cur + 1, lev + 1);
				vis[i] = 0;
			}
		}
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