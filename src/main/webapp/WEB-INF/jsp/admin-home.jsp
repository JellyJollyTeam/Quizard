<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" />
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

<jsp:include page="footer.jsp" />