<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>单文件上传</title>
</head>
<body>

#web网页上传图片格式   method="post" 采用post提交  action="/upload" 为提交IP地址  enctype="multipart/form-data告诉浏览器文件类型
<form method="post" action="${APP_PATH}/upload" enctype="multipart/form-data">
    <input type="file" name="uploadFile"><br>
    <input type="submit" value="提交">
</form>



</body>
</html>