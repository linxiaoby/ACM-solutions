import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	for(int i = 0; i <= 25; i++) {
    		map.put((char) ('a' + i - 32), i + 1);
    		map.put((char) ('a' + i), -i - 1);
    	}
    	
    	Scanner in = new Scanner(System.in);
    	int T, num;
    	char ch;
    	T = in.nextInt();
    	for(int i = 0; i < T; i++){
    		ch = in.next().charAt(0);
    		num = in.nextInt();
    		System.out.println(num + map.get(ch));
		}
    }
}