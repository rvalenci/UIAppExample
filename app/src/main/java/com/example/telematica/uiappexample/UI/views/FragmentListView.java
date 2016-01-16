package com.example.telematica.uiappexample.UI.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Hp on 15-01-2016.
 */
public interface FragmentListView {

    public void showConnectionErrorMsg();

    public void onPause();

    public void onResume();

}
