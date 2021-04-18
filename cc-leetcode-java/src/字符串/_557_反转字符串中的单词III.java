package 字符串;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * @date   2021年2月7日 上午7:15:46
 * @author cc
 *
 */
public class _557_反转字符串中的单词III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String reverseWords(String s) {
		StringBuilder temp = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == ' ') {
				sb.append(temp.reverse());
				sb.append(c);
				temp = new StringBuilder();
				
			} else {
				temp.append(c);
			}
		}
		
		sb.append(temp.reverse());
		return sb.toString();
		
    }

}
