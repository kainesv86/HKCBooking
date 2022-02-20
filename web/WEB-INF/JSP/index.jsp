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
            <jsp:param name="title" value="HKCBooking"/>
        </jsp:include>

    </head>
    <body>
        <div class="flex flex-col min-h-screen">
            <jsp:include page="./common/navbar.jsp"></jsp:include>
                <div class="min-h-full flex bg-gray-50 flex-1  items-center ">
                    <main class="flex h-full justify-center px-20 ">
                        <div class="text-center py-48 lg:text-left fade-in-index opacity-0">
                            <div class="px-4 sm:px-8 xl:pr-16 flex-1">
                                <h1 class="text-4xl tracking-tight font-extrabold text-gray-900 sm:text-5xl md:text-6xl lg:text-5xl xl:text-6xl flex flex-col">
                                    <span class="block xl:inline">Find your next</span>
                                    <span class="block text-rose-500 xl:inline">room stay</span>
                                </h1>
                                <p class="mt-3 max-w-md mx-auto text-lg text-gray-500 sm:text-xl md:mt-5 md:max-w-3xl">Search deals on hotels, homes, and much more...</p>
                                <div class="mt-10 sm:flex sm:justify-center lg:justify-start">
                                    <div class="rounded-md shadow">
                                        <a href="<%=Routers.FILTER_SERVLET%>" class="w-full flex items-center justify-center px-8 py-3 border border-transparent text-base font-medium rounded-md text-white bg-rose-600 hover:bg-rose-700 md:py-4 md:text-lg md:px-10"> Get started </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="w-1/2 h-full zoom-in">
                        <img class="inset-0 w-full h-full object-cover object-fit rounded-md" src="https://wallpaperaccess.com/full/2690557.jpg" alt="" />
                    </div>
                </main>
            </div>
        </div>
    </body>
</html>
