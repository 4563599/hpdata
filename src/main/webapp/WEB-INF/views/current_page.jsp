<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,height=device-height">
    <title>基础折线图</title>
    <style>::-webkit-scrollbar {
        display: none;
    }

    html, body {
        overflow: hidden;
        height: 100%;
        margin: 0;
    }</style>

    <link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">

    <!-- Custom styles for this template -->
    <link href="${APP_PATH}/css/starter-template.css" rel="stylesheet">
</head>
<body>
<%@include file="/WEB-INF/views/common/header.jsp" %>
<script>/*Fixing iframe window.innerHeight 0 issue in Safari*/
document.body.clientHeight;</script>
<script src="https://gw.alipayobjects.com/os/antv/pkg/_antv.g2-3.5.1/dist/g2.min.js"></script>
<script src="https://gw.alipayobjects.com/os/antv/pkg/_antv.data-set-0.10.1/dist/data-set.min.js"></script>
<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
<div class="container">
    <div class="button-row">
        <div class="form-group">
            <label for="jpush_test">推送数据测试</label>
            <input type="text" class="form-control" id="jpush_test" placeholder="滑坡概率>90,请注意!">
            <button class="btn btn-default" id="test_jpush_btn">提交</button>
        </div>
    </div>
</div>
</body>
</html>
