<?php
 // ���������д����˼��һ��������������
 // ��������
 $arr = array(3,-1,100,5,60);

 // 1 ð������
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

 // 2 ѡ������
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

 // 3 ��������
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