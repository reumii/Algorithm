import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException  {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		while(true) {
			if(isPalin(a) && isPrime(a)) {
				System.out.println(a);
				break;
			}
			a++;
		}		
	}
	
	public static boolean isPrime(int num) {
		if(num<2) {return false;}
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i==0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isPalin(int num) {
		String str = Integer.toString(num);
		for(int i = 0; i<=str.length()/2; i++) {
			if(str.charAt(i) != str.charAt(str.length()-i-1)) {
				return false;
			}
		}
		return true;
	}
}
