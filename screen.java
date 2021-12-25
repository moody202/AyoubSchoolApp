package com.ayoubschool.ayoubapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.ayoubschool.ayoubapp.BuildConfig;


public class screen extends AppCompatActivity {

    Handler handler=new Handler();
    Button nameapp;
    TextView vergen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_screen);
        nameapp=findViewById(R.id.nameapp);
        nameapp.setText("Ayoub App");
        vergen=findViewById(R.id.vergen);
        vergen.setText(BuildConfig.VERSION_NAME);


        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                run_activity();
            }

        };
        handler.postDelayed(runnable,3*1000);



    }
    public void run_activity(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}