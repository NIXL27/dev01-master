<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>主页</title>
    <script src="js/jquery-1.8.3.min.js"></script>
</head>
<body>
<h1 align="center" style="color: yellowgreen"><span id="username"></span>登录成功</h1>
</body>
<script type="application/javascript">
    $(function () {
        let token = localStorage.getItem("token");

        if (token === null) {
            alert("token不存在，请重新登录");
            location.href = "login.html";
        }else {
            $.ajax({
                type: "post",
                url: "/user/verifyToken",
                data: {"token" : token},
                success: function (resp) {
                    if (resp.success) {
                        $("#username").text(resp.data.username);
                    }else {
                        alert(resp.message);

                        location.href = "login.html";
                    }
                }
            })
        }
    })
</script>
</html>