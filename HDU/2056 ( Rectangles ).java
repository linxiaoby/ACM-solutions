import java.util.Scanner;

public class Main {
	static void swap(double[] a, int i ,int j) {
		double tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	double[] a = new double[9];
    	double minU, maxD, minR, maxL, s;
    	
    	while(in.hasNext()) {
    		for(int i = 1; i <= 8; i++) {
    			a[i] = in.nextDouble();
    			if((i == 3 || i == 4 || i == 7 || i == 8) && (a[i - 2] > a[i]))
    				swap(a, i - 2, i);
    		}
    		minU = Math.min(a[4], a[8]);
    		maxD = Math.max(a[2], a[6]);
    		minR = Math.min(a[3], a[7]);
    		maxL = Math.max(a[1], a[5]);
    		s = (maxD > minU || minR < maxL) ? 0 : (minU - maxD) * (minR - maxL); 
			System.out.printf("%.2f", s);
			System.out.println();
    	}
    }
}