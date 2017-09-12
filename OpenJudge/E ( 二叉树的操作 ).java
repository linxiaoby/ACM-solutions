import java.util.Scanner;

public class Main {
	static class Node {
		int l, r, p;//左孩子、右孩子以及父亲节点的下标
	}
	
	static final int MAXN = 100 + 3;
	static Node[] no = new Node[MAXN];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for(int i = 0; i < MAXN; i++) 
			no[i] = new Node();
		
		int t = in.nextInt(), n, m;
		while(t-- > 0) {
			n = in.nextInt(); m = in.nextInt();
			int x, y, z;
			for(int i = 0; i < n; i++) {
				x = in.nextInt(); y = in.nextInt(); z = in.nextInt();
				no[x].l = y; no[x].r = z;
				if(y != -1) 
					no[y].p = x; 
				if(z != -1) 
					no[z].p = x;
			}
			no[0].p = -1;
			
			int c;
			while(m-- > 0) {
				c = in.nextInt();
				if(c == 1) {
					//修改双方父亲的孩子
					x = in.nextInt(); y = in.nextInt();
					int px = no[x].p; int py = no[y].p;
					char tag1 = 'l', tag2 = 'l';
					if(no[px].r == x) tag1 = 'r';
					if(no[py].r == y) tag2 = 'r';
					
					if(tag1 == 'l') no[px].l = y;
					else no[px].r = y;
					if(tag2 == 'l') no[py].l = x;
					else no[py].r = x;
					
					//交换双方的父亲，
					no[x].p = py;
					no[y].p = px;
				}	
				else{
					x = in.nextInt();
					while(no[x].l != -1) {
						x = no[x].l;
					}
					System.out.println(x);
				}
			}
		}
	}
}

