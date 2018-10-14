package pro.sosnovsky.lifecycle;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = findViewById(R.id.btn_login);
        login.setOnClickListener(this);

        view = findViewById(R.id.text_one);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_login){
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("NAME", "VASYA");
            startActivityForResult(intent, 222);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            if(resultCode == RESULT_OK){
                if(requestCode == 222 && data != null && data.getExtras() !=null){
                    String text = "Hello, your mail is: "+ data.getStringExtra("mail")
                            + " and your phone number is: " + data.getStringExtra("phone");
                    view.setText(text);
                }
                if(requestCode == 333){

                }
            }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
