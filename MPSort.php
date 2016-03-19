<?php
// 冒泡排序，定义数组

$arr = array(5,6,9,4,7,10,2,8);

for($i = 0; $i < count($arr); $i++)
{
	// $j 从0开始所以要减1
	for($j = 0; $j < (count($arr) - $i -1); $j++ )
	{
		if($arr[$j] > $arr[$j+1]){
			
			$temp = $arr[$j];
			$arr[$j] = $arr[$j+1];
			$arr[$j+1] = $temp;
		}	
	}
}

var_dump($arr);

?>