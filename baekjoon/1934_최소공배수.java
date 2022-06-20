import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException  {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i<t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a > b) {
				int temp = a;
				a = b;
				b = temp;
			}
			
			int num = b;
			while(num%a != 0) {
				num += b;
			}
			System.out.println(num);
		}
	}
}
