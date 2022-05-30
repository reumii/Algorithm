import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer= 0;
		Long num[] = new Long[n];
		
		for(int i=0; i<n; i++) {
			num[i] = sc.nextLong();
		}
		
		Arrays.sort(num);
		
		for(int i=0; i<n ;i++) {
			int start = 0;
			int end = n-1;
			
			while(start < end) {
				if(num[start] + num[end] == num[i]) {
					if(start==i) {
						start++;
					}else if(end==i){
						end--;
					}else {
						answer++;
						break;
					}
				} else if(num[start] + num[end] > num[i]) {
					end--;
				}else {
					start++;
				}
			}
		}
		
		System.out.println(answer);
	}
}
