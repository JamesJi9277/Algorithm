// Java program to demonstrate working of split(regex,
// limit) with 0 limit.
import java.util.*;
public class GFG {
	public static void main(String args[]) {
		GFG g = new GFG();
		String s = "*-A/BC-/AKL";
		System.out.println("Original string is " + s);
		System.out.println("Post to pre is " + g.postToPre(g.preToPost(s)));
		System.out.println("Pre to post is " + g.preToPost(s));
	}
	private String postToPre(String post) {
	    Stack<String> stack = new Stack<>();
	    for (int i = 0; i < post.length(); i++) {
	        char c = post.charAt(i);
	        if (isOps(c)) {
	            StringBuffer sb = new StringBuffer();
	            String s1 = stack.pop();
	            String s2 = stack.pop();
	            sb.append(c);
	            sb.append(s2);
	            sb.append(s1);
	            stack.push(sb.toString());
	        } else {
	            stack.push("" + c);
	        }
	    }
	    return stack.pop();
	}
	private String preToPost(String prefix) {
	    Stack<String> stack = new Stack<>();
	    for (int i = prefix.length() - 1; i >= 0; i--) {
	        char c = prefix.charAt(i);
	        if (isOps(c)) {
	            StringBuffer sb = new StringBuffer();
	            sb.append(stack.pop());
	            sb.append(stack.pop());
	            sb.append(c);
	            stack.push(sb.toString());
	        } else {
	            stack.push("" + c);
	        }
	    }
	    return stack.pop();
	}
	private boolean isOps(char c) {
	    return c == '+' || c == '-' || c == '*' || c == '/';
	}
}
