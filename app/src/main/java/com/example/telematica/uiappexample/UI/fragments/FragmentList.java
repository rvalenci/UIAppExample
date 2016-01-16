package com.example.telematica.uiappexample.UI.fragments;

import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.telematica.uiappexample.R;
import com.example.telematica.uiappexample.UI.views.FragmentListView;

/**
 * Created by Hp on 15-01-2016.
 */
public class FragmentList extends Fragment implements FragmentListView{

    RecyclerView.LayoutManager mLayoutManager;
    FragmentList mFragmentList;
    RecyclerView mRecyclerView;

    public static FragmentList newInstance (){
        FragmentList fragmentList= new FragmentList();
        return fragmentList;
    }

    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState){
        super.onCreateView(inflater, container, saveInstanceState);
        View mainView = inflater.inflate(R.layout.activity_main, null);

        mRecyclerView = (RecyclerView) mainView.findViewById(R.id.content_frame);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        return mainView;
    }

}
