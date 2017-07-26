
import java.util.Scanner;

public class Main {
	static final int MAXN = 100 + 3;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(), C;
		
		String s1, s2, s12;
		for(int k = 1; k <= N; k++) {
			C = in.nextInt();
			s1 = in.next(); s2 = in.next(); s12 = in.next();
			String t1 = s1, t2 = s2, t12;
			int cnt = 0;
			boolean find = false;
			
			while(true) {
				t12 = "";
				for(int i = 0; i < C; i++) 
					t12 = t12 + t2.charAt(i) + t1.charAt(i);
				cnt++;
				if(t12.equals(s12)) {
					System.out.println(k + " " + cnt);
					find = true;
					break;
				}
				t1 = t12.substring(0, C);
				t2 = t12.substring(C, 2 * C);
				if(t1.equals(s1) && t2.equals(s2)) 
					break;
			}
			if(!find) System.out.println(k + " " + -1);
		}
	}
}