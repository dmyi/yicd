package 递归;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/hanota-lcci/
 * @date   2020年11月7日 下午4:06:10
 * @author cc
 *
 */

//在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
//(1) 每次只能移动一个盘子;
//(2) 盘子只能从柱子顶端滑出移到下一根柱子;
//(3) 盘子只能叠在比它大的盘子上。
//
//请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
//
//你需要原地修改栈。
//
//示例1:
//
// 输入：A = [2, 1, 0], B = [], C = []
// 输出：C = [2, 1, 0] // 说明最后一个是最大的
//示例2:
//
// 输入：A = [1, 0], B = [], C = []
// 输出：C = [1, 0]
//提示:
//
//A中盘子的数目不大于14个。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/hanota-lcci
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _面试题08_06汉诺塔问题 {
	public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {

		move(A.size(), A, B, C);
    }

    public void move(int n, List<Integer> p1, List<Integer> p2, List<Integer> p3) {
		if(n == 1) {
			p3.add(p1.remove(p1.size() -1));
			return;
		}
		
		move(n -1, p1, p3, p2);
		p3.add(p1.remove(p1.size() -1));
		move(n-1, p2, p1, p3);
	}
}
