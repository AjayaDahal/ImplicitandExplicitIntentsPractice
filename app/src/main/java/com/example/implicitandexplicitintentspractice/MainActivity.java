package com.example.implicitandexplicitintentspractice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1 ;
    ImageView ivMood, phn, web, location;
    final int CREATE_NEW_CONTACT = 1;
    String name="", number = "", website  =  "",map="", mood="";
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CREATE_NEW_CONTACT){
            if(resultCode==RESULT_OK){
                ivMood.setVisibility(View.VISIBLE);
                phn.setVisibility(View.VISIBLE);
                web.setVisibility(View.VISIBLE);
                location.setVisibility(View.VISIBLE);

                name = data.getStringExtra("name");
                number = data.getStringExtra("number");
                website = data.getStringExtra("web");
                map = data.getStringExtra("address");

                mood = data.getStringExtra("mood");
                if(mood.equals("happy")){
                    ivMood.setImageResource(R.drawable.happy);
                }
                else if(mood.equals("ok")){
                    ivMood.setImageResource(R.drawable.ok);
                }
                else if(mood.equals("sad")){
                    ivMood.setImageResource(R.drawable.sad);
                }
                else{
                    Toast.makeText(this, "No data was returned", Toast.LENGTH_SHORT).show();
                }

            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivMood = findViewById(R.id.ivMood);
        phn = findViewById(R.id.phn);
        web = findViewById(R.id.web);
        location = findViewById(R.id.location);
        btn1 = findViewById(R.id.btn1);

        ivMood.setVisibility(View.GONE);
        phn.setVisibility(View.GONE);
        web.setVisibility(View.GONE);
        location.setVisibility(View.GONE);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.implicitandexplicitintentspractice.Create_New_Contact.class);
                startActivityForResult(intent, CREATE_NEW_CONTACT);

            }
        });
        ivMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
            }
        });

        phn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https:\\"+website));
                startActivity(intent);
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+map));
                startActivity(intent);

            }
        });



    }
}
