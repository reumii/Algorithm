import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException  {
		Scanner sc = new Scanner(System.in);
		int m = Math.max(2, sc.nextInt());
		int n = sc.nextInt();
		boolean isPrime[] = new boolean[n+1];
		Arrays.fill(isPrime, true);
		
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(isPrime[i]) {
				for(int j=i*2; j<=n; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		
		for(int i=m; i<=n; i++) {
			if(isPrime[i]) {
				System.out.println(i);
			}
		}
	}	
}
