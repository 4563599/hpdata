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

    <link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">

    <!-- Custom styles for this template -->
    <link href="${APP_PATH}/css/starter-template.css" rel="stylesheet">
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

        <div>
            <div class="button-row">
                <a href="chart" class="btn btn-primary shake active" role="button">震动数据监测</a>
                <button type="button" class="btn btn-primary fun2">应力数据监测</button>
                <div class="button-row">

                    <div class="form-group">
                        <label for="jpush_test">推送数据测试</label>
                        <input type="text" class="form-control" id="jpush_test" placeholder="滑坡概率>90,请注意!">
                        <button class="btn btn-default" id="test_jpush_btn">提交</button>
                    </div>
                </div>
            </div>
        </div>
        <%--<p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a--%>
        <%--mostly barebones HTML document.</p>--%>
    </div>

</div><!-- /.container -->
<%--<a href="test"><h1>跳转测试</h1></a>--%>

<%--<a href="data"><h1>数据采集</h1></a>--%>
<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#test_jpush_btn").click(function(){
            var content = $("#jpush_test").val();
            $.ajax({
                url: "${APP_PATH}/jpush/push.do",
                data: {'content': content},
                dataType: 'JSON',
                type: 'post',
                success: function (data) {
                    if (data.success == true) {
                        alert('成功');
                    } else {
                        alert('失败');
                    }
                }
            });
        });
    });
</script>

</body>
</html>