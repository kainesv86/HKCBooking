<%@page import="variables.Routers"%>
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
        <jsp:include page="common/header.jsp">
            <jsp:param name="title" value="Filter Room"/>
        </jsp:include>
    </head>
    <body>
        <%
            ArrayList<RoomDetail> roomDetails = (ArrayList<RoomDetail>) request.getAttribute("roomDetails");
            session.setAttribute("roomDetailsClone", roomDetails);

            String minCheckIn = (String) request.getAttribute("minCheckIn");
            String minCheckOut = (String) request.getAttribute("minCheckOut");
            Integer listLimit = 10;
            Integer currentPage = (Integer) request.getAttribute("currentPage");

            Integer lowerList = (currentPage - 1) * listLimit;
            Integer upperList = lowerList + listLimit >= roomDetails.size() ? roomDetails.size() : lowerList + listLimit;

            Integer maxPagination = roomDetails.size() % listLimit == 0 ? roomDetails.size() / listLimit : (roomDetails.size() / listLimit) + 1;
            Integer lowerPagination = currentPage - 3 <= 0 ? 0 : currentPage - 3;
            Integer upperPagination = currentPage + 3 >= maxPagination ? maxPagination : currentPage + 3;
            System.out.println(lowerPagination + " : " + upperPagination);
        %>

        <div class="flex flex-col min-h-screen">
            <jsp:include page="./common/navbar.jsp"></jsp:include>
                <div class="min-h-full flex flex-col bg-gray-200 flex-1 items-center pb-10">
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
                        <jsp:include page="./common/searchBar.jsp">
                            <jsp:param name="minCheckIn" value="<%=minCheckIn%>"/>
                            <jsp:param name="minCheckOut" value="<%=minCheckOut%>"/>
                        </jsp:include>
                    </div>
                    <div class="flex flex-col">

                        <% for (int index = lowerList; index < upperList; index++) {

                        %>
                        <jsp:include page="./Components/room.jsp">
                            <jsp:param name="urlImage" value="<%=roomDetails.get(index).getRoom().getUrlImage()%>"/>
                            <jsp:param name="roomName" value="<%=roomDetails.get(index).getRoomType().getRoomName()%>"/>
                            <jsp:param name="capacity" value="<%=roomDetails.get(index).getRoomType().getCapacity()%>"/>
                            <jsp:param name="price" value="<%=roomDetails.get(index).getRoom().getPrice()%>"/>
                            <jsp:param name="description" value="<%=roomDetails.get(index).getRoom().getDescription()%>"/>
                            <jsp:param name="roomId" value="<%=roomDetails.get(index).getRoom().getRoomId()%>"/>
                        </jsp:include>
                        <% }%>

                        <div/>

                    </div>
                </div>
            </div>
            <nav class="relative z-0 inline-flex rounded-md shadow-sm -space-x-px" aria-label="Pagination">
                <a href="#" class="relative inline-flex items-center px-2 py-2 rounded-l-md border border-gray-300 bg-white text-sm font-medium text-gray-500 hover:bg-gray-50">
                    <span class="sr-only">Previous</span>
                    <!-- Heroicon name: solid/chevron-left -->
                    <svg class="h-5 w-5" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                    <path fill-rule="evenodd" d="M12.707 5.293a1 1 0 010 1.414L9.414 10l3.293 3.293a1 1 0 01-1.414 1.414l-4-4a1 1 0 010-1.414l4-4a1 1 0 011.414 0z" clip-rule="evenodd" />
                    </svg>
                </a>
                <%
                    for (int index = lowerPagination; index < upperPagination; index++) {

                %>
                <a href="<%= Routers.FILTER_SERVLET%>?page=<%=index + 1%>" class="<% if (index == currentPage - 1) { %> z-10 bg-indigo-50 border-indigo-500 text-indigo-600 <%
                } else { %>

                   bg-white border-gray-300 text-gray-500 hover:bg-gray-50
                   <%
                       }%> relative inline-flex items-center px-4 py-2 border text-sm font-medium"> <%=index + 1%> </a>
                <!-- Current: "z-10 bg-indigo-50 border-indigo-500 text-indigo-600", Default: "bg-white border-gray-300 text-gray-500 hover:bg-gray-50" -->
                <% }
                %>
                <!--<a href="#" aria-current="page" class="z-10 bg-indigo-50 border-indigo-500 text-indigo-600 relative inline-flex items-center px-4 py-2 border text-sm font-medium"> 2 </a>-->
                <a href="#" class="relative inline-flex items-center px-2 py-2 rounded-r-md border border-gray-300 bg-white text-sm font-medium text-gray-500 hover:bg-gray-50">
                    <span class="sr-only">Next</span>
                    <!-- Heroicon name: solid/chevron-right -->
                    <svg class="h-5 w-5" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                    <path fill-rule="evenodd" d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z" clip-rule="evenodd" />
                    </svg>
                </a>
            </nav>
        </div>
    </body>
</html>
