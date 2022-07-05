import java.io.*;
import java.util.*;

public class Main {
	public static int bottle[] = new int[3];
	public static boolean visited[][] = new boolean[201][201];
	public static TreeSet<Integer> answer = new TreeSet();
	public static void main(String[] args) throws IOException  {
		Scanner sc = new Scanner(System.in);
		bottle[0] = sc.nextInt();
		bottle[1] = sc.nextInt();
		bottle[2] = sc.nextInt();
		
		int water[] = {0,0,bottle[2]};
		dfs(water);
		
		for(int a : answer) {
			System.out.print(a + " ");
		}
	}
	
	public static void dfs(int[] water) {
		visited[water[0]][water[1]] = true;
		if(water[0] == 0) {
			answer.add(water[2]);
		}
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(i != j && water[i] > 0 && water[j] < bottle[j]) {
					int over = water[i] + water[j] - bottle[j];
					int now[] = water.clone();
					if(over > 0) {
						now[j] = bottle[j];
						now[i] = over;
					}else {
						now[j] += now[i];
						now[i] = 0;
					}
					
					if(!visited[now[0]][now[1]]) {
						dfs(now);
					}	
				}
			}
		}
	}
}
