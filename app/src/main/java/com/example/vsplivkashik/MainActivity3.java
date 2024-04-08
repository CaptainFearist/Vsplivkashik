package com.example.vsplivkashik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MainActivity3 extends AppCompatActivity {

    Button button;
    EditText sendto, theme, body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        button = findViewById(R.id.buttonSend);
        sendto = findViewById(R.id.editTextTextEmailAddress);
        theme = findViewById(R.id.editTextText);
        body = findViewById(R.id.editTextEmailText);

        button.setOnClickListener(v -> {
            String recipient = sendto.getText().toString().trim();
            String subject = theme.getText().toString().trim();
            String message = body.getText().toString().trim();

            sendEmail(recipient, subject, message);
        });
    }

    private void sendEmail(String recipient, String subject, String message) {
        new Thread(() -> {
            final String username = "golenischev2109@mail.ru";
            final String password = "aggtafkNyDTmMWrgmG3C";

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.mail.ru");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.ssl.enable", "true");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                            return new javax.mail.PasswordAuthentication(username, password);
                        }
                    });

            try {
                Message msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress(username));
                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
                msg.setSubject(subject);
                msg.setText(message);

                Transport.send(msg);

                runOnUiThread(() -> Toast.makeText(MainActivity3.this, "Письмо успешно отправлено!", Toast.LENGTH_SHORT).show());
            } catch (MessagingException e) {
                e.printStackTrace();
                runOnUiThread(() -> Toast.makeText(MainActivity3.this, "Ошибка отправки письма!", Toast.LENGTH_SHORT).show());
            }
        }).start();
    }
    public void goToNextPageBack2(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
