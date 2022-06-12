import java.io.*;
import java.util.*;

public class Main {
	public static int num[];
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			int find = Integer.parseInt(st.nextToken());
			System.out.println(findNum(find));
		}
	}	
	
	public static int findNum(int find) {
		int start = 0;
		int end = num.length-1;
		while(start <= end) {
			int mid = (start+end)/2;
			
			if(num[mid] == find) {
				return 1;
			}else if(num[mid] > find) {
				end = mid-1; 
			}else {
				start = mid+1;
			}
		}
		return 0;
	}
}
