package com.example.android.theconnectseries;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by markvandermerwe on 3/5/16.
 */
public class EventsFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private RecyclerView recyclerView;
    private EventsAdapter adapter;

    static String[] eventsTitle;


    public EventsFragment() {
    }

    public static void getDatabaseData(){
        final String delim = "[{ ,}:]+";
        // Instantiate the RequestQueue.
        RequestQueue queue = VolleySingleton.getsInstance().getRequestQueue();
        String url ="http://www.walmart.netau.net/";

        // Request a string response from the provided URL.
/*
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.w("myApp", response);
                        eventsTitle = response.split(delim);
                        for(int i=0;i<eventsTitle.length;i++) {
                            //Log.w("myApp", eventsTitle[i]);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //textView.setText("That didn't work!");
                Log.w("myApp", "No response.");
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
        */

        /*
        for(int y=0;y<eventsFeed.length;y++) {
            Log.w("myApp", eventsFeed[y]);
        }
        */

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.w("myApp", "Got it.");
                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.w("myApp", "Didn't work.");
            }
        });
        queue.add(jsonObjectRequest);

        /*
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        String answer = response.toString();
                        Log.w("myApp",answer);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.w("myApp", "Didn't work");
            }
        });
        queue.add(jsonArrayRequest);
        */

    }

    public static List<Event> getData(){
        List<Event> data = new ArrayList<>();
        getDatabaseData();
        int[] icons = {R.drawable.logo_ames,R.drawable.logo_ames,R.drawable.logo_ames,R.drawable.logo_ames};
        String[] titles = {"Event One","Event Two","Event Three","Event Four"};
        String[] descriptions = {"foobar","foobar","foobar","foobar"};
        for(int i = 0; i<icons.length && i<titles.length; i++){
            Event current = new Event();
            current.iconId= icons[i];
            current.title = titles[i];
            current.description = descriptions[i];
            data.add(current);
        }
        return data;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.events_fragment, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerList);
        adapter = new EventsAdapter(getActivity(),getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }
}
