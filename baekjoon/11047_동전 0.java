import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int money[] = new int[n];
		
		for(int i=0; i<n; i++) {
			money[i] = sc.nextInt();
		}
		
		int cnt = 0;
		for(int i=n-1; i>=0; i--) {
			int q = k/money[i];
			if(q > 0) {
				cnt += q;
				k -= money[i] * q;
			}
			
			if(k <= 0) {
				break;
			}
		}
		System.out.println(cnt);
	}	
	
	
}
