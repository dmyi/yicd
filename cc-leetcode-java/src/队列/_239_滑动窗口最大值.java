package 队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * @date   2021年2月16日 下午2:58:56
 * @author cc
 *
 */
public class _239_滑动窗口最大值 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length == 0 || k < 1) return new int[0];
		if(k == 1) return nums;
		
		int[] maxes = new int[nums.length - k + 1];
		Deque<Integer> deque = new LinkedList<Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
				deque.pollLast();
			}
			
			deque.offerLast(i);
			
			int w = i - k + 1;
			if(w < 0) continue;
			if(deque.peekFirst() < w) {
				deque.pollFirst();
			}
			maxes[w] = nums[deque.peekFirst()];
		}
		
		return maxes;
    }
}


public int[] maxSlidingWindow_1(int[] nums, int k) {
	if(nums == null || nums.length == 0 || k < 1) return new int[0];
	if(k == 1) return nums;
	
	int[] maxes = new int[nums.length - k + 1];
	// 双端队列中存储的是索引
	Deque<Integer> deque = new LinkedList<Integer>();
	
	for(int i = 0; i < nums.length; i++) {
		while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
			deque.pollLast();
		}
		
		deque.offerLast(i);
		int w = i - k + 1;
		if(w < 0) continue;
		if(deque.peekFirst() < w) {
			deque.pollFirst();
		}
		
		maxes[w] = nums[deque.peekFirst()];
	}
	
	return maxes;
}
