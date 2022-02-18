<%@page import="variables.roomStatus"%>
<%@page import="entities.Room"%>
<%@page import="entities.RoomType"%>
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
            Room room = (Room) request.getAttribute("room");
            ArrayList<RoomType> roomTypes = (ArrayList<RoomType>) request.getAttribute("roomTypes");
        %>

        <div class="flex min-h-screen">
            <jsp:include page="./common/Sidebar.jsp"></jsp:include>
                <div class="bg-gray-100 flex-1 py-20 justify-center flex items-center">
                    <form
                        action="EditRoomDetailServlet" method="POST"
                        enctype="multipart/form-data"
                        class="space-y-8 divide-y divide-gray-200 min-w-[480px] max-w-[800px]"
                        >

                        <input value="<%= room.getRoomId()%>" readonly name="roomId" class="hidden"/>
                    <div class="space-y-8 divide-y divide-gray-200">
                        <div>
                            <div>
                                <h3 class="text-3xl text-center leading-6 font-semibold text-rose-500 mb-4">Edit room</h3>
                            </div>
                            <div>
                                <label for="roomTypeId" class="block text-sm font-medium text-gray-700">Room Type</label>
                                <select id="roomTypeId" name="roomTypeId" class="mt-1 block w-full pl-3 pr-10 py-2 text-base border-gray-300 focus:outline-none focus:ring-rose-500 focus:border-rose-500 sm:text-sm rounded-md">
                                    <%
                                        for (RoomType roomType : roomTypes) {
                                    %>
                                    <option value="<%= roomType.getRoomTypeId()%>" <% if (roomType.getRoomTypeId() == room.getRoomTypeId()) { %> selected <% }%> ><%= roomType.getRoomName()%></option>
                                    <% }%>
                                </select>
                            </div>
                            <jsp:include page="./Components/InputField.jsp">
                                <jsp:param name="key" value="price" />
                                <jsp:param name="type" value="number" />
                                <jsp:param name="label" value="Price" />
                                <jsp:param name="inputValue" value="<%=room.getPrice()%>" />
                                <jsp:param name="error" value="${requestScope.priceError}"/>
                            </jsp:include>
                            <div>
                                <label for="imageUrl" class="block text-sm font-medium text-gray-700">Room Image</label>
                                <div class="h-auto w-auto">
                                    <img class="h-full w-full object-cover object-fit" src="<%= room.getUrlImage()%>" alt="" />
                                </div>
                                <div class="mt-2">
                                    <input id="imageUrl" name="imageUrl" type="file" class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" />
                                </div>
                                <p class="mt-2 text-sm text-red-600">${requestScope.roomImageError}</p>
                            </div>
                            <div class="sm:col-span-6">
                                <label for="desciption" class="block text-sm font-medium text-gray-700">Description</label>
                                <div class="mt-1">
                                    <textarea id="description" name="description" rows="10" class="shadow-sm focus:ring-rose-500 focus:border-rose-500 block w-full sm:text-sm border border-gray-300 rounded-md"><%=room.getDescription()%></textarea>
                                </div>
                            </div>
                        </div>

                        <div>
                            <label for="roomStatus" class="block text-sm font-medium text-gray-700">Room Status</label>
                            <select id="roomStatus" name="roomStatus" class="mt-1 block w-full pl-3 pr-10 py-2 text-base border-gray-300 focus:outline-none focus:ring-rose-500 focus:border-rose-500 sm:text-sm rounded-md">
                                <%
                                    for (roomStatus.status status : roomStatus.status.values()) {
                                %>
                                <option value="<%= status.toString()%>" <% if (status.toString().equals(room.getRoomStatus())) { %> selected <% }%> ><%= status.toString()%></option>
                                <% }%>
                            </select>
                        </div>


                        <div class="pt-5">
                            <div class="flex justify-end">
                                <a href="EditRoomServlet" class="bg-white py-2 px-4 border border-gray-300 rounded-md shadow-sm text-sm font-medium text-gray-700 hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-rose-500">Cancel</a>
                                <button type="submit" class="ml-3 inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-rose-600 hover:bg-rose-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-rose-500">Update</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
    </body>
</html>
