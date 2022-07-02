import java.io.*;
import java.util.*;

public class Main {
	public static ArrayList<Integer> a[];
	public static boolean visited[];
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
	
		// 인접리스트 초기화
		visited = new boolean[n+1];
		a = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		// 인접리스트 셋팅
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			a[n1].add(n2);
			a[n2].add(n1);
		}
		
		for(int i=1; i<=n; i++) {
			Collections.sort(a[i]);
		}
		
		dfs(v);
		System.out.println();
		visited = new boolean[n+1];
		bfs(v);
	}
	
	public static void dfs(int startIndex) {
		System.out.print(startIndex + " ");
		visited[startIndex] = true;
		for(int node : a[startIndex]) {
			if(!visited[node]) {
				dfs(node);
			}
		}
	}
	
	public static void bfs(int startIndex) {
		Queue<Integer> q = new LinkedList();
		q.add(startIndex);
		visited[startIndex] = true;
		
		while(!q.isEmpty()) {
			int nowNode = q.poll();
			System.out.print(nowNode + " ");
			for(int node : a[nowNode]) {
				if(!visited[node]) {
					visited[node] = true;
					q.add(node);
				}
			}
		}
	}
}
