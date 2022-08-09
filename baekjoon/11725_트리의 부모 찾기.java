import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static boolean visited[]; 
	static int parent[];
	static ArrayList<Integer> alist[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); 
		
		visited = new boolean[n+1];
		parent = new int[n+1];
		alist = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			alist[i] = new ArrayList();
		}
		for(int i=0; i<n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			alist[n1].add(n2);
			alist[n2].add(n1);
		}
		
		bfs();
			
		for(int i=2; i<=n; i++) {
			System.out.println(parent[i]);
		}
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList();
		q.add(1);
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int n : alist[node]) {
				if(!visited[n]) {
					visited[n] = true;
					q.add(n);
					parent[n] = node;
				}
			}
			
		}
	}
}