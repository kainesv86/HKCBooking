<%@page import="entities.RoomDetail"%>
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
            ArrayList<RoomDetail> roomDetails = (ArrayList<RoomDetail>) request.getAttribute("roomDetails");
            String minCheckIn = (String) request.getAttribute("minCheckIn");
            String minCheckOut = (String) request.getAttribute("minCheckOut");
        %>

        <div class="flex flex-col min-h-screen">
            <jsp:include page="./common/navbar.jsp"></jsp:include>
                <div class="min-h-full flex flex-col bg-gray-200 flex-1">
                    <div class="h-[40rem] w-full object-cover flex items-center justify-center relative">
                        <div class="text-gray-100 max-w-5xl px-4 sm:px-6 lg:px-8 w-fit -ml-[30rem] z-10">
                            <h1 class="text-5xl mb-2">Find your next stay</h1>
                            <h2 class="text-2xl indent-7">Search deals on hotels and much more...</h2>
                        </div>
                        <div class="absolute h-full w-full">
                            <div class="h-full w-full absolute">
                                <img class="w-full h-full object-fit object-cover object-bottom" src="https://wallpaperaccess.com/full/2690557.jpg" alt="" />
                            </div>
                            <div class="block w-full h-full bg-gray-900 absolute opacity-50"></div>
                        </div>
                    </div>

                    <div class="py-10 px-60 flex justify-center">
                        <div class="mr-4">
                        <jsp:include page="./common/searchBar.jsp">
                            <jsp:param name="minCheckIn" value="<%=minCheckIn%>"/>
                            <jsp:param name="minCheckOut" value="<%=minCheckOut%>"/>
                        </jsp:include>
                    </div>
                    <div class="flex flex-col">

                        <% for (RoomDetail roomDetail : roomDetails) {

                        %>
                        <jsp:include page="./Components/room.jsp">
                            <jsp:param name="urlImage" value="<%=roomDetail.getRoom().getUrlImage()%>"/>
                            <jsp:param name="roomName" value="<%=roomDetail.getRoomType().getRoomName()%>"/>
                            <jsp:param name="capacity" value="<%=roomDetail.getRoomType().getCapacity()%>"/>
                            <jsp:param name="price" value="<%=roomDetail.getRoom().getPrice()%>"/>
                            <jsp:param name="description" value="<%=roomDetail.getRoom().getDescription()%>"/>
                            <jsp:param name="roomId" value="<%=roomDetail.getRoom().getRoomId()%>"/>
                        </jsp:include>
                        <% }%>

                        <div/>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
