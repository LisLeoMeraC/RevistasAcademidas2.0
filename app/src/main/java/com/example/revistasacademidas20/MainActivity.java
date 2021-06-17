package com.example.revistasacademidas20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import com.example.revistasacademidas20.Adapter.RevistaAdapter;
import com.example.revistasacademidas20.Modelo.Revista;
import com.example.revistasacademidas20.ServicioWeb.Asynchtask;
import com.example.revistasacademidas20.ServicioWeb.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/issues.php?j_id=2",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<Revista> lstRevistas = new ArrayList<Revista> ();

        try{
            JSONObject JSONlista =  new JSONObject(result);
            JSONArray JSONlistaRevistas=  JSONlista.getJSONArray("data");

            lstRevistas=Revista.JsonObjectsBuild(JSONlistaRevistas);
            RevistaAdapter adaptrevista= new RevistaAdapter(this, lstRevistas);

            int resID= R.anim.layout_animation_down_to_up;
            LayoutAnimationController animation= AnimationUtils.loadLayoutAnimation(getApplicationContext(),resID);
            recyclerView.setLayoutAnimation(animation);
            recyclerView.setAdapter(adaptrevista);
        }catch (JSONException e){
            Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }
    }
}