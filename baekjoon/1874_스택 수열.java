package com.hauoli.mome;

import java.io.IOException;
import java.util.*;
public class Main {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num[] = new int[n];
		for(int i=0; i<n; i++) {
			num[i] = sc.nextInt();
		}
		
		int orderNum[] = num.clone();
		Arrays.sort(orderNum);
		
		StringBuffer bf = new StringBuffer();
		Stack<Integer> stack = new Stack();
		int index = 0;
		for(int i=0; i<n; i++) {
			while(index<n && orderNum[index] <= num[i]) {
				stack.add(orderNum[index]);
				index++;
				bf.append("+\n");
			}
			
			if(stack.pop() != num[i]) {
				System.out.println("NO");
				return;
			}else {
				bf.append("-\n");
			}
		}
		
		System.out.println(bf.toString());
	}
}
