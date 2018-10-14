package pro.sosnovsky.lifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    private Button ok, back;
    private EditText edit;
    private String mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ok = findViewById(R.id.btn_ok_third);
        ok.setOnClickListener(this);
        back = findViewById(R.id.btn_back_third);
        back.setOnClickListener(this);
        edit = findViewById(R.id.text_edit_third);

        Intent intent = getIntent();
        mail = intent.getStringExtra("mail");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_back_third) {
            Intent intent = new Intent();
            intent.putExtra("second", "cancelled from window 3");
            setResult(RESULT_CANCELED, intent);
            finish();
        }
        if (v.getId() == R.id.btn_ok_third) {
            Intent intent = new Intent();
            /**/
            intent.putExtra("phone", String.valueOf(edit.getText()));
            intent.putExtra("mail", mail);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
