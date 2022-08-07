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
		int n = Integer.parseInt(br.readLine());
		
		int sum = 0;
		PriorityQueue<Node> queue = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				int value = 0;
				if(s.charAt(j)>='a' && s.charAt(j)<='z') {
					value = s.charAt(j) - 96;
				}else if(s.charAt(j)>='A' && s.charAt(j)<='Z') {
					value = s.charAt(j) - 38;
				}
				sum += value;
				
				if(i!=j && value!=0) {
					queue.add(new Node(i,j,value));
				}
			}
		}
		
		parent = new int[n];
		for(int i=0 ;i<n; i++) {
			parent[i] = i;
		}
		
		int minValue = 0;
		int edgeCnt = 0;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(find(node.n1) != find(node.n2)) {
				minValue += node.value;
				edgeCnt++;
				union(node.n1, node.n2);
			}
		}
		
		if(edgeCnt == n-1) {
			System.out.println(sum - minValue);
		}else {
			System.out.println(-1);
		}
	}
	
	public static int find(int a) {
		while(parent[a] != a) {
			a = parent[a];
		}
		return a;
	}
	
	public static void union(int a, int b) {
		parent[find(b)] = find(a);
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