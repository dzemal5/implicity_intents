package com.example.implicity_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextMessage;
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.button_send);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, editTextMessage.getText().toString());
                intent.setType("text/plain");

                if(intent.resolveActivity(getPackageManager()) != null) {
                    Intent chooser = Intent.createChooser(intent, "Send a message");
                    startActivity(chooser);
                } else  {
                    Toast.makeText(getApplicationContext(), "There isn't any app to handle this action", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}