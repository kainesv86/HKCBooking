<div class="flex-1 flex justify-center px-2 lg:ml-6 lg:justify-end ">
    <div class="w-full">
        <label for="search" class="sr-only">Search</label>
        <div class="relative">
            <div class="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
                <!-- Heroicon name: solid/search -->
                <svg class="h-5 w-5 text-gray-400" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                    <path fill-rule="evenodd" d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z" clip-rule="evenodd" />
                </svg>
            </div>
            <div class="flex items-center -mt-7">
                <input id="search" name="search" class="block pl-10 pr-6 py-4 rounded-tl-md rounded-bl-md leading-5 bg-gray-700 text-gray-300 placeholder-gray-400 outline-none focus:bg-gray-100 focus:text-gray-900 sm:text-sm hover:bg-gray-100" placeholder="Search" type="search"/>
                <div class="flex text-white text-sm">
                    <label class="startDate bg-gray-700 py-4 px-2 " for="startDate">Start date</label>
                    <input type="date" id="startDate" class="bg-gray-700" min="2022-01-22"/>
                </div>
                <a class="bg-rose-700 rounded-tr-md rounded-br-md text-white text-sm hover:bg-rose-800 py-4 px-2">Search</a>
            </div>
        </div>
    </div>
</div>
