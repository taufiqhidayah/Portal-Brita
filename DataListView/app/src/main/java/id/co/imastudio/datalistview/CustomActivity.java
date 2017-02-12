package id.co.imastudio.datalistview;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;

public class CustomActivity extends AppCompatActivity {
ListView lCustom;
    String[] namabuah = {"Alpukat","Apel","Ceri","Durian"};
    Integer[] gambar = {R.drawable.alpukat1,R.drawable.apel1,R.drawable.ceri1,R.drawable.duriani};
    Integer[] suara ={R.raw.alpukat,R.raw.apel,R.raw.apel,R.raw.ceri,R.raw.durian};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lCustom = (ListView)findViewById(R.id.lvCustom);
        CutomAdapter adapter = new CutomAdapter(this,gambar,namabuah);
        lCustom.setAdapter(adapter);

        lCustom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent b = new Intent(CustomActivity.this,DetailActivity.class);
                    b.putExtra("nmbuah",namabuah[i]);
                    b.putExtra("gbbuah",gambar[i]);
                startActivity(b);


                MediaPlayer mp = new MediaPlayer();
                //chek directory Raw
                Uri uri = Uri.parse("android.resource://"+getPackageName()
                        +"/"+suara[i]);
                //set media player untuk memutar audio
                mp.setAudioStreamType(AudioManager.STREAM_MUSIC);


                try {
                    mp.setDataSource(CustomActivity.this,uri);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    mp.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mp.start();

            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
