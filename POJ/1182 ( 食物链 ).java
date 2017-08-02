/**
 * (1)0:和根节点同类; 1:被根节点吃; 2:吃根节点
 * 		在合并时节点权值的更新方式要和权值定义保持一致。
 * (2)scanner会TLE
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static final int MAXN = 50000 + 3;
	static int[] p = new int[MAXN], r = new int[MAXN];
	
	static int find(int x) {
		if (p[x] == -1) return x;
		int k = p[x];
		p[x] = find(p[x]);
		r[x] = (r[x] + r[k]) % 3;
		return p[x];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.valueOf(str[0]), K = Integer.valueOf(str[1]);
		
		Arrays.fill(p, -1);
		int d, x, y, ans = 0;
		while(K-- > 0) {
			str = br.readLine().split(" ");
			d = Integer.valueOf(str[0]); 
			x = Integer.valueOf(str[1]); y = Integer.valueOf(str[2]);
			
			if(x > N || y > N || (d == 2 && x == y)) {
				ans++; 
				continue;
			}
			int a = find(x), b = find(y);
			if(a != b) {
				p[b] = a; 
				r[a] = (3 - r[x] + r[y] + d - 1) % 3;
			}
			else if((d == 1 && r[x] != r[y]) || (d == 2 && r[x] != (r[y] + 1) % 3))
				ans++; 	 	
		}
		System.out.println(ans);
	}
}
