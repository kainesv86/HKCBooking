

<div class="flex w-fit bg-gray-100 rounded-md shadow-md overflow-hidden transform hover:scale-110 duration-300 mb-4">
    <div class="h-40 w-36 block">
        <img src="https://cdn.vietnambiz.vn/2019/11/4/dd32d9b188d86d6d8dc40d1ff9a0ebf6-15728512315071030248829.jpg" alt="" class="object-cover w-full h-full"/>
    </div>
    <div class="flex flex-col w-80 px-5 py-4 justify-between">
        <div>
            <p class="font-semibold text-lg text-gray-900">${param.roomName}</p>
            <p class="text-sm text-gray-800">Capacity: ${param.capacity}</p>
            <p class="text-sm text-amber-700">Price: ${param.price}$ / Day</p>
            <p class="text-xs text-gray-700 truncate">${param.description}</p>
        </div>
        <a class="text-rose-600 hover:text-red-700 text-xs cursor-pointer w-fit font-semibold">More detail</a>
    </div>
</div>
