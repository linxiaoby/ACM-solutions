import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, a, b, c;
        double m;
        while (in.hasNext()) {
            n = in.nextInt();
            a = 0;
            b = 0;
            c = 0;
            for (int i = 0; i < n; i++) {
                m = in.nextDouble();
                if(m < 0) {
                    a++;
                }
                else if (m == 0) {
                    b++;
                }
                else {
                    c++;
                }
            }
            if(n > 0) {
                System.out.println(a + " " + b + " " + c);
            }
        }
    }
}