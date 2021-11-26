package com.example.garden;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

public class PhotoUpload extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photoupload);

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setColorFilter(Color.parseColor("#000000"));
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //버튼 클릭시 액티비티 전환
        ImageButton upload_btn = (ImageButton) findViewById(R.id.btnUpload);
        upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("isUploaded", true);
                startActivity(intent);
            }
        });
    }
}
