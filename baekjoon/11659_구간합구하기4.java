import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> alist[];
	static boolean visited[];
	static int water[];
	static HashSet<Integer> answer;
	
	public static void main(String[] args) throws IOException  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int num[] = new int[n+1];
		int sum[] = new int[n+1];
		for(int i=1; i<=n; i++) {
			num[i] = sc.nextInt();
			sum[i] = sum[i-1] + num[i];
		}
		
		for(int i=0; i<m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			System.out.println(sum[end] - sum[start-1]);
		}
	}
}
