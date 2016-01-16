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

    Activity mContext;
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    FragmentListView mFragmentListView;

    public FragListImpl (Activity mContext, FragmentListView mFragmentListView){
        this.mContext = mContext;
        this.mFragmentListView = mFragmentListView;

        AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {

            @Override
            protected void onPreExecute(){

            }

            @Override
            protected String doInBackground(Void... params) {
                String resultado = new HttpServerConnection().connectToServer("http://www.mocky.io/v2/56990dc51200009e47e25b44", 15000);
                return resultado;
            }
            @Override
            protected void onPostExecute(String result) {
                if(result != null){
                    System.out.println(result);

                    // specify an adapter (see also next example)
                    mAdapter = new UIAdapter(getLista(result));
                    mRecyclerView.setAdapter(mAdapter);
                }
            }
        };

        task.execute();
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


}
