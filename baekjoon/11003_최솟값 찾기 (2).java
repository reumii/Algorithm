import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int answer[] = new int[n];
		
		st = new StringTokenizer(br.readLine());
		Deque<Node> q = new LinkedList();
		for(int i=1; i<=n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			while(!q.isEmpty() && q.peekLast().value >= num) {
				q.removeLast();
			}
			
			while(!q.isEmpty() && q.peekFirst().index <= (i-l)) {
				q.removeFirst();
			}
			
			q.add(new Node(i, num));
			bw.append(q.peek().value + " ");
		}
		
		bw.flush();
		bw.close();
	}
	
	static class Node {
		int index;
		int value;
		
		Node(int index, int value){
			this.index = index;
			this.value = value;
		}
	}
}
