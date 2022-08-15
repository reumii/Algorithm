import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static HashMap<String, Node> map;
	public static Queue<String> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String node[][] = new String[n][3];
		map = new HashMap<String, Node>();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String root = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			map.put(root, new Node(left, right));
		}
		
		q = new LinkedList();
		q.add("A");
		System.out.println(preorder());
		System.out.println(inorder());
		System.out.println(postorder());
	}
	
	public static String preorder() {
		Stack<String> stack = new Stack();
		stack.add("A");
		String result = "A";
		
		while(!stack.isEmpty()) {
			Node now = map.get(stack.peek());
			if(!now.left.equals(".") && result.indexOf(now.left) < 0) {
				result += now.left;
				stack.add(now.left);
			}else if(!now.right.equals(".") && result.indexOf(now.right) < 0) {
				result += now.right;
				stack.add(now.right);
			}else {
				stack.pop();
			}
		}
		
		return result;
	}
	
	public static String inorder() {
		Stack<String> stack = new Stack();
		stack.add("A");
		String result = "";
		
		while(!stack.isEmpty()) {
			Node now = map.get(stack.peek());
			if(!now.left.equals(".") && result.indexOf(now.left) < 0) {
				stack.add(now.left);
			}else {
				result += stack.pop();
				if(!now.right.equals(".") && result.indexOf(now.right) < 0) {
					stack.add(now.right);
				}
			}
		}
		
		return result;
	}
	
	public static String postorder() {
		Stack<String> stack = new Stack();
		stack.add("A");
		String result = "";
		
		while(!stack.isEmpty()) {
			Node now = map.get(stack.peek());
			if(!now.left.equals(".") && result.indexOf(now.left) < 0) {
				stack.add(now.left);
			}else if(!now.right.equals(".") && result.indexOf(now.right) < 0) {
				stack.add(now.right);
			}else {
				result += stack.pop();
			}
		}
		
		return result;
	}

	static class Node{
		String left;
		String right;

		Node(String left,String right) {
			this.left = left;
			this.right = right;
		}
	}
}
