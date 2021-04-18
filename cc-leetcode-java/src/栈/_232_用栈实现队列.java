package 栈;

import java.util.Stack;

public class _232_用栈实现队列 {
	// 支持泛型
	Stack<Integer> inStack;
	Stack<Integer> outStack;
	
    /** Initialize your data structure here. */
    public _232_用栈实现队列() {
    	inStack = new Stack<>();
    	outStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	inStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	checkOutStack(); 
    	return outStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
    	checkOutStack();
    	return outStack.peek();
    }
    
    private void checkOutStack() {
    	if(outStack.isEmpty()) {
    		while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());				
			}
    	} 
	}
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	return inStack.isEmpty() && outStack.isEmpty();
    }
}
