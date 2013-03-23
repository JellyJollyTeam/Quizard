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
                            <label for="username">用户名/邮箱：<a class="pull-right" href="<c:url value="/register" />">没有账号？</a></label>
                            <input id="username" name="username" class="input" type="text" placeholder="用户名/邮箱">
                            <label for="password">密码：<a class="pull-right" href="<c:url value="/find-password" />">忘记密码？</a></label>
                            <input id="password" name="password" class="input" type="password" placeholder="密码">
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

<jsp:include page="footer.jsp" />