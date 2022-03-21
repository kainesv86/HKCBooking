<%@page import="variables.Routers"%>
<%@page import="repositories.UserRepository"%>
<%@page import="entities.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    Integer userId = (Integer) session.getAttribute("userId");
    UserRepository userRepo = new UserRepository();
    User user = userRepo.getUserByUserId(userId);
%>

<li class="flex py-6">
    <div class="flex-shrink-0">
        <img src="${param.imageUrl}" alt="" class="w-24 h-24 rounded-md object-center object-cover sm:w-32 sm:h-32" />
    </div>

    <div class="ml-4 flex-1 flex flex-col sm:ml-6">
        <div>
            <div class="text-sm flex items-center justify-end">
                <p class="font-semibold mr-2 text-gray-800">Check to book</p>
                <input type="checkbox" value="${param.index}" name="bookIndex" />
            </div>
            <div class="flex justify-between">
                <h4 class="text-sm">
                    <a href="#" class="font-medium text-gray-700 hover:text-gray-800">${param.roomName}</a>
                </h4>
                <p class="ml-4 text-sm font-medium text-gray-900">Total: ${param.total}$</p>
            </div>
            <p class="mt-1 text-sm text-gray-500">Check In: ${param.startDate}</p>
            <p class="mt-1 text-sm text-gray-500">Check Out: ${param.endDate}</p>
        </div>
        <div class="flex flex-col">
            <div class="mt-4 flex-1 flex items-end justify-between">
                <input type="text" value="${param.index}" name="index" class="hidden">
                <c:choose>
                    <c:when test="<%= userId == null%>">
                        <a href="<%=Routers.LOGIN_SERVLET%>" class="text-sm font-medium cursor-pointer text-rose-600 hover:text-rose-500">You need to login before booking</a>
                    </c:when>
                    <c:otherwise>

                    </c:otherwise>
                </c:choose>
                <a  class="text-sm font-medium text-rose-600 hover:text-rose-500 cursor-pointer text-left" href="<%=Routers.REMOVE_CART_ITEM_SERVLET%>?index=${param.index}">
                    <span>Remove</span>
                </a>

            </div>
            <p class="text-sm font-medium text-rose-600">${param.errorMessage}</p>
        </div>
    </div>
</li>
