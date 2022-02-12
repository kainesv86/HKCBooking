<div class="flex flex-col">
    <label class="text-white text-sm font-semibold" for="${param.key}">${param.label}</label>
    <input type="date" class="px-2 py-1 rounded-md" 
           name="${param.key}" id="${param.key}" min="${param.minDate}" max="${param.maxDate}"/>
</div>
