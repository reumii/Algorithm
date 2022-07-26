import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 도시 개수
		int m = Integer.parseInt(st.nextToken()); // 노선 개수
		
		Node edge[] = new Node[m+1];
		long distance[] = new long[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;
		
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			edge[i] = new Node(start,end,time);
		}
		
		for(int i=1; i<n ;i++) {
			for(int j=1; j<=m; j++) {
				Node now = edge[j];
				if(distance[now.start]!=Integer.MAX_VALUE) {
					distance[now.end] = Math.min(distance[now.end], distance[now.start] + now.time);
				}
			}
		}
		
		boolean isCycle = false;
		for(int j=1; j<=m; j++) {
			Node now = edge[j];
			if(distance[now.start]!=Integer.MAX_VALUE && distance[now.end] > distance[now.start] + now.time) {
				isCycle = true;
				break;
			}
		}
		
		if(isCycle) {
			System.out.println(-1);
		}else {
			for(int i=2; i<=n; i++) {
				if(distance[i] == Integer.MAX_VALUE) {
					bw.append(-1 + "\n");
				}else {
					bw.append(distance[i] + "\n");
				}
			}
		}
		bw.flush();
		bw.close();
	}
}

class Node {
	int start;
	int end;
	int time;
	
	Node(int start, int end, int time){
		this.start = start;
		this.end = end;
		this.time = time;
	}
}