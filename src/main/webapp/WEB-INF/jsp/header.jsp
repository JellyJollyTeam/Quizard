<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <title>Quizard - 更简单更轻巧的问卷</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Le styles -->
    <link href="<c:url value="static/css/bootstrap.css" />" rel="stylesheet" />
    <link href="<c:url value="static/css/bootstrap-responsive.css" />" rel="stylesheet" />
    <link href="<c:url value="static/css/style.css" />" rel="stylesheet" />
    <link href="<c:url value="static/css/navbar.css" />" rel="stylesheet" />
    <script src="<c:url value="static/js/jquery-1.9.1.min.js" />"></script>
    <script src="<c:url value="static/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="static/js/holder.js" />"></script>
    <script src="<c:url value="static/js/check.js" />"></script>
</head>
<body>
    <div class="container">
        <!-- Title and Navbar -->
        <div class="row">
            <div id="header" class="span12">
                <c:choose>
                    <c:when test="${empty adminUser}">
                <div id="userinfo" class="pull-right">
                    <a href="<c:url value="/register"/>">注册</a>
                    <span>&middot;</span>
                    <a href="<c:url value="/login"/>">登录</a>
                </div>
                    </c:when>
                    <c:otherwise>
                <div id="userinfo" class="pull-right">
                    <a href="#"><c:out value="${adminUser.username}"/></a>
                    <span>&middot;</span>
                    <a href="<c:url value="/logout"/>">注销</a>
                </div>
                    </c:otherwise>
                </c:choose>
                <h3 class="muted">Quizard</h3>