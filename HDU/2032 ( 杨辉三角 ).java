import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] a = new int[30 + 3][30 + 3];
        for(int i = 1; i <= 30; i++) {
        	a[i][1] = a[i][i] = 1;
        	for(int j = 2; j <= i - 1; j++)
        		a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
        } 
        
        
        int n;
        while(in.hasNext()) {
        	n = in.nextInt();
        	for(int i = 1; i <= n; i++) {
        		for(int j = 1; j <= i - 1; j++) {
        			System.out.print(a[i][j] + " ");
        		}
        		System.out.println(a[i][i]);
        	}
        	System.out.println();
        }
    }
}