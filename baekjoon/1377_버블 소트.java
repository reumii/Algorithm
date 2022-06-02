import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException  {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		Node a[] = new Node[n];
		for(int i=0; i<n; i++) {
			a[i] = new Node(i, Integer.parseInt(bf.readLine()));
		}
		
		Arrays.sort(a);
		
		int answer = 0;
		for(int i=0; i<n; i++) {
			int gap = a[i].index - i;
			if(answer<gap) answer = gap;
		}
		
		System.out.println(answer+1);
		
	}
	
	static class Node implements Comparable<Node>{
		int index;
		int num;
		
		public Node(int index, int num) {
			this.index = index;
			this.num = num;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.num - o.num;
		}
	}
}
