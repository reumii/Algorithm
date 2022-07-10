import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayList<Integer> link[] = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			link[i] = new ArrayList<>();
		}
		int indegree[] = new int[n+1];
		
		int time[] = new int[n+1]; // 걸리는 시간
		for(int i=1; i<=n; i++) {
			time[i] = sc.nextInt();
			int pre = sc.nextInt(); // 먼저 지어야하는 건물
			while(pre != -1) {
				indegree[i]++;
				link[pre].add(i);
				pre = sc.nextInt();
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		
		int result[] = new int[n+1];
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int b : link[now]) {
				indegree[b]--;
				result[b] = Math.max(result[b], result[now] + time[now]);
				if(indegree[b]==0) {
					q.add(b);
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			System.out.println(result[i]+time[i]);
		}
	}
}