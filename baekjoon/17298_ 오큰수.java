package com.hauoli.mome;

import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] result = new int[n];
		Stack<Node> stack = new Stack();
		
		for(int i=0; i<n; i++) {
			int nowNum = sc.nextInt();
			while(!stack.isEmpty() && stack.peek().num < nowNum) {
				int index = stack.pop().index;
				result[index] = nowNum;
			}
			stack.push(new Node(i,nowNum));
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<n; i++) {
			if(result[i]==0) {
				sb.append("-1 ");
			}else {
				sb.append(result[i] + " ");
			}
		}
		System.out.print(sb.toString());
	}
	
	static class Node{
		public int index;
		public int num;
		
		Node(int index, int num){
			this.index = index;
			this.num = num;
		}
	}
}
