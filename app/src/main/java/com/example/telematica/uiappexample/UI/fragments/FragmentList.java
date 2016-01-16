package com.example.telematica.uiappexample.UI.fragments;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.telematica.uiappexample.R;
import com.example.telematica.uiappexample.UI.views.FragmentListView;
import com.example.telematica.uiappexample.models.Libro;
import com.example.telematica.uiappexample.presenters.HttpServerConnection;
import com.example.telematica.uiappexample.presenters.UIAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hp on 15-01-2016.
 */
public class FragmentList extends Fragment implements FragmentListView{

    private RecyclerView.LayoutManager mLayoutManager;
    private FragmentList mFragmentList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    public static FragmentList newInstance (){
        FragmentList fragmentList= new FragmentList();
        return fragmentList;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

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

        new JSTask().execute();

        return mainView;
    }


    private List<Libro> getLista(String result){
        List<Libro> listaLibros = new ArrayList<Libro>();
        try {
            JSONArray lista = new JSONArray(result);

            int size = lista.length();
            for(int i = 0; i < size; i++){
                Libro libro = new Libro();
                JSONObject objeto = lista.getJSONObject(i);

                libro.setId(objeto.getInt("id"));
                libro.setNombre(objeto.getString("nombre"));
                libro.setEditorial(objeto.getString("editorial"));
                libro.setGenero(objeto.getString("genero"));
                libro.setAutor(objeto.getInt("autor"));

                listaLibros.add(libro);
            }
            return listaLibros;
        } catch (JSONException e) {
            e.printStackTrace();
            return listaLibros;
        }
    }

    public class JSTask extends AsyncTask<String,String, String> {

        protected void onPostExecute(String result){
            if(result != null){
                System.out.println(result);
                mAdapter = new UIAdapter(getLista(result));
                mRecyclerView.setAdapter(mAdapter);
            }
        }


        @Override
        protected String doInBackground(String... params) {
            String resultado = new HttpServerConnection().connectToServer("http://www.mocky.io/v2/56990dc51200009e47e25b44", 15000);
            return resultado;
        }

    }
    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
    public void showConnectionErrorMsg() {
        Toast.makeText(getActivity(), "Fallo la conexion", Toast.LENGTH_LONG).show();
    }


}
