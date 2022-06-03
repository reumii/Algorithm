package com.hauoli.mome;

import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num[] = new int[n];
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		int answer = 0;
		int sum = 0;
		for(int p : num) {
			sum += p;
			answer += sum;
		}
		
		System.out.println(answer);
	}
}
