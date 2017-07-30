import java.util.Scanner;

public class Main {
	static final int MAXN = 1001 + 7;
	static int[] p = new int[MAXN], cx = new int[MAXN], cy = new int[MAXN], s = new int[MAXN];
	
	static int find(int x) {
		return p[x] == x ? x : (p[x] = find(p[x]));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(), d = in.nextInt();
		for(int i = 1; i <= N; i++) {
			cx[i] = in.nextInt(); cy[i] = in.nextInt();
			p[i] = i;
			s[i] = 0;
		}
		
		int tmp = d * d;
		while(in.hasNext()) {
			char op = in.next().charAt(0);
			if(op == 'O') {
				int k = in.nextInt();
				s[k] = 1;
				for(int i = 1; i <= N; i++) {
					if(i == k) continue;
					if(s[i] == 1 && 
							tmp >= (cx[i] - cx[k]) * (cx[i] - cx[k]) + (cy[i] - cy[k]) * (cy[i] - cy[k])) {
						int a = find(k), b = find(i);
						if(a != b)
							p[a] = b;
					}
				}
			}
			else {
				int a = find(in.nextInt()), b = find(in.nextInt());
				System.out.println(a == b ? "SUCCESS" : "FAIL");
			}
		}
		
	}
}