
for(int i = 1; i <= N; i++) {
			for(int j = 0; j <= C; j++)
				if(j >= c[i] )
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c[i]] + w[i]);
				else 
					dp[i][j] = dp[i - 1][j];
		}
	System.out.println(dp[N][C]);


for(int i = 1; i <= N; i++) {
			for(int j = C; j >= 0; j--) {
				if(j >= c[i]) dp[j] = Math.max(dp[j], dp[j - c[i]] + w[i]);
			}
		}
		
		System.out.println(dp[C]);