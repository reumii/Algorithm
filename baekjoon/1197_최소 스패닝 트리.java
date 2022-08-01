import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int parent[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken()); 
		int e = Integer.parseInt(st.nextToken());
		
		parent = new int[v+1];
		for(int i=1; i<=v; i++) {
			parent[i] = i;
		}
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken()); 
			int n2 = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			queue.add(new Node(n1, n2, value));
		}
		
		int sum = 0;
		int nodeCnt = 0;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(find(node.n1) != find(node.n2)) {
				nodeCnt++;
				sum += node.value;
				union(node.n1, node.n2);
			}
			
			if(nodeCnt >= v-1) {
				break;
			}
		}
		
		System.out.println(sum);
	}
	
	public static int find(int n) {
		while(parent[n] != n) {
			n = parent[n];
		}
		return n;
	}
	
	public static void union(int n1, int n2) {
		parent[n2] = find(n1);
	}
	
	public static class Node implements Comparable<Node>{
		int n1;
		int n2;
		int value;
		
		Node(int n1, int n2, int value){
			this.n1 = n1;
			this.n2 = n2;
			this.value = value;
		}
		
		@Override
		public int compareTo(Node node) {
			return this.value - node.value;
		}
	}
}