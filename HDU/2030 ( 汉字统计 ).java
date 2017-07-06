import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, cnt, len;
        String str;
        
        n = Integer.valueOf(in.nextLine());
        for(int i = 0; i < n; i++) {
        	str = in.nextLine();
        	cnt = 0;
        	len = str.length();
        	for(int j = 0; j < len; j++) {
        		if(str.charAt(j) > 127 )
        			cnt++;
        	}
        	System.out.println(cnt);
        }
    }
}