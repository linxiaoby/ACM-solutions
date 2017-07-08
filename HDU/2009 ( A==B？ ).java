import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	String str1, str2;
    	while (in.hasNext()) {
    		str1 = in.next();
    		str2 = in.next();
    		BigDecimal bd1 = new BigDecimal(str1);
    		BigDecimal bd2 = new BigDecimal(str2);
    		System.out.println(bd1.compareTo(bd2) == 0 ?  "YES" : "NO");
		}
    }
}