<?php
// ð�����򣬶�������

$arr = array(5,6,9,4,7,10,2,8);

for($i = 0; $i < count($arr); $i++)
{
	// $j ��0��ʼ����Ҫ��1
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