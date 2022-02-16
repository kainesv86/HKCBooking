<%
    String fullname = (String) session.getAttribute("fullname");
%>
<div class="flex w-64 flex-col min-h-screen inset-y-0">
    <!-- Sidebar component, swap this element with another sidebar if you like -->
    <div class="flex-1 flex flex-col min-h-0 bg-rose-600 px-2">
        <div class="flex-1 flex flex-col pt-5 pb-4 overflow-y-auto">
            <a class="flex items-center ml-2" href="IndexServlet">
                <div class="w-10 h-10">
                    <svg  viewBox="0 0 160 160" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <g clip-path="url(#clip0_512_6848)">
                            <path opacity="0.3" d="M134 66.8861C134 85.2544 116.715 108.268 83.2985 134.856L80.5 137L77.7015 134.784C44.2846 108.268 27 85.2544 27 66.8861C27 39.4409 50.2108 19 80.5 19C110.789 19 134 39.3695 134 66.8861Z" fill="white"/>
                            <path d="M120.5 67.9999C120.5 43.7999 102.833 26.6666 80.5 26.6666C58.1666 26.6666 40.5 43.7999 40.5 67.9999C40.5 83.5999 53.5 104.267 80.5 128.933C107.5 104.267 120.5 83.5999 120.5 67.9999ZM80.5 13.3333C108.5 13.3333 133.833 34.7999 133.833 67.9999C133.833 90.1333 116.033 116.333 80.5 146.667C44.9667 116.333 27.1667 90.1333 27.1667 67.9999C27.1667 34.7999 52.5 13.3333 80.5 13.3333Z" fill="white"/>
                            <path d="M98.9 70.5882H107L80 42L53 70.5882H61.1V96H66.5V89.6471H93.5V96H98.9V70.5882ZM67.067 64.2353H92.933L93.5 64.8388V70.5882H66.5V64.8388L67.067 64.2353ZM86.939 57.8824H73.061L80 50.5447L86.939 57.8824ZM66.5 83.2941V76.9412H93.5V83.2941H66.5Z" fill="white"/>
                        </g>
                        <defs>
                            <clipPath id="clip0_512_6848">
                                <rect width="160" height="160" fill="white" transform="translate(0.5)"/>
                            </clipPath>
                        </defs>
                    </svg>
                </div>
                <p class="text-white text-3xl">HKCBooking</p>
            </a>
            <nav class="mt-5 flex-1 px-2 space-y-1">
                <!-- Current: "bg-indigo-800 text-white", Default: "text-white hover:bg-indigo-600 hover:bg-opacity-75" -->
                <a href="BookingOrdersServlet" class="text-white font-semibold group flex items-center px-2 py-2 text-sm hover:text-gray-800 rounded-md hover:bg-gray-100">
                    <svg class="mr-3 flex-shrink-0 h-6 w-6 text-white group-hover:text-gray-800 " width="24" height="24" viewBox="0 0 24 24" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path d="M7 15H14V17H7V15ZM7 11H17V13H7V11ZM7 7H17V9H7V7ZM19 3H14.82C14.4 1.84 13.3 1 12 1C10.7 1 9.6 1.84 9.18 3H5C4.86 3 4.73 3.01 4.6 3.04C4.21 3.12 3.86 3.32 3.59 3.59C3.41 3.77 3.26 3.99 3.16 4.23C3.06 4.46 3 4.72 3 5V19C3 19.27 3.06 19.54 3.16 19.78C3.26 20.02 3.41 20.23 3.59 20.42C3.86 20.69 4.21 20.89 4.6 20.97C4.73 20.99 4.86 21 5 21H19C20.1 21 21 20.1 21 19V5C21 3.9 20.1 3 19 3ZM12 2.75C12.41 2.75 12.75 3.09 12.75 3.5C12.75 3.91 12.41 4.25 12 4.25C11.59 4.25 11.25 3.91 11.25 3.5C11.25 3.09 11.59 2.75 12 2.75ZM19 19H5V5H19V19Z" fill="currentColor"/>
                    </svg>
                    Booking orders
                </a>

                <a href="AddRoomServlet" class="text-white font-semibold group flex items-center px-2 py-2 text-sm hover:text-gray-800 rounded-md hover:bg-gray-100">
                    <svg class="mr-3 flex-shrink-0 h-6 w-6 text-white group-hover:text-gray-800 " width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M12 7C11.45 7 11 7.45 11 8V11H8C7.45 11 7 11.45 7 12C7 12.55 7.45 13 8 13H11V16C11 16.55 11.45 17 12 17C12.55 17 13 16.55 13 16V13H16C16.55 13 17 12.55 17 12C17 11.45 16.55 11 16 11H13V8C13 7.45 12.55 7 12 7ZM12 2C6.48 2 2 6.48 2 12C2 17.52 6.48 22 12 22C17.52 22 22 17.52 22 12C22 6.48 17.52 2 12 2ZM12 20C7.59 20 4 16.41 4 12C4 7.59 7.59 4 12 4C16.41 4 20 7.59 20 12C20 16.41 16.41 20 12 20Z" fill="currentColor"/>
                    </svg>
                    Add Room
                </a>
                <a href="#" class="text-white font-semibold group flex items-center px-2 py-2 text-sm hover:text-gray-800 rounded-md hover:bg-gray-100">
                    <svg class="mr-3 flex-shrink-0 h-6 w-6 text-white group-hover:text-gray-800 " width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M19 8L15 12H18C18 15.31 15.31 18 12 18C10.99 18 10.03 17.75 9.2 17.3L7.74 18.76C8.97 19.54 10.43 20 12 20C16.42 20 20 16.42 20 12H23L19 8ZM6 12C6 8.69 8.69 6 12 6C13.01 6 13.97 6.25 14.8 6.7L16.26 5.24C15.03 4.46 13.57 4 12 4C7.58 4 4 7.58 4 12H1L5 16L9 12H6Z" fill="currentColor"/>
                    </svg>
                    Edit Room
                </a>
                <a href="#" class="text-white font-semibold group flex items-center px-2 py-2 text-sm hover:text-gray-800 rounded-md hover:bg-gray-100">
                    <svg class="mr-3 flex-shrink-0 h-6 w-6 text-white group-hover:text-gray-800 " width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M15 8C14.45 8 14 8.45 14 9V11H12C11.45 11 11 11.45 11 12C11 12.55 11.45 13 12 13H14V15C14 15.55 14.45 16 15 16C15.55 16 16 15.55 16 15V13H18C18.55 13 19 12.55 19 12C19 11.45 18.55 11 18 11H16V9C16 8.45 15.55 8 15 8ZM2 12C2 9.42 3.4 7.17 5.48 5.96C5.8 5.77 6.01 5.45 6.01 5.08C6.01 4.31 5.17 3.83 4.5 4.22C1.82 5.78 0 8.68 0 12C0 15.32 1.82 18.22 4.5 19.78C5.17 20.17 6.01 19.69 6.01 18.92C6.01 18.55 5.8 18.23 5.48 18.04C3.4 16.83 2 14.58 2 12ZM15 3C10.04 3 6 7.04 6 12C6 16.96 10.04 21 15 21C19.96 21 24 16.96 24 12C24 7.04 19.96 3 15 3ZM15 19C11.14 19 8 15.86 8 12C8 8.14 11.14 5 15 5C18.86 5 22 8.14 22 12C22 15.86 18.86 19 15 19Z" fill="currentColor"/>
                    </svg>
                    Add Room Type
                </a>
                <a href="#" class="text-white font-semibold group flex items-center px-2 py-2 text-sm hover:text-gray-800 rounded-md hover:bg-gray-100">
                    <svg class="mr-3 flex-shrink-0 h-6 w-6 text-white group-hover:text-gray-800" width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" clip-rule="evenodd" d="M16.6699 13.13C18.0399 14.06 18.9999 15.32 18.9999 17V20H21.9999C22.5499 20 22.9999 19.55 22.9999 19V17C22.9999 14.82 19.4299 13.53 16.6699 13.13Z" fill="currentColor"/>
                        <path d="M9 12C11.2091 12 13 10.2091 13 8C13 5.79086 11.2091 4 9 4C6.79086 4 5 5.79086 5 8C5 10.2091 6.79086 12 9 12Z" fill="currentColor"/>
                        <path fill-rule="evenodd" clip-rule="evenodd" d="M14.9999 12C17.2099 12 18.9999 10.21 18.9999 8C18.9999 5.79 17.2099 4 14.9999 4C14.5299 4 14.0899 4.1 13.6699 4.24C14.4999 5.27 14.9999 6.58 14.9999 8C14.9999 9.42 14.4999 10.73 13.6699 11.76C14.0899 11.9 14.5299 12 14.9999 12Z" fill="currentColor"/>
                        <path fill-rule="evenodd" clip-rule="evenodd" d="M9 13C6.33 13 1 14.34 1 17V19C1 19.55 1.45 20 2 20H16C16.55 20 17 19.55 17 19V17C17 14.34 11.67 13 9 13Z" fill="currentColor"/>
                    </svg>
                    Users
                </a>
            </nav>
        </div>
        <div class="flex-shrink-0 flex  p-4">
            <a href="#" class="flex-shrink-0 w-full group block">
                <div class="flex items-center">

                    <div class="ml-3">
                        <p class="text-sm text-white font-semibold"><%=fullname%></p>
                    </div>
                </div>
            </a>
        </div>
    </div>
</div>