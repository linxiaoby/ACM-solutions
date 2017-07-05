import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, ans;
        String str;
        n = in.nextInt();
        while(in.hasNext()) {
            for(int i = 0; i < n; i++) {
                str = in.next();
                ans = 0;
                for(int j = 0; j < str.length(); j++) {
                    if(str.charAt(j) >= '0' && str.charAt(j) <= '9') {
                        ans++;
                    }
                }
                System.out.println(ans);
            }
        }
    }
}