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

        <script type="text/javascript">
            $('#nav-home').addClass('active');
        </script>

        <!-- Main Content -->
        <div id="mainContent" class="row">
            <div id="leftMain" class="span5 offset2">
                <h1 class="bigChar">更<span class="emphasis">简单</span><br />更<span class="emphasis">轻巧</span><br />的问卷</h1>
                <ul id="characteristic">
                    <li>所见即所得的问卷编辑</li>
                    <li>类Markdown文本编辑</li>
                </ul>
            </div><!-- END OF .span8 -->

            <!-- REGISTER FORM -->
            <div id="rightMain" class="span3">
                <form id="quickRegister" action="<c:url value="/register"/>" method="post" class="form-horizontal">
                    <p><input type="text" name="username" placeholder="用户名" /></p>
                    <p><input type="text" name="email" placeholder="邮箱" /></p>
                    <p><input type="password" name="password" placeholder="密码" /></p>
                    <p><a class="btn btn-large btn-info" type="button" onclick="$('#quickRegister').submit();">注册</a></p>
                </form>
            </div><!-- END OF .span4 -->
        </div><!-- END OF .row -->

        <hr />

        <!-- DETAILS -->
        <div id="details">
            <div class="detail row">
                <div class="span10 offset1">
                    <img class="pull-left" data-src="holder.js/500x309" />
                    <h3>便捷的所见即所得问卷编辑</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
                </div>
            </div><!-- END OF .detail -->

            <hr />

            <div class="detail row">
                <div class="span10 offset1">
                    <img class="pull-right" src="<c:url value="static/img/spell-sample.png" />" />
                    <h3>简约的类Markdown文本编辑</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
                </div>
            </div><!-- END OF .detail -->
        </div>
        <!-- END OF #details -->
    </div><!-- END OF .container -->

<%@include file="footer.jspf" %>
</body>
</html>