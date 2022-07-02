import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException  {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String numStr[] = s.split("-");
		
		int answer = sum(numStr[0]);
		for(int i=1; i<numStr.length; i++) {
			int sum = sum(numStr[i]);
			if(sum < 0) {
				answer += sum;
			}else {
				answer -= sum;
			}
		}
		System.out.println(answer);
	}
	
	public static int sum(String str) {
		String plusNum[] = str.split("\\+");
		int sum = 0;
		for(int i=0; i<plusNum.length; i++) {
			sum += Integer.parseInt(plusNum[i]);
		}
		return sum;
	}
}
