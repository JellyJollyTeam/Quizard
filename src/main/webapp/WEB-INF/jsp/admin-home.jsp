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

        <!-- Admin Info -->
        <div id="admin-info" class="row">
            <div id="admin-feed" class="span8">
                <div class="btn-group pull-right">
                  <a class="btn btn-link">查看问卷</a>
                  <a class="btn btn-link">编辑问卷</a>
                </div>
                <ul class="breadcrumb">
                  <li><a href="#">所有问卷</a> <span class="divider">/</span></li>
                  <li class="active">问卷标题</li>
                </ul><!-- END OF BREADCRUMBS -->
                <ul class="nav nav-tabs">
                  <li class="active">
                    <a href="#">所有消息</a>
                  </li>
                  <li><a href="#">发布消息</a></li>
                  <li><a href="#">统计消息</a></li>
                </ul><!-- END OF NAV TABS -->
                <div id="feeds">
                    <div class="media">
                        <img class="pull-left media-object" data-src="holder.js/35x35">
                        <div class="pull-right">
                            <p class="pubdate">2013年12月31日</p>
                        </div>
                        <div class="media-body">
                            <p class="media-content"><a href="#">predatorray</a>发布了一张新的问卷</p>
                        </div>
                    </div><!-- END OF .media -->
                    <div class="media">
                        <img class="pull-left media-object" data-src="holder.js/35x35">
                        <div class="pull-right">
                            <p class="pubdate">2013年12月31日</p>
                        </div>
                        <div class="media-body">
                            <p class="media-content"><a href="#">predatorray</a>发布了一张新的问卷</p>
                        </div>
                    </div><!-- END OF .media -->
                    <div class="media">
                        <img class="pull-left media-object" data-src="holder.js/35x35">
                        <div class="pull-right">
                            <p class="pubdate">2013年12月31日</p>
                        </div>
                        <div class="media-body">
                            <p class="media-content"><a href="#">predatorray</a>发布了一张新的问卷</p>
                        </div>
                    </div><!-- END OF .media -->
                    <a class="btn btn-link">更多</a>
                </div><!-- END OF #feeds -->
            </div><!-- END OF #admin-feed -->
            <div id="admin-quizzes" class="span4">
                <div class="alert alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                      <h4>感谢您的使用</h4>
                      需要帮助？查看<a href="<c:url value="/get-started" />">使用教程</a>
                </div>
                <ul class="nav nav-tabs nav-stacked">
                    <li class="active repo-title">
                        <a href="#" class="btn pull-right">新建</a>
                        <a>我的问卷<em>(2)</em></a>
                    </li>
                    <li><a href="#">问卷标题<span class="pull-right">&raquo;</span></a></li>
                    <li><a href="#">foobar<span class="pull-right">&raquo;</span></a></li>
                    <li class="more"><a href="#">更多...</a></li>
                </ul>
            </div><!-- END OF #admin-quizzes -->
        </div><!-- END OF #admin-info -->

    </div><!-- END OF .container -->

<%@include file="footer.jspf" %>
</body>
</html>