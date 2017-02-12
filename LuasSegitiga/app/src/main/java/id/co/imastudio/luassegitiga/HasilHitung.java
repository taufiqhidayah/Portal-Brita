package id.co.imastudio.luassegitiga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HasilHitung extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_hitung);
        TextView alas =(TextView)findViewById(R.id.txtNilaiAlas);
        TextView tinggi =(TextView)findViewById(R.id.txtNilaiTinggi);
        TextView hasil =(TextView)findViewById(R.id.txthasilkirim);
        //menangkap hasil dari MainActivity dan ditampilkan di TextView
        Intent b=getIntent();
        String alaskiriman=b.getStringExtra("alas");
        String tinggikiriman=b.getStringExtra("tinggi");
        String hasilkiriman=b.getStringExtra("hasil");
        //menampilkan text
        alas.setText(alaskiriman);
        tinggi.setText(tinggikiriman);
        hasil.setText(hasilkiriman);

    }
}
