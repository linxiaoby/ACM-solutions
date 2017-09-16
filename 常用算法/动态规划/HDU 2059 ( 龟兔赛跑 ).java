import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		final int MAXL = 100 + 5;
		final double INFINITY = 1000000000;
		Scanner in = new Scanner(System.in);
		int N, L; 
		double C, T, VR, VT1, VT2;
		double[] dp = new double[MAXL];
		int[] p = new int[MAXL];
		
		while (in.hasNext()) {
			L = in.nextInt();
			N = in.nextInt(); C = in.nextDouble(); T = in.nextDouble();
			VR = in.nextDouble(); VT1 = in.nextDouble(); VT2 = in.nextDouble();
			
			Arrays.fill(dp, INFINITY);
			double time, dis;
			dp[0] = 0;
			for(int i = 1; i <= N + 1; i++) {
				if(i == N + 1)	
					p[i] = L;
				else 
					p[i] = in.nextInt();
				for(int j = 0; j < i; j++) {
					dis = p[i] - p[j];
					if(dis <= C) 
						time = dis / VT1;
					else 
						time = C / VT1 + (dis - C) / VT2;
					if(j != 0) 
						time += T;
					dp[i] = Math.min(dp[i], dp[j] + time);
				}
			}
			
			System.out.println((dp[N + 1] > (L / VR)) ?  "Good job,rabbit!" : "What a pity rabbit!");
		}
	}
}