import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> a[];
	static boolean visited[];
	static boolean flg[];
	static boolean isEven;
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		for(int i=0; i<k ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			// 인접리스트 셋팅
			a = new ArrayList[v+1];
			for(int j=1; j<=v; j++) {
				a[j] = new ArrayList<Integer>();
			}
			
			for(int j=0; j<e; j++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				a[start].add(end);
				a[end].add(start);
			}
			
			visited = new boolean[v+1];
			flg = new boolean[v+1];
			isEven = true;
			
			for(int j=1; j<=v; j++) {
				if(!visited[j]) {
					dfs(j);
				}
			}
			
			
			if(isEven) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
	
	public static void dfs(int nowNode){
		visited[nowNode] = true;
		
		for(int node : a[nowNode]) {
			if(!visited[node]) {
				flg[node] = !flg[nowNode];
				dfs(node);
			}else if(flg[node] == flg[nowNode]) {
				isEven = false;
				return;
			}
		}
	}
}
