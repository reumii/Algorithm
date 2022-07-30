import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken());
		int[][] distance = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j) distance[i][j] = 0;
				else distance[i][j] = 101;
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int f1 = Integer.parseInt(st.nextToken());
			int f2 = Integer.parseInt(st.nextToken());
			distance[f1][f2] = 1;
			distance[f2][f1] = 1;
		}
		
		for(int k=1; k<=n ;k++) {
			for(int i=1; i<=n ;i++) {
				for(int j=1; j<=n ;j++) {
					if(distance[i][k] > 0 && distance[k][j] > 0) {
						distance[i][j] = Math.min(distance[i][j],distance[i][k]+distance[k][j]);
					}
				}
			}
		}
		
		int min = 101;
		int answer = 0;
		for(int i=1; i<=n; i++) {
			int sum = 0;
			for(int j=1; j<=n; j++) {
				sum += distance[i][j];
			}
			if(sum < min) {
				min = sum;
				answer = i;
			}
		}
		
		System.out.println(answer);
	}
}