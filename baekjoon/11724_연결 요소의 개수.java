import java.io.*;
import java.util.*;

public class Main {
	public static ArrayList<Integer> edge[];
	public static boolean visited[];
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		edge = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		for(int i=1; i<=n; i++) {
			edge[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			edge[s].add(e);
			edge[e].add(s);
		}
		
		int answer = 0;
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				answer++;
				dfs(i);
			}
		}
		
		System.out.println(answer);
	}
	
	public static void dfs(int node) {
		if(visited[node]) {
			return;
		}
		
		visited[node] = true;
		ArrayList<Integer> list = edge[node];
		for(int l : list) {
			dfs(l);
		}
	}
}
