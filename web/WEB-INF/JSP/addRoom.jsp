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
            ArrayList<RoomType> roomTypes = (ArrayList<RoomType>) request.getAttribute("roomTypes");
        %>

        <div class="flex min-h-screen">
            <jsp:include page="./common/Sidebar.jsp"></jsp:include>
                <div class="bg-gray-100 flex-1 py-20 justify-center flex items-center">
                    <form class="space-y-8 divide-y divide-gray-200 min-w-[480px] max-w-[800px]" method="POST" action="AddRoomServlet">
                        <div class="space-y-8 divide-y divide-gray-200">
                            <div>
                                <div>
                                    <h3 class="text-3xl text-center leading-6 font-semibold text-rose-500 mb-4">Add room</h3>
                                </div>
                                <div>
                                    <label for="roomTypeId" class="block text-sm font-medium text-gray-700">Room Type</label>
                                    <select id="roomTypeId" name="roomTypeId" class="mt-1 block w-full pl-3 pr-10 py-2 text-base border-gray-300 focus:outline-none focus:ring-rose-500 focus:border-rose-500 sm:text-sm rounded-md">
                                    <%
                                        for (RoomType roomType : roomTypes) {
                                    %>
                                    <option value="<%= roomType.getRoomTypeId()%>"><%= roomType.getRoomName()%></option>
                                    <% }%>
                                </select>
                            </div>
                            <jsp:include page="./Components/InputField.jsp">
                                <jsp:param name="key" value="price" />
                                <jsp:param name="type" value="number" />
                                <jsp:param name="label" value="Price" />
                                <jsp:param name="error" value="${requestScope.priceError}"/>
                            </jsp:include>
                            <jsp:include page="./Components/InputField.jsp">
                                <jsp:param name="key" value="roomImage" />
                                <jsp:param name="type" value="file" />
                                <jsp:param name="label" value="Room Image" />
                                <jsp:param name="error" value="${requestScope.roomImageError}"/>
                            </jsp:include>
                            <div class="sm:col-span-6">
                                <label for="desciption" class="block text-sm font-medium text-gray-700"> Desciption </label>
                                <div class="mt-1">
                                    <textarea id="desciption" name="desciption" rows="10" class="shadow-sm focus:ring-rose-500 focus:border-rose-500 block w-full sm:text-sm border border-gray-300 rounded-md"></textarea>
                                </div>
                            </div>
                        </div>


                        <div class="pt-5">
                            <div class="flex justify-end">
                                <a href="AddRoomServlet" class="bg-white py-2 px-4 border border-gray-300 rounded-md shadow-sm text-sm font-medium text-gray-700 hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-rose-500">Cancel</a>
                                <button type="submit" class="ml-3 inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-rose-600 hover:bg-rose-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-rose-500">Add</button>
                            </div>
                        </div>
                </form>
            </div>
        </div>
    </body>
</html>
