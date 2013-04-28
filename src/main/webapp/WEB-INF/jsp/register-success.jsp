<%--
    Document   : register-success
    Created on : 2013-4-28, 19:58:41
    Author     : rAy <predator.ray@gmail.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" />
                <div class="navbar">
                    <div class="navbar-inner">
                        <div class="container">
                            <ul class="nav">
                                <li><a href="<c:url value="/"/>">主页</a></li>
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

        <!-- register success -->
        <div id="register-success">
            <div class="row">
                <div class="span10 offset1">
                    <h2>注册成功！</h2>
                    <p class="muted">请验证您的邮箱以激活账户。</p>
                    <p>
                        <a href="<c:url value="/"/>">返回主页</a>
                        <span>&middot;</span>
                        <a href="<c:out value="/login"/>">登录账户</a>
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="span"></div>
            </div>
        </div>
<jsp:include page="footer.jsp" />