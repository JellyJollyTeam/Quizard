<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" />
                <div class="navbar">
                    <div class="navbar-inner">
                        <div class="container">
                            <ul class="nav">
                                <li><a href="<c:url value="/"/>">主页</a></li>
                                <li><a href="<c:url value="/repository"/>">问卷库</a></li>
                                <li class="active"><a href="<c:url value="/get-started"/>">使用教程</a></li>
                                <li><a href="<c:url value="/service"/>">服务</a></li>
                                <li><a href="<c:url value="/community"/>">社区支持</a></li>
                                <li><a href="<c:url value="/about"/>">关于我们</a></li>
                            </ul>
                        </div>
                    </div>
                </div><!-- END OF .navbar -->
            </div><!-- END OF #header -->
        </div><!-- END OF .row -->

        <!-- Get Started -->

<jsp:include page="footer.jsp" />
