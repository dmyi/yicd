package 栈;

import java.util.Stack;

public class _20_有效的括号 {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if(c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if(stack.isEmpty()) return false;
				char left = stack.pop();
				if(left == '(' && c != ')') return false;
				if(left == '{' && c != '}') return false;
				if(left == '[' && c != ']') return false;
			}
		}
		// 栈如果不为空也是无效的
		return stack.isEmpty();
    }
}
