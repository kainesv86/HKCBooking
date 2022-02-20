<%@page import="variables.Routers"%>
<%@page import="entities.RoomType"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="common/header.jsp">
            <jsp:param name="title" value="Add Room Type"/>
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
                        action="<%= Routers.ADD_ROOM_TYPE_SERVLET%>" method="POST"
                    class="space-y-8 divide-y divide-gray-200 min-w-[480px] max-w-[800px]"
                    >
                    <div class="space-y-8 divide-y divide-gray-200">
                        <div>
                            <div>
                                <h3 class="text-3xl text-center leading-6 font-semibold text-rose-500 mb-4">Add room</h3>
                            </div>
                            <jsp:include page="./Components/InputField.jsp">
                                <jsp:param name="key" value="roomName" />
                                <jsp:param name="type" value="text" />
                                <jsp:param name="label" value="Room Name" />
                                <jsp:param name="error" value="${requestScope.roomNameError}"/>
                            </jsp:include>

                            <jsp:include page="./Components/InputField.jsp">
                                <jsp:param name="key" value="capacity" />
                                <jsp:param name="type" value="number" />
                                <jsp:param name="label" value="Capacity" />
                                <jsp:param name="error" value="${requestScope.capacityError}"/>
                            </jsp:include>

                            <jsp:include page="./Components/InputField.jsp">
                                <jsp:param name="key" value="acreage" />
                                <jsp:param name="type" value="number" />
                                <jsp:param name="label" value="Acreage" />
                                <jsp:param name="error" value="${requestScope.acreageError}"/>
                            </jsp:include>

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
    </body>
</html>
