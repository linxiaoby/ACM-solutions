【BNUOJ 5457】
O(n^2)

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int MAXN = 100000;
	static int[] dp = new int[MAXN], a = new int[MAXN];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int N = in.nextInt();
			Arrays.fill(dp, 0);
			for(int i = 1; i <= N; i++) 
				a[i] = in.nextInt();
			
			int m = Integer.MIN_VALUE;
			for(int i = 1; i <= N; i++) {
				for(int j = 0; j < i;j++) {
					if(a[j] < a[i])
						dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
				m = Math.max(m, dp[i]);
			}
			System.out.println(m);
		}
	}
}

+++++++++++++++++++++++
O(nlogn)

import java.util.Scanner;

public class Main {
	static final int MAXN = 100000;
	static int[] LIS = new int[MAXN];//LIS[i] = j,长度为i子序列的末位最小是j
	static int k;//当前找到的最长子序列的长度
	
	/**
	 * 在LIS中查找第一个末位比x大的序列LIS[i]，将x接在长度为i - 1的序列后面，LIS[i]的末位变为x
	 * @param x
	 */
	static void BS(int x) {
		if(LIS[k] < x) {
			LIS[++k] = x;
			return;
		}
		int l = 1, r = k;
		while(l < r) {
			int m = (l + r) >> 1;
			if(LIS[m] > x) r = m;
			else l = m + 1;
		}
		LIS[l] = x;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int N = in.nextInt();
			LIS[0] = k = 0;
			for(int i = 1; i <= N; i++) 
				BS(in.nextInt());
			System.out.println(k);
		}
	}
}