package com.example.boundservicer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.Provider;

public class MainActivity extends AppCompatActivity implements ServiceConnection {

    TextView textCount ;
    Button btnCount ;
    Intent intent ;
    CounterService.CountBinder countBinder ;
    CounterService counterService ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textCount =(TextView) findViewById(R.id.textCount);
        btnCount =(Button)findViewById(R.id.buttonCount);
        intent =new Intent(this,CounterService.class);
        bindService(intent,this, Service.BIND_AUTO_CREATE);
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textCount.setText(""+counterService.getCounter());
            }
        });
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        countBinder = (CounterService.CountBinder) iBinder;
        counterService =countBinder.getCounterService();
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }
}