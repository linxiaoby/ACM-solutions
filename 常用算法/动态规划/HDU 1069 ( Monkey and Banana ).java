【版本1】
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static class Block implements Comparable<Block>{
        int x, y, z;
        public Block(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        @Override
        public int compareTo(Block o) {
            if(this.x == o.x)
                return this.y < o.y ? 1 : (this.y == o.y) ? 0 : -1;
            return this.x < o.x ? 1 : -1;
        }
    }
    
    public static void main(String[] args) {
        final int MAXN = 90 + 3;
        Scanner in = new Scanner(System.in);
        int n, t;
        List<Block> list = new ArrayList<Block>();
        int[][] G = new int[MAXN][MAXN];
        int[] dp = new int[MAXN];
        
        t = 1;
        while(true) {
            n = in.nextInt();
            if(n == 0) break;
            list.clear();
            
            int x, y, z;
            for(int i = 0; i < n; i++) {
                x = in.nextInt(); y = in.nextInt(); z = in.nextInt();
                list.add(new Block(Math.max(x, y), Math.min(x, y), z));
                list.add(new Block(Math.max(x, z), Math.min(x, z), y));
                list.add(new Block(Math.max(z, y), Math.min(z, y), x));
            }
            Collections.sort(list);
            
            Arrays.fill(dp, 0);
            dp[0] = list.get(0).z;
            int max = 0;
            for(int i = 1; i < 3 * n; i++) {
                Block tmp = list.get(i);
                dp[i] = tmp.z;
                for(int j = 0; j < i; j++) {
                    if(tmp.x < list.get(j).x && tmp.y < list.get(j).y)
                        dp[i] = Math.max(dp[i], dp[j] + tmp.z);
                }
                max = Math.max(dp[i], max);
            }
            
            System.out.println("Case " + t++ + ":" + " maximum height = " + max);
        }
    }
}


=================================================================================
【版本2】
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static class Block {
        int x, y, z;
        public Block(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    
    static int fun(int i, int n, int[][] G, int[] dp) {
        if(dp[i] != 0) return dp[i];
        for(int j = 0; j < n; j++) {
            if(G[i][j] != 0) 
                dp[i] = Math.max(dp[i], fun(j, n, G, dp) + G[i][j]);
        } 
        return dp[i];
    }
    public static void main(String[] args) {
        final int MAXN = 90 + 3;
        Scanner in = new Scanner(System.in);
        int n, t, x, y, z;
        List<Block> list = new ArrayList<Block>();
        int[][] G = new int[MAXN][MAXN];
        int[] dp = new int[MAXN];
        
        t = 1;
        while(true) {
            n = in.nextInt();
            if(n == 0) break;
            list.clear();
            
            for(int i = 0; i < n; i++) {
                x = in.nextInt(); y = in.nextInt(); z = in.nextInt();
                list.add(new Block(x, y, z));
                list.add(new Block(x, z, y));
                list.add(new Block(y, z, x));
            }
            
            for(int i = 0; i < MAXN; i++)
                Arrays.fill(G[i], 0);
            
            for(int i = 0; i < 3 * n; i++) {
                for(int j = 0; j < 3 * n; j++) {
                    if(j != i) {
                        Block a = list.get(i);
                        Block b = list.get(j);
                        if((b.x < a.x && b.y < a.y) || (b.y < a.x && b.x < a.y))
                            G[i][j] = b.z;
                    }
                }
            }
            
            Arrays.fill(dp, 0);
            for(int i = 0; i < 3 * n; i++)
                fun(i, 3 * n, G, dp);
            int max = 0;
            for(int i = 0; i < 3 * n; i++) 
                max = Math.max(max, dp[i] + list.get(i).z);
                
            System.out.println("Case " + t++ + ":" + " maximum height = " + max);
        }
    }
}