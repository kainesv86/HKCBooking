<form class="flex flex-col px-5 py-10 bg-rose-600 rounded-md overflow-hidden w-96" action="FilterServlet" method="POST">

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
                    <input id="search" name="search" class="flex-1 block pl-10 pr-6 py-2 rounded-tl-md rounded-bl-md leading-5 bg-gray-700 text-gray-300 placeholder-gray-400 outline-none focus:bg-gray-100 focus:text-gray-900 sm:text-sm hover:bg-gray-100" placeholder="Search" type="search"/>
                    <button type="submit" class="bg-rose-700 rounded-tr-md rounded-br-md text-white text-sm hover:bg-rose-800 py-2 px-2">Search</button>
                </div>
            </div>
        </div>
        <div class="mb-2">
            <jsp:include page="../Components/InputDate.jsp">
                <jsp:param name="key" value="checkIn"/>
                <jsp:param name="label" value="Check In"/>
            </jsp:include>
        </div>

        <div class="mb-2">
            <jsp:include page="../Components/InputDate.jsp">
                <jsp:param name="key" value="checkOut"/>
                <jsp:param name="label" value="Check Out"/>
            </jsp:include>
        </div>

        <div class="flex mb-2 flex-col  ">
            <label class="text-white font-semibold">Price</label>
            <div class="flex text-gray-700 justify-between">
                <input type="number" step="any" min="100000" value="100000" class="px-2 py-1 rounded-md w-36"/>
                <p class="font-semibold text-white">~</p>
                <input type="number" step="any" min="100000" value="100000" class="px-2 py-1 rounded-md w-36"/>
            </div>
        </div>
    </div>

</form>