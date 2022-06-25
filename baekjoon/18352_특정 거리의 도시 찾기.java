import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> a[];
	static int visited[];
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		// 초기화
		a = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<Integer>();
		}	
		
		visited = new int[n+1];
		for(int i=1; i<=n; i++) {
			visited[i] = -1;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		
		bfs(x);
		
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			if(visited[i] == k) {
				answer.add(i);
			}
		}
		
		if(answer.size() > 0) {
			Collections.sort(answer);
			for(int a : answer) {
				System.out.println(a);
			}
		}else {
			System.out.println("-1");
		}		
	}
	
	public static void bfs(int startNode){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(startNode);
		visited[startNode] = 0;
		
		while(!q.isEmpty()) {
			int nowNode = q.poll();
			for(Integer node : a[nowNode]) {
				if(visited[node] <= 0) {
					q.add(node);
					visited[node] = visited[nowNode] + 1; 
				}
			}
		}
	}
}
