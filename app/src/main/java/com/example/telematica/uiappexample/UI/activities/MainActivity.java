package com.example.telematica.uiappexample.UI.activities;


import android.os.Bundle;
import com.example.telematica.uiappexample.R;
import com.example.telematica.uiappexample.UI.fragments.FragmentList;


public class MainActivity extends BaseActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentFrame(R.id.content_frame);
        switchContent(FragmentList.newInstance(), null);

    }


}
