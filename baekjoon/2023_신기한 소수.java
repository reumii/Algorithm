import java.io.*;
import java.util.*;

public class Main {
	public static int n;
	public static int nums[] = {1,3,5,7,9};
	public static void main(String[] args) throws IOException  {
		Scanner sc  = new Scanner(System.in);
		n = sc.nextInt();
		
		dfs(2,1);
		dfs(3,1);
		dfs(5,1);
		dfs(7,1);
	}
	
	public static void dfs(int num, int depth) {
		if(!isPrime(num)) {//소수가 아니면 중단
			return;
		}
		
		if(depth >= n) {// n 자리수라면 출력
			System.out.println(num);
			return;
		}
		
		num *=  10;
		for(int i=0; i<5; i++) {
			dfs(num+nums[i], depth+1);
		}
	}
	
	public static boolean isPrime(int num) {
		for(int i=3; i<num/2 ;i++) {
			if(num%i == 0) {
				return false;
			}
		}
		return true;
	}
	
}
