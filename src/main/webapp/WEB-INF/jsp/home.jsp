<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" />

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
                <form action="<c:url value="/register?quickaccess"/>" method="post" class="form-horizontal">
                    <p><input type="text" name="username" placeholder="用户名" /></p>
                    <p><input type="text" name="email" placeholder="邮箱" /></p>
                    <p><input type="password" name="password" placeholder="密码" /></p>
                    <p><a class="btn btn-large btn-info" type="button">注册</a></p>
                </form>
            </div><!-- END OF .span4 -->
        </div><!-- END OF .row -->

        <hr />

        <!-- DETAILS -->
        <div id="details">
            <div class="detail row">
                <div class="span10 offset1">
                    <img class="pull-right" data-src="holder.js/500x309" />
                    <h3>便捷的所见即所得问卷编辑</h3>
                    <p>foo bar</p>
                </div>
            </div><!-- END OF .detail -->

            <hr />

            <div class="detail row">
                <div class="span10 offset1">
                    <img class="pull-left" data-src="holder.js/500x309" />
                    <h3>简约的类Markdown文本编辑</h3>
                    <p>foo bar</p>
                </div>
            </div><!-- END OF .detail -->
        </div>
        <!-- END OF #details -->

<jsp:include page="footer.jsp" />