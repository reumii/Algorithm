import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine()); // 도시 개수
		int m = Integer.parseInt(br.readLine()); // 버스 개수
		
		ArrayList<Bus> edge[] = new ArrayList[c+1];
		int cost[] = new int[c+1];
		boolean visited[] = new boolean[c+1];
		for(int i=1; i<=c; i++) {
			edge[i] = new ArrayList<>();
			cost[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int fee = Integer.parseInt(st.nextToken());
			edge[start].add(new Bus(end,fee));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int startCity = Integer.parseInt(st.nextToken());
		int endCity = Integer.parseInt(st.nextToken());
		cost[startCity] = 0;
		
		PriorityQueue<Bus> q = new PriorityQueue<>();
		q.add(new Bus(startCity,0));
		while(!q.isEmpty()) {
			Bus now = q.poll();
			if(!visited[now.city]) {
				visited[now.city] = true;
				
				for(Bus b : edge[now.city]) {
					if(cost[b.city] > cost[now.city] + b.fee) {
						cost[b.city] = cost[now.city] + b.fee;
						b.fee = cost[b.city];
						q.add(b);
					}
				}
			}
			
		}
		
		System.out.println(cost[endCity]);
	}
}

class Bus implements Comparable<Bus> {
	int city;
	int fee;
	
	Bus(int city,int fee){
		this.city = city;
		this.fee = fee;
	}
	
	public int compareTo(Bus b) {
		if(this.fee > b.fee) {
			return 1;
		}else {
			return -1;
		}
	}
}