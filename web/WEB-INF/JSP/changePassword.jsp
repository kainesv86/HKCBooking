<%@page import="variables.Routers"%>
<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <jsp:include page="common/header.jsp">
            <jsp:param name="title" value="Change Password"/>
        </jsp:include>
    </head>
    <body>

        <%
            User user = (User) request.getAttribute("user");
        %>

        <div class="flex flex-col min-h-screen">
            <jsp:include page="./common/navbar.jsp"></jsp:include>
                <div class="min-h-full flex flex-1 px-96 pt-16">
                    <form action="<%=Routers.CHANGE_PASSWORD_SERVLET%>" method="POST" class="space-y-8 divide-y divide-gray-200 w-full border-rose-600 border-2 p-4 rounded-md h-fit">
                    <div class="space-y-8 divide-y divide-gray-200 sm:space-y-5">
                        <div class="pt-8 space-y-6 sm:pt-10 sm:space-y-5">
                            <div>
                                <h3 class="text-lg leading-6 font-medium text-gray-900">Change Password</h3>
                            </div>

                            <div class="space-y-6 sm:space-y-5">
                                <jsp:include page="./Components/Input.jsp">
                                    <jsp:param name="type" value="password"/>
                                    <jsp:param name="key" value="password"/>
                                    <jsp:param name="label" value="Password"/>
                                    <jsp:param name="error" value="${requestScope.passwordError}"/>
                                </jsp:include>

                                <jsp:include page="./Components/Input.jsp">
                                    <jsp:param name="type" value="password"/>
                                    <jsp:param name="key" value="newPassword"/>
                                    <jsp:param name="label" value="New Password"/>
                                    <jsp:param name="error" value="${requestScope.newPasswordError}"/>
                                </jsp:include>

                                <jsp:include page="./Components/Input.jsp">
                                    <jsp:param name="type" value="password"/>
                                    <jsp:param name="key" value="newPasswordConfirm"/>
                                    <jsp:param name="label" value="New Password Confirm"/>
                                    <jsp:param name="error" value="${requestScope.newPasswordConfirmError}"/>
                                </jsp:include>

                            </div>
                        </div>
                        <div class="pt-5">
                            <div class="flex justify-end">
                                <button type="reset" class="bg-white py-2 px-4 border border-gray-300 rounded-md shadow-sm text-sm font-medium text-gray-700 hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Change Information</button>
                                <button type="submit" class="ml-3 inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-rose-600 hover:bg-rose-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-rose-600">Save</button>
                            </div>
                        </div>
                </form>

            </div>
        </div>
    </body>
</html>