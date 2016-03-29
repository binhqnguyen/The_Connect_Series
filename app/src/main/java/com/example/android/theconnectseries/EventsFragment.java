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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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


    public EventsFragment() {
    }

    public static List<Event> getData(){
        final String delim = "[{ ,}:]+";
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(MyApplication.getAppContext());
        String url ="http://155.99.89.140:8888/user_data.json";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.w("myApp", response);
                        String[] words = response.split(delim);
                        for(int i=0;i<words.length;i++) {
                            Log.w("myApp", words[i]);
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

        List<Event> data = new ArrayList<>();
        int[] icons = {R.drawable.logo_ames,R.drawable.logo_ames,R.drawable.logo_ames,R.drawable.logo_ames};
        String[] titles = {"One","Two","Three","Four"};
        for(int i = 0; i<icons.length && i<titles.length; i++){
            Event current = new Event();
            current.iconId= icons[i];
            current.title = titles[i];
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
