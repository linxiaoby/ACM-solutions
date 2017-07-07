import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        double s;
        List<Point> list = new ArrayList<Point>();
        while(true) {
            list.clear();
            n = in.nextInt();
            if(n == 0)
                break;
            
            s = 0;
            for(int i = 0; i < n; i++) {
                Point p = new Point(in.nextInt(), in.nextInt());
                list.add(p);
            }
            list.add(list.get(0));
            for(int i = 0; i < list.size() - 1; i++) 
                s += list.get(i).x / 2.0 * list.get(i + 1).y - list.get(i + 1).x / 2.0 * list.get(i).y;
            
            System.out.printf("%.1f", Math.abs(s));
            System.out.println();
        }
    }
}
