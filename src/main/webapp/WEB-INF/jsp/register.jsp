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

        <!-- register -->
        <div id="register">
            <script type="text/javascript">
                $(document).ready(function() {
                    $('#username').focus();
                });
            </script>
            <div class="row">
                <div class="span4 offset2">
                    <form id="registerForm" action="<c:url value="register" />" method="post" onsubmit="return checkRegister();">
                        <fieldset>
                            <legend>创建你的Quizard账号</legend>
                            <div id="errorMsg" class="alert alert-error hidden"></div>
                            <label for="username">用户名：</label>
                            <input id="username" name="username" class="input" type="text" placeholder="用户名">
                            <label for="username">邮箱：</label>
                            <input id="email" name="email" class="input" type="text" placeholder="邮箱">
                            <label for="password">密码：</label>
                            <input id="password" name="password" class="input" type="password" placeholder="密码">
                            <label for="confirm">确认密码：</label>
                            <input id="confirm" name="confirm" class="input" type="password" placeholder="确认密码">
                            <button type="submit" class="btn">注册</button>
                        </fieldset>
                    </form>
                </div><!-- END OF .span4 .offset2 -->
                <div class="span4 offset1">
                    <img data-src="holder.js/300x400" />
                </div><!-- END OF .span4 .offset1 -->
            </div><!-- END OF .row -->
        </div><!-- END OF #register -->


    </div><!-- END OF .container -->

<%@include file="footer.jspf" %>
</body>
</html>