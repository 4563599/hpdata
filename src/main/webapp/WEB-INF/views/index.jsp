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
    <style>
        span {
            color: red;
        }
    </style>
</head>
<body>
<div class="container">
    <%@include file="/WEB-INF/views/common/header.jsp" %>

    <!-- Jumbotron -->
    <div class="jumbotron">
        <h2>滑坡及地质数据采集系统</h2>
        <p class="lead">
            基于数据的地质灾害监测预警平台，是在将各种专业地质灾害监测设备与物联网和通信技术的集成的基础上，构建地质灾害监测、分析、预报、预警和应急服务于一体的信息化、智能化和可视化服务平台，实现灾前、灾中、灾后全生命周期动态管理，全面提升相关单位对突发性地质灾害的分析、预警、处置和服务的能力，为政府相关部门进行地质环境与地质灾害决策管理和社会服务提供技术保障.</p>

        <div class="alert alert-danger" role="alert" style="width: 50%">当前滑坡概率 18%</div>

        <div class="progress">
            <div class="progress-bar progress-bar-info progress-bar-striped" role="progressbar" aria-valuenow="18"
                 aria-valuemin="0" aria-valuemax="100" style="width: 18%">
                <span class="sr-only">18% Complete</span>
            </div>
        </div>
    </div>

    <!-- Example row of columns -->
    <div class="row">
        <div class="col-lg-3">
            <h2><span>温度</span>数据监测</h2>
            <p class="text-danger">采用VI子程序技术作为温度值的输入，设置了温度值的输出模式（摄氏或华氏），输出数据统计信息包括最大值、最小值、平均值，运行后的动态显示到界面文本.</p>
            <p><a class="btn btn-primary" href="${APP_PATH}/t_page" role="button">点击查看详细数据 &raquo;</a></p>
        </div>
        <div class="col-lg-3">
            <h2><span>湿度</span>数据监测</h2>
            <p class="text-danger">采用VI子程序技术作为湿度值的输入，设置了湿度的输出模式，输出数据统计信息包括最大值、最小值、平均值，运行后的动态显示到界面文本.</p>
            <p><a class="btn btn-primary" href="${APP_PATH}/Humidity1_page" role="button">点击查看详细数据 &raquo;</a></p>
        </div>
        <div class="col-lg-3">
            <h2><span>孔隙压</span>数据监测</h2>
            <p class="text-danger">采用VI子程序技术作为孔隙压的输入，设置了空隙压的输出模式，输出数据统计信息包括最大值、最小值、平均值，运行后的动态显示到界面文本.</p>
            <p><a class="btn btn-primary" href="${APP_PATH}/Pressure1_page" role="button">点击查看详细数据 &raquo;</a></p>
        </div>

        <div class="col-lg-3">
            <h2><span>加速度</span>数据监测</h2>
            <p class="text-danger">采用VI子程序技术作为加速度的输入，设置了空隙压的输出模式，输出数据统计信息包括最大值、最小值、平均值，运行后的动态显示到界面文本.</p>
            <p><a class="btn btn-primary" href="${APP_PATH}/A1_page" role="button">点击查看详细数据 &raquo;</a></p>
        </div>
    </div>


    <div class="row">
        <div class="col-lg-3">
            <h2><span>降雨量</span>数据监测</h2>
            <p class="text-danger">采用VI子程序技术作为降雨量的输入，设置了温度值的输出模式（摄氏或华氏），输出数据统计信息包括最大值、最小值、平均值，运行后的动态显示到界面文本.</p>
            <p><a class="btn btn-primary" href="${APP_PATH}/rainfall_page" role="button">点击查看详细数据 &raquo;</a></p>
        </div>
        <div class="col-lg-3">
            <h2><span>光照度</span>数据监测</h2>
            <p class="text-danger">采用VI子程序技术作为光照度的输入，设置了湿度的输出模式，输出数据统计信息包括最大值、最小值、平均值，运行后的动态显示到界面文本.</p>
            <p><a class="btn btn-primary" href="${APP_PATH}/illuminance_page" role="button">点击查看详细数据 &raquo;</a></p>
        </div>
        <div class="col-lg-3">
            <h2><span>电极电势</span>数据监测</h2>
            <p class="text-danger">采用VI子程序技术作为电极电势的输入，设置了空隙压的输出模式，输出数据统计信息包括最大值、最小值、平均值，运行后的动态显示到界面文本.</p>
            <p><a class="btn btn-primary" href="${APP_PATH}/V1_page" role="button">点击查看详细数据 &raquo;</a></p>
        </div>

        <div class="col-lg-3">
            <h2><span>地表位移</span>数据监测</h2>
            <p class="text-danger">采用VI子程序技术作为地表位移的输入，设置了空隙压的输出模式，输出数据统计信息包括最大值、最小值、平均值，运行后的动态显示到界面文本.</p>
            <p><a class="btn btn-primary" href="${APP_PATH}/displacement1_page" role="button">点击查看详细数据 &raquo;</a></p>
        </div>
    </div>


</div><!-- /.container -->
<%--<a href="test"><h1>跳转测试</h1></a>--%>

<%--<a href="data"><h1>数据采集</h1></a>--%>
<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#test_jpush_btn").click(function () {
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