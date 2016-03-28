package com.example.android.theconnectseries;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by markvandermerwe on 3/5/16.
 */
public class InterestsFragment extends Fragment {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private RecyclerView recyclerView;
    private InterestsAdapter adapter;

    public InterestsFragment() {
    }

    public static List<Interest> getData(){
        List<Interest> data = new ArrayList<>();
        int[] icons = {R.drawable.logo_ames,R.drawable.logo_ames,R.drawable.logo_ames,R.drawable.logo_ames};
        String[] titles = {"One","Two","Three","Four"};
        for(int i = 0; i<icons.length && i<titles.length; i++){
            Interest current = new Interest();
            current.iconId= icons[i];
            current.title = titles[i];
            data.add(current);
        }
        return data;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.interests_fragment, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerListInt);
        adapter = new InterestsAdapter(getActivity(),getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }


}
