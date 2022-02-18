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
        <img src="https://cdn.vietnambiz.vn/2019/11/4/dd32d9b188d86d6d8dc40d1ff9a0ebf6-15728512315071030248829.jpg" alt="Front side of mint cotton t-shirt with wavey lines pattern." class="w-24 h-24 rounded-md object-center object-cover sm:w-32 sm:h-32" />
    </div>

    <div class="ml-4 flex-1 flex flex-col sm:ml-6">
        <div>
            <div class="flex justify-between">
                <h4 class="text-sm">
                    <a href="#" class="font-medium text-gray-700 hover:text-gray-800">${param.roomName}</a>
                </h4>
                <p class="ml-4 text-sm font-medium text-gray-900">Total: ${param.total}$</p>
            </div>
            <p class="mt-1 text-sm text-gray-500">Check In: ${param.startDate}</p>
            <p class="mt-1 text-sm text-gray-500">Check Out: ${param.endDate}</p>
        </div>

        <form action="CartServlet" method="POST" class="flex flex-col">
            <% if (user != null) {%>
            <div class="mt-4">

                <jsp:include page="./InputField.jsp">
                    <jsp:param name="key" value="fullname" />
                    <jsp:param name="type" value="text" />
                    <jsp:param name="label" value="Fullname" />
                    <jsp:param name="error" value="${requestScope.fullnameError}"/>
                    <jsp:param name="inputValue" value="<%= user.getFullname()%>"/>
                </jsp:include>
                <jsp:include page="./InputField.jsp">
                    <jsp:param name="key" value="phone" />
                    <jsp:param name="type" value="text" />
                    <jsp:param name="label" value="Phone" />
                    <jsp:param name="error" value="${requestScope.phoneError}"/>
                    <jsp:param name="inputValue" value="<%= user.getPhone()%>"/>
                </jsp:include>
                <jsp:include page="./InputField.jsp">
                    <jsp:param name="key" value="address" />
                    <jsp:param name="type" value="text" />
                    <jsp:param name="label" value="Address" />
                    <jsp:param name="error" value="${requestScope.addressError}"/>
                    <jsp:param name="inputValue" value="<%= user.getAddress()%>"/>
                </jsp:include>
            </div>
            <% }%>
            <div class="mt-4 flex-1 flex items-end justify-between">
                <input type="text" value="${param.index}" name="index" class="hidden">
                <c:choose>
                    <c:when test="<%= userId == null%>">
                        <a href="LoginServlet" class="text-sm font-medium cursor-pointer text-rose-600 hover:text-rose-500">You need to login before booking</a>
                    </c:when>
                    <c:otherwise>
                        <p class="flex items-center text-sm text-gray-700 space-x-2">
                            <!-- Heroicon name: solid/check -->
                            <button type="submit" class="text-sm font-medium text-green-600 hover:text-green-500 cursor-pointer">Book now</button>
                        </p>
                    </c:otherwise>
                </c:choose>
                <a  class="text-sm font-medium text-rose-600 hover:text-rose-500 cursor-pointer" href="RemoveCartItemServlet?index=${param.index}">
                    <span>Remove</span>
                </a>

            </div>
        </form>
    </div>
</li>
