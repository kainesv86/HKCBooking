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
public class Routers {

    // For Redirect & Action with paramater
    public static final String INDEX_SERVLET = "IndexServlet";
    public static final String LOGIN_SERVLET = "LoginServlet";
    public static final String REGISTER_SERVLET = "RegisterServlet";
    public static final String ROOM_DETAIL_SERVLET = "RoomDetailServlet";
    public static final String CART_SERVLET = "CartServlet";
    public static final String FILTER_SERVLET = "FilterServlet";
    public static final String HISTORY_SERVLET = "HistoryServlet";
    public static final String USER_INFO_SERVLET = "UserInfoServlet";
    public static final String CHANGE_PASSWORD_SERVLET = "ChangePasswordServlet";
    public static final String BOOKING_ORDERS_SERVLET = "BookingOrdersServlet";
    public static final String ADD_ROOM_SERVLET = "AddRoomServlet";
    public static final String EDIT_ROOM_SERVLET = "EditRoomServlet";
    public static final String EDIT_ROOM_DETAIL_SERVLET = "EditRoomDetailServlet";
    public static final String ADD_ROOM_TYPE_SERVLET = "AddRoomTypeServlet";
    public static final String USERS_SERVLET = "UsersServlet";
    public static final String USER_HISTORIES_SERVLET = "UserHistoriesServlet";

    // Action no-Redirect
    public static final String REMOVE_CART_ITEM_SERVLET = "RemoveCartItemServlet";
    public static final String LOGOUT_SERVLET = "LogoutServlet";
    public static final String DELETE_ROOM_SERVLET = "DeleteRoomServlet";
    public static final String ADD_PARAMS_SERVLET = "AddParamsServlet";
    public static final String CANCEL_HISTORY_SERVLET = "CancelHistoryServlet";

    // For Dispatcher
    public static final String INDEX_PAGE = "/WEB-INF/JSP/index.jsp";
    public static final String LOGIN_PAGE = "/WEB-INF/JSP/login.jsp";
    public static final String REGISTER_PAGE = "/WEB-INF/JSP/register.jsp";
    public static final String ROOM_DETAIL_PAGE = "/WEB-INF/JSP/roomDetail.jsp";
    public static final String CART_PAGE = "/WEB-INF/JSP/cart.jsp";
    public static final String FILTER_PAGE = "/WEB-INF/JSP/filter.jsp";
    public static final String HISTORY_PAGE = "/WEB-INF/JSP/history.jsp";
    public static final String USER_INFO_PAGE = "/WEB-INF/JSP/userInfo.jsp";
    public static final String CHANGE_PASSWORD_PAGE = "/WEB-INF/JSP/changePassword.jsp";
    public static final String BOOKING_ORDERS_PAGE = "/WEB-INF/JSP/bookingOrders.jsp";
    public static final String ADD_ROOM_PAGE = "/WEB-INF/JSP/addRoom.jsp";
    public static final String EDIT_ROOM_PAGE = "/WEB-INF/JSP/editRoom.jsp";
    public static final String EDIT_ROOM_DETAIL_PAGE = "/WEB-INF/JSP/editRoomDetail.jsp";
    public static final String USERS_PAGE = "/WEB-INF/JSP/users.jsp";
    public static final String ADD_ROOM_TYPE_PAGE = "/WEB-INF/JSP/addRoomType.jsp";
    public static final String USER_HISTORIES_PAGE = "/WEB-INF/JSP/userHistories.jsp";

    // Discpatcher no-Action
    public static final String ERROR_404_PAGE = "/WEB-INF/JSP/404Page.jsp";
    public static final String ERROR_500_PAGE = "/WEB-INF/JSP/500Page.jsp";

}
