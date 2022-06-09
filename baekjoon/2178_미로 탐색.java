import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int maze[][] = new int[n][m];
		int[][] cnt = new int[n][m];
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<m; j++) {
				maze[i][j] = Character.getNumericValue(line.charAt(j));
			}
		}
		
		int x[] = {0, 0, -1, 1};
		int y[] = {-1, 1, 0, 0};
		Queue<int[]> queue = new LinkedList();
		
		queue.add(new int[] {0,0});
		maze[0][0] = 0;
		cnt[0][0] = 1;
		
		Loop1 :
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			int count = cnt[q[0]][q[1]];
			for(int i=0; i<4; i++) {
				int mazeX = q[0] + x[i];
				int mazeY = q[1] + y[i];
				if(mazeX>=0 && mazeX<n && mazeY>=0 && mazeY<m) {
					if(mazeX == n-1 && mazeY == m-1) {
						cnt[n-1][m-1] = count + 1;
						break Loop1;
					}else if(maze[mazeX][mazeY] == 1) {
						maze[mazeX][mazeY] = 0;
						cnt[mazeX][mazeY] = count + 1;
						queue.add(new int[] {mazeX,mazeY});
					}
				}
			}
		}
		
		System.out.println(cnt[n-1][m-1]);
	}	
}
