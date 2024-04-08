package com.example.vsplivkashik;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    Button button;
    EditText sendto, subject, body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        sendto = findViewById(R.id.editTextTextEmailAddress);
        subject = findViewById(R.id.editTextText);
        body = findViewById(R.id.editTextEmailText);
        button = findViewById(R.id.buttonSend);

        button.setOnClickListener(view -> {
            String emailsend = sendto.getText().toString();
            String emailsubject = subject.getText().toString();
            String emailbody = body.getText().toString();

            Intent intent = new Intent(Intent.ACTION_SEND);

            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailsend});
            intent.putExtra(Intent.EXTRA_SUBJECT, emailsubject);
            intent.putExtra(Intent.EXTRA_TEXT, emailbody);

            intent.setType("message/rfc822");

            intent.setPackage("com.google.android.gm");

            startActivity(intent);
        });
    }
}
