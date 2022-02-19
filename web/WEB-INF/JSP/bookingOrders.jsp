

<%@page import="variables.Routers"%>
<%@page import="org.apache.tomcat.util.codec.binary.StringUtils"%>
<%@page import="variables.HistoryStatus"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.HistoryDetail"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>JSP Page</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>

        <%
            ArrayList<HistoryDetail> historyDetails = (ArrayList<HistoryDetail>) request.getAttribute("historyDetails");
            String location = (String) request.getAttribute("location");
        %>
        <div class="flex min-h-screen">
            <jsp:include page="./common/Sidebar.jsp"></jsp:include>
                <div class="bg-gray-100 flex-1 p-20 min-w-auto">
                    <div class="text-center flex flex-col mb-4">
                        <h2 class="text-rose-600 text-2xl font-semibold">Order Status</h2>
                        <div class="relative self-center bg-gray-100 rounded-lg p-0.5 flex w-fit text-center">
                            <a href="<%=Routers.BOOKING_ORDERS_SERVLET%>" class="cursor-pointer mr-1 bg-white border-gray-200 rounded-md shadow-sm py-2 text-sm font-semibold text-gray-800 whitespace-nowrap focus:outline-none focus:ring-2 focus:z-10 w-24">All</a>
                        <a href="<%=Routers.BOOKING_ORDERS_SERVLET%>?status=PENDING" class="cursor-pointer mr-1 bg-amber-400 border-gray-200 rounded-md shadow-sm py-2 text-sm font-semibold text-white whitespace-nowrap focus:outline-none focus:ring-2 focus:z-10 w-24">Pending</a>
                        <a href="<%=Routers.BOOKING_ORDERS_SERVLET%>?status=READY" class="cursor-pointer mr-1 bg-blue-400 border-gray-200 rounded-md shadow-sm py-2 text-sm font-semibold text-white whitespace-nowrap focus:outline-none focus:ring-2 focus:z-10 w-24">Ready</a>
                        <a href="<%=Routers.BOOKING_ORDERS_SERVLET%>?status=COMPLETED" class="cursor-pointer mr-1 bg-green-400 border-gray-200 rounded-md shadow-sm py-2 text-sm font-semibold text-white whitespace-nowrap focus:outline-none focus:ring-2 focus:z-10 w-24">Completed</a>
                        <a href="<%=Routers.BOOKING_ORDERS_SERVLET%>?status=CANCEL" class="cursor-pointer mr-1 bg-rose-400 border-gray-200 rounded-md shadow-sm py-2 text-sm font-semibold text-white whitespace-nowrap focus:outline-none focus:ring-2 focus:z-10 w-24">Cancel</a>
                    </div>
                </div>

                <div class="flex flex-col items-center">
                    <div class="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
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
                                            for (HistoryDetail historyDetail : historyDetails) {
                                        %>
                                        <tr>
                                    <form action="<%= Routers.BOOKING_ORDERS_SERVLET%>" method="POST">
                                        <input name="historyId" value="<%= historyDetail.getHistory().getHistoryId()%>" class="hidden">
                                        <input name="location" value="<%= location%>" class="hidden">
                                        <td class="px-6 py-4 whitespace-nowrap">
                                            <div class="flex items-center">
                                                <div class="flex-shrink-0 h-20 w-20">
                                                    <img class="h-20 w-20" src="<%= historyDetail.getRoom().getUrlImage()%>" alt="" />
                                                </div>
                                                <div class="ml-4">
                                                    <div class="text-sm font-medium text-gray-900"><%= historyDetail.getRoomType().getRoomName()%></div>
                                                    <div class="text-sm text-gray-500"><%= historyDetail.getHistory().getTotal()%>$</div>
                                                    <div class="text-sm text-gray-500"><%= historyDetail.getHistory().getStartDate()%> ~ <%= historyDetail.getHistory().getEndDate()%></div>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="px-6 py-4 whitespace-nowrap">
                                            <div class="text-sm text-gray-900"><%= historyDetail.getHistory().getFullname()%></div>
                                            <div class="text-sm text-gray-500"><%= historyDetail.getHistory().getAddress()%></div>
                                            <div class="text-sm text-gray-900"><%= historyDetail.getHistory().getPhone()%></div>
                                        </td>
                                        <td class="px-6 py-4">
                                            <p class="text-sm text-gray-900 w-48 text-justify"><%= historyDetail.getHistory().getNote()%></p>
                                        </td>
                                        <td class="px-6 py-4">
                                            <textarea rows="4" name="message" id="message" class="shadow-md focus:ring-rose-500 focus:border-rose-500 block sm:text-sm border-gray-300 rounded-md w-48"><%= historyDetail.getHistory().getMessage()%></textarea>
                                        </td>
                                        <td class="px-6 py-4 whitespace-nowrap">
                                            <select id="historyStatus" name="historyStatus" class="cursor-pointer mt-1 block pl-3 pr-10 py-2 text-base border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm rounded-md">
                                                <%
                                                    for (HistoryStatus.status status : HistoryStatus.status.values()) {
                                                        if (status.toString().equals(historyDetail.getHistory().getHistoryStatus())) {
                                                %>
                                                <option value="<%= status.toString()%>" selected class="cursor-pointer"><%= status.toString()%></option>
                                                <%
                                                } else {
                                                %>
                                                <option value="<%= status.toString()%>" class="cursor-pointer"><%= status.toString()%></option>
                                                <%
                                                    }
                                                %>
                                                <%
                                                    }
                                                %>
                                            </select>

                                            <!-- <span class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800"> Active </span> -->
                                        </td>
                                        <td class="px-6 py-4 whitespace-nowrap text-right text-sm font-medium">
                                            <button type="submit" class="text-indigo-600 hover:text-indigo-900">Save</button>
                                        </td>
                                        </tr>
                                    </form>
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
