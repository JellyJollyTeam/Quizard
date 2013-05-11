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
        function sample() {
            var sampleSpell = "Part 1\n--------------------\nThis is a sample.\n\n1. What's your favorite color?\n(x) Red\n() Yellow\n() Blue\n() Green\n\n2. What's your hobby?\n[x] Soccer\n[] Basketball\n[x] Badminton\n[] Others\n\n3. What's your name?\n___Alice? Bob?___\n\n4. Introduce yourself\n___I'm a programmer______\n___and sometimes a geek._\n";
            $('#source').val(sampleSpell);
        }
        $(document).ready(function() {
            $.ajaxSetup({
              contentType: "text/plain"
            });
            sample();
            setInterval(parse, 1200);
            var buffer = '';
            function parse() {
                var source = $('#source').val();
                if (source === '') {
                    $('#form').html('');
                    return;
                }
                var changed = (buffer != source);
                if (changed) {
                    buffer = source;
                    $.post('./spell', $('#source').val(), function(data) {
                        $('#form').html(data);
                    });
                }
            }
        });
        </script>
        <!-- Community Support -->
        <div id="editor">
            <form method="post" action="">
                <h3>发布问卷</h3>
                <label for="quiz-title">标题：</label>
                <input id="quiz-title" name="title" class="input" type="text" placeholder="问卷标题"></input>
                <label for="quiz-intro">简介：</label>
                <textarea id="quiz-intro" name="intro" class="span12"></textarea>
                <label for="source">问卷：</label>
                <div class="row">
                    <div class="span6">
                        <textarea id="source" class="span6"></textarea>
                    </div>
                    <div class="span6 preview">
                        <div id="form">
                        </div>
                    </div>
                </div>
                <input type="submit" class="btn btn-info" value="发布问卷"></input>
            </form>
        </div>

    </div><!-- END OF .container -->

<%@include file="footer.jspf" %>
</body>
</html>