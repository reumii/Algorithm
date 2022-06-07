import java.io.*;
import java.util.*;

public class Main {
	public static ArrayList<Integer>[] edge;
	public static boolean[] visited;
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		//인접 리스트 초기화
		edge = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			edge[i] = new ArrayList<Integer>();
		}
		
		// 인접 리스트 저장
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edge[a].add(b);
			edge[b].add(a);
		}
		
		// 인접 리스트 정렬
		for(int i=1; i<=n; i++) {
			Collections.sort(edge[i]);
		}
		
		visited = new boolean[n+1];
		dfs(v);
		System.out.println();
		visited = new boolean[n+1];
		bfs(v);
	}
	
	public static void dfs(int now) {
		System.out.print(now + " ");
		visited[now] = true;
		for(int e :edge[now]) {
			if(!visited[e]) {
				dfs(e);
			}
		}
	}
	
	public static void bfs(int start) {
		String order = "";
		Queue<Integer> queue = new LinkedList();
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			order += now + " ";
			for(int e : edge[now]) {
				if(!visited[e]) {
					visited[e] = true;
					queue.add(e);
				}
			}
		}
		System.out.println(order);
	}	
}
