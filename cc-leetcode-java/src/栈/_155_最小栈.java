package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * @date   2021年2月16日 上午10:17:38
 * @author cc
 *
 */


public class _155_最小栈 {

}

class MinStack {

	private Stack<Integer> stack;
	private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
    	stack = new Stack<Integer>();
    	minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
    	
    	if(stack.isEmpty()) {	
    		stack.push(x);
    		minStack.push(x);
    	} else {
    		stack.push(x);
    		minStack.push(Math.min(x, minStack.peek()));
    	}
    }
    
    public void pop() {
    	stack.pop();
    	minStack.pop();
    }
    
    public int top() {
    	return stack.peek();
    }
    
    public int getMin() {
    	return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
