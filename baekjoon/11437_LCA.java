import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static ArrayList<Integer> tree[];
	public static int depth[];
	public static int parent[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n+1];
		depth = new int[n+1];
		parent = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		
		setTree(n);
		
		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(getLCA(a, b));
		}
	}
	
	public static void setTree(int n) {
		Queue<Integer> q = new LinkedList();
		q.add(1);
		depth[1] = 0;
		boolean visited[] = new boolean[n+1];
		visited[1] = true;
		int level = 1;
		int cnt = 0;
		int size = 1;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			
			for(int child : tree[node]) {
				if(!visited[child]) {
					visited[child] = true;
					parent[child] = node;
					depth[child] = level;
					q.add(child);
				}
			}
			
			cnt++;
			
			if(cnt == size) {
				cnt = 0;
				size = q.size();
				level++;
			}
		}
	}
	
	public static int getLCA(int a, int b) {
		if(depth[a] > depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		while(depth[a] != depth[b]) {
			b = parent[b];
		}
		
		while(a != b) {
			a = parent[a];
			b = parent[b];
		}
		return a;
	}
}
