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
