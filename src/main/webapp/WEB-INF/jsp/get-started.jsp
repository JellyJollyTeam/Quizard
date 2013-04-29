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

        <script type="text/javascript">
            $('#nav-tutor').addClass('active');
        </script>

        <!-- Get Started -->
        <div id="mock" class="row">
            <div class="span10 offset1">
                <h2>Lorem ipsum</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>

                <h2>Lorem ipsum</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>

                <h2>Lorem ipsum</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>

                <h2>Lorem ipsum</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
            </div>
        </div>

    </div><!-- END OF .container -->

<%@include file="footer.jspf" %>
</body>
</html>