import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 도시 개수
		int m = Integer.parseInt(st.nextToken()); // 도로 개수
		int k = Integer.parseInt(st.nextToken());
		
		// 오름차순 정렬
		Comparator<Integer> cp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 < o2) {
					return 1;
				}else {
					return -1;
				}
			}
		};
		
		// 인접리스트/최단거리 배열 초기화
		ArrayList<Road>  a[] = new ArrayList[n+1];
		PriorityQueue<Integer> distance[] = new PriorityQueue[n+1];
		for(int i=1; i<=n; i++) {
			a[i] = new ArrayList<>();
			distance[i] = new PriorityQueue<Integer>(k,cp);
		}
		distance[1].add(0);
		
		// 방문 배열
		boolean visited[] = new boolean[n+1];
		
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			a[start].add(new Road(end, time));
		}
		
		PriorityQueue<Road> pq = new PriorityQueue<>();
		pq.add(new Road(1,0));
		
		while(!pq.isEmpty()) {
			Road r = pq.poll();
			
			for(Road now : a[r.city]) {
				int time = r.time + now.time;
				if(distance[now.city].size() < k) {
					distance[now.city].add(time);
					pq.add(new Road(now.city, time));
				}else if(distance[now.city].peek() > time){
					distance[now.city].poll();
					distance[now.city].add(time);
					pq.add(new Road(now.city, time));
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			if(distance[i].size() < k) {
				System.out.println(-1);
			}else {
				System.out.println(distance[i].poll());
			}
		}
	}
}

class Road implements Comparable<Road> {
	int city;
	int time;
	
	Road(int city,int time){
		this.city = city;
		this.time = time;
	}
	
	public int compareTo(Road b) {
		if(this.time > b.time) {
			return 1;
		}else {
			return -1;
		}
	}
}