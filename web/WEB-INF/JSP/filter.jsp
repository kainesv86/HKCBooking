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
            Integer currentPage = (Integer) request.getAttribute("page");
            if (currentPage > 0) {
                --currentPage;
            }

            Integer lowerList = currentPage * listLimit;
            Integer upperList = lowerList + listLimit >= roomDetails.size() ? roomDetails.size() : lowerList + listLimit;

            Integer maxPagination = roomDetails.size() % listLimit == 0 ? roomDetails.size() / listLimit : (roomDetails.size() / listLimit) + 1;
            Integer lowerPagination = currentPage - 3 <= 0 ? 0 : currentPage - 3;
            Integer upperPagination = currentPage + 3 >= maxPagination ? maxPagination : currentPage + 3;

            String roomName = (String) request.getAttribute("roomName");

            String checkIn = (String) request.getAttribute("checkIn");
            String checkOut = (String) request.getAttribute("checkOut");

            Float minPrice = (Float) request.getAttribute("minPrice");
            Float maxPrice = (Float) request.getAttribute("maxPrice");
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
                            <jsp:param name="roomName" value="<%= roomName%>"/>
                            <jsp:param name="checkIn" value="<%= checkIn%>"/>
                            <jsp:param name="checkOut" value="<%= checkOut%>"/>
                            <jsp:param name="minPrice" value="<%= minPrice%>"/>
                            <jsp:param name="maxPrice" value="<%= maxPrice%>"/>
                        </jsp:include>
                    </div>
                    <div class="flex flex-col">
                        <% if (roomDetails.size() > 0) { %>
                        <%
                            for (int index = lowerList; index < upperList; index++) {
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
                        <%} else {%>
                        <div class="flex flex-col items-center justify-center h-full ml-8">
                            <a class="flex items-center" href="<%= Routers.INDEX_SERVLET%>">
                                <div class="w-20 h-20 text-rose-600">
                                    <svg viewBox="0 0 160 160" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <g clip-path="url(#clip0_512_6848)">
                                    <path opacity="0.3" d="M134 66.8861C134 85.2544 116.715 108.268 83.2985 134.856L80.5 137L77.7015 134.784C44.2846 108.268 27 85.2544 27 66.8861C27 39.4409 50.2108 19 80.5 19C110.789 19 134 39.3695 134 66.8861Z" fill="currentColor" />
                                    <path d="M120.5 67.9999C120.5 43.7999 102.833 26.6666 80.5 26.6666C58.1666 26.6666 40.5 43.7999 40.5 67.9999C40.5 83.5999 53.5 104.267 80.5 128.933C107.5 104.267 120.5 83.5999 120.5 67.9999ZM80.5 13.3333C108.5 13.3333 133.833 34.7999 133.833 67.9999C133.833 90.1333 116.033 116.333 80.5 146.667C44.9667 116.333 27.1667 90.1333 27.1667 67.9999C27.1667 34.7999 52.5 13.3333 80.5 13.3333Z" fill="currentColor" />
                                    <path d="M98.9 70.5882H107L80 42L53 70.5882H61.1V96H66.5V89.6471H93.5V96H98.9V70.5882ZM67.067 64.2353H92.933L93.5 64.8388V70.5882H66.5V64.8388L67.067 64.2353ZM86.939 57.8824H73.061L80 50.5447L86.939 57.8824ZM66.5 83.2941V76.9412H93.5V83.2941H66.5Z" fill="currentColor" />
                                    </g>
                                    <defs>
                                    <clipPath id="clip0_512_6848">
                                        <rect width="160" height="160" fill="white" transform="translate(0.5)" />
                                    </clipPath>
                                    </defs>
                                    </svg>
                                </div>
                                <p class="text-rose-600 text-4xl">HKCBooking</p>
                            </a>
                            <p class="font-semibold text-xl text-gray-800">None room can fit</p>
                            <a href="<%= Routers.INDEX_SERVLET%>" class="text-base font-medium text-rose-600 hover:text-rose-500">Go back home<span aria-hidden="true"> &rarr;</span></a>
                        </div>
                        <%}%>

                        <div/>

                    </div>
                </div>
            </div>
            <nav class="relative z-0 inline-flex rounded-md shadow-sm -space-x-px" aria-label="Pagination">
                <form href="<%= Routers.ADD_PARAMS_SERVLET%>" >
                    <button type="submit" class="relative inline-flex items-center px-2 py-2 rounded-l-md border border-gray-300 bg-white text-sm font-medium text-gray-500 hover:bg-gray-50">
                        <span class="sr-only">Previous</span>
                        <!-- Heroicon name: solid/chevron-left -->
                        <svg class="h-5 w-5" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                        <path fill-rule="evenodd" d="M12.707 5.293a1 1 0 010 1.414L9.414 10l3.293 3.293a1 1 0 01-1.414 1.414l-4-4a1 1 0 010-1.414l4-4a1 1 0 011.414 0z" clip-rule="evenodd" />
                        </svg>
                    </button>
                    <input value="<%=checkIn%>" type="text" name="checkIn" hidden readonly/>
                    <input value="<%=checkOut%>" type="text" name="checkOut" hidden readonly/>
                    <input value="<%=minPrice%>" type="number" name="minPrice" hidden readonly/>
                    <input value="<%=maxPrice%>" type="number" name="maxPrice" hidden readonly/>
                    <input name="page" readonly hidden type="text" value="<%=currentPage + 1 - 1%>" required readonly>
                    <input readonly required hidden value="<%= Routers.FILTER_SERVLET%>" type="text" name="redirectTo"/>
                </form>
                <%
                    for (int index = lowerPagination; index < upperPagination; index++) {

                %>
                <form action="<%= Routers.ADD_PARAMS_SERVLET%>" method="POST">
                    <button type="submit"   class="
                            <% if (index == currentPage) {
                            %>
                            z-10 bg-indigo-50 border-indigo-500 text-indigo-600
                            <% } else { %>
                            bg-white border-gray-300 text-gray-500 hover:bg-gray-50
                            <%
                                }
                            %>
                            relative inline-flex items-center px-4 py-2 border text-sm font-medium"> <%=index + 1%>
                    </button>

                    <input value="<%=checkIn%>" type="text" name="checkIn" hidden readonly/>
                    <input value="<%=checkOut%>" type="text" name="checkOut" hidden readonly/>
                    <input value="<%=minPrice%>" type="number" name="minPrice" hidden readonly/>
                    <input value="<%=maxPrice%>" type="number" name="maxPrice" hidden readonly/>
                    <input name="page" readonly hidden type="text" value="<%=index + 1%>" required readonly>
                    <input readonly required hidden value="<%= Routers.FILTER_SERVLET%>" type="text" name="redirectTo"/>
                </form>
                <!-- Current: "z-10 bg-indigo-50 border-indigo-500 text-indigo-600", Default: "bg-white border-gray-300 text-gray-500 hover:bg-gray-50" -->
                <% }
                %>
                <!--<a href="#" aria-current="page" class="z-10 bg-indigo-50 border-indigo-500 text-indigo-600 relative inline-flex items-center px-4 py-2 border text-sm font-medium"> 2 </a>-->

                <form href="<%= Routers.ADD_PARAMS_SERVLET%>" >
                    <button type="submit" class="relative inline-flex items-center px-2 py-2 rounded-r-md border border-gray-300 bg-white text-sm font-medium text-gray-500 hover:bg-gray-50">
                        <span class="sr-only">Next</span>
                        <!-- Heroicon name: solid/chevron-right -->
                        <svg class="h-5 w-5" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                        <path fill-rule="evenodd" d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z" clip-rule="evenodd" />
                        </svg>
                    </button>
                    <input value="<%=checkIn%>" type="text" name="checkIn" hidden readonly/>
                    <input value="<%=checkOut%>" type="text" name="checkOut" hidden readonly/>
                    <input value="<%=minPrice%>" type="number" name="minPrice" hidden readonly/>
                    <input value="<%=maxPrice%>" type="number" name="maxPrice" hidden readonly/>
                    <input name="page" readonly hidden type="text" value="<%=currentPage + 1 + 1%>" required readonly>
                    <input readonly required hidden value="<%= Routers.FILTER_SERVLET%>" type="text" name="redirectTo"/>
                </form>

            </nav>
        </div>
    </body>
</html>
