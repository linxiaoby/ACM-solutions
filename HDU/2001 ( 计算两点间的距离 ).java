import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x1, y1, x2, y2, dis;
        DecimalFormat df = new DecimalFormat("###.00");
        while(in.hasNext()) {
            x1 = in.nextDouble();
            y1 = in.nextDouble();
            x2 = in.nextDouble();
            y2 = in.nextDouble();
            dis = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
            System.out.println(df.format(dis));
        }
    }
}