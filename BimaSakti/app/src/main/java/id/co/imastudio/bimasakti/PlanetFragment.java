package id.co.imastudio.bimasakti;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlanetFragment extends Fragment {

    GridView grView;
    AQuery aq;
    ArrayList<HashMap<String,String>> data = new ArrayList<HashMap<String,String>>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_planet, container, false);
        aq = new AQuery(getActivity());
        grView = (GridView)v.findViewById(R.id.grPlanet);
        getPlanet();
        grView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HashMap<String,String> map =data.get(i);

                Intent z = new Intent(getActivity(),DetailActivity.class);
                    z.putExtra("id",map.get("id"));
                    z.putExtra("judul",map.get("judul"));
                    z.putExtra("gambar",map.get("gambar"));
                    z.putExtra("detail",map.get("detail"));
                startActivity(z);
            }
        });

        return v;
    }

    private void getPlanet() {
        String planet = RequestHttp.data;
        ProgressDialog pg = new ProgressDialog(getActivity());
        pg.setMessage("Menunggu.....");
        pg.setCancelable(true);
        pg.setIndeterminate(true);
        aq.progress(pg).ajax(planet,String.class,new AjaxCallback<String>() {
            @Override
            public void callback(String url, String object, AjaxStatus status) {
               if (object != null){
                   try {
                       JSONObject json = new JSONObject(object);
                       String pesan = json.getString("pesan");
                       String hasil = json.getString("sukses");
                       JSONArray jray = json.getJSONArray("berita");

                       if (hasil.equalsIgnoreCase("true")) {
                           for (int a = 0; a < jray.length(); a++) {
                               JSONObject js =jray.getJSONObject(a);
                               String id =js.getString("id");
                               String judul =js.getString("judul");
                               String gambar =js.getString("gambar");
                               String detail =js.getString("detail");
                               HashMap<String,String> map = new HashMap<String, String>();
                               map.put("id",id);
                               map.put("judul",judul);
                               map.put("gambar",gambar);
                               map.put("detail",detail);
                               data.add(map);
                               tampildata(data);


                           }
                           Toast.makeText(getActivity(), pesan, Toast.LENGTH_SHORT).show();
                       }else {
                           Toast.makeText(getActivity(), pesan, Toast.LENGTH_SHORT).show();
                       }
                   } catch (JSONException e) {
                       e.printStackTrace();
                       Toast.makeText(getActivity(), "Gagal Json", Toast.LENGTH_SHORT).show();
                   }

               }else {
                   Toast.makeText(getActivity(), "Objek Gk ada", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }

    private void tampildata(ArrayList<HashMap<String, String>> data) {
        CustomAdapter adapter = new CustomAdapter(getActivity(),data);
        grView.setAdapter(adapter);
    }

}







