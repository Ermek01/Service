package com.example.service.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.service.R;
import com.example.service.data.NotificationHelper;
import com.example.service.data.ServiceBuilder;

public class MainActivity extends AppCompatActivity {

    private String CHANNEL_ID = "Service";
    private Button btnPush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
        setupListeners();
    }

    private void setupListeners() {
       btnPush.setOnClickListener(v -> {
            startService(new Intent(this, ServiceBuilder.class));
       });
    }

    private void setupView(){
        btnPush = findViewById(R.id.btnPush);
    }
}
