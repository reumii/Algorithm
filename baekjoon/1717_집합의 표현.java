import java.io.*;
import java.util.*;

public class Main {
	public static int node[];
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		node = new int[n+1];
		for(int i=0; i<=n; i++) {
			node[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(type == 0) {
				union(a, b);
			}else {
				//대표 노드가 같은지 확인
				if(find(a) == find(b)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
	}
	
	// 집합 합치기
	public static void union(int a, int b) {
		int parent = find(a);
		node[find(b)] = parent;
	}
	
	// 대표 노드 찾기
	public static int find(int n) {
		while(node[n] != n) {
			n = node[n];
		}
		return n;
	}
}
