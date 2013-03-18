<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="header.jsp" />

        <!-- repository -->
        <div id="repository" class="row">
            <div class="span10 offset1">
                <ul class="nav nav-tabs">
                  <li class="active">
                    <a href="#">最新问卷</a>
                  </li>
                  <li><a href="#">最热问卷</a></li>
                  <li><a href="#">自定义</a></li>
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
                                </c:otherwise>
                            <a href="?page=${varStatus.count}">${varStatus.count}</a>
                        </li>
                            </c:choose>
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