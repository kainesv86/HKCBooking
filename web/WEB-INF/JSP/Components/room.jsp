<%@page import="variables.Routers"%>
<div class="flex bg-gray-100 rounded-md shadow-md overflow-hidden transform hover:scale-105 duration-300 fade-in">
    <div class="h-40 w-36 block">
        <img src="${param.urlImage == "null" ? "../../public/images/default-image.jpg" : param.urlImage }" alt="" class="object-cover w-full h-full"/>
    </div>
    <div class="flex flex-col w-96 px-5 py-4 justify-between">
        <div>
            <p class="font-semibold text-lg text-gray-900">${param.roomName}</p>
            <p class="text-sm text-gray-800">Capacity: ${param.capacity}</p>
            <p class="text-sm text-amber-700">Price: ${param.price}$ / Day</p>
            <p class="text-xs text-gray-700 truncate">${param.description}</p>
        </div>
        <a href="<%= Routers.ROOM_DETAIL_SERVLET%>?roomId=${param.roomId}" class="text-rose-600 hover:text-red-700 text-xs cursor-pointer w-fit font-semibold">More detail</a>
    </div>
</div>
