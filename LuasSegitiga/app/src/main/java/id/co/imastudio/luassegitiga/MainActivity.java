package id.co.imastudio.luassegitiga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener{
    Button btnOK,btnClear,btnKirim;
    TextView nilaiHasil;
    EditText txtnilaialas,txtnilaitinggi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOK=(Button)findViewById(R.id.btnOK);
        txtnilaialas=(EditText)findViewById(R.id.txtnilaialas);
        txtnilaitinggi=(EditText)findViewById(R.id.txtnilaitinggi);
        btnClear=(Button)findViewById(R.id.btnclear);
        btnKirim=(Button)findViewById(R.id.btnkirim);
        nilaiHasil=(TextView)findViewById(R.id.txthasil);
        //biar bisa di klik
        btnOK.setOnClickListener(this);
        btnKirim.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view==btnOK){
            //mencegah text agar tidak kosong
            if (TextUtils.isEmpty(txtnilaialas.getText().toString())){
                txtnilaialas.setError("Nilai alas tidak boleh kosong Bro...");
            }else if (TextUtils.isEmpty(txtnilaitinggi.getText().toString())){
                txtnilaitinggi.setError("Nilai tinggi tidak boleh kosong Bro..");
            }else {
                double a=Double.parseDouble(txtnilaialas.getText().toString());
                double b=Double.parseDouble(txtnilaitinggi.getText().toString());
                double hasil = (a*b)/2;
                nilaiHasil.setText("Hasilnya = "+hasil);
            }
        }
        else if (view==btnClear){
            txtnilaialas.setText("");
            txtnilaitinggi.setText("");
            nilaiHasil.setText("");
        }else if (view==btnKirim){
            Intent b=new Intent(MainActivity.this,HasilHitung.class);
            b.putExtra("alas",txtnilaialas.getText().toString());
            b.putExtra("tinggi",txtnilaitinggi.getText().toString());
            b.putExtra("hasil",nilaiHasil.getText().toString());
            startActivity(b);
        }

    }
}
