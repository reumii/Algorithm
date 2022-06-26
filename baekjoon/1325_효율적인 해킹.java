import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> a[];
	static boolean visited[];
	static int answer[];
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 인접리스트 셋팅
		a = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int aNode = Integer.parseInt(st.nextToken());
			int bNode = Integer.parseInt(st.nextToken());
			a[bNode].add(aNode);
		}
		
		answer = new int[n+1];
		for(int i=1; i<=n; i++) {
			visited = new boolean[n+1];
			bfs(i);
		}
		
		int max = -1;
		for(int i=1; i<=n; i++) {
			max = Math.max(max, answer[i]);
		}
		
		for(int i=1; i<=n; i++) {
			if(answer[i] == max) {
				bw.append(i + " ");
			}
		}
		bw.flush();
		bw.close();
	}
	
	public static void bfs(int startNode){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(startNode);
		visited[startNode] = true;
		
		while(!q.isEmpty()) {
			int nowNode = q.poll();
			for(int node : a[nowNode]) {
				if(!visited[node]) {
					visited[node] = true; 
					q.add(node);
					answer[startNode]++;
				}
			}
		}
	}
}
