import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static class TV implements Comparable<TV>{
		int start;
		int end;
		public TV(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(TV b) {
			int aend = this.end;
			int bend = b.end;
			return (aend < bend ? -1 : (aend == bend ? 0 : 1));
		}
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, cnt;
        List<TV> list = new ArrayList<TV>();
        while(true) {
        	list.clear();
        	n = in.nextInt();
        	if(n == 0)
        		break;
        	
        	cnt = 0;
        	for(int i = 0; i < n; i++) 
        		list.add(new TV(in.nextInt(), in.nextInt()));
        	Collections.sort(list);
        	
        	int preEnd = 0;
        	for (TV tv : list) {
				if(tv.start >= preEnd) {
					cnt++;
					preEnd = tv.end;
				}
			}
        	System.out.println(cnt);
        }
    }
}