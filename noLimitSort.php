<?php

// 无限极分类，循环+递归的用法
header('Content-type: text/html; charset = utf-8');

$lists = Array();

$lists[0] = Array('1','数码','0');
$lists[1] = Array('2','家电','0');
$lists[2] = Array('3','手机','1');
$lists[3] = Array('4','电脑','1');
$lists[4] = Array('5','小米','3');
$lists[5] = Array('6','华为','3');
$lists[6] = Array('7','联想','4');
$lists[7] = Array('8','神舟','4');
$lists[8] = Array('9','空调','2');
$lists[9] = Array('10','冰箱','2');
$lists[10] = Array('11','格力','9');
$lists[11] = Array('12','海尔','9');
$lists[12] = Array('13','星星','10');
$lists[13] = Array('14','新飞','10');

function NoLimitSort($arr,$pid = 0,$lev = 0)
{
	// 定义一个静态变量存放数组
	static $list;

	// 循环数组

	for($i = 0 ; $i < count($arr); $i++)
	{
		// 递归出口，判断是否有该分类的下级分类，若无跳出递归
		if($arr[$i][2] == $pid)
		{
			$arr[$i]['lev'] = $lev;
			// 存入静态数组
			$list[] = $arr[$i];

			// 遍历该数组下还有没元素 若没有程序会进入下一层循环
			NoLimitSort($arr, $arr[$i][0], $lev+1);
		}
	}

	// 返回数组
	
	return $list;
}

$arr = NoLimitSort($lists);

echo '<pre>';
var_dump($arr);
echo '</pre>';

?>