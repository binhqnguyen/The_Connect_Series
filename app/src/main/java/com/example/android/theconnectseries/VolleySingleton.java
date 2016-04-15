package com.example.android.theconnectseries;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by markvandermerwe on 4/14/16.
 */
public class VolleySingleton {

    private static VolleySingleton sInstance = null;
    private RequestQueue requestQueue;
    private VolleySingleton(){
        requestQueue = Volley.newRequestQueue(MyApplication.getAppContext());
    }

    public static VolleySingleton getsInstance(){
        if(sInstance==null){
            sInstance = new VolleySingleton();
        }

        return sInstance;
    }

    public RequestQueue getRequestQueue(){
        return requestQueue;
    }
}
