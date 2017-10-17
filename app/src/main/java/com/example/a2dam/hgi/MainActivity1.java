package com.example.a2dam.hgi;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity1 extends AppCompatActivity {
    private EditText et_nom;
    private Button botoInfo;
    private RadioButton Mascle;
    private RadioButton Femella;
    final int SUBACT_1=1;

    protected void tornarDelActivity(){
        et_nom.setEnabled(false);
        botoInfo.setEnabled(false);
        Mascle.setEnabled(false);
        Femella.setEnabled(false);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        botoInfo = (Button) findViewById(R.id.botoInfo);
        et_nom = (EditText) findViewById(R.id.et_nom);
       Mascle = (RadioButton) findViewById(R.id.Mascle);
        Femella = (RadioButton) findViewById(R.id.Femella);

        botoInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Act2.class);
                Bundle parametres = new Bundle();
                parametres.putCharSequence("nomActivity1", et_nom.getText());
                if(Mascle.isChecked()){
                    parametres.putCharSequence("sexo","en ");
                }else{
                    parametres.putCharSequence("sexo","na ");
                }

                i.putExtras(parametres);
                startActivityForResult(i,SUBACT_1);
            }
        });
    }


        public void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==SUBACT_1){
            if(resultCode==RESULT_OK){
                tornarDelActivity();
                Bundle bundle = data.getExtras();
                String edadString = bundle.getCharSequence("Edat").toString();
                int edadInt =  Integer.parseInt(edadString);
                if(edadInt >18&& edadInt<25){
                    Toast.makeText(this, "Ja eres major de edad ", Toast.LENGTH_LONG).show();
                } if(edadInt >=25 && edadInt<35)
                Toast.makeText(this, "Estas en la flor de la vida", Toast.LENGTH_LONG).show();
                if(edadInt >35){
                    Toast.makeText(this, "ay ay ay", Toast.LENGTH_LONG).show();
                }

            }else{
                Toast.makeText(this,"La activity no ha segut satisfactoria",Toast.LENGTH_LONG).show();
            }
        }

    }
        //botoInfo.setOnClickListener(new View.O
       // );
    }

