<%@page import="entities.User"%>
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

                        <div class="mt-12">
                            <section aria-labelledby="cart-heading">
                                <h2 id="cart-heading" class="sr-only">Items in your Room cart</h2>

                            <c:choose>
                                <c:when test="<%= cart.size() > 0%>" >
                                    <ul role="list" class="border-t border-b border-gray-200 divide-y divide-gray-200">
                                        <%
                                            for (int index = 0; index < cart.size(); index++) {
                                        %>

                                        <jsp:include page="./Components/CartItem.jsp">
                                            <jsp:param name="roomName" value="<%= cart.get(index).getRoomName()%>"/>
                                            <jsp:param name="startDate" value="<%= cart.get(index).getStartDate()%>" />
                                            <jsp:param name="endDate" value="<%= cart.get(index).getEndDate()%>" />
                                            <jsp:param name="total" value="<%= cart.get(index).getTotal()%>" />
                                            <jsp:param name="index" value="<%= index%>"/>
                                        </jsp:include>
                                        <% }%>


                                    </ul>
                                </c:when>
                                <c:otherwise>
                                    <div class="flex flex-col items-center">
                                        <svg width="160" height="160" viewBox="0 0 160 160" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path d="M59.1997 66.2666L66.2663 73.3333L73.333 66.2666L59.1997 52.1333L45.0663 66.2666L52.133 73.3333L59.1997 66.2666ZM79.9997 116.667C95.533 116.667 108.733 106.933 114.066 93.3333H45.933C51.2663 106.933 64.4663 116.667 79.9997 116.667ZM86.6663 66.2666L93.733 73.3333L100.8 66.2666L107.866 73.3333L114.933 66.2666L100.8 52.1333L86.6663 66.2666ZM79.933 13.3333C43.133 13.3333 13.333 43.1333 13.333 79.9999C13.333 116.867 43.133 146.667 79.933 146.667C116.733 146.667 146.666 116.867 146.666 79.9999C146.666 43.1333 116.8 13.3333 79.933 13.3333ZM79.9997 133.333C50.533 133.333 26.6663 109.467 26.6663 79.9999C26.6663 50.5333 50.533 26.6666 79.9997 26.6666C109.466 26.6666 133.333 50.5333 133.333 79.9999C133.333 109.467 109.466 133.333 79.9997 133.333Z" fill="#323232"/>
                                        </svg>

                                        <p class="mt-4 text-2xl text-gray-800 font-semibold">There are nothing in your cart</p>
                                    </div>
                                </c:otherwise>
                            </c:choose>


                            <!-- More products... -->
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
                                    or <a href="IndexServlet" class="text-rose-600 font-medium hover:text-rose-500">Continue find other room<span aria-hidden="true"> &rarr;</span></a>
                                </p>
                            </div>
                        </section>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
