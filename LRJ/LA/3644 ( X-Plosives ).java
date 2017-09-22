import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int MAXN = 100000 + 3;
	static int[] p = new int[MAXN];
	
	static int find(int x) {
		return p[x] == -1 ? x : (p[x] = find(p[x]));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a, b;
		while(in.hasNext()) {
			int ans = 0;
			Arrays.fill(p, -1);
			while((a = in.nextInt()) != -1) {
				b = in.nextInt();
				int x = find(a), y = find(b);
				if(x == y) ans++;
				else p[a] = b;
			}
			System.out.println(ans);
		}
	}
}


