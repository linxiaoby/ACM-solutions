/**
*教练，这道题不是我自己想出来的。(我想了一个下午就弃疗了。。)
*/
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N, M;
		while (in.hasNext()) {
			N = in.nextInt();
			M = in.nextInt();
			if (N == 0 && M == 0)
				break;
			
			for(int i = ((int)Math.sqrt(2 * M)); i >= 1; i--) {
				int a = (M - (i * (i - 1) / 2))/i;
				if((i * a + (i * (i - 1) / 2)) == M)
					System.out.println("[" + a + "," + (a + i - 1) + "]");
			}
			System.out.println();
		}
	}
}
