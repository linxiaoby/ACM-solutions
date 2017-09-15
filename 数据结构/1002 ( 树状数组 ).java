【hdu 1166】
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static final int MAXN = 50000 + 3;
	static int[] x = new int[MAXN], sum = new int[MAXN];
	static int N;
	
	static class BIT {
		static int lowbit(int x){
		    return x & (-x);
		}
		
		static void build(){ 
		    for (int i = 1;i <= N; i++){
		        sum[i] = x[i];
		        for (int j = i -1; j > i - lowbit(i); j--)
		            sum[i] += x[j];
		    }
		}
		
		static void modify(int i, int delta, int tag){
		    for (int j = i; j <= N; j += lowbit(j))
		        sum[j] = tag == 1 ? sum[j] + delta : sum[j] - delta;
		}
		
		static int sum (int k){
		    int ans = 0;
		    for (int i = k; i > 0; i -= lowbit(i))
		        ans += sum[i];
		    return ans;
		}
	}
		
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.valueOf(br.readLine());
			String[] tmp = br.readLine().split(" ");
			for(int i = 1; i <= N; i++) 
				x[i] = Integer.valueOf(tmp[i - 1]);
			
			BIT.build();
			System.out.println("Case " + t + ":");
			while(true) {
				tmp = br.readLine().split(" ");
				if(tmp[0].equals("End")) break;
				
				int a = Integer.valueOf(tmp[1]), b = Integer.valueOf(tmp[2]);
				if(tmp[0].equals("Add")) 
					BIT.modify(a, b, 1);
				else if(tmp[0].equals("Sub")) 
					BIT.modify(a, b, -1);
				else 
					System.out.println(BIT.sum(b) - BIT.sum(a - 1));	
			}
		}
	}
}

