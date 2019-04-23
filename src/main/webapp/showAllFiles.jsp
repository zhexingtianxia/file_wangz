<%--
  Created by IntelliJ IDEA.
  User: wangz
  Date: 2019/3/11
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <table style="border: 2px;">
        <thead>
        <tr>
            <td align="left">用户：${login.realname}</td>
        </tr>
            <tr>
                <td>文件id</td>
                <td>原始名称</td>
                <td>新文件名称</td>
                <td>文件后缀</td>
                <td>存储路径</td>
                <td>大小</td>
                <td>文件类型</td>
                <td>是否是图片</td>
                <td>下载次数</td>
                <td>操作</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${documents}" var="d">
                <tr>
                <td>${d.id}</td>
                <td>${d.originalName}</td>
                <td>${d.newName}</td>
                <td>${d.extension}</td>
                <td>${d.storagePath}</td>
                <td>${d.fileSize}</td>
                <td>${d.fileType}</td>
                <td>${d.isImage}</td>
                <td>${downloadTimes}</td>
                <td><a href="" >下载</a>&nbsp; <a href="" >在线打开</a>&nbsp;<a href="" >删除</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <hr>

    <form action="${pageContext.request.contextPath}/document/upload" method="post" enctype="multipart/form-data">
        选择文件
        <input type="file" name="aaa"/><br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
