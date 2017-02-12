package id.co.imastudio.bimasakti;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    TextView tvdet;
    ImageView imgdet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvdet=(TextView)findViewById(R.id.tvDet);
        imgdet =(ImageView)findViewById(R.id.imgDet);


        tvdet.setText(getIntent().getStringExtra("detail"));
        Glide.with(getApplicationContext())
                .load(RequestHttp.icon+getIntent()
                        .getStringExtra("gambar"))
                .crossFade()
                .placeholder(R.drawable.alpukat1)
                .into(imgdet);
        setTitle(getIntent().getStringExtra("judul"));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT,"Share Berita Ini");
                i.putExtra(Intent.EXTRA_TEXT,""+getIntent()
                        .getStringExtra("judul")+"\n" +"\n"
                        +getIntent().getStringExtra("detail"));
                startActivity(i.createChooser(i,"Share berita ini"));

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
