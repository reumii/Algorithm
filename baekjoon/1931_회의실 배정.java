import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] m = new int[n][2];
		for(int i=0; i<n; i++) {
			m[i][0] = sc.nextInt(); //시작시간
			m[i][1] = sc.nextInt(); //종료시간
		}
		
		Arrays.sort(m ,(o1,o2)->{
			if(o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}else {
				return o1[1] - o2[1];
			}
		});
		
		int answer = 0;
		int time = 0;
		for(int i=0; i<n; i++) {
			if(m[i][0] >= time) {//시작 시간이 끝난 시간 이후일때
				answer++; // 회의 진행
				time = m[i][1]; // 끝난 시간 셋팅
			}
		}
		System.out.println(answer);
	}	
}
