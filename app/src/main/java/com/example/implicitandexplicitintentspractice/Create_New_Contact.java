package com.example.implicitandexplicitintentspractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Create_New_Contact extends AppCompatActivity implements View.OnClickListener{
    TextView etName, etNumber, etWeb, etLocation;
    ImageView happy, sad, ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__new__contact);

        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        etLocation = findViewById(R.id.etAddress);
        etWeb = findViewById(R.id.etWeb);

        happy = findViewById(R.id.happy);
        ok = findViewById(R.id.ok);
        sad = findViewById(R.id.sad);

        happy.setOnClickListener(this);
        sad.setOnClickListener(this);
        ok.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(etName.getText().toString().isEmpty()||etName.getText().toString().isEmpty()||etLocation.getText().toString().isEmpty()||etWeb.getText().toString().isEmpty()||etNumber.getText().toString().isEmpty()){
            Toast.makeText(this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent  = new Intent();
            intent.putExtra("name", etName.getText().toString().trim());
            intent.putExtra("number", etNumber.getText().toString().trim());
            intent.putExtra("web", etWeb.getText().toString().trim());
            intent.putExtra("address", etLocation.getText().toString().trim());
            if (v.getId() == R.id.happy){
                intent.putExtra("mood", "happy");
            }
            else if (v.getId() == R.id.ok){
                intent.putExtra("mood", "ok");
            }
            else {
                intent.putExtra("mood", "sad");
            }
            setResult(RESULT_OK, intent);
            Create_New_Contact.this.finish();
            }



        }
    }

