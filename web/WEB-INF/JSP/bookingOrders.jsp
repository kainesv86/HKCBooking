

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>JSP Page</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>
        <div class="flex min-h-screen">
            <jsp:include page="./common/Sidebar.jsp"></jsp:include>
            <div class="bg-gray-100 flex-1 p-20">
                <div class="text-center flex flex-col mb-4">
                    <h2 class="text-rose-600 text-2xl font-semibold">Order Status</h2>
                    <div class="relative self-center bg-gray-100 rounded-lg p-0.5 flex w-fit text-center">
                        <a href="BookingOrdersServlet" class="cursor-pointer mr-1 bg-white border-gray-200 rounded-md shadow-sm py-2 text-sm font-semibold text-gray-800 whitespace-nowrap focus:outline-none focus:ring-2 focus:z-10 w-24">All</a>
                        <a href="BookingOrdersServlet?historyStatus=PENDING" class="cursor-pointer mr-1 bg-amber-400 border-gray-200 rounded-md shadow-sm py-2 text-sm font-semibold text-white whitespace-nowrap focus:outline-none focus:ring-2 focus:z-10 w-24">Pending</a>
                        <a href="BookingOrdersServlet?historyStatus=READY" class="cursor-pointer mr-1 bg-blue-400 border-gray-200 rounded-md shadow-sm py-2 text-sm font-semibold text-white whitespace-nowrap focus:outline-none focus:ring-2 focus:z-10 w-24">Ready</a>
                        <a href="BookingOrdersServlet?historyStatus=COMPLETED" class="cursor-pointer mr-1 bg-green-400 border-gray-200 rounded-md shadow-sm py-2 text-sm font-semibold text-white whitespace-nowrap focus:outline-none focus:ring-2 focus:z-10 w-24">Completed</a>
                        <a href="BookingOrdersServlet?historyStatus=CANCEL" class="cursor-pointer mr-1 bg-rose-400 border-gray-200 rounded-md shadow-sm py-2 text-sm font-semibold text-white whitespace-nowrap focus:outline-none focus:ring-2 focus:z-10 w-24">Cancel</a>
                    </div>
                </div>

                <div class="flex flex-col">
                    <div class="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
                        <div class="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
                            <div class="shadow overflow-hidden border-b border-gray-200 sm:rounded-lg">
                                <table class="min-w-full divide-y divide-gray-200">
                                    <thead class="bg-gray-50">
                                        <tr>
                                            <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Room</th>
                                            <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Customer Information</th>
                                            <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Contact</th>
                                            <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider w-24">Note</th>
                                            <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider w-24">Message</th>
                                            <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Status</th>
                                            <th scope="col" class="relative px-6 py-3">
                                                <span class="sr-only">Edit</span>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody class="bg-white divide-y divide-gray-200">
                                        <tr>
                                            <td class="px-6 py-4 whitespace-nowrap">
                                                <div class="flex items-center">
                                                    <div class="flex-shrink-0 h-20 w-20">
                                                        <img class="h-20 w-20" src="https://cdn.vietnambiz.vn/2019/11/4/dd32d9b188d86d6d8dc40d1ff9a0ebf6-15728512315071030248829.jpg" alt="" />
                                                    </div>
                                                    <div class="ml-4">
                                                        <div class="text-sm font-medium text-gray-900">Single Room</div>
                                                        <div class="text-sm text-gray-500">480$</div>
                                                        <div class="text-sm text-gray-500">20-11-2013 ~ 24-11-2021</div>
                                                    </div>
                                                </div>
                                            </td>
                                            <td class="px-6 py-4 whitespace-nowrap">
                                                <div class="text-sm text-gray-900">Pham Vinh Tai</div>
                                                <div class="text-sm text-gray-500">Khom 2 Thi Tran Cang Long</div>
                                            </td>
                                            <td class="px-6 py-4 whitespace-nowrap">
                                                <div class="text-sm text-gray-900">0987709812</div>
                                                <div class="text-sm text-gray-500">kainesv86@gmail.com</div>
                                            </td>
                                            <td class="px-6 py-4">
                                                <p class="text-sm text-gray-900 w-48 text-justify">Nah I don't give a shit care how nice you are, asda asdpjoajpo asdasdljka sdasoidui asdlkjasdlj asdpoiasd asdasd zjxc</p>
                                            </td>
                                            <td class="px-6 py-4">
                                                <textarea rows="4" name="message" id="comment" class="shadow-md focus:ring-rose-500 focus:border-rose-500 block sm:text-sm border-gray-300 rounded-md w-48"></textarea>
                                            </td>
                                            <td class="px-6 py-4 whitespace-nowrap">
                                                <select id="location" name="historyStatus" class="mt-1 block pl-3 pr-10 py-2 text-base border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm rounded-md">
                                                    <option value="PENDING">Pending</option>
                                                    <option value="READY">Ready</option>
                                                    <option value="COMPLETED">Completed</option>
                                                    <option value="CANCEL">Cancel</option>
                                                </select>

                                                <!-- <span class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800"> Active </span> -->
                                            </td>
                                            <td class="px-6 py-4 whitespace-nowrap text-right text-sm font-medium">
                                                <a href="#" class="text-indigo-600 hover:text-indigo-900">Save</a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="px-6 py-4 whitespace-nowrap">
                                                <div class="flex items-center">
                                                    <div class="flex-shrink-0 h-20 w-20">
                                                        <img class="h-20 w-20" src="https://cdn.vietnambiz.vn/2019/11/4/dd32d9b188d86d6d8dc40d1ff9a0ebf6-15728512315071030248829.jpg" alt="" />
                                                    </div>
                                                    <div class="ml-4">
                                                        <div class="text-sm font-medium text-gray-900">Single Room</div>
                                                        <div class="text-sm text-gray-500">480$</div>
                                                        <div class="text-sm text-gray-500">20-11-2013 ~ 24-11-2021</div>
                                                    </div>
                                                </div>
                                            </td>
                                            <td class="px-6 py-4 whitespace-nowrap">
                                                <div class="text-sm text-gray-900">Pham Vinh Tai</div>
                                                <div class="text-sm text-gray-500">Khom 2 Thi Tran Cang Long</div>
                                            </td>
                                            <td class="px-6 py-4 whitespace-nowrap">
                                                <div class="text-sm text-gray-900">0987709812</div>
                                                <div class="text-sm text-gray-500">kainesv86@gmail.com</div>
                                            </td>
                                            <td class="px-6 py-4">
                                                <p class="text-sm text-gray-900 w-48 text-justify">Nah I don't give a shit care how nice you are, asda asdpjoajpo asdasdljka sdasoidui asdlkjasdlj asdpoiasd asdasd zjxc</p>
                                            </td>
                                            <td class="px-6 py-4">
                                                <textarea rows="4" name="message" id="comment" class="shadow-md focus:ring-rose-500 focus:border-rose-500 block sm:text-sm border-gray-300 rounded-md w-48"></textarea>
                                            </td>
                                            <td class="px-6 py-4 whitespace-nowrap">
                                                <select id="location" name="historyStatus" class="mt-1 block pl-3 pr-10 py-2 text-base border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm rounded-md">
                                                    <option value="PENDING">Pending</option>
                                                    <option value="READY">Ready</option>
                                                    <option value="COMPLETED">Completed</option>
                                                    <option value="CANCEL">Cancel</option>
                                                </select>

                                                <!-- <span class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800"> Active </span> -->
                                            </td>
                                            <td class="px-6 py-4 whitespace-nowrap text-right text-sm font-medium">
                                                <a href="#" class="text-indigo-600 hover:text-indigo-900">Save</a>
                                            </td>
                                        </tr>

                                        <!-- More people... -->
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
