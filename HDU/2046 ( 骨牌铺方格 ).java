import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
    	long[] a = new long[51];
    	a[0] = a[1] = 1;
    	a[2] = 2;
    	for(int i = 3; i <= 50; i++)
    		a[i] = a[i - 1] + a[i - 2]; 
    	
    	Scanner in = new Scanner(System.in);
    	int n;
    	while(in.hasNext()) {
    		n = in.nextInt();
    		System.out.println(a[n]);
    	}
    }
}