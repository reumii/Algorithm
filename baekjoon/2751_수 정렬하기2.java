import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer a[] = new Integer[n];
	
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(a);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(Integer num : a) {
			bw.write(num + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
