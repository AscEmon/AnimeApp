package com.example.animeapp.Class;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.animeapp.Adapter.RecyclerViewAdapter;
import com.example.animeapp.Model.Anime;
import com.example.animeapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String  JSON_URL="https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Anime> lst_anime;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst_anime=new ArrayList<>();
        recyclerView=findViewById(R.id.RecyclerViewId);


        JsonRequest();




    }

    private void JsonRequest() {
        request=new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject=null;


                for(int i=0;i<response.length();i++)
                {
                    try {
                        jsonObject=response.getJSONObject(i);
                        Anime anime=new Anime();
                        anime.setName(jsonObject.getString("name"));
                        //anime.setDescription(jsonObject.getString("description"));
                        anime.setRating(jsonObject.getString("Rating"));
                        anime.setEpisode(jsonObject.getInt("episode"));
                        anime.setCategorie(jsonObject.getString("categorie"));
                        anime.setStudio(jsonObject.getString("studio"));
                        anime.setImg(jsonObject.getString("img"));
                        lst_anime.add(anime);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }



                setUpRecyclerView();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });



        requestQueue= Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);

    }

    private void setUpRecyclerView() {


        RecyclerViewAdapter adapter=new RecyclerViewAdapter(this,lst_anime);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }
}
