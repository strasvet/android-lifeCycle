package pro.sosnovsky.lifecycle;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private Button next, back;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        /*Intent gI = getIntent();
        String name = gI.getStringExtra("NAME");*/

        next = findViewById(R.id.btn_two);
        next.setOnClickListener(this);
        back = findViewById(R.id.btn_back_two);
        back.setOnClickListener(this);
        edit = findViewById(R.id.text_edit_two);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btn_two){
            Intent intent = new Intent(this, ThirdActivity.class);
            intent.putExtra("mail", String.valueOf(edit.getText()));
            startActivityForResult(intent, 333);
        }

        if(v.getId() == R.id.btn_back_two){
            Intent intent = new Intent();
            intent.putExtra("second", "your pressed BACK button");
            setResult(RESULT_CANCELED, intent);
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == 333 && data!= null && data.getExtras()!= null){
                /*Intent intent = new Intent();
                String mail = data.getStringExtra("mail");
                String phone = data.getStringExtra("phone");
                intent.putExtra("mail", mail);
                intent.putExtra("phone", phone);
                */
                setResult(RESULT_OK, data);
                finish();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
