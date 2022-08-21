import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static long tree[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int tempN = n;
		int treeHeight = 0;
		while(tempN > 0) {
			tempN /= 2;
			treeHeight++;
		}
		
		int treeSize = (int)Math.pow(2, treeHeight+1);
		tree = new long[treeSize+1];
		for(int i=0; i<n; i++) {
			tree[(int) Math.pow(2, treeHeight)+i] = Long.parseLong(br.readLine());
		}
		setTree();
		
		for(int i=0; i<m+k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1) {
				int index = (int) (Math.pow(2,treeHeight))+b-1;
				change(index,c);
			}else {
				int indexB = (int) (Math.pow(2, treeHeight) + b-1);
				int indexC = (int) (Math.pow(2, treeHeight) + c-1);
				System.out.println(sum(indexB,indexC));
			}
		}	
	}
	
	public static void setTree() {
		int index = tree.length-1;
		while(index > 1) {
			tree[index/2] += tree[index];
			index--;
		}
	}
	
	public static void change(int index, long c) {
		long gap = c - tree[index];
		while(index > 0) {
			tree[index] += gap;
			index /= 2;
		}
	}
	
	public static long sum(int start, int end) {
		long sum = 0;
		while(start <= end) {
			if(start%2 == 1) {
				sum += tree[start];
				start++;
			}
			
			if(end%2 == 0) {
				sum += tree[end];
				end--;
			}
			
			start /= 2;
			end /= 2;
		}
		
		return sum;
	}
}
