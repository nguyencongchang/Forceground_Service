package com.example.forceground_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtthongbao;
    Button btnstart,btnstop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickstart();
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickstop();

            }
        });
    }

    private void clickstop() {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }
    private void clickstart() {
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("key",edtthongbao.getText().toString().trim());
        startService(intent);
    }

    private void AnhXa() {
        edtthongbao = (EditText)findViewById(R.id.EDTTHONGBAO);
        btnstart = (Button) findViewById(R.id.BTNSTART);
        btnstop = (Button)findViewById(R.id.BTNSTOP);
    }
}