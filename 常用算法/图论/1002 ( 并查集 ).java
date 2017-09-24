【基本并查集】
static int find(int x) {
		return p[x] == x ? x : (p[x] = find(p[x]));
	}

static void union(int x, int y) {
	int a = find(x), b = find(y);
	if(a != b)
		p[a] = b;
}
=======================================
【基本并查集例题：HDU1213】
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
		while(T-- > 0){
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
===============================================
【带权并查集例题：POJ 1182 ( 食物链 )】
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

