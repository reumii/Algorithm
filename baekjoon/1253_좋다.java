import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long num[] = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			num[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(num);
		
		int answer = 0;
		
		for(int i=0; i<n; i++) {
			long nowNum = num[i];
			int start = 0;
			int end = n-1;
			
			while(start<end) {
				long sum = num[start]+num[end];
				if(nowNum == sum) {
					if(i==start) {
						start++;
					}else if(i==end) {
						end--;
					}else {
						answer++;
						break;
					}
				}else if(nowNum < sum) {
					end--;
				}else {
					start++;
				}
			}
		}
		
		System.out.println(answer);
	}
}
