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
    <script src="<c:url value="static/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="static/js/holder.js" />"></script>
</head>
<body>
    <div class="container">
        <!-- Title and Navbar -->
        <div class="row">
            <div id="header" class="span12">
                <div id="userinfo" class="pull-right">
                    <a href="<c:url value="/register"/>">注册</a>
                    <span>&middot;</span>
                    <a href="<c:url value="/login"/>">登录</a>
                </div>
                <h3 class="muted">Quizard</h3>
                <div class="navbar">
                    <div class="navbar-inner">
                        <div class="container">
                            <ul class="nav">
                                <li class="active"><a href="<c:url value="/"/>">主页</a></li>
                                <li><a href="<c:url value="/repository"/>">问卷库</a></li>
                                <li><a href="<c:url value="/get-started"/>">使用教程</a></li>
                                <li><a href="<c:url value="/service"/>">服务</a></li>
                                <li><a href="<c:url value="/community"/>">社区支持</a></li>
                                <li><a href="<c:url value="/about"/>">关于我们</a></li>
                            </ul>
                        </div>
                    </div>
                </div><!-- END OF .navbar -->
            </div><!-- END OF #header -->
        </div><!-- END OF .row -->