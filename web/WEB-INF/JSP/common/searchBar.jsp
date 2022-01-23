<div class="flex flex-col p-4 bg-rose-600 rounded-md overflow-hidden w-96">

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
                    <a class="bg-rose-700 rounded-tr-md rounded-br-md text-white text-sm hover:bg-rose-800 py-2 px-2">Search</a>
                </div>
            </div>
        </div>
        <div class="mb-2">
            <jsp:include page="../Components/InputDate.jsp">
                <jsp:param name="key" value="startDate"/>
                <jsp:param name="label" value="Start Date"/>
            </jsp:include>
        </div>

        <div class="mb-2">
            <jsp:include page="../Components/InputDate.jsp">
                <jsp:param name="key" value="endDate"/>
                <jsp:param name="label" value="End Date"/>
            </jsp:include>
        </div>

        <div>
            <input type="number" step="any" min="100000" value="100000" class="px-2 py-1 rounded-md"/>
        </div>
    </div>

</div>