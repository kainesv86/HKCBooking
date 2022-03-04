<form class="bg-rose-600 p-4 flex justify-cneter">
    <div class="mr-9 flex flex-col w-60">
        <div class="flex mb-2 flex-col">
            <label for="${param.key}" class="block text-sm text-gray-100 font-semibold">Room Id</label>
            <input value="${param.inputValue}" id="username" name="${param.key}" type="${param.type}"  class="appearance-none block w-full px-3 py-1 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" />
        </div>
        <div class="flex mb-2 flex-col">
            <label for="${param.key}" class="block text-sm text-gray-100 font-semibold">Room name</label>
            <input value="${param.inputValue}" id="username" name="${param.key}" type="${param.type}"  class="appearance-none block w-full px-3 py-1 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" />
        </div>
        <div class="flex mb-2 flex-col">
            <label for="${param.key}" class="block text-sm text-gray-100 font-semibold">Room Type</label>
            <select id="roomTypeId" name="roomTypeId" class="mt-1 block w-full pl-3 pr-10 py-1 text-base border-gray-200 focus:outline-none focus:ring-rose-500 focus:border-rose-500 sm:text-sm rounded-md">
                <option value="<%= roomType.getRoomTypeId()%>"><%= roomType.getRoomName()%></option>
            </select>
        </div>
        <div class="flex mb-2 flex-col">
            <label for="${param.key}" class="block text-sm text-gray-100 font-semibold">Room Status</label>
            <select id="roomTypeId" name="roomTypeId" class="mt-1 block w-full pl-3 pr-10 py-1 text-base border-gray-200 focus:outline-none focus:ring-rose-500 focus:border-rose-500 sm:text-sm rounded-md">
                <option value="<%= roomType.getRoomTypeId()%>"><%= roomType.getRoomName()%></option>
            </select>
        </div>
    </div>
    <div class="mr-9 flex flex-col w-60">
        <div class="flex mb-2 flex-col">
            <label for="${param.key}" class="block text-sm text-gray-100 font-semibold">User Id</label>
            <input value="${param.inputValue}" id="username" name="${param.key}" type="${param.type}"  class="appearance-none block w-full px-3 py-1 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" />
        </div>
        <div class="flex mb-2 flex-col">
            <label for="${param.key}" class="block text-sm text-gray-100 font-semibold">Booking person's name</label>
            <input value="${param.inputValue}" id="username" name="${param.key}" type="${param.type}"  class="appearance-none block w-full px-3 py-1 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" />
        </div>
        <div class="flex mb-2 flex-col">
            <label for="${param.key}" class="block text-sm text-gray-100 font-semibold">Room name</label>
            <input value="${param.inputValue}" id="username" name="${param.key}" type="${param.type}"  class="appearance-none block w-full px-3 py-1 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" />
        </div>
        <div class="flex mb-2 flex-col">
            <label for="${param.key}" class="block text-sm text-gray-100 font-semibold">Room Type</label>
            <select id="roomTypeId" name="roomTypeId" class="mt-1 block w-full pl-3 pr-10 py-1 text-base border-gray-200 focus:outline-none focus:ring-rose-500 focus:border-rose-500 sm:text-sm rounded-md">
                <option value="<%= roomType.getRoomTypeId()%>"><%= roomType.getRoomName()%></option>
            </select>
        </div>
    </div>
    <div>
        <div class="flex">
            <div class="flex mb-2 flex-col">
                <label class="text-white text-sm font-semibold" for="${param.key}">${param.label}</label>
                <input type="date" class="px-2 py-1 rounded-md w-40" name="${param.key}" id="${param.key}" min="${param.min}" max="${param.maxDate}" />
            </div>
            <p class="mx-4 block"></p>
            <div class="flex flex-col">
                <label class="text-white text-sm font-semibold" for="${param.key}">${param.label}</label>
                <input type="date" class="px-2 py-1 rounded-md w-40" name="${param.key}" id="${param.key}" min="${param.min}" max="${param.maxDate}" />
            </div>
        </div>
        <div class="flex mb-2">
            <div class="flex flex-col">
                <label class="text-white text-sm font-semibold" for="${param.key}">${param.label}</label>
                <input id="username" name="${param.key}" type="${param.type}"   class="appearance-none block px-3 py-1 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-rose-500 focus:border-rose-500 sm:text-sm w-40" />
            </div>
            <p class="mx-4 block"></p>
            <div class="flex flex-col">
                <label class="text-white text-sm font-semibold" for="${param.key}">${param.label}</label>
                <input id="username" name="${param.key}" type="${param.type}"   class="appearance-none block px-3 py-1 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-rose-500 focus:border-rose-500 sm:text-sm w-40" />
            </div>
        </div>
    </div>
</form>