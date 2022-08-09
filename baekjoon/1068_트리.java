import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int parent[];
	static ArrayList<Integer> alist[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		parent = new int[n];
		alist = new ArrayList[n];
		int root = 0;
		for(int i=0; i<n; i++) {
			alist[i] = new ArrayList();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			parent[i] = Integer.parseInt(st.nextToken());
			if(parent[i] < 0) {
				root = i;
			}else {
				alist[parent[i]].add(i);
			}
		}
		
		int cutEdge = Integer.parseInt(br.readLine()); 
		if(root == cutEdge) {
			System.out.println(0);
		}else {
			System.out.println(bfs(root, cutEdge));
		}
	}
	
	public static int bfs(int root, int cutEdge) {
		Queue<Integer> q = new LinkedList();
		q.add(root);
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			int child = 0;
			for(int n : alist[node]) {
				if(n != cutEdge) {
					q.add(n);
					child++;
				}
			}
			if(child == 0) cnt++;
		}
		return cnt;
	}
}