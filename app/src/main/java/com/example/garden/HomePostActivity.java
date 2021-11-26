package com.example.garden;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomePostActivity extends Activity {
    private ImageButton btnBack2;
    private ImageButton btnToStore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_post);

        btnBack2 = findViewById(R.id.btnBack2);
        btnBack2.setColorFilter(Color.parseColor("#000000"));
        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnToStore = findViewById(R.id.btnToStore);
        btnToStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Product2Activity.class);
                startActivity(intent);
            }
        });
    }
}
