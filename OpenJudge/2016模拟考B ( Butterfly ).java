package Hdu;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int MAXN = 1000 + 3;
	static int[] p = new int[MAXN];
	
	static int find(int x) {
		return p[x] == x ? x : (p[x] = find(p[x]));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n, m;
		while(true) {
			n = in.nextInt(); m = in.nextInt();
			for(int i = 0; i < n; i++) 
				p[i] = i;
			int x, y, r, a, b;
			boolean ok = true;
			for(int i = 0; i < m; i++) {
				x = in.nextInt(); 
				y = in.nextInt();
				r = in.nextInt();
				a = find(x);
				b = find(y);
				if((r == 1 && a == b) || (r == 0 && a != b ) ) {
					ok = false; break;
				}
				else if(r == 0 && )
			}
		}
	}
}


