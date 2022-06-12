import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = 0;
		int end = 0;
		
		st = new StringTokenizer(br.readLine());
		int lesson[] = new int[n];
		for(int i=0; i<n; i++) {
			lesson[i] =  Integer.parseInt(st.nextToken());
			if(start < lesson[i]) {start = lesson[i];}
			end += lesson[i];
		}
		
		int answer = end;
		while(start <= end) {
			int mid = (start+end)/2;
			
			if(mid==17) {
				System.out.println(mid);
			}
			int sum = 0;
			int cnt = 1;
			for(int i=0; i<n; i++) {
				sum += lesson[i];
				if(sum > mid) {
					sum = lesson[i];
					cnt++;
				}
			}
			
			if(cnt > m) {
				start = mid+1;
			}else {
				end = mid-1;				
			}
		}
		
		System.out.println(start);	
	}	
	
	
}
