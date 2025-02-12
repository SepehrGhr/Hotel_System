package com.fanap.hotel.util.constants;

import javax.swing.plaf.PanelUI;

public class Routes {
    public static final String API_KEY = "/api";
    public static final String VERSION = "/v";
    public static final String V1_API = API_KEY + VERSION + "1";

    // ADMIN
    public static final String ADMIN_ROUTE = V1_API + "/admin";
    public static final String BLOCK = "/block";

    //ROOM
    public static final String ROOM_ROUTE = V1_API + "/room";
    public static final String ROOM_ID_PARAM_KEY = "/{id}";
}
