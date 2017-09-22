import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int MAXN = 20000 + 3;
	static int[] p = new int[MAXN], d = new int[MAXN];
	
	static int find(int x) {
		if(p[x] != -1) {
			int tmp = find(p[x]);
			d[x] += d[p[x]];
			return p[x] = tmp;
		}
		else return x;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt(), n, u, v;
		char op;
		for(int t = 0; t < T; t++) {
			Arrays.fill(p, -1);
			Arrays.fill(d, 0);
			n = in.nextInt();
			while(true) {
				op = in.next().charAt(0);
				if(op == 'O') break;
				u = in.nextInt();
				if(op == 'I') {
					 v = in.nextInt();
					p[u] = v;		
					d[u] = Math.abs(u - v) % 1000;
				}	
				else {
					find(u);
					System.out.println(d[u]);
				}
			}
		}
	}
}
