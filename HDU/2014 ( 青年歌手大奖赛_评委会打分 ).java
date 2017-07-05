import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("##0.00");
        double[] a = new double[100 + 5];
        int n;
        double sum, max, min;
        while(in.hasNext()) {
            n = in.nextInt();
            sum = 0;
            max = -1;
            min = 110;
            for(int i = 0; i < n; i++) {
                a[i] = in.nextDouble();
                if(a[i] > max) max = a[i];
                if(a[i] < min) min = a[i];
            }
            for(int i = 0; i < n; i++) {
                sum += a[i];
            }
            sum = sum - max - min;
            System.out.println(df.format((sum/(n - 2))));
        }
    }
}