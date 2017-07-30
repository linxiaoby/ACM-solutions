static int find(int x) {
		return p[x] == x ? x : (p[x] = find(p[x]));
	}

static void union(int x, int y) {
	int a = find(x), b = find(y);
	if(a != b)
		p[a] = b;
}

【HDU1213】
import java.util.Scanner;

public class Main {
	static final int MAXN = 1000 + 7;
	static int[] p = new int[MAXN];
	
	static int find(int x) {
		return p[x] == x ? x : (p[x] = find(p[x]));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int N, M;
		while(T-- >= 0){
			N = in.nextInt(); M = in.nextInt();
			for(int i = 1; i <= N; i++)
				p[i] = i;
			
			int ans = N;
			for(int i = 0; i < M; i++) {
				int a = find(in.nextInt()), b = find(in.nextInt());
				if(a != b) {
					p[a] = b;
					ans--;
				}
			}
			System.out.println(ans);
		}
	}
}
