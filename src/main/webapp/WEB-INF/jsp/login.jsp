<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-cn">
<%@include file="head.jspf" %>
<body>
    <div class="container">
        <%@include file="header.jspf" %>

        <!-- login -->
        <div id="login">
            <script type="text/javascript">
                $(document).ready(function() {
                    $('#username').focus();
                });
            </script>
            <div class="row">
                <div class="span4 offset2">
                    <form action="<c:url value="/login" />" method="post">
                        <fieldset>
                            <legend>登录你的Quizard账号</legend>
                            <c:if test="${!empty param.error}">
                            <div class="alert alert-error">
                                <c:choose>
                                    <c:when test="${param.error==1}">用户名或密码错误</c:when>
                                </c:choose>
                            </div>
                            </c:if>
                            <label for="username">用户名/邮箱：<a class="pull-right" href="<c:url value="/register" />">没有账号？</a></label>
                            <input id="username" name="username" class="input" type="text" placeholder="用户名/邮箱" tabindex="1"/>
                            <label for="password">密码：<a class="pull-right" href="<c:url value="/find-password" />">忘记密码？</a></label>
                            <input id="password" name="password" class="input" type="password" placeholder="密码" tabindex="2"/>
                            <label class="checkbox">
                                <input type="checkbox" name="rememberMe">记住我</input>
                            </label>
                            <button type="submit" class="btn">登录</button>
                        </fieldset>
                    </form>
                </div><!-- END OF .span4 .offset2 -->
                <div class="span4 offset1">
                    <h3>需要账号？<a href="<c:url value="/register" />">注册一个</a></h3>
                    <ul>
                        <li>创建自己的问卷</li>
                        <li>获取实时的统计</li>
                    </ul>
                </div><!-- END OF .span4 -->
            </div><!-- END OF .row -->
        </div><!-- END OF #login -->

    </div><!-- END OF .container -->

<%@include file="footer.jspf" %>
</body>
</html>