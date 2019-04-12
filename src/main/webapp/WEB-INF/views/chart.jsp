<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <!-- 引入在线资源 -->
    <script src="https://gw.alipayobjects.com/os/lib/antv/g2/3.4.10/dist/g2.min.js"></script>
</head>
<body>
<section class="wrapper">
    <section id="c1"></section>
    <section id="c2"></section>
    <section id="c3"></section>
</section>
<script>
    // const data = [
    //     {genre: 'Sports', sold: 275},
    //     {genre: 'Strategy', sold: 115},
    //     {genre: 'Action', sold: 120},
    //     {genre: 'Shooter', sold: 350},
    //     {genre: 'Other', sold: 150}
    // ]; // G2 对数据源格式的要求，仅仅是 JSON 数组，数组的每个元素是一个标准 JSON 对象。
    // // Step 1: 创建 Chart 对象
    // const chart = new G2.Chart({
    //     container: 'c1', // 指定图表容器 ID
    //     width: 600, // 指定图表宽度
    //     height: 300 // 指定图表高度
    // });
    // // Step 2: 载入数据源
    // chart.source(data);
    // // Step 3：创建图形语法，绘制柱状图，由 genre 和 sold 两个属性决定图形位置，genre 映射至 x 轴，sold 映射至 y 轴
    // chart.interval().position('genre*sold').color('genre')
    // // Step 4: 渲染图表
    // chart.render();

    var websocket = null;
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://120.77.144.115:8080/hp/websocket/webSocketServer.do");
    } else if ('MozWebSocket' in window) {
        websocket = new MozWebSocket("ws://120.77.144.115:8080/hp/websocket/webSocketServer.do");
    } else {
        websocket = new SockJS("http://120.77.144.115:8080/hp/sockjs/webSocketServer.do");
    }

    // 由于 G2 对数据源格式的要求，这里将数据转为 JSON 数组。
    function parseData(data, callback) {
        for (var i = 0, d1Ary = [], d2Ary = [], d3Ary = []; i < 40; i = i + 1) {
            d1Ary.push({'key': i, 'value': parseFloat(data[13 + 3 * i])});
            d2Ary.push({'key': i, 'value': parseFloat(data[14 + 3 * i])});
            d3Ary.push({'key': i, 'value': parseFloat(data[15 + 3 * i])});
            callback(d1Ary, d2Ary, d3Ary);
        }
    }

    // G2 对数据进行动态更新。
    function render() {
        for (var i = 1; i < 4; i = i + 1) {
            window['chart' + i].changeData(arguments[i - 1]);
        }
    }


    // 实例化 Chart 对象方法
    function instantiationChart(o, container) {

        // Step 1: 创建 Chart 对象
        window[o] = new G2.Chart({
            container: container,  // 指定图表容器 ID
            width: 600, // 指定图表宽度
            height: 300 // 指定图表高度
        });

        // Step 2: 载入数据源
        window[o].source([]);

        // Step 3：创建图形语法，绘制柱状图，由 key 和 value 两个属性决定图形位置，key 映射至 x 轴，value 映射至 y 轴
        window[o].line().position('key*value');

        // Step 4: 渲染图表
        window[o].render();
    }

    // 实例化3个 Chart 对象， 对应页面上三个图表。
    for (var i = 1; i < 4; i = i + 1) {
        instantiationChart('chart' + i, 'c' + i);
    }

    // 接收实时数据，并渲染至图表
    websocket.onmessage = function (evt) {
        var wsDataAry = evt.data.split(' ');
        parseData(wsDataAry, render)
    };
</script>
</body>
</html>