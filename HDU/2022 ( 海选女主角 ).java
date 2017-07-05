import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m, n, x = 0, y = 0, s = 0, tmp;
        while(in.hasNext()) {
            m = in.nextInt();
            n = in.nextInt();
            s = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    tmp = in.nextInt();
                    if(Math.abs(tmp) > Math.abs(s)) {
                        x = i;
                        y = j;
                        s = tmp;
                    } 
                }
            }
            System.out.println((x + 1) + " " + (y + 1) + " " + s);
        }
    }
}