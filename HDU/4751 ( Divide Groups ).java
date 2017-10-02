【dfs】
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final int MAXN = 100 + 3;
	static int[][] G = new int[MAXN][MAXN];
	static List<Integer>[] E = new ArrayList[MAXN];
	static int[] col = new int[MAXN];
	
	public static boolean dfs(int u, int c) {
		col[u] = c;
		for(int j = 0; j < E[u].size(); j++) {
			int v = E[u].get(j);
			if(col[v] == -1) {
				if(!dfs(v, 1 - c)) 
					return false;
			}
			else if(col[v] == col[u])
				return false;
		}
		return true; 
	}
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n;
		while(in.hasNext()) {
			n = in.nextInt();
			for(int i = 0; i <= n; i++) {
				Arrays.fill(G[i], 0);
				E[i] = new ArrayList<Integer>();
			}
				
			int k;
			for(int i = 1; i <= n; i++) 
				while((k = in.nextInt()) != 0) 
					G[i][k] = 1;
			
			for(int i = 1; i <= n - 1; i++) 
				for(int j = i + 1; j <= n; j++) {
					if(G[i][j] == 0 || G[j][i] == 0) {
						//建立边
						E[i].add(j); 
						E[j].add(i);
					}
				}
			
			Arrays.fill(col, -1);
			boolean ok = true;
			for(int i = 1; i <= n; i++) 
				if(col[i] == -1 && !dfs(i, 0)) {
					ok = false;
					break;
				} 
			System.out.println(ok ? "YES" : "NO");
		}
	}
}

===================

【bfs】
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final int MAXN = 100 + 3;
	static int[][] G = new int[MAXN][MAXN];
	static List<Integer>[] E = new ArrayList[MAXN];
	static int[] col = new int[MAXN];
	
	static public boolean bfs(int s) {
		boolean ok = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s); col[s] = 0;
		
		while(!q.isEmpty() && ok) {
			int u = q.poll();
			for(int i = 0; i < E[u].size(); i++) {
				int v = E[u].get(i);
				if(col[v] == -1) {
					col[v] = 1 - col[u];
					q.add(v);
				}
				else if(col[v] == col[u]) {
					ok = false;
					break;
				}
			}
		}
		return ok;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n;
		while(in.hasNext()) {
			n = in.nextInt();
			for(int i = 0; i <= n; i++) {
				Arrays.fill(G[i], 0);
				E[i] = new ArrayList<Integer>();
			}
				
			int k;
			for(int i = 1; i <= n; i++) 
				while((k = in.nextInt()) != 0) 
					G[i][k] = 1;
			
			for(int i = 1; i <= n - 1; i++) 
				for(int j = i + 1; j <= n; j++) {
					if(G[i][j] == 0 || G[j][i] == 0) {
						//建立边
						E[i].add(j); 
						E[j].add(i);
					}
				}
			
			Arrays.fill(col, -1);
			boolean ok = true;
			for(int i = 1; i <= n; i++) 
				if(col[i] == -1 && !bfs(i)) 
					ok = false;
			System.out.println(ok ? "YES" : "NO");
		}
	}
}


==============================
【dfs】
