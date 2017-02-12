package id.co.imastudio.datalistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Taufiq on 2/9/2017.
 */

public class CutomAdapter extends BaseAdapter {
    Activity act;
    Integer[] gbr;
    String[] nm_buah;

    public CutomAdapter(CustomActivity customActivity, Integer[] gambar, String[] namabuah) {
        gbr =gambar;
        act= customActivity;
        nm_buah = namabuah;
    }
//jumlah row
    @Override
    public int getCount() {
        return gbr.length;
    }
//jumlah item
    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater =(LayoutInflater)
                act.getSystemService(act.LAYOUT_INFLATER_SERVICE);
        View v =inflater.inflate(R.layout.listitem,null);
        ImageView img = (ImageView)v.findViewById(R.id.imgList);
        TextView tv = (TextView)v.findViewById(R.id.tvList);

        tv.setText(nm_buah[i]);
        img.setImageResource(gbr[i]);

        return v;
    }
}
