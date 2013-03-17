<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" />

        <!-- Service -->
        <div id="service" class="row">
            <div class="span10 offset1">
                <h3>套餐与价格</h3>
                <p class="muted">根据您的需求，选择您所需的套餐</p>
                <hr />
                <div class="row">
                    <div class="span3 plan">
                        <div class="thumbnail">
                            <h4>免费套餐<span class="pull-right">0元/月</span></h4>
                            <hr />
                            <ul>
                                <li>无限公开问卷</li>
                                <li>实时问卷统计</li>
                                <li>社区支持</li>
                            </ul>
                        </div>
                    </div>
                    <div class="span3 plan">
                        <div class="thumbnail">
                            <h4>标准套餐<span class="pull-right">暂不提供</span></h4>
                            <hr />
                            <ul>
                                <li>无限公开问卷</li>
                                <li>实时问卷统计</li>
                                <li>官方支持</li>
                                <li>将会有更多功能...</li>
                            </ul>
                        </div>
                    </div>
                    <div class="span3 ellipsis">
                        ...
                    </div>
                </div>
            </div>
        </div>

<jsp:include page="footer.jsp" />
