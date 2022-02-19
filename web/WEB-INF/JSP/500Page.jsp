<%--
    Document   : 404Page
    Created on : Feb 18, 2022, 11:11:44 PM
    Author     : Kaine
--%>

<%@page import="variables.Routers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>
        <div class="flex flex-col min-h-screen">
            <jsp:include page="./common/navbar.jsp"></jsp:include>
                <div class="min-h-full flex flex-1 flex-col justify-center items-center">
                    <p class="text-sm font-semibold text-rose-600 uppercase tracking-wide">500 error</p>
                    <div class="flex-shrink-0 flex justify-center">
                        <a class="flex items-center" href="<%= Routers.INDEX_SERVLET%>">
                        <div class="w-20 h-20 text-rose-600">
                            <svg viewBox="0 0 160 160" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <g clip-path="url(#clip0_512_6848)">
                            <path opacity="0.3" d="M134 66.8861C134 85.2544 116.715 108.268 83.2985 134.856L80.5 137L77.7015 134.784C44.2846 108.268 27 85.2544 27 66.8861C27 39.4409 50.2108 19 80.5 19C110.789 19 134 39.3695 134 66.8861Z" fill="currentColor" />
                            <path d="M120.5 67.9999C120.5 43.7999 102.833 26.6666 80.5 26.6666C58.1666 26.6666 40.5 43.7999 40.5 67.9999C40.5 83.5999 53.5 104.267 80.5 128.933C107.5 104.267 120.5 83.5999 120.5 67.9999ZM80.5 13.3333C108.5 13.3333 133.833 34.7999 133.833 67.9999C133.833 90.1333 116.033 116.333 80.5 146.667C44.9667 116.333 27.1667 90.1333 27.1667 67.9999C27.1667 34.7999 52.5 13.3333 80.5 13.3333Z" fill="currentColor" />
                            <path d="M98.9 70.5882H107L80 42L53 70.5882H61.1V96H66.5V89.6471H93.5V96H98.9V70.5882ZM67.067 64.2353H92.933L93.5 64.8388V70.5882H66.5V64.8388L67.067 64.2353ZM86.939 57.8824H73.061L80 50.5447L86.939 57.8824ZM66.5 83.2941V76.9412H93.5V83.2941H66.5Z" fill="currentColor" />
                            </g>
                            <defs>
                            <clipPath id="clip0_512_6848">
                                <rect width="160" height="160" fill="white" transform="translate(0.5)" />
                            </clipPath>
                            </defs>
                            </svg>
                        </div>
                        <p class="text-rose-600 text-4xl">HKCBooking</p>
                    </a>
                </div>
                <div class="">
                    <div class="text-center">
                        <h1 class="text-4xl font-extrabold text-gray-900 tracking-tight sm:text-5xl">Internal Server Error.</h1>
                        <p class="mt-2 text-base text-gray-500">Sorry, The server encountered an internal error or misconfiguration and was unable to complete your request.</p>
                        <div class="mt-6">
                            <a href="<%= Routers.INDEX_SERVLET%>" class="text-base font-medium text-rose-600 hover:text-rose-500">Go back home<span aria-hidden="true"> &rarr;</span></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
