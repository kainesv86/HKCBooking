<%--
    Document   : login
    Created on : Jan 12, 2022, 9:18:19 PM
    Author     : kaine
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form method="POST" action="LoginServlet">
                <div>
                    <label>Username</label>
                    <input name="username" type="text" id="username"/>
                    ${requestScope.usernameError}
                </div>
                <div>
                    <label>Password</label>
                    <input name="password" type="password" id="password"/>
                    ${requestScope.passwordError}
                </div>
                <input type="submit" value="Send" id="send"/>
            </form>
        </div>
    </body>
</html>
