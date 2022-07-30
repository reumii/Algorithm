import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //도시 개수
		int m = Integer.parseInt(br.readLine()); //버스 개수
		
		int distance[][] = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
		
		for(int i=1; i<=n; i++) {
			distance[i][i] = 0;
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); //시작 도시
			int end = Integer.parseInt(st.nextToken()); //도착 도시
			int value = Integer.parseInt(st.nextToken()); //비용
			distance[start][end] = Math.min(distance[start][end], value);
		}
		
		for(int k=1; k<=n ;k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE) {
						distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
					}
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(distance[i][j] == Integer.MAX_VALUE) {
					System.out.print("0 ");
				}else {
					System.out.print(distance[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}