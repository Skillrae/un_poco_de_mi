package com.example.acerca_de_mi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private ImageButton etbtnregresar;
    private ImageButton etbtnlink;
    private ImageButton etbtnwsp;
    private ImageButton etbtngmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etbtnregresar = findViewById(R.id.regresar);
        etbtnlink = findViewById(R.id.btnlink);
        etbtnwsp = findViewById(R.id.bntwsp);
        etbtngmail = findViewById(R.id.btngmail);

        Intent intent = getIntent();

        // Primero configuramos el boton para regresar al primer main
        etbtnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra esta actividad presente y regresa a la anterior
                finish();
            }
        });

        // Segundo configuramos el boton que une a LinkedIn
        etbtnlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String url = "https://www.linkedin.com/in/richard-diaz-rivera-01a093b5/";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                } catch (android.content.ActivityNotFoundException e) {
                    // Se muestra un mensaje si falla el programa por no encontrar la aplicacion requerida
                    Toast.makeText(v.getContext(), "No se encontró un navegador instalado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Tercero creamos el boton que nos dirigira a Whatsapp
        etbtnwsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nro = "56985835246";
                String urlWsp = "https://api.whatsapp.com/send?phone=" + nro;

                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlWsp));
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(v.getContext(), "La aplicacion WhatsApp,no está instalado en este dispositivo", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Cuarto creamos el boton que nos dirigira al Gmail
        etbtngmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailDestino = "richard.diaz.rivera@gmail.com";

                Intent intentEmail = new Intent(Intent.ACTION_SENDTO);
                // Con esto nos aseguramos que nos de opciones de aplicaciones de email
                intentEmail.setData(Uri.parse("mailto:"));

                // El destinatario debe ir en un Array de Strings
                intentEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{emailDestino});

                try {
                    // Nos lanza aplicaciones que sean de email
                    startActivity(Intent.createChooser(intentEmail, "Enviar correo con..."));
                } catch (android.content.ActivityNotFoundException e) {
                    Toast.makeText(v.getContext(), "No tienes ninguna aplicación para enviar emails", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}