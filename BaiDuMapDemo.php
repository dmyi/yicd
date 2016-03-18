<?php
//  2016.3.18 yi
header('Content-type:text/html;charset=utf-8');

// 设置地址
$addr = 'your addr'; 
$tel = 'your tel'; 
$name = 'your company'; 

// ak use your baidu ak
$str = file_get_contents('http://api.map.baidu.com/geocoder/v2/?address='.$addr.'&output=json&ak=your ak');
$res = json_decode ( $str );

$lng = $res->result->location->lng; // 经度
$lat = $res->result->location->lat; // 纬度

$city = '惠州市'; // 城市

?>
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />  
<title>JSAPI与URLAPI结合示例</title>  
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.5&ak=your ak"></script>  
<script src="http://d1.lashouimg.com/static/js/release/jquery-1.4.2.min.js" type="text/javascript"></script>  
<style type="text/css">  
html,body{  
    width:700px;  
    height:600px;
    margin:0;
    overflow:hidden;  
    }
</style>  
</head>  
<body>  
    <div style="width:700px;height:600px;border:1px solid gray" id="container"></div>  
</body>  
</html>  
<script type="text/javascript">  
    var map = new BMap.Map("container");  
    map.centerAndZoom(new BMap.Point(116.403884,39.914887), 13);  
    map.enableScrollWheelZoom();  
    var marker=new BMap.Marker(new BMap.Point(<?php echo $lng; ?>,<?php echo $lat; ?>));  
    map.addOverlay(marker);  
    var licontent="<b><?php echo $name; ?></b><br>";  
        licontent+="<span><strong>地址：</strong><?php echo $addr; ?></span><br>";  
        licontent+="<span><strong>电话：</strong><?php echo $tel; ?></span><br>";  
        licontent+="<span class=\"input\"><strong>起点</strong><input class=\"outset\" type=\"text\" name=\"origin\" value=\"\"/><input class=\"outset-but\" type=\"button\" value=\"公交\" onclick=\"gotobaidu(1)\" /><input class=\"outset-but\" type=\"button\" value=\"驾车\"  onclick=\"gotobaidu(2)\"/><a class=\"gotob\" href=\"url=\"http://api.map.baidu.com/direction?destination=latlng:"+marker.getPosition().lat+","+marker.getPosition().lng+"|name:<?php echo $name; ?>"+"®ion=<?php echo $city; ?>"+"&output=html\" target=\"_blank\"></a></span>";
 
    var hiddeninput="<input type=\"hidden\" value=\""+'<?php echo $city; ?>'+"\" name=\"region\" /><input type=\"hidden\" value=\"html\" name=\"output\" /><input type=\"hidden\" value=\"driving\" name=\"mode\" /><input type=\"hidden\" value=\"latlng:"+marker.getPosition().lat+","+marker.getPosition().lng+"|name:<?php echo $name; ?>"+"\" name=\"destination\" />";
 
    var content1 ="<form id=\"gotobaiduform\" action=\"http://api.map.baidu.com/direction\" target=\"_blank\" method=\"get\">" + licontent +hiddeninput+"</form>";
   
    var opts1 = { width: 300 };  
       
    var  infoWindow = new BMap.InfoWindow(content1, opts1);  
    marker.openInfoWindow(infoWindow);  
    marker.addEventListener('click',function(){
        marker.openInfoWindow(infoWindow);
    });  
     
    function gotobaidu(type)  
    {  
        if($.trim($("input[name=origin]").val())=="")  
        {  
            alert("请输入起点！");  
            return;  
        }else{  
            if(type==1)  
            {  
                $("input[name=mode]").val("transit");  
                $("#gotobaiduform")[0].submit();  
            }else if(type==2)  
            {      
                $("input[name=mode]").val("driving");          
                $("#gotobaiduform")[0].submit();  
            }  
        }  
    }    
</script>