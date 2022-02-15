<div>
    <label for="${param.key}" class="block text-sm font-medium text-gray-700">${param.label}</label>
    <div class="mt-1">
        <input value="${param.inputValue}" id="username" name="${param.key}" type="${param.type}" autocomplete="${param.key != "password"  ? param.key : ""}" required class="appearance-none block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm placeholder-gray-400 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" />
    </div>
    <p class="mt-2 text-sm text-red-600" id="${param.key}">${param.error == "null" ? "" : param.error}</p>
</div>
