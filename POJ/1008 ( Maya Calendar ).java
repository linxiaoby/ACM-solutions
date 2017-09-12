package test;

import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		String[] strh = new String[]{"pop", "no", "zip", "zotz", "tzec", "xul", "yoxkin", 
									"mol", "chen", "yax", "zac", 
									"ceh", "mac", "kankin", "muan", "pax", "koyab", "cumhu", "uayet"};
		String[] strt = new String[]{"imix", "ik", "akbal", "kan", "chicchan", "cimi", "manik", "lamat", "muluk", "ok", 
									"chuen", "eb", "ben", "ix", "mem", "cib", "caban", "eznab", "canac", "ahau"};
		System.out.println(1995 * 365 + 10 * 20 + 11);
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(n);
		
		for(int t = 0; t < n; t++){
			String a = in.next();
			int index = 0;
			for (int i = 0; i < a.length(); i++) {
				if(a.charAt(i) == '.') {
					index = i; 
					break;
				}
			}
			int d1 = Integer.valueOf(a.substring(0, index));
			
			String tmp = in.next();
			int y1 = in.nextInt();
			int m1 = 0;
			for(int i = 0; i < strh.length; i++) {
				if(strh[i].equals(tmp)) {
					m1 = i;
					break;
				}
			}
			System.out.println("m1 " + m1);
			int s = d1 + 1 + m1 * 20 + y1 * 365;
//			s = tmp.equals("uayet") ?  (s + (m1 - 1) * 20 + 5) : (s + m1 * 20) ;  
			System.out.println("天数:" + s);
			int y2 = s / 260;
			int m2 = s % 20;
			int d2 = s % 13;
			System.out.println(d2 + " " + strt[m2 - 1] + " " + y2);
		} 
	}
}
