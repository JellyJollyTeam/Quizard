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

        <!-- quiz -->
        <div class="row">
            <div id="quiz" class="span10 offset1">
                <h1>问卷标题</h1>
                <p class="pubinfo">2013年12月31日<a href="#">季文昊</a>发布</p>
                <div id="quizcontent">
                    <form action="#" method="post">
                    <q:elements var="e" no="no" quiz="${quiz}">
                        <q:text>
                            <p>${e.text}</p>
                        </q:text>
                        <q:title>
                            <legend>${e.text}</legend>
                        </q:title>
                        <q:singleChoice>
                            <label class="title" for="${q:formatQuestionName(no)}">
                                <c:out value="${q:formatQuestionTitle(no, e.getTitle)}"
                            </label>
                            <c:forEach var="option" items="${e.options}" varStatus="varStatus">
                                <label class="radio">
                                    <c:choose>
                                        <c:when test="${e.defaultIndex == varStatus.index}">
                                            <input type="radio" id="${q:formatQuestionName(no)}" name="${q:formatQuestionName(no)}" checked="checked"/>
                                        </c:when>
                                        <c:otherwise>
                                            <input type="radio" id="${q:formatQuestionName(no)}" name="${q:formatQuestionName(no)}"/>
                                        </c:otherwise>
                                    </c:choose>
                                </label>
                            </c:forEach>
                        </q:singleChoice>
                        <q:multipleChoice>
                            <label class="title" for="${q:formatQuestionName(no)}">
                                <c:out value="${q:formatQuestionTitle(no, e.getTitle)}"
                            </label>
                            <c:forEach var="option" items="${e.options}" varStatus="varStatus">
                                <label class="checkbox">
                                    <c:choose>
                                        <c:when test="${e.defaultIndex == varStatus.index}">
                                            <input type="checkbox" id="${q:formatQuestionOption(no, varStatus.index)}" name="${q:formatQuestionOption(no, varStatus.index)}" checked="checked"/>
                                        </c:when>
                                        <c:otherwise>
                                            <input type="checkbox" id="${q:formatQuestionOption(no, varStatus.index)}" name="${q:formatQuestionOption(no, varStatus.index)}"/>
                                        </c:otherwise>
                                    </c:choose>
                                </label>
                            </c:forEach>
                        </q:multipleChoice>
                        <q:singleTextbox>
                            <label class="title" for="${q:formatQuestionName(no)}">
                                <c:out value="${q:formatQuestionTitle(no, e.getTitle)}"
                            </label>
                            <c:choose>
                                <c:when test="${empty e.defaultValue}">
                                    <input id="${q:formatQuestionName(no)}" name="${q:formatQuestionName(no)}" type="text"/>
                                </c:when>
                                <c:otherwise>
                                    <input id="${q:formatQuestionName(no)}" name="${q:formatQuestionName(no)}" type="text" value="${e.defaultValue}"/>
                                </c:otherwise>
                            </c:choose>
                        </q:singleTextbox>
                        <q:multipleTextbox>
                            <label class="title" for="${q:formatQuestionName(no)}">
                                <c:out value="${q:formatQuestionTitle(no, e.getTitle)}"
                            </label>
                            <textarea class="span4" id="${q:formatQuestionName(no)}" name="${q:formatQuestionName(no)}" rows="10">
                                <c:if test="${!empty e.defaultValue}">
                                    <c:out value="e.defaultValue}"/>
                                </c:if>
                            </textarea>
                        </q:multipleTextbox>
                    </q:elements>
                    <!--
                      <fieldset>
                        <legend>第一部分 - 基本信息</legend>
                        <label class="title" for="q_1">1. 你的名字是</label>
                        <input id="q_1" name="q_1" type="text" placeholder="你的名字">
                        <span class="help-block">例如：张三</span>
                        <label class="title" for="q_2">2. 你的性别是</label>
                        <label class="radio">
                            <input type="radio" id="q_2" name="q_2">男</input>
                        </label>
                        <label class="radio">
                            <input type="radio" id="q_2" name="q_2">女</input>
                        </label>
                        <label class="radio">
                            <input type="radio" id="q_2" name="q_2">女博士/程序媛</input>
                        </label>

                        <legend>第二部分 - 更多信息</legend>
                        <label class="title" for="q_3">3. 你的兴趣有</label>
                        <label class="checkbox">
                            <input name="q_3_1" type="checkbox">足球</input>
                        </label>
                        <label class="checkbox">
                            <input name="q_3_2" type="checkbox">篮球</input>
                        </label>
                        <label class="title" for="q_4">4. 你的自我介绍</label>
                        <textarea id="q_4" class="span4" name="q_4" rows="10"></textarea><br />

                        <button type="submit" class="btn">提交</button>
                      </fieldset>
                      -->
                    </form>
                </div>
            </div>
        </div>


    </div><!-- END OF .container -->

<%@include file="footer.jspf" %>
</body>
</html>