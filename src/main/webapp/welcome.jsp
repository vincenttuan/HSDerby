<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script>
    window.document.writeln('3 秒後進入登入畫面...')
    setTimeout(function() { 
        window.location.href = 'mvc/login/input';
    }, 3000);
    
</script>