<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Information</title>
    <style type="text/css">
    
body{
background-color: #f0f0f0;
display: flex;
flex-direction: column;
margin: 0;
padding: 0;

}
header{
background-color: black;
color: white;
display: flex;
justify-content: space-between;
align-items: center;
width: 100%;

}

h2{
margin-left: 20px;
}

ul{
list-style-type: none;
display: flex;
}

li{
margin-right: 20px;
}
	
footer{
	background-color: #f0f0f0;
	display:flex;
	padding: 20px;
	border-radius: 8px;
	height:70vh;
	justify-content:center;
	width: 100%;
	
	}
.cm{

	align-content:flex-end;
	width: 300px;	
	
}
.homeMainDiv{
	
	display: flex;
	width: 1500px;
	flex-direction: column;

}
.homeChildDiv{
	display: flex;
	
}
  
 
    }
    
    
    </style>
</head>
<body>
    
    
    <div class = "category">
    <h1>My</h1>
    <p>내 정보 조회</p>
    <p>비밀번호 변경</p>
    <p>휴학 신청<p>
    <p>휴학 내역 조회</p>
    <p>등록금 내역 조회</p>
    <p>등록금 납부 고지서</p>
    </div>
    
    <h1>내 정보 조회</h1>
    <div class = information>
    <table border="1">
    	<th>학번</th>
    	<td>202400001</td>
    	<th>소속</th>
    	<th>202400001</th>
    </table>
    </div>
    
    
    
</body>
</html>
