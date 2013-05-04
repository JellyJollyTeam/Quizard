<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-cn">
<%@include file="head.jspf" %>
<body>
    <div class="container">
        <%@include file="header.jspf" %>

        <script type="text/javascript">
            $('#nav-repo').addClass('active');
        </script>

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

    </div><!-- END OF .container -->

<%@include file="footer.jspf" %>
</body>
</html>