import java.io.*;
import java.util.*;

public class Main {
	static long answer[];
	static ArrayList<Node>[] nodeList;
	static boolean visited[];
	public static void main(String[] args) throws IOException  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 초기화
		answer = new long[n];
		visited = new boolean[n];
		nodeList = new ArrayList[n];
		for(int i=0; i<n; i++) {
			nodeList[i] = new ArrayList<Node>();
		}
		
		long lcm = 1; //최소공배수
		for(int i=1; i<n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			nodeList[a].add(new Node(b,p,q));
			nodeList[b].add(new Node(a,q,p));
			lcm *= (p * q / gcd(p,q));
		}
		
		
		answer[0] = lcm; //첫 시작을 최소공배수로 셋팅
		dfs(0);
		
		long gcd = answer[0];
		//구한 비율의 최대공약수 구하기
		for(int i=1; i<n; i++) {
			gcd = gcd(gcd , answer[i]);
		}
		
		for(long a : answer) {
			System.out.print(a/gcd +" ");
		}
	}
	
	public static void dfs(int index) {
		visited[index] = true;
		for(Node node : nodeList[index]) {
			if(!visited[node.n]) {
				answer[node.n] = answer[index] * node.q / node.p;
				dfs(node.n);
			}
		}
	}
	
	// 최대공약수
	public static long gcd(long a, long b) {
		if(b == 0) {
			return a;
		}else {
			return gcd(b, a%b);
		}
	}
	
	static class Node{
		int n;
		int p;
		int q;
		
		public Node(int n, int p, int q){
			this.n = n;
			this.p = p;
			this.q = q;
		}
	}
}
