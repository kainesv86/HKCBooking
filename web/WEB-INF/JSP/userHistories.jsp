<%@page import="variables.RoomStatus"%>
<%@page import="entities.RoomType"%>
<%@page import="variables.Routers"%>
<%@page import="entities.History"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="common/header.jsp">
            <jsp:param name="title" value="Booking orders"/>
        </jsp:include>
    </head>
    <body>
        <%
            ArrayList<History> list = (ArrayList<History>) request.getAttribute("list");
            Integer userId = (Integer) request.getAttribute("userId");

            String startDate = (String) request.getAttribute("startDate");
            String endDate = (String) request.getAttribute("endDate");
        %>


        <div class="flex min-h-screen">
            <jsp:include page="./common/Sidebar.jsp"></jsp:include>


                <div class="flex items-center justify-center flex-col flex-1">
                    <form action="<%=Routers.ADD_PARAMS_SERVLET%>" method="POST" class="bg-rose-600 py-6 px-12 flex flex-col rounded-md mb-4">
                    <input readonly required hidden value="<%= Routers.USER_HISTORIES_SERVLET%>" type="text" name="redirectTo"/>
                    <div class="flex items-end">
                        <div class="flex flex-col mr-4 -translate-y-2">
                            <label for="userId" class="block text-sm text-gray-100 font-semibold">User Id</label>
                            <input  required value="<%= userId != null ? userId : ""%>" id="userId" name="userId" type="text"  class="appearance-none block w-full px-3 py-1 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" />
                        </div>
                        <div class="mr-4">
                            <jsp:include page="./Components/InputDate.jsp">
                                <jsp:param name="key" value="startDate"/>
                                <jsp:param name="label" value="Start date"/>
                                <jsp:param name="inputValue" value="<%=startDate%>"/>

                            </jsp:include>
                        </div>
                        <div class="mr-4">
                            <jsp:include page="./Components/InputDate.jsp">
                                <jsp:param name="key" value="endDate"/>
                                <jsp:param name="label" value="End date"/>
                                <jsp:param name="inputValue" value="<%=endDate%>"/>

                            </jsp:include>
                        </div>
                        <div class="-translate-y-2">
                            <button type="submit" class=" h-fit px-4 py-2 rounded-md shadow-sm text-sm font-semibold text-rose-500 bg-gray-100 hover:bg-gray-50 focus:outline-none">Search</button>
                        </div>
                    </div>
                </form>
                <div class="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
                    <div class="py-2 align-middle inline-block min-w-auto sm:px-6 lg:px-8">
                        <div class="shadow overflow-hidden border-b border-gray-200 sm:rounded-lg fade-in">
                            <table class="min-w-full divide-y divide-gray-200">
                                <thead class="bg-gray-50">
                                    <tr class="text-2xl">
                                        <th scope="col" class="px-6 py-3 text-left text-sm font-medium text-gray-500 uppercase tracking-wider ">History Info</th>
                                        <th scope="col" class="px-6 py-3 text-left text-sm font-medium text-gray-500 uppercase tracking-wider">Booking Info</th>
                                        <th scope="col" class="px-6 py-3 text-left text-sm font-medium text-gray-500 uppercase tracking-wider">Total</th>
                                        <th scope="col" class="px-6 py-3 text-left text-sm font-medium text-gray-500 uppercase tracking-wider w-24">Note</th>
                                        <th scope="col" class="px-6 py-3 text-left text-sm font-medium text-gray-500 uppercase tracking-wider w-24">Message</th>
                                        <th scope="col" class="px-6 py-3 text-left text-sm font-medium text-gray-500 uppercase tracking-wider">Status</th>
                                    </tr>
                                </thead>
                                <tbody class="bg-white divide-y divide-gray-200">
                                    <% for (History history : list) {%>


                                    <tr>

                                        <td class="px-6 py-4 whitespace-nowrap">
                                            <div class="text-sm text-gray-900">ID: #<%= history.getHistoryId()%></div>
                                            <div class="text-sm text-gray-500">Room ID: #<%= history.getRoomId()%></div>
                                            <div class="text-sm text-gray-900"><%= history.getStartDate()%> ~ <%= history.getEndDate()%></div>
                                        </td>
                                        <td class="px-6 py-4 whitespace-nowrap">
                                            <div class="text-sm text-gray-900"><%= history.getFullname()%></div>
                                            <div class="text-sm text-gray-500"><%= history.getPhone()%></div>
                                            <div class="text-sm text-gray-900"><%= history.getAddress()%></div>
                                        </td>
                                        <td class="px-6 py-4 whitespace-nowrap text-right text-sm">
                                            <p class="text-sm text-gray-900 w-48 text-justify"><%= history.getTotal()%>$</p>
                                        </td>
                                        <td class="px-6 py-4">
                                            <p class="text-sm text-gray-900 w-48 text-justify"><%= history.getNote()%></p>
                                        </td>
                                        <td class="px-6 py-4">
                                            <p class="text-sm text-gray-900 w-48 text-justify"><%= history.getMessage()%></p>
                                        </td>

                                        <td class="px-6 py-4 whitespace-nowrap">
                                            <p class="text-sm text-gray-900 w-48 text-justify"><%= history.getHistoryStatus()%></p>
                                        </td>
                                    </tr>

                                    <% }
                                    %>

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
