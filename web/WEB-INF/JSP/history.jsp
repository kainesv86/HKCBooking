<%@page import="variables.HistoryStatus"%>
<%@page import="variables.Routers"%>
<%@page import="entities.HistoryDetail"%>
<%@page import="entities.User"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="common/header.jsp">
            <jsp:param name="title" value="Booking History"/>
        </jsp:include>
    </head>
    <body>
        <%
            ArrayList<HistoryDetail> list = (ArrayList<HistoryDetail>) request.getAttribute("list");
            String location = (String) request.getAttribute("location");
        %>

        <div class="flex flex-col min-h-screen">

            <jsp:include page="./common/navbar.jsp"></jsp:include>
                <div class="bg-gray-100 flex-1 py-20 px-1">
                    <div class="text-center flex flex-col mb-4">
                        <h2 class="text-rose-600 text-2xl font-semibold">Booking History</h2>
                        <div class="relative self-center bg-gray-100 rounded-lg p-0.5 flex w-fit text-center">
                            <a href="<%= Routers.HISTORY_SERVLET%>" class="cursor-pointer mr-1 bg-white border-gray-200 rounded-md shadow-sm py-2 text-sm font-semibold text-gray-800 whitespace-nowrap focus:outline-none focus:ring-2 focus:z-10 w-24">All</a>
                        <a href="<%= Routers.HISTORY_SERVLET%>?status=PENDING" class="cursor-pointer mr-1 bg-amber-400 border-gray-200 rounded-md shadow-sm py-2 text-sm font-semibold text-white whitespace-nowrap focus:outline-none focus:ring-2 focus:z-10 w-24">Pending</a>
                        <a href="<%= Routers.HISTORY_SERVLET%>?status=READY" class="cursor-pointer mr-1 bg-blue-400 border-gray-200 rounded-md shadow-sm py-2 text-sm font-semibold text-white whitespace-nowrap focus:outline-none focus:ring-2 focus:z-10 w-24">Ready</a>
                        <a href="<%= Routers.HISTORY_SERVLET%>?status=COMPLETED" class="cursor-pointer mr-1 bg-green-400 border-gray-200 rounded-md shadow-sm py-2 text-sm font-semibold text-white whitespace-nowrap focus:outline-none focus:ring-2 focus:z-10 w-24">Completed</a>
                        <a href="<%= Routers.HISTORY_SERVLET%>?status=CANCEL" class="cursor-pointer mr-1 bg-rose-400 border-gray-200 rounded-md shadow-sm py-2 text-sm font-semibold text-white whitespace-nowrap focus:outline-none focus:ring-2 focus:z-10 w-24">Cancel</a>
                    </div>
                </div>
                <div class="flex flex-col">
                    <div class="-my-2 overflow-x-auto flex justify-center">
                        <div class="py-2 align-middle inline-block min-w-auto sm:px-6 lg:px-8">
                            <div class="shadow overflow-hidden border-b border-gray-200 sm:rounded-lg">
                                <table class="min-w-full divide-y divide-gray-200">
                                    <thead class="bg-gray-50">
                                        <tr>
                                            <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Room</th>
                                            <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Customer Information</th>
                                            <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider w-24">Note</th>
                                            <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider w-24">Message</th>
                                            <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Status</th>
                                            <th scope="col" class="relative px-6 py-3">
                                                <span class="sr-only">Edit</span>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody class="bg-white divide-y divide-gray-200">
                                        <%
                                            for (int index = 0; index < list.size(); index++) {
                                        %>
                                        <tr class="w-fit">
                                    <form action="<%= Routers.HISTORY_SERVLET%>" method="POST" >
                                        <input name="historyId" value="<%= list.get(index).getHistory().getHistoryId()%>" class="hidden">
                                        <input name="location" value="<%= location%>" class="hidden">
                                        <td class="px-6 py-4 whitespace-nowrap">
                                            <div class="flex items-center w-fit">
                                                <div class="flex-shrink-0 h-20 w-20">
                                                    <img class="h-20 w-20" src="<%= list.get(index).getRoom().getUrlImage()%>" alt="" />
                                                </div>
                                                <div class="ml-4">
                                                    <div class="text-sm font-medium text-gray-900">Id: #<%= list.get(index).getHistory().getHistoryId()%></div>
                                                    <a href="<%= Routers.ROOM_DETAIL_SERVLET%>?roomId=<%= list.get(index).getRoom().getRoomId()%>" class="text-sm font-medium text-gray-900 cursor-pointer"><%= list.get(index).getRoomType().getRoomName()%></a>
                                                    <div class="text-sm text-gray-500"><%= list.get(index).getHistory().getTotal()%>$</div>
                                                    <div class="text-sm text-gray-500"><%= list.get(index).getHistory().getStartDate()%> ~ <%= list.get(index).getHistory().getEndDate()%></div>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="px-6 py-4 whitespace-nowrap">
                                            <div class="text-sm text-gray-900"><%= list.get(index).getHistory().getFullname()%></div>
                                            <div class="text-sm text-gray-500"><%= list.get(index).getHistory().getAddress()%></div>
                                            <div class="text-sm text-gray-900"><%= list.get(index).getHistory().getPhone()%></div>
                                        </td>

                                        <td class="px-6 py-4">
                                            <textarea rows="4" name="note" id="note" placeholder="Enter your note here" class="focus:ring-rose-500 focus:border-rose-500 block sm:text-sm border-gray-300 rounded-md w-48"><%= list.get(index).getHistory().getNote()%></textarea>
                                        </td>
                                        <td class="px-6 py-4">
                                            <p class="text-sm text-gray-900 w-48 text-justify"><%= list.get(index).getHistory().getMessage()%></p>
                                        </td>
                                        <td class="px-6 py-4 whitespace-nowrap">
                                            <div class="text-sm text-gray-500"><%= list.get(index).getHistory().getHistoryStatus()%></div>
                                            <!-- <span class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800"> Active </span> -->
                                        </td>

                                        <td class="px-6 py-4 whitespace-nowrap text-right text-sm font-medium">
                                            <div class="flex flex-col flex-start">
                                                <button type="submit" class="text-indigo-600 hover:text-indigo-900 font-semibold" >Save</button>
                                                <% if (list.get(index).getHistory().getHistoryStatus().equals(HistoryStatus.status.PENDING.toString())) {%>
                                                <a href="<%= Routers.CANCEL_HISTORY_SERVLET%>?historyId=<%= list.get(index).getHistory().getHistoryId()%>" onclick="return confirm('Are you sure?')" class="text-rose-600 hover:text-rose-500">Cancel</a>
                                                <% } %>
                                            </div>
                                        </td>


                                    </form>
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
