<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <style type="text/css">
        form {
            margin: 0px auto;

            width: 500px;
            padding: 20px;
        }
    </style>
    <title></title>

</head>

<body>

<a href="test">跳转测试</a>

<a href="data">采集数据</a>

<div id="output"></div>
</body>
</html>