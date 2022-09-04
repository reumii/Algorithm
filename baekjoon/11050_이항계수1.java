import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int d[][] = new int[n+1][n+1];
		
		for(int i=0; i<=n; i++) {
			d[i][0] = 1;
			d[i][i] = 1;
			d[i][1] = i;
		}
		
		for(int i=2; i<=n; i++) {
			for(int j=1; j<i; j++) {
				d[i][j] = d[i-1][j-1] + d[i-1][j];
			}
		}
		
		System.out.println(d[n][k]);
	}
}
