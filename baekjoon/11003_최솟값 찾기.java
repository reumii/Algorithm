package com.hauoli.mome;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Deque<Node> deque = new LinkedList<>();
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(!deque.isEmpty() && deque.getFirst().index <= i-l) {
				deque.removeFirst();
			}
			
			while(!deque.isEmpty() && deque.getLast().num >= num) {
				deque.removeLast();
			}
			deque.addLast(new Node(i,num));
			bw.write(deque.getFirst().num + " ");
		}
		
		bw.flush();
		bw.close();
	}
	
	static class Node {
		int index;
		int num;
		
		Node(int index, int num){
			this.index = index;
			this.num = num;
		}
	}
}
