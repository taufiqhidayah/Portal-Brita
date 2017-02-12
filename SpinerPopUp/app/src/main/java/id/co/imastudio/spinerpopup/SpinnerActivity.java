package id.co.imastudio.spinerpopup;

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
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class SpinnerActivity extends AppCompatActivity {
    Spinner spindrop;
    TextView tvSpinner;
    ImageView  imgSpinner;

    String[] list = {"Alpukat","Apel", "Ceri","Durian","Jambu Air",
            "Manggis","Strawberry"};
    Integer[] gambar ={R.drawable.alpukat1, R.drawable.apel1,R.drawable.ceri1,R.drawable.duriani
        ,R.drawable.jambuairi,R.drawable.manggisi,R.drawable.strawberrya};
    Integer[] suara ={R.raw.alpukat,R.raw.apel,R.raw.ceri,R.raw.durian, R.raw.durian
            ,R.raw.jambuair,R.raw.manggis,R.raw.strawberry};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spindrop = (Spinner)findViewById(R.id.spin);
        tvSpinner = (TextView)findViewById(R.id.tvSpin);
        imgSpinner =(ImageView)findViewById(R.id.imgSpin);

        ArrayAdapter adapter = new
                ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, list);
        spindrop.setAdapter(adapter);

        spindrop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SpinnerActivity.this,
                        list[i], Toast.LENGTH_SHORT).show();

                tvSpinner.setText(list[i]);
                imgSpinner.setImageResource(gambar[i]);

                MediaPlayer mp = new MediaPlayer();
                //chek directory Raw
                Uri uri = Uri.parse("android.resource://"+getPackageName()
                    +"/"+suara[i]);
                //set media player untuk memutar audio
                mp.setAudioStreamType(AudioManager.STREAM_MUSIC);


                try {
                    mp.setDataSource(SpinnerActivity.this,uri);
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

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}






