<%@page import="helper.FunctionJSP"%>
<%@page import="entities.RoomType"%>
<%@page import="entities.Room"%>
<%@page import="java.util.ArrayList"%>
<%@page import="repositories.RoomTypeRepository"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>
        <%
            ArrayList<Room> rooms = (ArrayList<Room>) request.getAttribute("rooms");
//            RoomTypeRepository rtr = new RoomTypeRepository();
            ArrayList<RoomType> roomTypes = (ArrayList<RoomType>) request.getAttribute("roomTypes");

        %>

        <div class="flex flex-col min-h-screen">
            <jsp:include page="./common/navbar.jsp"></jsp:include>
                <div class="min-h-full flex flex-col bg-gray-200 flex-1">
                    <div class="h-72 w-full object-cover bg-rose-600 flex items-center justify-center">
                        <div class="text-white max-w-5xl px-4 sm:px-6 lg:px-8 w-fit -ml-[30rem]">
                            <h1 class="text-5xl mb-2">Find your next stay</h1>
                            <h2 class="text-2xl indent-7">Search deals on hotels, , and much more...</h2>
                        </div>
                    </div>

                    <div class="py-10 px-60 flex justify-center">
                        <div class="mr-4">
                        <jsp:include page="./common/searchBar.jsp"></jsp:include>
                        </div>
                        <div class="flex flex-col">

                        <% for (int index = 0; index < rooms.size(); index++) {
                                RoomType roomType = FunctionJSP.getRoomTypeById(roomTypes, rooms.get(index).getRoomTypeId());
                        %>
                        <jsp:include page="./Components/room.jsp">
                            <jsp:param name="roomName" value="<%=roomType.getRoomName()%>"/>
                            <jsp:param name="capacity" value="<%=roomType.getCapacity()%>"/>
                            <jsp:param name="price" value="<%=rooms.get(index).getPrice()%>"/>
                            <jsp:param name="description" value="<%=rooms.get(index).getDescription()%>"/>
                            <jsp:param name="roomId" value="<%=rooms.get(index).getRoomId()%>"/>
                        </jsp:include>
                        <% }%>

                        <div/>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
