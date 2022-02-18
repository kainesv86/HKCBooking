package variables;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kaine
 */
public class routes {

    // For Redirect & Action with paramater
    public static String INDEX_SERVLET = "IndexServlet";
    public static String LOGIN_SERVLET = "LoginServlet";
    public static String REGISTER_SERVLET = "RegisterServlet";
    public static String ROOM_DETAIL_SERVLET = "RoomDetailServlet";
    public static String CART_SERVLET = "CartServlet";
    public static String FILTER_SERVLET = "FilterServlet";
    public static String HISTORY_SERVLET = "HistoryServlet";
    public static String USER_INFO_SERVLET = "UserInfoServlet";
    public static String CHANGE_PASSWORD_SERVLET = "UserInfoServlet";
    public static String BOOKING_ORDERS_SERVLET = "BookingOrdersServlet";
    public static String ADD_ROOM_SERVLET = "AddRoomServlet";
    public static String EDIT_ROOM_SERVLET = "EditRoomServlet";
    public static String EDIT_ROOM_DETAIL_SERVLET = "EditRoomDetailServlet";
    
    // Action no-Redirect
    public static String REMOVE_CART_ITEM_SERVLET = "RemoveCartItemServlet";
    public static String LOGOUT_SERVLET = "LogoutServlet";
    public static String DELETE_ROOM_SERVLET = "DeleteRoomServlet";

    // For Dispatcher
    public static String INDEX_PAGE = "/WEB-INF/JSP/index.jsp";
    public static String LOGIN_PAGE = "/WEB-INF/JSP/login.jsp";
    public static String REGISTER_PAGE = "/WEB-INF/JSP/register.jsp";
    public static String ROOM_DETAIL_PAGE = "/WEB-INF/JSP/roomDetail.jsp";
    public static String CART_PAGE = "/WEB-INF/JSP/cart.jsp";
    public static String FILTER_PAGE = "/WEB-INF/JSP/filter.jsp";
    public static String HISTORY_PAGE = "/WEB-INF/JSP/history.jsp";
    public static String USER_INFO_PAGE = "/WEB-INF/JSP/userInfo.jsp";
    public static String CHANGE_PASSWORD_PAGE = "/WEB-INF/JSP/userInfo.jsp";
    public static String BOOKING_ORDERS_PAGE = "/WEB-INF/JSP/bookingOrders.jsp";
    public static String ADD_ROOM_PAGE = "/WEB-INF/JSP/addRoom.jsp";
    public static String EDIT_ROOM_PAGE  = "/WEB-INF/JSP/editRoom.jsp";
    public static String EDIT_ROOM_DETAIL_PAGE  = "/WEB-INF/JSP/editRoomDetail.jsp";
}
