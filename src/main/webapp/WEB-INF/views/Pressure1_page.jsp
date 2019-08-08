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
<script>/*Fixing iframe window.innerHeight 0 issue in Safari*/
document.body.clientHeight;</script>
<script src="https://gw.alipayobjects.com/os/antv/pkg/_antv.g2-3.5.1/dist/g2.min.js"></script>
<script src="https://gw.alipayobjects.com/os/antv/pkg/_antv.data-set-0.10.1/dist/data-set.min.js"></script>
<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.15.3/dist/bootstrap-table.min.css">
<!-- Latest compiled and minified JavaScript -->
<script src="https://unpkg.com/bootstrap-table@1.15.3/dist/bootstrap-table.min.js"></script>
<!-- Latest compiled and minified Locales -->
<script src="https://unpkg.com/bootstrap-table@1.15.3/dist/locale/bootstrap-table-zh-CN.min.js"></script>
<div class="container">
    <%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <div id="mountNode"></div>
    <table id="table" style="overflow: auto"></table>
    <script>

        $(function () {
            loadData(1);
        });

        function loadData(hour_num) {
            var data;
            $.ajax({
                url: "http://119.3.5.25:8080/hpserver/get_Pressure1_mean",
                type: "GET",
                data: {
                    "hour": hour_num,
                },
                dataType: 'json',
                success: function (result) {
                    // if (result.success) {
                    //     var zNodes = result.data;
                    //     $.fn.zTree.init($("#treeDemo"), setting, zNodes);
                    // } else {
                    //     alert("加载数据失败...");
                    // }

                    var min = result.baseNumData.min;
                    var max = result.baseNumData.max;


                    data = result.baseDataList.map(function (v) {
                        return { num: +v.num,time: v.time}
                    });

                    // var chart = new G2.Chart({
                    //     container: 'mountNode',
                    //     forceFit: true,
                    //     width: 1000,
                    //     height: 500,
                    //     padding: [20, 20, 95, 80] // 上，右，下，左
                    // });
                    // chart.source(data, {
                    //     num: {
                    //         min: min,
                    //         max: max,
                    //         tickCount: 5,
                    //     },
                    // });
                    //
                    // chart.scale('time', {
                    //     range: [0, 1],
                    //     tickCount: 10,
                    //     // type: 'timeCat',
                    //     mask: 'HH:MM',
                    // });
                    // chart.tooltip({
                    //     crosshairs: {
                    //         type: 'line'
                    //     }
                    // });
                    // chart.line().position('time*num');
                    // chart.point().position('time*num').size(1).shape('circle').style({
                    //     stroke: '#fff',
                    //     lineWidth: 1
                    // });
                    // chart.render();


                    const chart = new G2.Chart({
                        container : 'mountNode',
                        forceFit: true,
                        height : 400
                    });
                    chart.source(data, {
                        'time': {
                            type: 'time',
                            nice: false,
                            mask: 'HH:mm'
                        },
                    });
                    chart.line().position('time*num').shape('smooth').size(2);
                    chart.point().position('time*num').size(1).shape('circle').style({
                        stroke: '#f00',
                        lineWidth: 2
                    })
                    chart.render();

                    // var data = result.baseDataList.map(function (v) {
                    //     return {id: v.id, num: v.num}
                    // }); // G2 对数据源格式的要求，仅仅是 JSON 数组，数组的每个元素是一个标准 JSON 对象。


                    $('#table').bootstrapTable({
                        url: 'http://119.3.5.25:8080/hpserver/get_Pressure1_mean?hour=5',
                        columns: [{
                            field: 'id',
                            title: '编号',
                        }, {
                            field: 'num',
                            title: '温度值',
                        }, {
                            field: 'time',
                            title: '时间',
                        }],
                        striped: true,
                        pagination: true,
                        pageNumber: 1,
                        pageSize: 10,
                        height: 8000,
                        uniqueId: "id",
                        showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
                        cardView: false,                    //是否显示详细视图
                        detailView: false,                   //是否显示父子表
                        pageList: [5, 25, 50, 100],
                        responseHandler: function (res) {

                            console.log(res)
                            return res.baseDataList
                        }
                    })

                },
                error: function (error) {
                    alert(error);
                }
            });

        }

    </script>
</div>
</body>
</html>
