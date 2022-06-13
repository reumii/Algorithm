import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Integer> q = new PriorityQueue();
		
		for(int i=0; i<n; i++) {
			q.add(sc.nextInt());
		}
		
		int answer = 0;
		while(q.size()>1) {
			int num1 = q.poll();
			int num2 = q.poll();
			answer += (num1+num2);
			q.add(num1+num2);
		}
		System.out.println(answer);
	}	
}
