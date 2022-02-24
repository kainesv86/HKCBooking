
<%@page import="entities.Review"%>
<%@page import="java.util.ArrayList"%>
<%@page import="variables.Routers"%>
<%@page import="entities.RoomDetail"%>
<%@page import="entities.RoomType"%>
<%@page import="entities.Room"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="common/header.jsp">
            <jsp:param name="title" value="Room detail"/>
        </jsp:include>
    </head>
    <body>

        <%
            RoomDetail roomDetail = (RoomDetail) request.getAttribute("roomDetail");
            String minCheckIn = (String) request.getAttribute("minCheckIn");
            String minCheckOut = (String) request.getAttribute("minCheckOut");
            String message = (String) session.getAttribute("message");
            request.setAttribute("message", message);
            String fullname = (String) session.getAttribute("fullname");
            Integer roomId = (Integer) request.getAttribute("roomId");
            ArrayList<Review> reviews = (ArrayList<Review>) request.getAttribute("reviews");
        %>
        <div class="flex flex-col min-h-screen">
            <jsp:include page="./common/navbar.jsp"></jsp:include>

                <div class="flex-1">
                    <div class="bg-white">

                        <main class="mx-auto pt-14 pb-24 px-4 sm:pt-16 sm:pb-32 sm:px-6 lg:max-w-7xl lg:px-8">
                            <!-- Product -->
                            <div class="lg:grid lg:grid-rows-1 lg:grid-cols-7 lg:gap-x-8 lg:gap-y-10 xl:gap-x-16">
                                <!-- Product image -->
                                <div class="lg:row-end-1 lg:col-span-4">
                                    <div class="aspect-w-4 aspect-h-3 rounded-lg bg-gray-100 overflow-hidden min-h-[360px]">
                                        <img src="<%= roomDetail.getRoom().getUrlImage()%>" class="object-center object-cover">
                                </div>
                            </div>

                            <!-- Product details -->

                            <div class="max-w-2xl mx-auto mt-14 sm:mt-16 lg:max-w-none lg:mt-0 lg:row-end-2 lg:row-span-2 lg:col-span-3">
                                <div class="flex flex-col-reverse">
                                    <div class="mt-4">
                                        <h1 class="text-2xl font-extrabold tracking-tight text-gray-900 sm:text-3xl"><%=roomDetail.getRoomType().getRoomName()%></h1>

                                        <h2 id="information-heading" class="sr-only">Product information</h2>
                                        <p class="text-xl text-yellow-600 mt-2">Day / <%= roomDetail.getRoom().getPrice()%>$</p>
                                    </div>

                                    <div>
                                        <h3 class="sr-only">Reviews</h3>
                                        <div class="flex items-center">
                                            <!--
                                              Heroicon name: solid/star

                                              Active: "text-yellow-400", Default: "text-gray-300"
                                            -->
                                            <svg class="text-yellow-400 h-5 w-5 flex-shrink-0" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                            <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                                            </svg>

                                            <!-- Heroicon name: solid/star -->
                                            <svg class="text-yellow-400 h-5 w-5 flex-shrink-0" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                            <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                                            </svg>

                                            <!-- Heroicon name: solid/star -->
                                            <svg class="text-yellow-400 h-5 w-5 flex-shrink-0" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                            <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                                            </svg>

                                            <!-- Heroicon name: solid/star -->
                                            <svg class="text-yellow-400 h-5 w-5 flex-shrink-0" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                            <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                                            </svg>

                                            <!-- Heroicon name: solid/star -->
                                            <svg class="text-gray-300 h-5 w-5 flex-shrink-0" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                            <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                                            </svg>
                                        </div>
                                        <p class="sr-only">4 out of 5 stars</p>
                                    </div>
                                </div>
                                <div class="text-gray-900">

                                    <p class="mt-6"><%= roomDetail.getRoom().getDescription()%></p>
                                    <p class="mt-6">Capacity: <%= roomDetail.getRoomType().getCapacity()%> People</p>
                                    <p class="mt-6">Acreage: <%= roomDetail.getRoomType().getAcreage()%> square meters</p>
                                </div>

                                <div class="border-t border-gray-200 mt-10 pt-10">
                                    <h3 class="text-xl font-medium text-gray-900 mb-4">Pick your time</h3>
                                    <form action="<%= Routers.ROOM_DETAIL_SERVLET%>" method="POST" class="flex flex-col mb-2 bg-rose-600 p-4 rounded-md" >
                                        <input type="text" value="<%= roomDetail.getRoom().getRoomId()%>" name="roomId" class="hidden">

                                        <div class="mb-2">
                                            <jsp:include page="./Components/InputDate.jsp">
                                                <jsp:param name="key" value="checkIn"/>
                                                <jsp:param name="label" value="Check In"/>
                                                <jsp:param name="min" value="<%=minCheckIn%>" />
                                            </jsp:include>
                                        </div>

                                        <jsp:include page="./Components/InputDate.jsp">
                                            <jsp:param name="key" value="checkOut"/>
                                            <jsp:param name="label" value="Check out"/>
                                            <jsp:param name="min" value="<%=minCheckOut%>" />
                                        </jsp:include>

                                        <p class="text-gray-100 font-semibold text-sm">${requestScope.message}</p>

                                        <div class="mt-4">
                                            <button type="submit" class="text-gray-800 inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-gray-100 hover:bg-gray-200">Add to cart</button>
                                        </div>

                                    </form>
                                </div>
                            </div>

                            <div class="w-full max-w-2xl mx-auto mt-16 lg:max-w-none lg:mt-0 lg:col-span-4">
                                <div>
                                    <div class="border-b border-gray-200">
                                        <div class="-mb-px flex space-x-8" aria-orientation="horizontal" role="tablist">
                                            <!-- Selected: "border-indigo-600 text-indigo-600", Not Selected: "border-transparent text-gray-700 hover:text-gray-800 hover:border-gray-300" -->
                                            <p id="tab-reviews" class="border-transparent text-gray-700 hover:text-gray-800 hover:border-gray-300 whitespace-nowrap py-6 border-b-2 font-medium text-sm" aria-controls="tab-panel-reviews" >Customer Reviews</p>

                                        </div>
                                    </div>

                                    <!-- 'Customer Reviews' panel, show/hide based on tab state -->
                                    <div id="tab-panel-reviews" class="-mb-10" aria-labelledby="tab-reviews" role="tabpanel" tabindex="0">
                                        <h3 class="sr-only">Customer Reviews</h3>
                                        <form action="<%= Routers.REVIEW_SERVLET%>" method="POST">
                                            <input name="roomId" value="<%= roomId%>" readonly hidden/>
                                            <input name="fullname" value="<%= fullname%>" readonly hidden/>
                                            <label for="comment" class="block font-medium text-gray-700"><%= fullname%></label>
                                            <div class="flex w-fit items-center">
                                                <label for="comment" class="block text-sm font-medium text-gray-700">Star rating: </label>
                                                <input name="rate" type="number" min="1" max="5" value="5" class="w-fit focus:ring-rose-500 focus:border-rose-500 block border-gray-300 rounded-md border-2 "/>
                                                <svg class="text-yellow-400 h-5 w-5 flex-shrink-0" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                                <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                                                </svg>
                                            </div>
                                            <div class="mt-1">
                                                <textarea rows="6" name="comment" id="comment" placeholder="Add your review here" class="shadow focus:ring-indigo-500 focus:border-indigo-500 block w-full sm:text-sm border-gray-300 rounded-md"></textarea>
                                            </div>
                                            <div class="mt-4 flex justify-end">
                                                <button type="submit" class="text-white inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-rose-500 hover:bg-rose-600">Comment</button>
                                            </div>
                                        </form>
                                        <% for (Review review : reviews) {
                                        %>
                                        <div class="flex text-sm text-gray-500 space-x-4">

                                            <div class="flex-1 py-10 border-t border-gray-200">
                                                <h3 class="font-medium text-gray-900"><%= review.getFullname()%></h3>


                                                <div class="flex items-center mt-4">
                                                    <!--
                                                      Heroicon name: solid/star

                                                      Active: "text-yellow-400", Default: "text-gray-300"
                                                    -->
                                                    <% for (int i = 0; i < review.getRate(); i++) { %>
                                                    <svg class="text-yellow-400 h-5 w-5 flex-shrink-0" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                                    <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                                                    </svg>
                                                    <% }%>
                                                </div>
                                                <p class="sr-only">5 out of 5 stars</p>

                                                <div class="mt-4 prose prose-sm max-w-none text-gray-500">
                                                    <p><%= review.getComment()%></p>
                                                </div>
                                            </div>
                                        </div>
                                        <% }%>

                                        <!-- More reviews... -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </main>


                </div>
            </div>
        </div>
    </body>
</html>
