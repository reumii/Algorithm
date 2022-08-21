import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static int tree[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int treeHeight = 0;
		while(n > Math.pow(2, treeHeight)) {
			treeHeight++;
		}
		
		int treeSize = (int) Math.pow(2, treeHeight+1);
		int startIndex = (int) Math.pow(2, treeHeight);
		tree = new int[treeSize];
		Arrays.fill(tree, Integer.MAX_VALUE);
		
		for(int i=0; i<n; i++) {
			tree[startIndex+i] = Integer.parseInt(br.readLine());
		}
		
		setTree();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(getMin(startIndex+a-1, startIndex+b-1));
		}
	}
	
	public static void setTree() {
		int index = tree.length-2;
		while(index > 1) {
			tree[index/2] = Math.min(tree[index], tree[index+1]);
			index -= 2;
		}
	}
	
	public static int getMin(int start, int end) {
		int min = Integer.MAX_VALUE;
		while(start <= end) {
			if(start%2 == 1) {
				min = Math.min(tree[start], min);
				start++;
			}
			
			if(end%2 == 0) {
				min = Math.min(tree[end], min);
				end--;
			}
			
			start /= 2;
			end /= 2;
		}
		return min;
	}
}
