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
            <table class="table table-striped">
                <thead>
                <tr>
                    <th style="width: 20%;">申报部门</th>
                    <th style="width: 20%;">街镇</th>
                    <th style="width: 20%;">路段名称</th>
                    <th style="width: 30%;">起止路名</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tr id="row0">
                    <td>
                        <select id="UrbanDepNo0" name="UrbanDepNo" style="width:90%">
                            <option value="1">三林城管署</option>
                            <option value="2">港城城管署</option>
                            <option value="3">惠南城管署</option>
                            <option value="4">金桥城管署</option>
                            <option value="5">陆家嘴城管办</option>
                            <option value="6">川沙城管署</option>
                        </select>
                    </td>
                    <td>
                        <input type="text" id="LocNo0" name="LocNo" style="width:90%"/>

                    </td>
                    <td>
                        <input type="text" id="RoadSectionName0" name="RoadSectionName" style="width:90%"/>
                    </td>
                    <td>
                        <input type="text" id="StStartRoad0" name="StStartRoad" style="width:45%"/>--
                        <input type="text" id="EndRoadName0" name="EndRoadName" style="width:45%"/>
                    </td>
                    <td>
                        <input type="button" name="delete" value="删 除" style="width:80px"
                               onclick="deleteSelectedRow(0)"/>

                    </td>
                </tr>
                <tr>
                    <td align="center" colspan="5">
                        <br/>
                        <input type="button" name="insert" value="增加一行" style="width:80px" onclick="insertNewRow()"/>&nbsp&nbsp
                        <input type="button" value=" 保    存 " style="width:80px" onclick="GetValue()"/>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>
