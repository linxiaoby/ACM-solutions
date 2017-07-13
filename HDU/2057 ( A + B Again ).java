import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str, res;
        Long ans;
        while(in.hasNext()) {
            ans = 0L;
            for(int i = 1; i <= 2; i++) {
                str = in.next();
                if(str.startsWith("+"))
                    str = str.substring(1, str.length());
                ans += Long.valueOf(str, 16);
            }
            res = Long.toHexString(Math.abs(ans)).toUpperCase();
            System.out.println((ans >= 0) ? res : ("-" + res));
        }
    }
}