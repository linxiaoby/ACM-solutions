/**
 * (1)0:和根节点同类; 1:吃根节点; 2:被根节点吃
 * (2)d[i]:节点i指向根节点的关系，若有关系 r x y，rootx = a，rooty = b,
 *		则合并时应当让p[a] = b。若d[i]表示根节点指向节点i的关系，那么p[b] = a
 * (2)scanner会TLE
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static final int MAXN = 50000 + 3;
	static int[] p = new int[MAXN], d = new int[MAXN];
	
	static int find(int x) {
		if(p[x] == -1) return x;
		int tmp = find(p[x]);
		d[x] = (d[x] + d[p[x]]) % 3;
		return p[x] = tmp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.valueOf(tmp[0]), k = Integer.valueOf(tmp[1]), r, x, y;
		Arrays.fill(p, -1);
		Arrays.fill(d, 0);
		
		int ans = 0;
		for(int i = 0; i < k; i++) {
			tmp = br.readLine().split(" ");
			r = Integer.valueOf(tmp[0]); x = Integer.valueOf(tmp[1]); y = Integer.valueOf(tmp[2]);
			if(x > n || y > n || (r == 2 && x == y)) {
				ans ++ ;
				continue;
			}
			int a = find(x), b = find(y);
			if((a == b) && d[x] != (d[y] + r - 1) % 3) 
					ans++;
			else if(a != b){	
				p[a] = b;
				d[a] = (3 - d[x] + r - 1 + d[y]) % 3;
			}
		}
		System.out.println(ans);
	}
}