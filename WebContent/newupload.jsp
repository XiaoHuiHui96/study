<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上传</title>
</head>
<body>
<form method="post" action="newupload" enctype="multipart/form-data">
	file<input type="file" name="file" id="file"/><br/>
	destination<input type="text" value="/tmp" name="lujin"/><br/>
	<input type="submit" value="upload" name="upload" id="upload"/>
</form>
</body>
</html>33