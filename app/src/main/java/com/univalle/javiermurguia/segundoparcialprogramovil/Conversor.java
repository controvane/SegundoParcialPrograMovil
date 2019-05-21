package com.univalle.javiermurguia.segundoparcialprogramovil;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Conversor extends AppCompatActivity {
    private String operacion;
    private Bundle extras;
    private TextView textoOperacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        this.extras = getIntent().getExtras();
        this.operacion = extras.getString("operacion");

        this.textoOperacion = (TextView) findViewById(R.id.textoOperacion);
        this.textoOperacion.setText(this.operacion);
    }

}
