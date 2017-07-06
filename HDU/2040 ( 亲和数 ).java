import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M, A, B;
        M = in.nextInt();
        for(int i = 0; i < M; i++) {
        	A = in.nextInt();
        	B = in.nextInt();
        	double sqa = Math.sqrt(A);
        	double sqb = Math.sqrt(B);
        	int sa = 0, sb = 0;
        	
        	for(int j = 1; j <= sqa; j++) {
        		if(A % j == 0) {
        			sa = sa + j + A/j;
        			if(j == 1 || j == A/j)
            			sa -= A/j;
        		}
        		if(sa > B)
        			break;
        	}
        	if(sa != B) {
        		System.out.println("NO");
        		continue;
        	}
        	
        	for(int j = 1; j <= sqb; j++) {
        		if(B % j == 0) {
        			sb = sb + j + B/j;
        			if(j == 1 || j == B/j)
            			sb -= B/j;
        		}
        		if(sb > A)
        			break;
        	}
        	System.out.println((sb == A) ? "YES" : "NO");
        }
    }
}