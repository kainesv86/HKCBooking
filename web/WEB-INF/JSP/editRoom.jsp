<%@page import="variables.RoomStatus"%>
<%@page import="variables.Routers"%>
<%@page import="entities.RoomType"%>
<%@page import="entities.RoomDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="common/header.jsp">
            <jsp:param name="title" value="Edit Room"/>
        </jsp:include>
    </head>
    <body>
        <%
            ArrayList<RoomDetail> roomDetails = (ArrayList<RoomDetail>) request.getAttribute("roomDetails");
            ArrayList<RoomType> roomTypes = (ArrayList<RoomType>) request.getAttribute("roomTypes");
        %>
        <div class="flex min-h-screen">
            <jsp:include page="./common/Sidebar.jsp"></jsp:include>
                <div class="bg-gray-100 flex-1 p-20 min-w-auto">
                    <div class="text-center flex flex-col mb-4">
                        <h2 class="text-rose-600 text-2xl font-semibold">Room list</h2>
                    </div>

                    <div class="flex flex-col items-center">
                        <form action="<%=Routers.ADD_PARAMS_SERVLET%>" method="POST" class="bg-rose-600 py-6 px-12 flex flex-col rounded-md mb-4">
                        <input readonly required hidden value="<%= Routers.EDIT_ROOM_SERVLET%>" type="text" name="redirectTo"/>
                        <div class="flex mb-2">
                            <div class="flex flex-col mr-4">
                                <label for="roomId" class="block text-sm text-gray-100 font-semibold">Room Id</label>
                                <input  id="roomId" name="roomId" type="text"  class="appearance-none block w-full px-3 py-1 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" />
                            </div>
                            <div class="flex flex-col mr-4">
                                <label for="roomName" class="block text-sm text-gray-100 font-semibold">Room name</label>
                                <input  id="roomName" name="roomName" type="text}"  class="appearance-none block w-full px-3 py-1 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" />
                            </div>
                            <div class="flex flex-col mr-4">
                                <label for="capacity" class="block text-sm text-gray-100 font-semibold">Capacity</label>
                                <input  id="capacity" name="capacity" type="number" min="0"  class="appearance-none block w-full px-3 py-1 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" />
                            </div>

                            <div class="flex flex-col mr-4">
                                <label for="minPrice" class="block text-sm text-gray-100 font-semibold">Min price</label>
                                <input  id="minPrice" name="minPrice" type="number" min="0" class="appearance-none block w-full px-3 py-1 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" />
                            </div>

                            <div class="flex flex-col">
                                <label for="maxPrice" class="block text-sm text-gray-100 font-semibold">Max price</label>
                                <input  id="maxPrice" name="maxPrice" type="number" min="0" class="appearance-none block w-full px-3 py-1 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" />
                            </div>
                        </div>

                        <div class="flex mb-2">
                            <div class="flex flex-col mr-4 w-60">
                                <label for="roomTypeId" class="block text-sm text-gray-100 font-semibold">Room Type</label>
                                <select id="roomTypeId" name="roomTypeId" class="block w-full pl-3 pr-10 py-1 text-base border-gray-200 focus:outline-none focus:ring-rose-500 focus:border-rose-500 sm:text-sm rounded-md">
                                    <option value="" selected></option>
                                    <%
                                        for (RoomType roomType : roomTypes) {
                                    %>
                                    <option value="<%=roomType.getRoomTypeId()%>" ><%=roomType.getRoomName()%></option>
                                    <% }
                                    %>

                                </select>
                            </div>
                            <div class="flex flex-col mr-4 w-60">
                                <label for="roomStatus" class="block text-sm text-gray-100 font-semibold">Room Status</label>
                                <select id="roomStatus" name="roomStatus" class="block w-full pl-3 pr-10 py-1 text-base border-gray-200 focus:outline-none focus:ring-rose-500 focus:border-rose-500 sm:text-sm rounded-md">
                                    <option value="" selected></option>
                                    <%
                                        for (RoomStatus.status status : RoomStatus.status.values()) {
                                            if (status != RoomStatus.status.DELETED) {
                                    %>
                                    <option value="<%= status.toString()%>" ><%=status.toString()%></option>
                                    <% }
                                        }
                                    %>

                                </select>
                            </div>
                        </div>
                        <div class="flex mb-2 justify-end">
                            <button type="submit" class="flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-semibold text-rose-500 bg-gray-100 hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-gray-200">Filter</button>
                        </div>
                    </form>
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
