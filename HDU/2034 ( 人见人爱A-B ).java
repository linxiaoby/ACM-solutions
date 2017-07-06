import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, m;
        
        while(true) {
        	n = in.nextInt();
        	m = in.nextInt();
        	if(n == 0 && m == 0)
        		break;
        	
        	List<Integer> alist = new ArrayList<Integer>();
        	for(int i = 0; i < n; i++)
        		alist.add(in.nextInt());
        	int tmp;
        	for(int i = 0; i < m; i++){
        		tmp = in.nextInt();
        		if(alist.contains(tmp))
        			alist.remove(Integer.valueOf(tmp));
        	}
        	
        	if(alist.isEmpty())
        		System.out.print("NULL");
        	else {
        		Collections.sort(alist);
				for (Integer e : alist)
					System.out.print(e + " ");
			}
        	System.out.println();
        }
    }
}