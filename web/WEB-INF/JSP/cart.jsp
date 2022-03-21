<%@page import="variables.Routers"%>
<%@page import="entities.User"%>
<%@page import="entities.CartItem"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="common/header.jsp">
            <jsp:param name="title" value="Cart Room"/>
        </jsp:include>
    </head>
    <body>
        <%
            ArrayList<CartItem> cart = (ArrayList<CartItem>) request.getAttribute("cart");
            Integer userId = (Integer) session.getAttribute("userId");
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
                                    <form action="<%= Routers.CART_SERVLET%>" method="POST">

                                        <ul role="list" class="border-t border-b border-gray-200 divide-y divide-gray-200">
                                            <%
                                                for (int index = 0; index < cart.size(); index++) {
                                            %>
                                            <jsp:include page="./Components/CartItem.jsp">
                                                <jsp:param name="imageUrl" value="<%= cart.get(index).getRoom().getUrlImage()%>"/>
                                                <jsp:param name="roomName" value="<%= cart.get(index).getRoomName()%>"/>
                                                <jsp:param name="startDate" value="<%= cart.get(index).getCheckIn()%>" />
                                                <jsp:param name="endDate" value="<%= cart.get(index).getCheckOut()%>" />
                                                <jsp:param name="total" value="<%= cart.get(index).getTotal()%>" />
                                                <jsp:param name="index" value="<%= index%>"/>
                                                <jsp:param name="errorMessage" value="<%= cart.get(index).getError()%>"/>
                                            </jsp:include>

                                            <% }%>
                                        </ul>
                                        <%
                                            if (userId != null) {
                                        %>
                                        <div class="flex justify-end">
                                            <button type="button" id="btnAllCheck" class="text-sm font-medium bg-blue-400 text-gray-100 px-2 py-1 rounded-md cursor-pointer mr-2">Check All Room</button>
                                            <button type="button" id="btnAllUncheck" class="text-sm font-medium bg-rose-600 text-gray-100 px-2 py-1 rounded-md cursor-pointer">Un-check All Room</button>
                                        </div>
                                        <div class="flex justify-end mt-2">
                                            <button type="submit" class="text-sm font-medium text-gray-100 bg-green-600 hover:bg-green-500 px-2 py-1 rounded-md cursor-pointer">Book with checked box</button>
                                        </div>

                                        <% }%>
                                    </form>
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



                            <div class="mt-6 text-sm text-center">
                                <p>
                                    <a href="<%=Routers.HISTORY_SERVLET%>" class="text-rose-600 font-medium hover:text-rose-500">View your history<a/> or <a href="<%=Routers.INDEX_SERVLET%>" class="text-rose-600 font-medium hover:text-rose-500">Continue find other room<span aria-hidden="true"> &rarr;</span></a>
                                </p>
                            </div>
                        </section>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script>

        document.getElementById("btnAllCheck").onclick = () => {

            var checkBoxes = document.getElementsByName("bookIndex");
            for (var i = 0; i < checkBoxes.length; i++) {
                checkBoxes[i].checked = true;
            }
        }

        document.getElementById("btnAllUncheck").onclick = () => {
            var checkBoxes = document.getElementsByName("bookIndex");
            for (var i = 0; i < checkBoxes.length; i++) {
                checkBoxes[i].checked = false;
            }
        }

    </script>
</html>
