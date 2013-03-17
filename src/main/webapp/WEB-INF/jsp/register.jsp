<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" />

        <!-- register -->
        <div id="register">
            <div class="row">
                <div class="span4 offset2">
                    <form action="admin-home.html">
                        <fieldset>
                            <legend>创建你的Quizard账号</legend>
                            <label for="username">用户名：</label>
                            <input id="username" name="username" class="input" type="text" placeholder="用户名">
                            <label for="username">邮箱：</label>
                            <input id="username" name="email" class="input" type="text" placeholder="邮箱">
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

<jsp:include page="footer.jsp" />