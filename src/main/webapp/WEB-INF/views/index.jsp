<%--<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>--%>
<%--<%--%>
<%--String path = request.getContextPath();--%>
<%--String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";--%>
<%--%>--%>

<%--<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">--%>
<%--<html>--%>
<%--<head>--%>
<%--<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css"--%>
<%--integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">--%>
<%--<base href="<%=basePath%>">--%>
<%--<meta charset="utf-8">--%>
<%--<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>
<%--<style type="text/css">--%>
<%--form {--%>
<%--margin: 0px auto;--%>

<%--width: 500px;--%>
<%--padding: 20px;--%>
<%--}--%>
<%--</style>--%>
<%--<title></title>--%>

<%--</head>--%>

<%--<body>--%>


<%--<div id="output"></div>--%>

<%--<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js"--%>
<%--integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"--%>
<%--crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js"--%>
<%--integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"--%>
<%--crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js"--%>
<%--integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"--%>
<%--crossorigin="anonymous"></script>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/font-awesome.min.css">

    <!-- Custom styles for this template -->
    <link href="../../css/starter-template.css" rel="stylesheet">
    <![endif]-->
</head>
<body>

<div class="container">


    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">地质数据采集与实时监测系统</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="data">数据采集</a></li>
                    <li><a href="test">数据上传测试</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </nav>


    <div class="starter-template">
        <h1>滑坡数据采集系统</h1>

        <div >
            <div class="button-row">
                <a href="chart" class="btn btn-primary shake active" role="button">震动数据监测</a>
                <button type="button" class="btn btn-primary fun2">应力数据监测</button>
            </div>
        </div>
        <%--<p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a--%>
        <%--mostly barebones HTML document.</p>--%>
    </div>

</div><!-- /.container -->
<%--<a href="test"><h1>跳转测试</h1></a>--%>

<%--<a href="data"><h1>数据采集</h1></a>--%>

<script src="../../jquery/jquery-2.1.1.min.js"></script>
<script src="../../bootstrap/js/bootstrap.min.js"></script>
</body>
</html>