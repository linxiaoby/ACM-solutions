import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n; 
		long x, y;
		while ((n = in.nextInt()) != 0) {
			x = 1;
			while (true) {
				y = Long.parseLong(Long.toBinaryString(x));
				if (y % n == 0)
					break;
				x++;
			}
			System.out.println(Long.toBinaryString(x));
		}
	}
}

====================================
【DFS】
import java.util.Scanner;

public class Main {
	static int n, ok;
	
	static void dfs(long x, int lev) {
		if(ok == 1 || lev > 18) return;
		if(x % n == 0) {
			System.out.println(x);
			ok = 1;
			return ;
		}
		dfs(x * 10, lev + 1); 
		dfs(x * 10 + 1, lev + 1);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while((n = in.nextInt()) != 0) {
			ok = 0;
			dfs(1, 0);
		}
	}
}