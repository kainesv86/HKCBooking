<%@page import="entities.CartItem"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>JSP Page</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>
        <%
            ArrayList<CartItem> cart = (ArrayList<CartItem>) request.getAttribute("cart");
            System.out.println(cart.size());
        %>

        <div class="flex flex-col min-h-screen">

            <jsp:include page="./common/navbar.jsp"></jsp:include>
                <div class="bg-white">
                    <div class="max-w-2xl mx-auto py-16 px-4 sm:py-24 sm:px-6 lg:px-0">
                        <h1 class="text-3xl font-extrabold text-center tracking-tight text-gray-900 sm:text-4xl">Room Cart</h1>

                        <form class="mt-12">
                            <section aria-labelledby="cart-heading">
                                <h2 id="cart-heading" class="sr-only">Items in your Room cart</h2>

                                <ul role="list" class="border-t border-b border-gray-200 divide-y divide-gray-200">
                                    <li class="flex py-6">
                                        <div class="flex-shrink-0">
                                            <img src="https://cdn.vietnambiz.vn/2019/11/4/dd32d9b188d86d6d8dc40d1ff9a0ebf6-15728512315071030248829.jpg" alt="Front side of mint cotton t-shirt with wavey lines pattern." class="w-24 h-24 rounded-md object-center object-cover sm:w-32 sm:h-32" />
                                        </div>

                                        <div class="ml-4 flex-1 flex flex-col sm:ml-6">
                                            <div>
                                                <div class="flex justify-between">
                                                    <h4 class="text-sm">
                                                        <a href="#" class="font-medium text-gray-700 hover:text-gray-800">Single Room</a>
                                                    </h4>
                                                    <p class="ml-4 text-sm font-medium text-gray-900">Total: $32.00</p>
                                                </div>
                                                <p class="mt-1 text-sm text-gray-500">Check In:</p>
                                                <p class="mt-1 text-sm text-gray-500">Check Out:</p>
                                            </div>

                                            <div class="mt-4 flex-1 flex items-end justify-between">
                                                <p class="flex items-center text-sm text-gray-700 space-x-2">
                                                    <!-- Heroicon name: solid/check -->
                                                    <a class="text-green-500">Book now</a>
                                                </p>
                                                <div class="ml-4">
                                                    <button type="button" class="text-sm font-medium text-indigo-600 hover:text-indigo-500">
                                                        <span>Remove</span>
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </li>

                                <%
                                    for (int index = 0; index < cart.size(); index++) {
                                        System.out.println(index);
                                %>
                                <jsp:include page="./Components/CartItem.jsp">
                                    <jsp:param name="roomName" value="<%= cart.get(index).getRoomName()%>"/>
                                    <jsp:param name="startDate" value="<%= cart.get(index).getStartDate()%>" />
                                    <jsp:param name="endDate" value="<%= cart.get(index).getEndDate()%>" />
                                    <jsp:param name="total" value="<%= cart.get(index).getTotal()%>" />
                                </jsp:include>

                                <% }%>

                                <!-- More products... -->
                            </ul>
                        </section>

                        <!-- Order summary -->
                        <section aria-labelledby="summary-heading" class="mt-10">
                            <!-- <h2 id="summary-heading" class="sr-only">Order summary</h2> -->

                            <!-- <div>
                              <dl class="space-y-4">
                                <div class="flex items-center justify-between">
                                  <dt class="text-base font-medium text-gray-900">Subtotal</dt>
                                  <dd class="ml-4 text-base font-medium text-gray-900">$96.00</dd>
                                </div>
                              </dl>
                              <p class="mt-1 text-sm text-gray-500">Shipping and taxes will be calculated at checkout.</p>
                            </div> -->

                            <!-- <div class="mt-10">
                              <button type="submit" class="w-full bg-indigo-600 border border-transparent rounded-md shadow-sm py-3 px-4 text-base font-medium text-white hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-offset-gray-50 focus:ring-indigo-500">Checkout</button>
                            </div> -->

                            <div class="mt-6 text-sm text-center">
                                <p>
                                    or <a href="#" class="text-indigo-600 font-medium hover:text-indigo-500">Continue find other room<span aria-hidden="true"> &rarr;</span></a>
                                </p>
                            </div>
                        </section>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
