dp[i]为以a[i]结尾的连续子序列的最大和。
dp[1] = a[1]
dp[i] = max{dp[i - 1] + a[i], a[i]}
