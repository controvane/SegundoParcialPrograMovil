package com.univalle.javiermurguia.segundoparcialprogramovil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botonCentAKelv;
    private Button botonCentAFahr;
    private Button botonFahrACent;
    private Button botonKelvAFahr;
    private Button botonMetACent;
    private Button botonCentAMet;
    private Button botonCentAInch;
    private Button botonInchACent;
    private String operacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.botonCentAKelv = (Button) findViewById(R.id.botonCentAKelv);
        this.botonCentAFahr = (Button) findViewById(R.id.botonCentaFahr);
        this.botonFahrACent = (Button) findViewById(R.id.botonFahrACent);
        this.botonKelvAFahr = (Button) findViewById(R.id.botonKelvAFahr);
        this.botonMetACent = (Button) findViewById(R.id.botonMetACent);
        this.botonCentAMet = (Button) findViewById(R.id.botonCentAMet);
        this.botonCentAInch = (Button) findViewById(R.id.botonCentAInch);
        this.botonInchACent = (Button) findViewById(R.id.botonInchACent);

        this.botonCentAKelv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.setOperacion("CentAKelv");
                MainActivity.this.iniciarConversion();
            }
        });

        this.botonCentAFahr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.setOperacion("CentAFahr");
                MainActivity.this.iniciarConversion();
            }
        });

        this.botonFahrACent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.setOperacion("FahrACent");
                MainActivity.this.iniciarConversion();
            }
        });

        this.botonKelvAFahr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.setOperacion("KelvAFahr");
                MainActivity.this.iniciarConversion();
            }
        });

        this.botonMetACent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.setOperacion("MetACent");
                MainActivity.this.iniciarConversion();
            }
        });

        this.botonCentAMet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.setOperacion("CentAMet");
                MainActivity.this.iniciarConversion();
            }
        });

        this.botonCentAInch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.setOperacion("CentAInch");
                MainActivity.this.iniciarConversion();
            }
        });

        this.botonInchACent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.setOperacion("InchACent");
                MainActivity.this.iniciarConversion();
            }
        });
    }

    public void setOperacion(String operacion){
        this.operacion = operacion;
    }

    public String getOperacion(){
        return this.operacion;
    }

    public void iniciarConversion(){
        Intent intento = new Intent(this,Conversor.class);
        intento.putExtra("operacion",this.operacion);
        startActivity(intento);
    }


}
