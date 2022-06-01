package com.hauoli.mome;

import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException  {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->{
			if(Math.abs(o1) > Math.abs(o2)) {
				return 1;
			}else if(Math.abs(o1) == Math.abs(o2) && o1>o2) {
				return 1;
			}else {
				return -1;
			}
		});

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			if(x == 0) {
				if(queue.isEmpty()) {
					bw.write(0 + "\n");
				}else {
					bw.write(queue.poll() + "\n");
				}
			}else {
				queue.add(x);
			}
		}
		bw.flush();
	}
}
