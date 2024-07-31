<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

body {
	width: 100%;
	height: 100vh;
}

.container {
	display: flex;
	height: 100%;
	flex-direction: row;
	background-color: blue;
}

.item {
	flex-grow: 1;
	border: 1px solid black;
	text-align: center;
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>


</head>
<body>

	<div class="container">
		<div class="item ">item1</div>
		<div class="item ">item2</div>
		<div class="item ">item3</div>
	</div>

</body>
</html>