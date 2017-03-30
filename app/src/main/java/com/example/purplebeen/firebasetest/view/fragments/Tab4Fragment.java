package com.example.purplebeen.firebasetest.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.purplebeen.firebasetest.controllers.FriendsDataHandler;
import com.example.purplebeen.firebasetest.view.CommentActivity;
import com.example.purplebeen.firebasetest.view.dialogs.CustomDialog;
import com.example.purplebeen.firebasetest.adapters.MyAdapter;
import com.example.purplebeen.firebasetest.R;
import com.example.purplebeen.firebasetest.models.RecyclerData;
import com.example.purplebeen.firebasetest.view.TabLayoutActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tab4Fragment extends Fragment {
    private RecyclerView mRecyclerView;
    public static RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    public static ArrayList<RecyclerData> myDataset= new ArrayList<RecyclerData>();

    private android.support.design.widget.FloatingActionButton button;
    public Tab4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FriendsDataHandler handler = new FriendsDataHandler();
        handler.setting(getActivity());
        for (int i=1 ; i<=100 ; i++)
        {
            CommentActivity.up_count.add(1);
            CommentActivity.down_count.add(1);
        }


        View view = inflater.inflate(R.layout.fragment_tab4, null);

        button = (android.support.design.widget.FloatingActionButton) view.findViewById(R.id.fab2);

        mRecyclerView = (RecyclerView)view. findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(getActivity());
                customDialog.show();

            }
        });

        return view;
    }

}