
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>JSP Page</title>
        <script src="https://cdn.tailwindcss.com"></script>
        <jsp:include page="./common/navbar.jsp"></jsp:include>
        </head>
        <body>
        <%
            String messageError = "";
            if (request.getAttribute("messageError") != null) {
                messageError = (String) request.getAttribute("messageError");
            }
        %>

        <div>
            <form method="POST" action="LoginServlet">
                <div>
                    <label>Username</label>
                    <input name="username" type="text" id="username" style="border: 1px black solid"/>
                    ${requestScope.usernameError}
                </div>
                <div>
                    <label>Password</label>
                    <input name="password" type="password" id="password" style="border: 1px black solid" />
                    ${requestScope.passwordError}
                </div>
                <div>                   
                    <p style="color: red"><%=messageError%></p>
                </div>
                <input type="submit" value="Login" id="send" style="border: 1px black solid; border-radius: 5%"/>
            </form>
        </div>
    </body>
</html>
