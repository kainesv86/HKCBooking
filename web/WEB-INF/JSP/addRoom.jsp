<%@page import="variables.Routers"%>
<%@page import="entities.RoomType"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="common/header.jsp">
            <jsp:param name="title" value="Add Room"/>
        </jsp:include>
    </head>
    <body>
        <%
            ArrayList<RoomType> roomTypes = (ArrayList<RoomType>) request.getAttribute("roomTypes");
            String message = (String) request.getAttribute("message");
        %>

        <div class="flex min-h-screen">
            <jsp:include page="./common/Sidebar.jsp"></jsp:include>
                <div class="bg-gray-100 flex-1 py-20 justify-center flex items-center">
                    <form
                        action="<%= Routers.ADD_ROOM_SERVLET%>" method="POST"
                    enctype="multipart/form-data"
                    class="space-y-8 divide-y divide-gray-200 fade-in min-w-[480px] max-w-[800px]"
                    >
                    <div class="space-y-8 divide-y divide-gray-200">
                        <div>
                            <div>
                                <h3 class="text-3xl text-center leading-6 font-semibold text-rose-500 mb-4">Add room</h3>
                            </div>
                            <div>
                                <label for="roomTypeId" class="block text-sm font-medium text-gray-700">Room Type</label>
                                <select id="roomTypeId" name="roomTypeId" class="mt-1 block w-full pl-3 pr-10 py-2 text-base border-gray-300 focus:outline-none focus:ring-rose-500 focus:border-rose-500 sm:text-sm rounded-md border-1">
                                    <%
                                        for (RoomType roomType : roomTypes) {
                                    %>
                                    <option value="<%= roomType.getRoomTypeId()%>"><%= roomType.getRoomName()%> - <%= roomType.getAcreage()%> square meters - <%= roomType.getCapacity()%> People</option>
                                    <% }%>
                                </select>
                            </div>
                            <jsp:include page="./Components/InputField.jsp">
                                <jsp:param name="key" value="price" />
                                <jsp:param name="type" value="number" />
                                <jsp:param name="label" value="Price" />
                                <jsp:param name="error" value="${requestScope.priceError}"/>
                            </jsp:include>
                            <div>
                                <label for="imageUrl" class="block text-sm font-medium text-gray-700">Room Image</label>
                                <div class="h-auto w-auto">
                                    <img class="h-full w-full object-cover object-fit" id="pre-photo" src="" alt="" />
                                </div>
                                <div class="mt-1">
                                    <input id="imageUrl" name="imageUrl" type="file" class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" />
                                </div>
                                <p class="mt-2 text-sm text-red-600">${requestScope.roomImageError}</p>
                            </div>
                            <div class="sm:col-span-6">
                                <label for="desciption" class="block text-sm font-medium text-gray-700">Description</label>
                                <div class="mt-1">
                                    <textarea id="description" name="description" rows="10" class="shadow-sm focus:ring-rose-500 focus:border-rose-500 block w-full sm:text-sm border border-gray-300 rounded-md"></textarea>
                                </div>
                            </div>
                        </div>


                        <div class="pt-5">
                            <div class="flex justify-end">
                                <a href="<%= Routers.ADD_ROOM_SERVLET%>" class="bg-white py-2 px-4 border border-gray-300 rounded-md shadow-sm text-sm font-medium text-gray-700 hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-rose-500">Cancel</a>
                                <button type="submit" class="ml-3 inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-rose-600 hover:bg-rose-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-rose-500">Add</button>
                            </div>
                        </div>
                        <p class="text-gray-800 text-sm font-semibold"><%=message == null ? "" : message%><p/>
                </form>
            </div>
        </div>
        <script>
            window.onload = function () {
                document.getElementById("imageUrl").addEventListener(
                        "change",
                        function () {
                            const reader = new FileReader();
                            reader.onload = function () {
                                const dataURL = reader.result;
                                const output = document.getElementById("pre-photo");
                                output.src = dataURL;
                            };
                            reader.readAsDataURL(this.files[0]);
                        },
                        false
                        );
            };
        </script>
    </body>
</html>
