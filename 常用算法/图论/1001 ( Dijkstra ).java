=====================
【POJ 2387 邻接矩阵】
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Pair implements Comparable<Pair>{
		int v, w;

		public Pair(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Pair x) {
			return this.w < x.w ? -1 : (this.w == x.w ? 0 : 1);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt(), N = in.nextInt();
		@SuppressWarnings("unchecked")
		List<Pair>[] G = new ArrayList[N + 3];
		int[] d = new int[N + 3];
		for(int i = 0; i < N + 3; i++) {
			G[i] = new ArrayList<Pair>();
			d[i] = Integer.MAX_VALUE;
		} 
		for(int i = 0; i < T; i++) {
			int u = in.nextInt(), v = in.nextInt(), w = in.nextInt();
			G[u].add(new Pair(v, w));
			G[v].add(new Pair(u, w));
		}
		
		d[1] = 0;
		Queue<Pair> q = new PriorityQueue<Pair>();
		q.add(new Pair(1, 0));
		while(!q.isEmpty()) {
			Pair a = q.poll();
			//a.w > d[a.v]表示该结点已经被计算出了，应该被跳过
			/*
			*执行松弛操作之后，可能会出现同一节点被多次加入队列的情况
			*(如a1, a2……ax, 它们的v都是同一个点)
			*其中优先级最高的点a1的结果d[a1.v]最先被计算出来，此时其余节点
			*都不必再进行计算，这些不必再计算的节点ax都满足ax.w > d[ax.v]。
			*/
			while(!q.isEmpty() && a.w > d[a.v]) 
				a = q.poll();
			if(a.v == N) break;
			for(int i = 0; i < G[a.v].size(); i++) {
				Pair b = G[a.v].get(i);
				if(d[b.v] > d[a.v] + b.w) {
					d[b.v] = d[a.v] + b.w;
					q.add(new Pair(b.v, d[b.v]));
				}
			}
		}
		System.out.println(d[N]);
	}
}