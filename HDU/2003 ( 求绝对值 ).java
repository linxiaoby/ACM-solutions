import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("###.00"); 
        double n;
        while (in.hasNext()) {
            n = in.nextDouble();
            System.out.println(df.format(Math.abs(n)));
        }
    }
}