package com.hauoli.mome;

import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int p = sc.nextInt();
		String dna = sc.next();
		int cnt1[] = new int[4];
		int cnt2[] = new int[4];
		for(int i=0; i<4; i++) {
			cnt1[i] = sc.nextInt();
		}
		int answer= 0;
		
		for(int i=0; i<p; i++) {
			dna.charAt(i);
			switch(dna.charAt(i)){
			case 'A' : cnt2[0]++; break;
			case 'C' : cnt2[1]++; break;
			case 'G' : cnt2[2]++; break;
			case 'T' : cnt2[3]++; break;
			}
		}	
		
		if(check(cnt1, cnt2)) answer++;
		
		for(int i=0; i+p<s; i++) {
			char rid = dna.charAt(i);
			char add = dna.charAt(i+p);
			if(rid != add) {
				switch(rid){
				case 'A' : cnt2[0]--; break;
				case 'C' : cnt2[1]--; break;
				case 'G' : cnt2[2]--; break;
				case 'T' : cnt2[3]--; break;
				}
				
				switch(add){
				case 'A' : cnt2[0]++; break;
				case 'C' : cnt2[1]++; break;
				case 'G' : cnt2[2]++; break;
				case 'T' : cnt2[3]++; break;
				}
			}
			
			if(check(cnt1, cnt2)) answer++;
		}
		
		System.out.println(answer);
	}
	
	public static boolean check(int[] cnt1,int[] cnt2) {
		for(int i=0; i<cnt1.length; i++) {
			if(cnt1[i] > cnt2[i]) {
				return false;
			}
		}
		return true;
	}
}
