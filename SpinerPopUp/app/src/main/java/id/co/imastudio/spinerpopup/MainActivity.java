package id.co.imastudio.spinerpopup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnSpin,btnPop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSpin =(Button)findViewById(R.id.btPindahSpinner);
        btnPop = (Button)findViewById(R.id.btPindahPopUp);

        btnSpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent
                        (MainActivity.this,SpinnerActivity.class);
                startActivity(i);
            }
        });
        btnPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i = new Intent
                    (MainActivity.this,PopUpActivity.class);
                startActivity(i);
            }
        });

    }
}








