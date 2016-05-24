<?php
 // 排序的另种写法，思想一样，代码有所简化
 // 定义数组
 $arr = array(3,-1,100,5,60);

 // 1 冒泡排序
 function test(&$arr){

	for($i = 0; $i < count($arr)-1; $i++)
	{
		for($j = 0; $j < count($arr) - $i - 1; $j++ )
		{
			if($arr[$j] > $arr[$j + 1])
			{
				$tmp = $arr[$j];
				$arr[$j] = $arr[$j + 1];
				$arr[$j + 1] = $tmp;
			}		
		}	
	}
	return $arr;
 }

 // 2 选择排序
 function selSort(&$arr)
 {
	for($i = 0; $i < count($arr); $i++)
	{
		for($j = $i + 1; $j < count($arr); $j++)
		{
			if($arr[$i] > $arr[$j])
			{
				$tmp = $arr[$i];
				$arr[$i] = $arr[$j];
				$arr[$j] = $tmp;
			}		
		}
	}

	return $arr;
 }

 // 3 插入排序
 function insertSort(&$arr)
 {
	for($i = 1; $i < count($arr); $i++)
	{
		for($j = $i - 1; $j >= 0; $j--)
		{
			if($arr[$i] < $arr[$j])
			{
				$tmp = $arr[$i];
				$arr[$i] = $arr[$j];
				$arr[$j] = $tmp;
			}		
		}
	}

	return $arr;
 }

 //$res = selSort($arr);
 
 $res = insertSort($arr);

 var_dump($res);

?>