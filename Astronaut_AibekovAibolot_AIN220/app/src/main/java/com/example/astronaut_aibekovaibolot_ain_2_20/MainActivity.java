package com.example.astronaut_aibekovaibolot_ain_2_20;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText wishes;
    Button sendWishes1;
    Button sendWishes2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        clickListener();
    }

    public void init() {
        wishes = findViewById(R.id.et_my_wishes_to_astronavt);
        sendWishes1 = findViewById(R.id.btn_send);
        sendWishes2 = findViewById(R.id.btn_send);
    }
    public void  clickListener(){
        sendWishes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendWishes1.setVisibility(View.INVISIBLE);
                wishes.setVisibility(View.VISIBLE);
                wishes.setCursorVisible(true);
                sendWishes2.setVisibility(View.VISIBLE);
            }
        });
        sendWishes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
    }
    @SuppressLint("IntentReset")
    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT,wishes.getText().toString());
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finish", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There is no email client installed.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
