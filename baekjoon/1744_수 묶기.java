import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Integer> positive = new PriorityQueue(Collections.reverseOrder());
		PriorityQueue<Integer> negative = new PriorityQueue();
		int sum = 0;
		for(int i=0; i<n ; i++) {
			int num = sc.nextInt();
			if(num > 1) {
				positive.add(num);
			}else if(num == 1) {
				sum += num;
			}else {
				negative.add(num);
			}
		}
		
		while(positive.size() > 1) {
			sum += positive.poll() * positive.poll();
		}
		
		if(!positive.isEmpty()) {
			sum += positive.poll();
		}
		
		while(negative.size() > 1) {
			sum += negative.poll() * negative.poll();
		}
		
		if(!negative.isEmpty()) {
			sum += negative.poll();
		}
		
		System.out.println(sum);
	}	
}
