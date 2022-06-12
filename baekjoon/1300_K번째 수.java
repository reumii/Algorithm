import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int start = 1;
		int end = k;
		
		int answer = 0;
		while(start <= end) {
			int mid = (start+end)/2;
			int cnt = 0;
			for(int i=1; i<=n; i++) {
				cnt += Math.min(n, mid/i);
			}
			
			if(cnt < k) {
				start = mid+1;
			}else {
				end = mid-1;
				answer = mid;
			}
		}
		
		System.out.println(answer);
	}	
	
	
}
