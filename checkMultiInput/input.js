// js函数 

//实现参数的添加和删除
function addCan(n){
	$(".can"+n).append($(".canlist"+n+":first").clone(true));
	$(".canlist"+n+":last input").val(" "); // 这样写法可以获取最后一个input的值，并加以修改，用id不行，因为id要唯一
	$(".canlist"+n+":last textarea").val(" "); // 清空
};
function delCan(n){
	if(!($(".canlist"+n).length == 1)){
		$(".canlist"+n+":last").remove();
	}
};

// 检查多个同名标签是否为空的函数  若要修改，为空就不能提交 2016.3.14
function checkKong(tag,loop,arr){
	
	var obj = $(tag);
	var flag = 1;
	// 循环
	for(var i =0; i<obj.length; i++){

    	// if(obj.eq(i).val() == ''){
    	if(obj.eq(i).val().length <= 1){
    		flag = 0;
    		if(i % loop == 0){
    			alert(arr[0]);			
     			break; // 跳出循环
    		}else{
    			alert(arr[i % loop]);			
     			break;
    		}
    	}
	}
	
	return flag;
}

// 判断第一个不为空，其它则不为空
function checkKong2(tag,loop,arr){
	
	var obj = $(tag);
	var res = 2;
	// 循环
	for(var i =0; i<obj.length; i++){

		// 调用判断为空的函数 就是要填该选项全部不能为空
    	if(obj.eq(i).val().length > 1 && (i % loop == 0)){
    		res = checkKong(tag,loop,arr);

    		// 跳出循环
    		break;
    	}
	}
	
	return res;
}


