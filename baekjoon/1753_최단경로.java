import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken()); // 노드 개수
		int e = Integer.parseInt(st.nextToken()); // 에지 개수
		int k = Integer.parseInt(br.readLine()); //출발 노드
		
		ArrayList<Node> link[] = new ArrayList[v+1];
		int distance[] = new int[v+1];
		boolean visited[] = new boolean[v+1];
		for(int i=1; i<=v; i++) {
			link[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}
		distance[k] = 0; //출발 노드는 0
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			link[n1].add(new Node(n2,value));
		}
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(k,0));
		while(!q.isEmpty()) {
			Node now = q.poll();
			if(!visited[now.vertex]) {
				visited[now.vertex] = true;
				for(Node n : link[now.vertex]) {
					if(distance[n.vertex] > distance[now.vertex] + n.value){
						distance[n.vertex] = distance[now.vertex] + n.value;
						n.value = distance[n.vertex];
						q.add(n);
					}
					
				}
			}
		}
		
		for(int i=1; i<=v; i++) {
			if(visited[i]) {
				System.out.println(distance[i]);
			}else {
				System.out.println("INF");
			}
		}
	}
}

class Node implements Comparable<Node>{
	int vertex;
	int value;
	
	Node(int vertex, int value){
		this.vertex = vertex;
		this.value = value;
	}
	
	public int compareTo(Node n) {
		return (this.value > n.value) ? 1:-1;
	}
}