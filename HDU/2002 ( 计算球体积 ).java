import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final double PI = 3.1415927;
        Scanner in = new Scanner(System.in);
        double r, s;
        DecimalFormat df = new DecimalFormat("###.000"); 
        while (in.hasNext()) {
            r = in.nextDouble();
            s = (4.0*PI*Math.pow(r, 3.0))/3.0;
            System.out.println(df.format(s));
        }
    }
}