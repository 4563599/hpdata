<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/11
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/jquery.ajaxfileupload.js"></script>
</head>
<body>
<%--<input type="file" capture="camera" accept="images/*" id="upload" name="file">--%>
#web网页上传图片格式   method="post" 采用post提交  action="/upload" 为提交IP地址  enctype="multipart/form-data告诉浏览器文件类型
<form method="post" action="/upload_pic" enctype="multipart/form-data">
    <input type="file" name="uploadFile"><br>
    <input type="submit" value="提交">
</form>
<script>
    // $("#upload").live("change", upload);
    //
    // function upload(event) {
    //     if (event.target.files.length == 1) {
    //         if (event.target.files[0].size >= 4096000) {
    //             alert('您这张图片过大，应小于4M');
    //         } else {
    //             $.ajaxFileUpload({
    //                 url: 'upload_pic',
    //                 secureuri: false,
    //                 fileElementId: 'upload',
    //                 dataType: 'text/html',
    //                 success: function (data, success) {
    //                     alert(data);
    //                 },
    //                 error: function (data, status, e) {
    //                     aler("上传图片失败，请稍后重试。");
    //                     closeLoad();
    //                 }
    //             });
    //         }
    //     } else {
    //         alert('您上传的不是图片，请选择图片上传');
    //     }
    // }
</script>
</body>
</html>