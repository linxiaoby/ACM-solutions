import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n, s;
		while(in.hasNext()) {
			n = in.nextInt();
			s = (n & 1) == 0 ? n / 2 * (n + 1) : (n + 1) / 2 * n;
			System.out.println(s);
			System.out.println();
		}
	}
}
