<%@page import="variables.Routers"%>
<form class="flex flex-col px-5 py-10 bg-rose-600 rounded-md overflow-hidden w-96" action="<%= Routers.ADD_PARAMS_SERVLET%>" method="POST">
    <input readonly required hidden value="<%= Routers.FILTER_SERVLET%>" type="text" name="redirectTo"/>
    <label class="text-center text-white mb-4 text-2xl font-medium">Search filter</label>
    <div class="flex-1 flex justify-center px-2 lg:justify-end flex-col">
        <div class="w-full mb-2">
            <label for="search" class="sr-only">Search</label>
            <div class="relative">
                <div class="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                    <!-- Heroicon name: solid/search -->
                    <svg class="h-5 w-5 text-gray-400" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                        <path fill-rule="evenodd" d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z" clip-rule="evenodd" />
                    </svg>
                </div>
                <div class="flex items-center">
                    <input id="roomName" name="roomName" class="flex-1 block pl-10 pr-6 py-2 rounded-tl-md rounded-bl-md leading-5 bg-gray-700 text-gray-300 placeholder-gray-400 outline-none focus:bg-gray-100 focus:text-gray-900 sm:text-sm hover:bg-gray-100" placeholder="Search" type="search"/>
                    <button type="submit" class="bg-rose-700 rounded-tr-md rounded-br-md text-white text-sm hover:bg-rose-800 py-2 px-2">Search</button>
                </div>
            </div>
        </div>
        <div class="mb-2">
            <jsp:include page="../Components/InputDate.jsp">
                <jsp:param name="key" value="checkIn"/>
                <jsp:param name="label" value="Check In"/>
                <jsp:param name="inputValue" value="${param.checkIn}"/>
                <jsp:param name="min" value="${param.minCheckIn}" />
                <jsp:param name="error" value="${requestScope.checkInError}" />
            </jsp:include>
        </div>

        <div class="mb-2">
            <jsp:include page="../Components/InputDate.jsp">
                <jsp:param name="key" value="checkOut"/>
                <jsp:param name="label" value="Check Out"/>
                <jsp:param name="inputValue" value="${param.checkOut}"/>
                <jsp:param name="min" value="${param.minCheckOut}"/>
                <jsp:param name="error" value="${requestScope.checkOutError}" />
            </jsp:include>
        </div>

        <div class="flex mb-2 flex-col  ">
            <label class="text-white font-semibold">Price</label>
            <div class="flex text-gray-700 justify-between">
                <input type="number" step="any" min="0" name="minPrice" class="px-2 py-1 rounded-md w-36" value="${param.minPrice != null ? param.minPrice : ""}"/>
                <p class="font-semibold text-white">~</p>
                <input type="number" step="any" min="0" name="maxPrice" class="px-2 py-1 rounded-md w-36" value="${param.maxPrice != "null" ? param.maxPrice : ""}"/>
            </div>
            <p class="mt-2 text-sm text-white" >${requestScope.priceError}</p>
        </div>
    </div>

</form>