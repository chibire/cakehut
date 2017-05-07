package com.chibire.terence.cakehut.drawer;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.chibire.terence.cakehut.MainActivity;
import com.chibire.terence.cakehut.R;
import com.chibire.terence.cakehut.adapter.RecyclerViewAdapter;
import com.chibire.terence.cakehut.configs.MenuConfig;
import com.chibire.terence.cakehut.constructors.MenuConstructor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 4/23/17.
 */

public class LunchFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private LinearLayoutManager lLayout;

    SwipeRefreshLayout mSwipeRefreshLayout;

    ArrayList<MenuConstructor> breakfasts = new ArrayList<>();

    private ProgressDialog loading;
    RecyclerViewAdapter rcAdapter;

    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View x = inflater.inflate(R.layout.fragment_breakfast, container, false);
        ((MainActivity) getActivity()).mToolbar.setTitle("Breakfast");

//        lLayout = new LinearLayoutManager(getActivity());

//        final RecyclerView rView = (RecyclerView) x.findViewById(R.id.recycler_view_all);
//        rView.setItemAnimator(new DefaultItemAnimator());
//        rView.setLayoutManager(lLayout);
////        final List<MenuConstructor> rowListItem = getMenuItem();
//        rcAdapter = new RecyclerViewAdapter(getActivity());
//        rView.setAdapter(rcAdapter);
        mSwipeRefreshLayout = (SwipeRefreshLayout) x.findViewById(R.id.swipe_container);
        loading = ProgressDialog.show(getActivity(), "Please wait...", "Fetching...", false, false);

        RecyclerViewAdapter.OnItemClickListener onItemClickListener = new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
//                Toast.makeText(getActivity(), "Clicked " + position, Toast.LENGTH_SHORT).show();

            }
        };

        rcAdapter.setOnItemClickListener(onItemClickListener);

        // Inflate the layout for this fragment
        return x;
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            // Set title
            getActivity().getActionBar()
                    .setTitle("Breakfast");
        }
    }
    public List<MenuConstructor> getMenuItem() {
        loading = ProgressDialog.show(getActivity(), "Please wait...", "Fetching...", false, false);

        String url = MenuConfig.MENU_URL;

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loading.dismiss();
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);

        return breakfasts;
    }
    private void showJSON(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray("menu_items");


            for (int i = 0; i < result.length(); i++) {

                JSONObject breakfastData = result.getJSONObject(i);
                MenuConstructor breakfast = new MenuConstructor();
                breakfast.setMenu_name(breakfastData.getString("menu_name"));
                breakfast.setMenu_name(breakfastData.getString("menu_unit"));
                breakfast.setMenu_name(breakfastData.getString("menu_price"));
                breakfasts.add(breakfast);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}