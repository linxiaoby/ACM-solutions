import java.util.Scanner;

public class Main {
	static String fun(int n) {
		String str = "";
		String tmp = Integer.toBinaryString(n);
		int len = tmp.length();
		for(int i = 0; i < len; i++) {
			int x = len - i - 1;
			if(i != 0 && tmp.charAt(i) != '0') str += "+";
			if(tmp.charAt(i) == '1' && x > 2) 
				str += "2(" + fun(x) + ")";
			else if(tmp.charAt(i) == '1' && x == 1) 
				str += "2";
			else if(tmp.charAt(i) == '1')
				str += "2(" + x + ")";
		}
		return str;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(fun(n));
	}
}

