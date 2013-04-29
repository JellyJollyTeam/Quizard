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

        <!-- register success -->
        <div id="register-success">
            <div class="row">
                <div class="span10 offset1">
                    <h2>注册成功！</h2>
                    <p class="muted">请验证您的邮箱以激活账户。</p>
                    <p>
                        <a href="<c:url value="/"/>">返回主页</a>
                        <span>&middot;</span>
                        <a href="<c:url value="/login"/>">登录账户</a>
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="span"></div>
            </div>
        </div>

    </div><!-- END OF .container -->

<%@include file="footer.jspf" %>
</body>
</html>