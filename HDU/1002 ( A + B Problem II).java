import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T;
		BigInteger A, B;
		T = in.nextInt();
		for(int i = 1; i <= T; i++) {
			A = new BigInteger(in.next());
			B = new BigInteger(in.next());
			System.out.println("Case " + i + ":");
			System.out.println(A + " + " + B + " = " + (A.add(B)));
			if(i != T)
				System.out.println();
		}
	}
}
