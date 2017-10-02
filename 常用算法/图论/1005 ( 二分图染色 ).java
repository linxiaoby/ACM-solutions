
============================
【hdu 3478】
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static final int MAXN = 100000 + 7;
	static List<Integer>[] E = new ArrayList[MAXN];
	static int[] col = new int[MAXN];

	static boolean dfs(int u, int c) {
		col[u] = c;
		for(int i = 0; i < E[u].size(); i++) {
			int v = E[u].get(i);
			if(col[v] == -1 && !dfs(v, 1 - c))
				return false;
			else if(col[v] == col[u])
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine()), N, M, S;
				
		for(int t = 1; t <= T; t++) {
			String[] tmp = br.readLine().split(" "); 
			N = Integer.valueOf(tmp[0]); M = Integer.valueOf(tmp[1]); S = Integer.valueOf(tmp[2]);
			
			for(int i = 0; i < MAXN; i++)
				E[i] = new ArrayList<Integer>();
			Arrays.fill(col, -1);
			for(int i = 0; i < M; i++) {
				tmp = br.readLine().split(" ");
				int u = Integer.valueOf(tmp[0]), v = Integer.valueOf(tmp[1]);
				E[u].add(v);
				E[v].add(u);
			}
			
			boolean ok = true;
			for(int i = 0; i < N; i++) {//防止有不连通的情况
				if(col[i] == -1 && !dfs(i, 0)) {
					ok = false;
					break;
				}
			}
			String ans = "Case " + t + ": ";
			ans += ok ?  "NO" : "YES"; 
			System.out.println(ans);
		}
	}
}