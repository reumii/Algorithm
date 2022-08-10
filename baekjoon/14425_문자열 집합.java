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
		HashSet<String> set = new HashSet();
		
		for(int i=0; i<n; i++) {
			set.add(br.readLine());
		}
		
		int answer = 0;
		for(int i=0 ;i<m; i++) {
			if(set.contains(br.readLine())) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}