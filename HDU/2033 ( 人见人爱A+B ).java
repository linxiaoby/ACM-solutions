import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N;
        int[] A = new int[3];
        int[] B = new int[3];
        int[] ans = new int[3];
        
        N = in.nextInt();
        for(int t = 0; t < N; t++) {
        	 for(int i = 0; i < 3; i++)
             	A[i] = in.nextInt();
             for(int i = 0; i < 3; i++)
             	B[i] = in.nextInt();
             
             int f = 0, tmp;
             for(int i = 2; i >= 1; i--) {
             	tmp = A[i] + B[i] + f;
             	ans[i] = tmp % 60;
             	f = (tmp >= 60) ? 1 : 0; 
             }
             ans[0] = A[0] + B[0] + f;
             
             System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
        }
    }
}