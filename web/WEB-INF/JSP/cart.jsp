<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>JSP Page</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body>
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
                                        <img src="https://tailwindui.com/img/ecommerce-images/checkout-page-03-product-04.jpg" alt="Front side of mint cotton t-shirt with wavey lines pattern." class="w-24 h-24 rounded-md object-center object-cover sm:w-32 sm:h-32" />
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

                                <li class="flex py-6">
                                    <div class="flex-shrink-0">
                                        <img src="https://tailwindui.com/img/ecommerce-images/shopping-cart-page-01-product-02.jpg" alt="Front side of charcoal cotton t-shirt." class="w-24 h-24 rounded-md object-center object-cover sm:w-32 sm:h-32" />
                                    </div>

                                    <div class="ml-4 flex-1 flex flex-col sm:ml-6">
                                        <div>
                                            <div class="flex justify-between">
                                                <h4 class="text-sm">
                                                    <a href="#" class="font-medium text-gray-700 hover:text-gray-800"> Basic Tee </a>
                                                </h4>
                                                <p class="ml-4 text-sm font-medium text-gray-900">$32.00</p>
                                            </div>
                                            <p class="mt-1 text-sm text-gray-500">Charcoal</p>
                                            <p class="mt-1 text-sm text-gray-500">Large</p>
                                        </div>

                                        <div class="mt-4 flex-1 flex items-end justify-between">
                                            <p class="flex items-center text-sm text-gray-700 space-x-2">
                                                <!-- Heroicon name: solid/clock -->
                                                <svg class="flex-shrink-0 h-5 w-5 text-gray-300" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                                <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm1-12a1 1 0 10-2 0v4a1 1 0 00.293.707l2.828 2.829a1 1 0 101.415-1.415L11 9.586V6z" clip-rule="evenodd" />
                                                </svg>
                                                <span>Will ship in 7-8 years</span>
                                            </p>
                                            <div class="ml-4">
                                                <button type="button" class="text-sm font-medium text-indigo-600 hover:text-indigo-500">
                                                    <span>Remove</span>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </li>

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
