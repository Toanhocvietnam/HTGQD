<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Thêm bài báo</title>
<meta charset="utf-8">
<title>Insert title here</title>
	<script type="text/javascript">
	
	function Search(){
		
		var xhttp;
		var search = document.myForm.search.value;
		
		if(search != "")
			
			{
			var url="Search?search="+search;
			
			if(window.XMLHttpRequest){
				xhttp = new XMLHttpRequest();
			}
			else{
				xhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			
			xhttp.onreadystatechange = function(){
				if(xhttp.readyState == 4){
					
					var data = xhttp.responseText;
					
					document.getElementById("resultsearch").innerHTML = data;
				}
			}
			
			xhttp.open("GET",url,true);
			xhttp.send();
			
		}
		
		else{
			document.getElementById("searchBox").innerHTML ="";
		}
		
	}
	function AddAuthor(){
		
		var xhttp;
		var search = document.myForm.search.value;
		
		if(search != "")
			{
			var url="Search";
			var data= "email"+search;
			
			if(window.XMLHttpRequest){
				xhttp = new XMLHttpRequest();
			}
			else{
				xhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			
			xhttp.onreadystatechange = function(){
				if(xhttp.readyState == 4){
					
					var data = xhttp.responseText;
					document.getElementById("added").innerHTML = data;
					document.getElementById("resultsearch").innerHTML = "";
				}
			}
			
			xhttp.open("POST",url,true);
			 xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xhttp.send("email=" + search);
			
		}
		
		else{
			document.getElementById("resultsearch").innerHTML ="";
		}
		
	}
	
	
	</script>
</head>
<body>
	<form action="/HTGQD/ThemBaiBao" method="POST" name="myForm">
		<input type="checkbox" name="LinhVuc" value="Blockchain">Blockchain
		<br/>
		<input type="checkbox" name="LinhVuc" value="Cơ sở dữ liệu">Cơ sở dữ liệu
		<br/>
		<input type="checkbox" name="LinhVuc" value="Trí tuệ nhân tạo">Trí tuệ nhân tạo
		<br/>
		<input type="checkbox" name="LinhVuc" value="An toàn thông tin">An toàn thông tin
		<br/>
		<input type="checkbox" name="LinhVuc" value="Web">Web
		<br/>
		<input type="checkbox" name="LinhVuc" value="Công nghệ phần mềm">Công nghệ phần mềm
		<br/>
		<input type="checkbox" name="LinhVuc" value="Khoa học máy tính">Khoa học máy tính
		<br/>
		<input type="checkbox" name="LinhVuc" value="Hệ thống thông tin">Hệ thống thông tin
		<br/>
		<input type="checkbox" name="LinhVuc" value="Android/IOS">Android/IOS
		<br/>
		
		<h4>Tên bài báo</h4>
		<input type="text"  name="TenBB"/>
		<h4>Nôi dung</h4>
		<input type="text"  name="NoiDung"/>
		
		<h4>Đồng tác giả</h4>
		<input type="text"  name="search" id="searchBox"  onkeyup="Search()" /><button type="button" onClick="AddAuthor()">Thêm</button>
		<div id="added"></div>
		<div  id="resultsearch"></div>
		
		<input type="submit" value="Submit" />
	</form>
</body>
</html>