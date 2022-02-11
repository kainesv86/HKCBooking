<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>
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

                        <c:forEach var="room" items="${requestScope.rooms}">
                            <jsp:include page="./Components/room.jsp">
                                <jsp:param name="roomName" value="Dual Room"/>
                                <jsp:param name="capacity" value="2"/>
                                <jsp:param name="price" value="25"/>
                                <jsp:param name="description" value="Something is very very very very very very long even nobody give a shit care"/>
                            </jsp:include>
                        </c:forEach>

                        <jsp:include page="./Components/room.jsp">
                            <jsp:param name="roomName" value="Dual Room"/>
                            <jsp:param name="capacity" value="2"/>
                            <jsp:param name="price" value="25"/>
                            <jsp:param name="description" value="Something is very very very very very very long even nobody give a shit care"/>
                        </jsp:include>

                        <jsp:include page="./Components/room.jsp">
                            <jsp:param name="roomName" value="Dual Room"/>
                            <jsp:param name="capacity" value="2"/>
                            <jsp:param name="price" value="25"/>
                            <jsp:param name="description" value="Something is very very very very very very long"/>
                        </jsp:include>

                        <jsp:include page="./Components/room.jsp">
                            <jsp:param name="roomName" value="Dual Room"/>
                            <jsp:param name="capacity" value="2"/>
                            <jsp:param name="price" value="25"/>
                            <jsp:param name="description" value="Something is very very very very very very long"/>
                        </jsp:include>


                        <div/>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
