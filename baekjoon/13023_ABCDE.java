import java.io.*;
import java.util.*;

public class Main {
	public static ArrayList<Integer>[] edge;
	public static boolean[] visited;
	public static int answer;
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		answer = 0;
		
		edge = new ArrayList[n];
		for(int i=0; i<n; i++) {
			edge[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edge[a].add(b);
			edge[b].add(a);
		}
		
		for(int i=0; i<n; i++) {
			visited = new boolean[n];
			dfs(i,1);
			if(answer==1) {
				break;
			}
		}
		
		System.out.println(answer);
	}
	
	public static void dfs(int num, int depth) {
		if(visited[num]) {
			return;
		}
		
		if(depth>=5) {
			answer = 1;
			return;
		}
		
		visited[num] = true;
		ArrayList<Integer> list = edge[num];
		for(int l : list) {
			dfs(l, depth+1);
		}
		visited[num] = false;
	}	
}
