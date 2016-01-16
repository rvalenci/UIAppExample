package com.example.telematica.uiappexample.UI.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Hp on 15-01-2016.
 */
public class BaseActivity extends AppCompatActivity {
    private int contentFrame;

    protected void setContentFrame (int contentFrame){
        this.contentFrame = contentFrame;
    }

    public void switchContent (Fragment fragment, String addBackStack){
        try{
            final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            if(addBackStack != null)
                fragmentTransaction.commit();
            fragmentTransaction.replace(contentFrame, fragment);
            fragmentTransaction.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}