/*
教练， 我不会这道题，这不是我写的代码。
*/
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int A, B, n;
		int[] f = new int[50 + 3];
		while(true) {
			A = in.nextInt(); B = in.nextInt(); n = in.nextInt();
			if(A == 0 && B == 0 && n == 0) break;
			
			f[1] = f[2] = 1;
			boolean flag = false;
			int a = 0, b = 0;
			for(int i = 3; i <= n && !flag; i++) {
				f[i] = (A * f[i - 1] + B * f[i - 2]) % 7;
				for(int j = 2; j <= i - 1; j++) {
					if(f[i] == f[j] && f[i - 1] == f[j - 1]) {
						a = i;
						b = j;
						flag = true;
						break;
					}
				}
			}
			System.out.println(flag ? f[b + (n - a) % (a - b)] : f[n]);
		}
	}
}