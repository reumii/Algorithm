import java.io.*;
import java.util.*;

public class Main {
	public static int node[];
	public static int nodeLink[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		nodeLink = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			nodeLink[i] = i;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				int info = sc.nextInt();
				if(info==1) {
					union(i,j);
				}
			}
		}
		
		int now = sc.nextInt();
		for(int i=1; i<m; i++) {
			int next = sc.nextInt();
			if(find(now) != find(next)) {
				System.out.println("NO");
				return;
			}
			now = next;
		}
		System.out.println("YES");
	}
	
	public static void union(int a, int b) {
		nodeLink[find(b)] = find(a);
	}
	
	public static int find(int node) {
		while(nodeLink[node] != node) {
			node = nodeLink[node];
		}
		return node;
	}
}
