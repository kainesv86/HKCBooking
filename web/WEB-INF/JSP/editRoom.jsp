<%@page import="variables.Routers"%>
<%@page import="entities.RoomType"%>
<%@page import="entities.RoomDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>
        <%
            ArrayList<RoomDetail> roomDetails = (ArrayList<RoomDetail>) request.getAttribute("roomDetails");
        %>
        <div class="flex min-h-screen">
            <jsp:include page="./common/Sidebar.jsp"></jsp:include>
                <div class="bg-gray-100 flex-1 p-20 min-w-auto">
                    <div class="text-center flex flex-col mb-4">
                        <h2 class="text-rose-600 text-2xl font-semibold">Room list</h2>
                    </div>

                    <div class="flex flex-col items-center">
                        <div class="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
                            <div class="py-2 align-middle inline-block min-w-auto sm:px-6 lg:px-8">
                                <div class="shadow overflow-hidden border-b border-gray-200 sm:rounded-lg">
                                    <table class="min-w-full divide-y divide-gray-200">
                                        <thead class="bg-gray-50">
                                            <tr>
                                                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Room Id</th>
                                                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Room Image</th>
                                                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Room Type</th>
                                                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider w-20">Price</th>
                                                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Description</th>
                                                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Status</th>
                                                <th scope="col" class="relative px-6 py-3">
                                                    <span class="sr-only">Edit</span>
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody class="bg-white divide-y divide-gray-200">
                                        <%
                                            for (RoomDetail roomDetail : roomDetails) {
                                        %>
                                        <tr>

                                    <input name="roomId" value="<%= roomDetail.getRoom().getRoomId()%>" class="hidden">

                                    <td class="px-6 py-4 whitespace-nowrap">
                                        <div class="text-sm text-gray-900"><%= roomDetail.getRoom().getRoomId()%></div>
                                    </td>
                                    <td class="px-6 py-4 whitespace-nowrap">
                                        <div class="flex-shrink-0 h-60 w-80">
                                            <img class="h-full w-full object-cover object-fit" src="<%= roomDetail.getRoom().getUrlImage()%>" alt="" />
                                        </div>

                                    </td>
                                    <td class="px-6 py-4 text-sm">
                                        <p class="font-medium text-gray-900 w-48"><%= roomDetail.getRoomType().getRoomName()%></p>
                                        <p class="text-gray-500"><%= roomDetail.getRoomType().getCapacity()%> people</p>
                                        <p class="text-gray-500"><%= roomDetail.getRoomType().getAcreage()%> square meters</p>
                                    </td>
                                    <td class="px-6 py-4">
                                        <p class="text-sm text-gray-900 text-justify"><%= roomDetail.getRoom().getPrice()%>$ / day</p>
                                    </td>
                                    <td class="px-6 py-4 w-48">
                                        <p class="text-sm text-gray-900 text-justify"><%= roomDetail.getRoom().getDescription()%></p>
                                    </td>
                                    <td class="px-6 py-4">
                                        <p class="text-sm text-gray-900 text-justify"><%= roomDetail.getRoom().getRoomStatus()%></p>
                                    </td>


                                    <td class="px-6 py-4 whitespace-nowrap text-right text-sm font-medium ">
                                        <div class="flex flex-col items-start justify-center">
                                            <a href="<%= Routers.EDIT_ROOM_DETAIL_SERVLET%>?roomId=<%= roomDetail.getRoom().getRoomId()%>" class="text-indigo-600 hover:text-indigo-900 font-semibold cursor-pointer">Edit</a>
                                            <a href="<%= Routers.DELETE_ROOM_SERVLET%>?roomId=<%= roomDetail.getRoom().getRoomId()%>" onclick="return confirm('Are you sure to delete roomId = <%= roomDetail.getRoom().getRoomId()%> and all customers book this room will be cancel')" class="text-rose-500 hover:text-rose-600 font-semibold cursor-pointer">Delete</a>
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
