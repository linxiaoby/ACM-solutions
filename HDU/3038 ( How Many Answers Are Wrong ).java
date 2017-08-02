import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int MAXN = 200000 + 3;
	static int[] p = new int[MAXN], s = new int[MAXN];
	
	static int find(int x) {
		if(p[x] == -1) return x;
		int k = p[x];
		p[x] = find(p[x]);
		s[x] += s[k];
		return p[x];
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N, M;
		while(in.hasNext()) {
			N = in.nextInt(); M = in.nextInt();
			Arrays.fill(p, 0, N + 1, -1); 
			Arrays.fill(s, 0, N + 1, 0);
			
			int a, b, v, ans = 0;
			while(M-- > 0) {
				a = in.nextInt(); b = in.nextInt(); v = in.nextInt();
				a--;
				int x = find(a), y = find(b);
				if(x != y) {   
					p[y] = x;
					s[y] = s[a] - s[b] + v;
				}
				else if(s[b] != s[a] + v) 
					ans++;
			}
			System.out.println(ans);
		}
	}
}