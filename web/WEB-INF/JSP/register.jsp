<%-- 
    Document   : register
    Created on : Jan 12, 2022, 11:56:43 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.tailwindcss.com"></script>
        <jsp:include page="./common/navbar.jsp"></jsp:include>
        </head>
        <body>

        <%
            String username_err = "", email_err = "", pwd_err = "", cfpwd_err = "";
            if (request.getAttribute("username_err") != null) {
                username_err = (String) request.getAttribute("username_err");
            }
            if (request.getAttribute("email_err") != null) {
                email_err = (String) request.getAttribute("email_err");
            }
            if (request.getAttribute("pwd_err") != null) {
                pwd_err = (String) request.getAttribute("pwd_err");
            }
            if (request.getAttribute("cfpwd_err") != null) {
                cfpwd_err = (String) request.getAttribute("cfpwd_err");
            }
        %>


        <form method="POST" action="UserServlet">
            <h1>SIGN UP</h1>
            <div>
                <label>Username</label>
                <input name="username" type="text" id="username" placeholder="username"/>
                <p style="color: red"><%=username_err%></p>
            </div>
            <div>
                <label>Password</label>
                <input name="password" type="password" id="password" placeholder="password"/>
                <p style="color: red"><%=pwd_err%></p>
            </div>
            <div>
                <label>Confirm-Password</label>
                <input name="cfpassword" type="password" id="cfpassword" placeholder="confirm-password"/>
                <p style="color: red"><%=cfpwd_err%></p>
            </div>
            <div>
                <label>Full Name</label>
                <input name="fullname" type="text" id="fullname" placeholder="fullname"/>
                <p style="color: red"><%=username_err%></p>
            </div>
            <div>
                <label>Address</label>
                <input name="address" type="text" id="address" placeholder="address"/>
                <p style="color: red"><%=username_err%></p>
            </div>
            <div>
                <label>Phone</label>
                <input name="phone" type="text" id="phone" placeholder="phone"/>
                <p style="color: red"><%=username_err%></p>
            </div>
            <div>
                <label>Email</label>
                <input name="email" type="text" id="email" placeholder="abc@gmail.com.vn"/>
                <p style="color: red"><%=email_err%></p>
            </div>
            <input type="submit" value="Register" id="register"/>
        </form>
    </body>
</html>
