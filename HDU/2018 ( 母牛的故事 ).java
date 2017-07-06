
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] ans = new int[55 + 3];
        ans[1] = 1; ans[2] = 2; ans[3] = 3;
        for(int i = 4; i <= 55; i++)
            ans[i] = ans[i - 1] + ans[i -3]; 
        
        int n;
        while (true) {
            n = in.nextInt();
            if(n == 0)
                break;
            System.out.println(ans[n]);
        }
    }
}