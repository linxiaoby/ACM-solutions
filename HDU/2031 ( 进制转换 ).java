import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N, R;
        while(in.hasNext()) {
        	N = in.nextInt();
        	R = in.nextInt();
        	System.out.println(Integer.toString(N, R).toUpperCase());
        }
    }
}