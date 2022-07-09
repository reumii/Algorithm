import java.util.*;

public class Main {
	public static int link[];
	public static int known;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		link = new int[n+1];
		for(int i=1; i<=n; i++) {
			link[i] = i;
		}
		
		int cnt = sc.nextInt();
		if(cnt<=0) {
			System.out.println(m);
			return;
		}
		
		known = sc.nextInt();
		for(int i=1; i<cnt ; i++) {
			link[sc.nextInt()] = known;
		}
		 
		int party[] = new int[m];
		for(int i=0; i<m; i++) {
			cnt = sc.nextInt();
			if(cnt > 0) {
				party[i] = sc.nextInt();
				for(int j=1; j<cnt; j++) {
					union(party[i], sc.nextInt());
				}
			}
		}
		
		int answer = 0;
		for(int i=0; i<m; i++) {
			if(find(party[i]) != known) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	public static int find(int a) {
		while(link[a] != a) {
			a = link[a];
		}
		return a;
	}
	
	public static void union(int a, int b) {
		if(find(b) == known) {
			link[find(a)] = find(b);
		}else {
			link[find(b)] = find(a);
		}
	}
}