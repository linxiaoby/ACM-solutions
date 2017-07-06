import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M;
        int[] s = new int[5];
        String str;
        M = Integer.valueOf(in.nextLine());
        
        for (int i = 0; i < M; i++) {
			str = in.nextLine();
			if(!(str.length() >= 8 && str.length() <= 16)) {
				System.out.println("NO");
				continue;
			}
			
			Arrays.fill(s, 0);
			for(int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);
				if(ch >= 'A' && ch <= 'Z')
					s[1] = 1;
				else if(ch >= 'a' && ch <= 'z')
					s[2] = 1;
				else if(ch >= '0' && ch <= '9')
					s[3] = 1;
				else 
					s[4] = 1;
			}
			int cnt = s[1] + s[2] + s[3] + s[4];
			System.out.println((cnt >= 3) ? "YES" : "NO");
		}
    }
}