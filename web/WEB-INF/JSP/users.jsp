<%@page import="java.util.ArrayList"%>
<%@page import="entities.User"%>
<%@page import="variables.Routers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="common/header.jsp">
            <jsp:param name="title" value="User list"/>
        </jsp:include>
    </head>
    <body>
        <%
            ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
        %>
        <div class="flex min-h-screen">
            <jsp:include page="./common/Sidebar.jsp"></jsp:include>
                <div class="bg-gray-100 flex-1 p-20 min-w-auto">
                    <div class="text-center flex flex-col mb-4">
                        <h2 class="text-rose-600 text-2xl font-semibold">User list</h2>
                    </div>

                    <div class="flex flex-col items-center">
                        <div class="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
                            <div class="py-2 align-middle inline-block min-w-auto sm:px-6 lg:px-8">
                                <div class="shadow overflow-hidden border-b border-gray-200 sm:rounded-lg">
                                    <table class="min-w-full divide-y divide-gray-200">
                                        <thead class="bg-gray-50">
                                            <tr>
                                                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">User Id</th>
                                                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Username</th>
                                                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Fullname</th>
                                                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider w-20">Contact</th>
                                                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Role</th>
                                                <th scope="col" class="relative px-6 py-3">
                                                    <span class="sr-only">Edit</span>
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody class="bg-white divide-y divide-gray-200">
                                        <%
                                            for (User user : users) {
                                        %>
                                        <tr>

                                            <td class="px-6 py-4 whitespace-nowrap">
                                                <div class="text-sm text-gray-900"><%= user.getUserId()%></div>
                                            </td>

                                            <td class="px-6 py-4 whitespace-nowrap">
                                                <div class="text-sm text-gray-900"><%= user.getUsername()%></div>
                                            </td>

                                            <td class="px-6 py-4 whitespace-nowrap">
                                                <div class="text-sm text-gray-900"><%= user.getFullname()%></div>
                                            </td>

                                            <td class="px-6 py-4 text-sm">
                                                <p class="font-medium text-gray-900 w-48"><%= user.getEmail()%></p>
                                                <p class="text-gray-500"><%= user.getPhone()%></p>
                                                <p class="text-gray-500"><%= user.getAddress()%></p>
                                            </td>
                                            <td class="px-6 py-4">
                                                <p class="text-sm text-gray-900 text-justify"><%= user.getRole()%></p>
                                            </td>
                                            <td class="px-6 py-4 whitespace-nowrap text-right text-sm font-medium ">
                                                <div class="flex flex-col items-start justify-center">
                                                    <a href="<%= Routers.USER_HISTORIES_SERVLET%>?userId=<%= user.getUserId()%>" class="text-indigo-600 hover:text-indigo-900 font-semibold cursor-pointer">View History</a>
                                                </div>
                                            </td>
                                        </tr>

                                        <% }%>

                                        <!-- More people... -->
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
