<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>单文件上传</title>
    <link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">

    <!-- Custom styles for this template -->
    <link href="${APP_PATH}/css/starter-template.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    #web网页上传图片格式 method="post" <br/>采用post提交 action="/upload" 为提交IP地址 <br/>enctype="multipart/form-data告诉浏览器文件类型
    <form method="post" action="${APP_PATH}/upload" enctype="multipart/form-data">
        <input type="file" name="uploadFile"><br>
        <input type="submit" value="提交">
    </form>
    <br/> <br/> <br/> <br/> <br/>

    #get方法测试 格式为http://localhost:8080/upload_data?datas=需要上传的字符串 <br/> <br/>比如http://localhost:8080/upload_data?datas=111
    111就是需要上传的数据
    <form method="get" action="${APP_PATH}/upload_data" enctype="multipart/form-data">
        <input type="text" name="datas"><br>
        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>