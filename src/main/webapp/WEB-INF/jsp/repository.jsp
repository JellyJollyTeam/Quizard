<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="header.jsp" />
                <div class="navbar">
                    <div class="navbar-inner">
                        <div class="container">
                            <ul class="nav">
                                <li><a href="<c:url value="/"/>">主页</a></li>
                                <li class="active"><a href="<c:url value="/repository"/>">问卷库</a></li>
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

        <!-- repository -->
        <div id="repository" class="row">
            <div class="span10 offset1">
                <ul class="nav nav-tabs">
                    <c:choose>
                        <c:when test="${(empty param.type) or (param.type == 'new')}">
                  <li class="active">
                        </c:when>
                        <c:otherwise>
                  <li>
                        </c:otherwise>
                    </c:choose>
                    <a href="?type=new">最新问卷</a>
                  </li>
                    <c:choose>
                        <c:when test="${param.type == 'hot'}">
                  <li class="active">
                        </c:when>
                        <c:otherwise>
                  <li>
                        </c:otherwise>
                    </c:choose>
                      <a href="?type=hot">最热问卷</a>
                  </li>
                  <li>
                      <a href="#">自定义</a>
                  </li>
                </ul>
                <div id="quizzes">
                    <c:forEach var="quiz" items="${quizzes}">
                    <div class="media">
                        <img class="pull-left media-object" src="<c:url value="static/img/quiz-ico.png" />">
                        <div class="pull-right">
                            <p>
                                <c:forEach var="tag" items="${quiz.tags}">
                                <span class="category">${tag}</span>
                                </c:forEach>
                                <!--<i class="icon-eye-open"></i><span class="viewed">12</span>-->
                                <i class="icon-pencil"></i><span class="answered">${quiz.answeredCount}</span>
                            </p>
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading"><a href="quiz.html">${quiz.title}</a></h4>
                            <p class="pubdate"><fmt:formatDate value="${quiz.creationDate}" pattern="yyyy年MM月dd日" /></p>
                            <p class="pubauthor"><a href="#">${quiz.owner.username}</a>发布</p>
                            <p class="intro">${quiz.description}</p>
                        </div>
                    </div><!-- END OF .media -->
                    </c:forEach>
                </div><!-- END OF #quizzes -->
                <div class="pagination">
                    <ul>
                        <c:choose>
                            <c:when test="${hasPrev}">
                        <li>
                            <a href="?page=${currentPage-1}">&laquo;</a>
                            </c:when>
                            <c:otherwise>
                        <li class="disabled">
                            <a href="#">&laquo;</a>
                            </c:otherwise>
                        </c:choose>
                        </li>
                        <c:forEach begin="1" end="${maxPage}" varStatus="varStatus">
                            <c:choose>
                                <c:when test="${varStatus.count == currentPage}">
                        <li class="active">
                                </c:when>
                                <c:otherwise>
                        <li>
                                </c:otherwise>
                            </c:choose>
                            <a href="?page=${varStatus.count}">${varStatus.count}</a>
                        </li>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${hasNext}">
                        <li>
                            <a href="?page=${currentPage+1}">&raquo;</a>
                            </c:when>
                            <c:otherwise>
                        <li class="disabled">
                            <a href="#">&raquo;</a>
                            </c:otherwise>
                        </c:choose>
                        </li>
                    </ul>
                </div><!-- END OF .pagination -->
            </div><!-- END OF .span10 .offset1 -->
        </div><!-- END OF #repository -->

<jsp:include page="footer.jsp" />