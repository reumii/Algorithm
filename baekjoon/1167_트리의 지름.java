import java.io.*;
import java.util.*;

public class Main {
	public static ArrayList<int[]>[] edge;
	public static boolean[] visited;
	public static int[] distance;
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		edge = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			edge[i] = new ArrayList<int[]>();
		}
		
		for(int i=0; i<n; i++) {
			String[] v = br.readLine().split(" ");
			int node = Integer.parseInt(v[0]);
			int index = 1;
			while(!v[index].equals("-1")) {
				int node2 = Integer.parseInt(v[index]);
				int dis = Integer.parseInt(v[index+1]);
				edge[node].add(new int[]{node2,dis});
				index += 2;
			}
		}

		visited = new boolean[n+1];
		distance = new int[n+1];
		int maxIndex = 1;
		bfs(1);
		for(int i=2; i<=n; i++) {
			if(distance[maxIndex]<distance[i]) {
				maxIndex = i;
			}
		}
		
		visited = new boolean[n+1];
		distance = new int[n+1];
		bfs(maxIndex);
		Arrays.sort(distance);
		System.out.print(distance[n]);
	}	
	
	public static void bfs(int node) {
		Queue<Integer> queue = new LinkedList();
		queue.add(node);
		visited[node] = true;
		
		while(!queue.isEmpty()) {
			node = queue.poll();
			for(int info[] :edge[node]) {
				int node2 = info[0];
				int dis = info[1];
				if(!visited[node2]) {
					visited[node2] = true;
					queue.add(node2);
					distance[node2] = distance[node] + dis;
				}
			}
		}
	}
}
