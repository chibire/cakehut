package com.chibire.terence.cakehut.drawer;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chibire.terence.cakehut.R;
import com.chibire.terence.cakehut.adapter.CustMenuAdapter;

/**
 * Created by root on 4/14/17.
 */

public class HomeFragment extends Fragment {
    private boolean isListView;
    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private CustMenuAdapter mAdapter;
    FragmentManager mFragmentManager;
    private ProgressDialog loading;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.home_fragment, container, false);

        isListView = true;

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);

        mAdapter = new CustMenuAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);

        CustMenuAdapter.OnItemClickListener onItemClickListener = new CustMenuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                loading = ProgressDialog.show(getActivity(), "Please wait...", "Fetching...", false, false);
//                if (position == 0)
//                {
////                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
////                    fragmentTransaction.replace(R.id.contentView,new BreakfastFragment()).addToBackStack(null).commit();
//                    loading = ProgressDialog.show(getActivity(), "Please wait...", "Fetching...", false, false);
//                }
//                else if (position == 1)
//                {
//                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.contentView,new BurgersFragment()).addToBackStack(null).commit();
//                }
//                else if(position == 2)
//                {
//                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.contentView,new BakeryFragment()).addToBackStack(null).commit();
//                }
//                else if(position == 3)
//                {
//                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.contentView,new DrinksFragment()).addToBackStack(null).commit();
//                }
//                else if(position == 4)
//                {
//                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.contentView,new LunchFragment()).addToBackStack(null).commit();
//                }
//                else if (position == 5)
//                {
//                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.contentView,new SaladsFragment()).addToBackStack(null).commit();
//                }
//                else if(position == 6)
//                {
//                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.contentView,new SandwichesFragment()).addToBackStack(null).commit();
//                }
//                else if(position == 7)
//                {
//                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.contentView,new SnacksFragment()).addToBackStack(null).commit();
//                }
//                else
//                {
//                    Toast.makeText(getActivity(), "Clicked " + position, Toast.LENGTH_SHORT).show();
//                }

            }
        };
        mAdapter.setOnItemClickListener(onItemClickListener);

        return rootView;
    }
}
