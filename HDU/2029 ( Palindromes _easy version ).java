package Hdu;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n;
		String str;
		boolean flag;
		while(in.hasNextLine()) {
			n = Integer.valueOf(in.nextLine());
			for(int i = 0; i < n; i++) {
				str = in.nextLine();
				flag = true;
				int len = str.length();
				for(int j = 0; j < len/2; j++) {
					if(str.charAt(j) != str.charAt(len - 1 - j)) {
						flag = false;
						break;
					}
				}
				if(flag)
					System.out.println("yes");
				else 
					System.out.println("no");
			}
		}
	}
}