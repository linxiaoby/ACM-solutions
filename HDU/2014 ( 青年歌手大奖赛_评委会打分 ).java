
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        double x,sum, max, min;
        while(in.hasNext()) {
            n = in.nextInt();
            sum = 0;
            max = -1;
            min = 110;
            for(int i = 0; i < n; i++) {
                x = in.nextDouble();
                if(x > max) max = x;
                if(x < min) min = x;
                sum += x;
            }
            sum = sum - max - min;
            System.out.printf("%.2f",sum/(n - 2));
            System.out.println();
        }
    }
}