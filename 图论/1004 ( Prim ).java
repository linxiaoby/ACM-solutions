static final int MAXN = 2000 + 7;
	static int[][] cost = new int[MAXN][MAXN];
	static int[] vis = new int[MAXN], lowc = new int[MAXN];
	
	static int prim(int n) {
		Arrays.fill(vis, 0);
		vis[0] = 1;
		for(int i = 0; i < n; i++) lowc[i] = cost[0][i];
		
		int ans = 0; 
		for(int i = 1; i < n; i++) {
			int p = -1, minc = Integer.MAX_VALUE;
			for(int j = 0; j < n; j++) 
				if(vis[j] != 1 && lowc[j] < minc) {
					minc = lowc[j];
					p = j;
				}
			if(p == -1) return -1;
			
			ans += minc;
			vis[p] = 1;
			for(int j = 0; j < n; j++) 
				if(vis[j] != 1 && cost[p][j] < lowc[j])
					lowc[j] = cost[p][j];
		}
		return ans;
	}
	