

=============================
【hdu 1269 检测强连通图】
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static final int MAXN = 10000 + 7;
	static List<Integer>[] E = new ArrayList[MAXN];
	static List<Integer>[] RE = new ArrayList[MAXN];
	static boolean[] vis = new boolean[MAXN];
	static int cnt;
	static boolean flag;
	
	static void dfs(int u) {
		cnt++;
		vis[u] = true;
		int len = flag? E[u].size() : RE[u].size();
		for(int i = 0; i < len; i++) {
			int v = flag? E[u].get(i) : RE[u].get(i) ;
			if(!vis[v]) dfs(v);
		}
	}
	
	static void init() {
		Arrays.fill(vis, false);
		cnt = 0;
	}
	
	static boolean judge(int n) {
		init();
		flag = true;
		dfs(1);
		if(cnt != n) return false;
		
		init();
		flag = !flag;
		dfs(1);
		if(cnt != n) return false;
		return true;
	}
	
	public static void main(String[] args)  {
		Scanner in = new Scanner(System.in);
		int N, M;
		while(true) {
			N = in.nextInt(); M = in.nextInt();
			if(N == 0 && M == 0) break;
			for(int i = 0; i < N + 3; i++) {
				E[i] = new ArrayList<Integer>();
				RE[i] = new ArrayList<Integer>();
			}
			
			for(int i = 0; i < M; i++) {
				int u = in.nextInt(), v = in.nextInt();
				E[u].add(v);
				RE[v].add(u);
			}
			
			System.out.println(judge(N) ? "Yes" : "No");
		}
	}
}