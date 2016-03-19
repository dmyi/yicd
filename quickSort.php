<?php

// 快速排序demo  yi
$arr = array(6,5,7,4,10);

function test($arr){

	if(count($arr) <= 1) return $arr;
	
	// 定义两个数组
	$left = $right = array();
	for($i = 1 ; $i < count($arr); $i++){
		// 遍历数组
		if($arr[$i] < $arr[0])
		{
			$left[] = $arr[$i];
			
		}else{
			$right[] = $arr[$i];
		}		
	}

	$left = test($left);
	$right = test($right);
	return array_merge ( $left,array($arr[0]),$right );
}

$res = test($arr);

echo '<pre>';
var_dump($res);
echo '</pre>';

// php一个数组可以赋值给一个变量吗 ，赋值后变量类型是什么呢?

// 递归调用示意图 数字是执行顺序，> <是执行返回方向，v是执行顺序
// 数组长度小于等于1则返回

/****************************************************************/
/*								   >>>	2 |---------|			*/
/*					1 |----------		 |	 left 4				*/
/*	|---------		 |left 4	|  3  left| : 4	   |			*/
/*	|	|	 |	>>>	 |	v		|  <<<	  -------- |			*/
/*	|left 5 4|		 |arr[0] 5	5			v					*/
/*	|	|  	7left:4,5 |	v		|	>>>	 4| --------|			*/
/*	|	|/	 |		 |righ null |5 righ:null righ null			*/
/*	|	v	 |	<<<	 ----------	|		 |	v	   |		    */
/*	|arr[0] 6|			6 v return 4 5	<<<	---------			*/
/*	|	|	 |		8											*/
/*	|	|	 |	>>>	|-------|     >>>    9 |---------|			*/
/*	|	v	 |		left null  10left:null  |left null			*/
/*	|righ 7 10		|	v	|			  |	   	     |			*/
/*	|		 |	<<<	|arr[0]	7	7<<<      --------- |           */
/*  |   v    14 righ:7,10 v     |          11       v           */
/*	----|-----		righ  10|  >>>12 righ: 10|--------|			*/
/*		|			---------		      |righ 10	|			*/
/*	15 return 4,5,6,7,10	13 return 7,10<<<|	v	|		    */
/*										  ----------|			*/
/*																*/
/****************************************************************/


?>