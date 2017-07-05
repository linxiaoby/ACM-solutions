import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, a;
        int ans;
        while (in.hasNext()) {
            ans = 1;
            n = in.nextInt();
            for(int i = 0; i < n; i++) {
                a = in.nextInt();
                if(a%2 != 0){
                    ans = ans * a;
                }
            }
            System.out.println(ans);
        }
    }
}