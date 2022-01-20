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
                <div class="">
                    <div class="h-48 w-full object-cover bg-rose-600 flex items-center justify-center">
                        <div class="text-white max-w-5xl px-4 sm:px-6 lg:px-8 w-fit -ml-[30rem]">
                            <h1 class="text-5xl mb-2">Find your next stay</h1>
                            <h2 class="text-2xl indent-7">Search deals on hotels, homes, and much more...</h2>
                        </div>
                    </div>
                </div>
                <div class="max-w-5xl mx-auto px-4 sm:px-6 lg:px-8">
                    <!--<div class="sm:flex sm:items-end sm:space-x-5 justify-center">-->
                <jsp:include page="./common/searchBar.jsp"></jsp:include>
            </div>
            <div class="hidden sm:block md:hidden mt-6 min-w-0 flex-1 text-red-500">
                <h1 class="text-2xl font-bold text-gray-900 truncate">Ricardo Cooper</h1>
            </div>
        </div>
    </div>
</body>
</html>
