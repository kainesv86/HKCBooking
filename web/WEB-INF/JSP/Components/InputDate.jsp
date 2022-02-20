<div class="flex flex-col">
    <label class="text-white text-sm font-semibold" for="${param.key}">${param.label}</label>
    <input type="date" class="px-2 py-1 rounded-md" name="${param.key}" id="${param.key}" min="${param.min}" max="${param.maxDate}" required value="${param.inputValue != "null" ? param.inputValue: "" }"/>
    <p class="mt-2 text-sm text-red-600" id="${param.key}">${param.error == "null" ? "" : param.error}</p>
</div>
