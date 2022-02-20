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
                    <form action="<%=Routers.USER_INFO_SERVLET%>" method="POST" class="space-y-8 divide-y divide-gray-200 w-full border-rose-600 border-2 p-4 rounded-md h-fit">
                    <div class="space-y-8 divide-y divide-gray-200 sm:space-y-5">
                        <div class="pt-8 space-y-6 sm:pt-10 sm:space-y-5">
                            <div>
                                <h3 class="text-lg leading-6 font-medium text-gray-900">Personal Information</h3>
                            </div>

                            <div class="space-y-6 sm:space-y-5">
                                <div class="sm:grid sm:grid-cols-3 sm:gap-4 sm:items-start sm:border-t sm:border-gray-200 sm:pt-5">
                                    <label for="username" class="block text-sm font-medium text-gray-700 sm:mt-px sm:pt-2">Username</label>
                                    <div class="mt-1 sm:mt-0 sm:col-span-2 flex">
                                        <input type="text" name="username" id="username" value="<%= user.getUsername() == null ? "" : user.getUsername()%>" class="max-w-lg block w-full shadow-sm focus:ring-rose-500 focus:border-rose-500 sm:max-w-xs sm:text-sm border-gray-300 rounded-md py-1 px-2" readonly disabled />

                                    </div>
                                </div>
                                <jsp:include page="./Components/Input.jsp">
                                    <jsp:param name="type" value="text"/>
                                    <jsp:param name="key" value="fullname"/>
                                    <jsp:param name="label" value="Fullname"/>
                                    <jsp:param name="value" value="<%= user.getFullname()%>" />
                                    <jsp:param name="error" value="${requestScope.fullnameError}"/>
                                </jsp:include>

                                <jsp:include page="./Components/Input.jsp">
                                    <jsp:param name="type" value="phone"/>
                                    <jsp:param name="key" value="phone"/>
                                    <jsp:param name="label" value="Phone"/>
                                    <jsp:param name="value" value="<%= user.getPhone()%>" />
                                    <jsp:param name="error" value="${requestScope.phoneError}"/>
                                </jsp:include>

                                <jsp:include page="./Components/Input.jsp">
                                    <jsp:param name="type" value="email"/>
                                    <jsp:param name="key" value="email"/>
                                    <jsp:param name="label" value="Email"/>
                                    <jsp:param name="value" value="<%= user.getEmail()%>" />
                                    <jsp:param name="error" value="${requestScope.emailError}"/>
                                </jsp:include>

                                <jsp:include page="./Components/Input.jsp">
                                    <jsp:param name="type" value="text"/>
                                    <jsp:param name="key" value="address"/>
                                    <jsp:param name="label" value="Address"/>
                                    <jsp:param name="value" value="<%= user.getAddress()%>" />
                                    <jsp:param name="error" value="${requestScope.addressError}"/>
                                </jsp:include>

                            </div>
                        </div>
                        <div class="pt-5">
                            <div class="flex justify-end">
                                <button type="reset" class="bg-white py-2 px-4 border border-gray-300 rounded-md shadow-sm text-sm font-medium text-gray-700 hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Cancel</button>
                                <button type="submit" class="ml-3 inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-rose-600 hover:bg-rose-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-rose-600">Save</button>
                            </div>
                        </div>
                </form>

            </div>
        </div>
    </body>
</html>