import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int c, r;
    	while(in.hasNext()) {
    		c = in.nextInt();
    		r = in.nextInt();
    		
    		for(int i = 1; i <= r + 2; i++) {
    			for(int j = 1; j <= c + 2; j++) {
    				if((i == 1 && j == 1) || (i == 1 && j == c + 2)||(i == r + 2 && j == 1) 
    				|| (i == r + 2 && j == c + 2))
    					System.out.print("+");
    				else if(i == 1 || i == r + 2)
    					System.out.print("-");
    				else if(j == 1 || j == c + 2)
    					System.out.print("|");
    				else 
    					System.out.print(" ");
    			}
    			System.out.println();
    		}
    		System.out.println();
    	}
    }
}