package id.co.imastudio.spinerpopup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PopUpActivity extends AppCompatActivity {
    Button btnPopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);

        btnPopUp =(Button)findViewById(R.id.btPopUp);
        btnPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final PopupMenu pop = new
                        PopupMenu(PopUpActivity.this, view);
                pop.inflate(R.menu.main_menu);
                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.mPetani :
                                Toast.makeText(PopUpActivity.this, "Hai Petani",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.mBoss :
                                Toast.makeText(PopUpActivity.this, "Hai Boss",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                });
                pop.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mPetani :
                Toast.makeText(PopUpActivity.this, "Hai Petani",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.mBoss :
                Toast.makeText(PopUpActivity.this, "Hai Boss",
                        Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}









