package id.co.imastudio.bimasakti;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Taufiq on 2/10/2017.
 */

public class CustomAdapter extends BaseAdapter {
    ArrayList <HashMap<String,String>> viewData;
    Context c;
    public CustomAdapter(FragmentActivity activity, ArrayList<HashMap<String, String>> data) {
        this.c =activity;
        this.viewData =data;

    }

    @Override
    public int getCount() {
        return viewData.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflate = (LayoutInflater)
                c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(R.layout.listitem,null);

        TextView judul = (TextView)v.findViewById(R.id.tvPlanet);
        ImageView img = (ImageView)v.findViewById(R.id.imgPlanet);

        judul.setText(viewData.get(i).get("judul"));
        Glide.with(c)
                .load(RequestHttp.icon+viewData.get(i).get("gambar"))
                .crossFade()
                .placeholder(R.drawable.alpukat1)
                .into(img);

        return v;
    }
}
