package com.example.garden;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class SurveyActivity2 extends Activity {
    ToggleButton[] toggleButtons = new ToggleButton[15];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survey2);

        int[] btnId = {R.id.ib1, R.id.ib2, R.id.ib3, R.id.ib4, R.id.ib5, R.id.ib6, R.id.ib7,
                R.id.ib8, R.id.ib9, R.id.ib10, R.id.ib11, R.id.ib12, R.id.ib13, R.id.ib14, R.id.ib15};
        for(int i=0; i<15;i++){
            toggleButtons[i] = (ToggleButton) findViewById(btnId[i]);
            //toggleButtons[i].setOnClickListener(btnListener);
        }

        toggleButtons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButtons[0].isChecked()){
                    toggleButtons[0].setBackgroundDrawable(getResources().getDrawable(R.drawable.clicked1));
                }
            }
        });
        toggleButtons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButtons[1].isChecked()){
                    toggleButtons[1].setBackgroundDrawable(getResources().getDrawable(R.drawable.clicked2));
                }
            }
        });
        toggleButtons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButtons[2].isChecked()){
                    toggleButtons[2].setBackgroundDrawable(getResources().getDrawable(R.drawable.clicked3));
                }
            }
        });
        toggleButtons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButtons[3].isChecked()){
                    toggleButtons[3].setBackgroundDrawable(getResources().getDrawable(R.drawable.clicked4));
                }
            }
        });
        toggleButtons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButtons[4].isChecked()){
                    toggleButtons[4].setBackgroundDrawable(getResources().getDrawable(R.drawable.clicked5));
                }
            }
        });
        toggleButtons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButtons[5].isChecked()){
                    toggleButtons[5].setBackgroundDrawable(getResources().getDrawable(R.drawable.clicked6));
                }
            }
        });
        toggleButtons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButtons[6].isChecked()){
                    toggleButtons[6].setBackgroundDrawable(getResources().getDrawable(R.drawable.clicked7));
                }
            }
        });
        toggleButtons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButtons[7].isChecked()){
                    toggleButtons[7].setBackgroundDrawable(getResources().getDrawable(R.drawable.clicked8));
                }
            }
        });
        toggleButtons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButtons[8].isChecked()){
                    toggleButtons[8].setBackgroundDrawable(getResources().getDrawable(R.drawable.clicked9));
                }
            }
        });
        toggleButtons[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButtons[9].isChecked()){
                    toggleButtons[9].setBackgroundDrawable(getResources().getDrawable(R.drawable.clicked10));
                }
            }
        });
        toggleButtons[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButtons[10].isChecked()){
                    toggleButtons[10].setBackgroundDrawable(getResources().getDrawable(R.drawable.clicked11));
                }
            }
        });
        toggleButtons[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButtons[11].isChecked()){
                    toggleButtons[11].setBackgroundDrawable(getResources().getDrawable(R.drawable.clicked12));
                }
            }
        });
        toggleButtons[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButtons[12].isChecked()){
                    toggleButtons[12].setBackgroundDrawable(getResources().getDrawable(R.drawable.clicked13));
                }
            }
        });
        toggleButtons[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButtons[13].isChecked()){
                    toggleButtons[13].setBackgroundDrawable(getResources().getDrawable(R.drawable.clicked14));
                }
            }
        });
        toggleButtons[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButtons[14].isChecked()){
                    toggleButtons[14].setBackgroundDrawable(getResources().getDrawable(R.drawable.clicked15));
                }
            }
        });


        Button btnSurvey2 = findViewById(R.id.btnSurvey2);
        btnSurvey2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMainActivity();
            }
        });
    }

    private void startMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //로그인 상태에서 뒤로가기 했을 때 로그인 창 안나오게
        startActivity(intent);
    }


}