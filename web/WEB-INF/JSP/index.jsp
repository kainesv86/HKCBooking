<%--
    Document   : index
    Created on : Jan 12, 2022, 9:53:30 PM
    Author     : kaine
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.tailwindcss.com"></script>
        <jsp:include page="./common/navbar.jsp"></jsp:include>
    </head>
    <body>
        <div>
            <div>
                <div class="h-48 w-full object-cover bg-rose-600"></div>
            </div>
            <div class="max-w-5xl mx-auto px-4 sm:px-6 lg:px-8">
                <div class="sm:flex sm:items-end sm:space-x-5 justify-center">

                    <img class="h-24 w-24 rounded-full ring-4 ring-yellow-500 sm:h-32 sm:w-32" src="https://images.unsplash.com/photo-1463453091185-61582044d556?ixlib=rb-=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=8&w=1024&h=1024&q=80" alt="" />

                </div>
                <div class="hidden sm:block md:hidden mt-6 min-w-0 flex-1">
                    <h1 class="text-2xl font-bold text-gray-900 truncate">Ricardo Cooper</h1>
                </div>
            </div>
        </div>
    </body>
</html>
