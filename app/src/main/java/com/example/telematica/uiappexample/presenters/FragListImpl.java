package com.example.telematica.uiappexample.presenters;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.example.telematica.uiappexample.UI.views.FragmentListView;
import com.example.telematica.uiappexample.models.Libro;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hp on 15-01-2016.
 */
public class FragListImpl {

    private Activity mContext;
    private FragmentListView mFragmentListView;

    public FragListImpl (Activity mContext, FragmentListView mFragmentListView){
        this.mContext = mContext;
        this.mFragmentListView = mFragmentListView;
        mFragmentListView.showConnectionErrorMsg();

    }

}
