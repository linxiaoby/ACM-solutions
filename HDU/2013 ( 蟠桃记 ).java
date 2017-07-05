import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, ans;
        while(in.hasNext()) {
            n = in.nextInt();
            ans = 1;
            for(int i = 1; i <= n - 1; i++) {
                ans = (ans + 1) * 2;
            }
            System.out.println(ans);
        }
    }
}