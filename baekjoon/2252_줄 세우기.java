import java.util.*;

public class Main {
	public static int link[];
	public static int known;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		// 인접리스트 초기화
		ArrayList<Integer> link[] = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			link[i] = new ArrayList<>();
			
		}

		int indegree[] = new int[n+1]; //진입 차수 배열
		for(int i=0; i<m; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			link[n1].add(n2);
			indegree[n2]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		
		StringBuffer answer = new StringBuffer();
		while(!q.isEmpty()) {
			int n1 = q.poll();
			answer.append(n1 + " ");
			for(int a : link[n1]) {
				indegree[a]--;
				if(indegree[a] == 0) {
					q.add(a);
				}
			}
		}
		
		System.out.println(answer);
	}
}