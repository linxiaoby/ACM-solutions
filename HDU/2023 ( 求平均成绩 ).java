import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, m, s;
        double s1, s2;
        double[][] a = new double[50 + 3][5 + 2];
        double[] avr1 = new double[50 + 3];
        double[] avr2 = new double[5 + 2];
        while(in.hasNext()) {
            n = in.nextInt();
            m = in.nextInt();
            s = 0;
            for(int i = 0; i < n; i++) {
                s1 = 0;
                for(int j = 0; j < m; j++) {
                    a[i][j] = in.nextDouble();
                    s1 += a[i][j];
                }
                avr1[i] = s1/m;
            }
            for(int j = 0; j < m; j++) {
                s2 = 0;
                for(int i = 0; i < n; i++) {
                    s2 += a[i][j];
                }
                avr2[j] = s2/n; 
            }
            
            for(int i = 0; i < n; i++) {
                boolean flag = true;
                for(int j = 0; j < m; j++) {
                    if(a[i][j] < avr2[j]){
                        flag = false;
                        break;
                    }
                }
                if(flag)
                    s++;
            }
            
            for(int i = 0; i < n; i++){
                if(i != 0)
                    System.out.print(" ");
                System.out.printf("%.2f", avr1[i]);
            }
            System.out.println();
            for(int i = 0; i < m; i++) {
                if(i != 0)
                    System.out.print(" ");
                System.out.printf("%.2f", avr2[i]);
            }
            System.out.println();
            System.out.println(s);
            System.out.println();
        }
    }
}