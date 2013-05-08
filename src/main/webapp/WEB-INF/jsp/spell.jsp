<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh-cn">
<%@include file="head.jspf" %>
<body>
    <script type="text/javascript">
    $(document).ready(function() {
        $.ajaxSetup({
          contentType: "text/plain"
        });
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
                $.post('/spell', $('#source').val(), function(data) {
                    $('#form').html(data);
                });
            }
        }
    });
    </script>
    <div id="quizcontent" class="container">
        <div class="row" style="margin-top: 20px;">
            <div class="span5">
                <h3>Spell your quiz</h3>
                <textarea id="source" class="span5" style="background: #4e4e4e; color: #fff; overflow-y:visible; height: 200px; font-family: Consolas, Menlo, Monaco, Lucida Console, Liberation Mono, DejaVu Sans Mono, Bitstream Vera Sans Mono, Courier New, monospace, serif;"></textarea>
            </div>
            <div class="span6" style="border: 1px dashed #ccc;">
                <form id="form" style="margin: 10px;">
                </form>
            </div>
        </div>
        </div>
    </div>
</body>
</html>