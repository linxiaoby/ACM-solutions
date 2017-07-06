import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M;
        double s;
        
        M = in.nextInt();
        for(int i = 0; i < M; i++) {
        	s = 0;
        	double max = -1, x;
        	for(int j = 0; j < 3; j++) {
        		x = in.nextDouble();
        		s += x;
        		max = Math.max(max, x);
        	}
        	s -= max;
        	System.out.println(s > max ? "YES" : "NO");
        }
    }
}