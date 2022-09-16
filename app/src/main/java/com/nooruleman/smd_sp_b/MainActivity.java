package com.nooruleman.smd_sp_b;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView add;
    TextView tv;
    SharedPreferences mPref;
    SharedPreferences.Editor editmPref;
    int count;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=findViewById(R.id.add);
        tv=findViewById(R.id.tv);

        mPref=getSharedPreferences("com.nooruleman.smd_sp_b",MODE_PRIVATE);
        editmPref=mPref.edit();

        count=mPref.getInt("count",0);
        tv.setText(count+"");
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                tv.setText(count+"");

            }
        });
    }
    @Override
    protected void onPause(){
        super.onPause();
        editmPref.putInt("count",count);
        editmPref.apply();
        editmPref.commit();
    }

    @Override
    protected void onResume(){
        super.onResume();
        editmPref.putInt("count",0);
        tv.setText(count+"");
    }
}