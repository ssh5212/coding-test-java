import java.io.*;
import java.util.*;

public class Main {
	
	static int V, E;
	
	static class Node implements Comparable<Node> {
		int e;
		int c;
		public Node(int e, int c) {
			this.e = e;
			this.c = c;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.c, o.c);
		}
		
		
	}
	
	static ArrayList<Node>[] adj;
	static boolean[] v;
	static int[] distance;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
				
		// 첫째 줄
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[V + 1];
		for (int i = 1; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}
		distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		v = new boolean[V + 1];
				
		// 둘째 줄
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		
		// 나머지 줄
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adj[from].add(new Node(to, cost));
		}
		
		
		distance[start] = 0;
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(start, 0));
				
		while(!q.isEmpty()) {
			Node p = q.poll();
			int minIdx = p.e;
			
			if(v[minIdx] == true) continue;
			v[minIdx] = true;
			
			for (Node next : adj[minIdx]) {
				if(v[next.e] == false && distance[next.e] > distance[minIdx] + next.c) {
					distance[next.e] = distance[minIdx] + next.c;
					q.add(new Node(next.e, distance[next.e]));
				}
			}
			
		}
		
		for (int i = 1; i < distance.length; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(distance[i]);
			}
		}
	}
}