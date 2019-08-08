<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <!-- The mobile navbar-toggle button can be safely removed since you do not need it in a non-responsive implementation -->
            <a class="navbar-brand" href="${APP_PATH}/index" style="color: black;font-size: 26px;">地质数据采集系统</a>
        </div>
        <!-- Note that the .navbar-collapse and .collapse classes have been removed from the #navbar -->
        <div id="navbar">
            <ul class="nav navbar-nav">
                <li class="datas">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">数据监测 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${APP_PATH}/t_page">温度</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">湿度</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">加速度</a></li>

                    </ul>
                </li>
                <li class="change_school">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">学校切换 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">南方科技大学</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">兰州大学</a></li>
                    </ul>
                </li>

                <li class="datas">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">数据测试 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${APP_PATH}/upload_test">数据上传测试</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="push_page">推送功能</a></li>
                        <li><a href="current_data">数据实时监测功能</a></li>
                    </ul>
                </li>

            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="./">当前监测地:兰州 <span class="sr-only"></span></a></li>
            </ul>
            <%--<form class="navbar-form navbar-left">--%>
            <%--<div class="form-group">--%>
            <%--<input type="text" class="form-control" placeholder="Search">--%>
            <%--</div>--%>
            <%--<button type="submit" class="btn btn-default">Submit</button>--%>
            <%--</form>--%>
            <%--<ul class="nav navbar-nav navbar-right">--%>
            <%--<li><a href="#">Link</a></li>--%>
            <%--<li><a href="#">Link</a></li>--%>
            <%--<li><a href="#">Link</a></li>--%>
            <%--</ul>--%>
        </div><!--/.nav-collapse -->


    </div>
</nav>