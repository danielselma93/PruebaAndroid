package com.example.a2dam.hgi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Act2 extends AppCompatActivity {
private TextView benv;
    private Button btnOk;
    private EditText edad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act22);
        btnOk = (Button) findViewById(R.id.btnOk);
        benv = (TextView) findViewById(R.id.benv);
        edad = (EditText) findViewById(R.id.edad);
        final Intent i = getIntent();
        Bundle b =i.getExtras();
        if(b!=null){
            benv.setText("Hola, "+b.getCharSequence("sexo").toString()+b.getCharSequence("nomActivity1").toString());
        }

        btnOk.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                i.putExtra("Edat",edad.getText());
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }
}
