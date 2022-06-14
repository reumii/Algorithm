import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException  {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String num = "";
		boolean isMinus = false;
		int answer = 0;
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c == '-' || c == '+') {
				if(isMinus) {
					answer -= Integer.parseInt(num);
				}else if(c == '-') {
					answer += Integer.parseInt(num);
					isMinus = true;
				}else if(c == '+') {
					answer += Integer.parseInt(num);
				}
				num = "";
			} else { // 숫자인 경우
				num += c;
			}
		}
		
		if(isMinus) {
			answer -= Integer.parseInt(num);
		}else {
			answer += Integer.parseInt(num);
		}
		System.out.println(answer);
	}	
}
