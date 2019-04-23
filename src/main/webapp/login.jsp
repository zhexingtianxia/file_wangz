<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>登陆</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    <table cellpadding="0" cellspacing="0" border="0"
           class="form_table">
        <tr>

            <td valign="middle" align="left">
                用户名:
                <input type="text" class="inputgri" name="username" />
            </td>
        </tr>

        <tr>

            <td valign="middle" align="left">
                密码:
                <input type="password" class="inputgri" name="password" />
            </td>
        </tr>
        <tr>

            <td valign="middle" align="left">
                验证码:
                <input type="text" class="inputgri" name="vCode" />

                <img id="num" src="${pageContext.request.contextPath}/user/getImage" />
                <a href="javascript:;" onclick="document.getElementById('num').src = '${pageContext.request.contextPath}/user/getImage?'+(new Date()).getTime()">换一张</a>
            </td>
        </tr>
    </table>
    <span style="color:darkred">${message}</span>
    <p>
        <input type="submit" class="button" value="登陆" />
    </p>
</form>
</body>
</html>