import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N;
		while(true) {
			N = in.nextInt();
			if(N == 0)
				break;
			
			List<String> list = new ArrayList<String>();
			List<Integer> cntList = new ArrayList<Integer>();
			String str;
			int maxi = 0;
			cntList.add(1);
			for(int i = 0; i < N; i++) {
				str = in.next();
				if(list.contains(str)) {
					int j = list.indexOf(str);
					int c = cntList.get(j);
					cntList.set(j, c + 1);
					if(c + 1 > cntList.get(maxi))
						maxi = j;
				}
				else {
					list.add(str);
					cntList.add(1);
				}
			}
			
			System.out.println(list.get(maxi));
		}
	}
}
