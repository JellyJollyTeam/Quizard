<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" />

        <!-- quiz -->
        <div class="row">
            <div id="quiz" class="span10 offset1">
                <h1>问卷标题</h1>
                <p class="pubinfo">2013年12月31日<a href="#">季文昊</a>发布</p>
                <div id="quizcontent">
                    <form>
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
                    </form>
                </div>
            </div>
        </div>

<jsp:include page="footer.jsp" />