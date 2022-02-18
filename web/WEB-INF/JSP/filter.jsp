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
        %>

        <div class="flex flex-col min-h-screen">
            <jsp:include page="./common/navbar.jsp"></jsp:include>
                <div class="min-h-full flex flex-col bg-gray-200 flex-1">
                    <div class="h-[28rem] w-full object-cover flex items-center justify-center relative">
                        <div class="text-gray-100 max-w-5xl px-4 sm:px-6 lg:px-8 w-fit -ml-[30rem] z-10">
                            <h1 class="text-5xl mb-2">Find your rest room</h1>
                            <h2 class="text-2xl indent-7">Find your room with fit price, type and date.</h2>
                        </div>
                        <div class="absolute h-full w-full">
                            <div class="h-full w-full absolute">
                                <img class="w-full h-full object-cover object-fit" src="https://d1epjnee0y8w64.cloudfront.net/blog/s3fs-public/2019-02/architecture-chair-contemporary-1001965.jpg" alt="">
                            </div>
                            <div class="block w-full h-full bg-gray-900 absolute opacity-50"></div>
                        </div>
                    </div>

                    <div class="py-10 px-60 flex justify-center">
                        <div class="mr-4">
                        <jsp:include page="./common/searchBar.jsp"></jsp:include>
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
