<div class="sm:grid sm:grid-cols-3 sm:gap-4 sm:items-start sm:border-t sm:border-gray-200 sm:pt-5">
    <label for="fullname" class="block text-sm font-medium text-gray-700 sm:mt-px sm:pt-2">${param.label}</label>
    <div class="mt-1 sm:mt-0 sm:col-span-2 flex">
        <input type="${param.type}" name="${param.key}" id="${param.key}" value="${param.value == "null" ?  "" : param.value }" class="max-w-lg block w-full shadow-sm focus:ring-rose-500 focus:border-rose-500 sm:max-w-xs sm:text-sm border-gray-300 rounded-md bg-gray-100 hover:bg-gray-200 py-1 px-2" />
        <p class="ml-4 mt-2 text-sm text-red-600">${param.error}</p>
    </div>
</div>