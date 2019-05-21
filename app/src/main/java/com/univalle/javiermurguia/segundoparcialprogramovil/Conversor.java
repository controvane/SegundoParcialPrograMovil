package com.univalle.javiermurguia.segundoparcialprogramovil;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Conversor extends AppCompatActivity {
    private String operacion;
    private Bundle extras;
    private TextView textoOperacion;
    private Button convertir;
    private EditText textoPrimerArgumento;
    private TextView textoResultado;
    private Button botonVolver;

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
        this.textoOperacion = (TextView) findViewById(R.id.textoOperacion);
        this.extras = getIntent().getExtras();
        this.operacion = extras.getString("operacion");
        this.convertir = (Button) findViewById(R.id.botonOperacion);
        this.textoPrimerArgumento = (EditText) findViewById(R.id.textoPrimerArgumento);
        this.textoResultado = (TextView) findViewById(R.id.textoResultado);
        this.botonVolver = (Button) findViewById(R.id.botonVolver);
        this.textoResultado.setFocusable(false);
        switch (this.operacion){
            case "CentAKelv":
                this.setTitle("Centigrados a Kelvin");
                this.textoOperacion.setText("Centigrados a Kelvin");
                this.textoPrimerArgumento.setHint("Centigrados");
                this.textoResultado.setHint("Kelvin");
                break;
            case "CentAFahr":
                this.setTitle("Centigrados a Fahrenheit");
                this.textoOperacion.setText("Centigrados a Fahrenheit");
                this.textoPrimerArgumento.setHint("Centigrados");
                this.textoResultado.setHint("Fahrenheit");
                break;
            case "FahrACent":
                this.setTitle("Fahrenheit a Centigrados");
                this.textoOperacion.setText("Fahrenheit a Centigrados");
                this.textoPrimerArgumento.setHint("Fahrenheit");
                this.textoResultado.setHint("Centigrados");
                break;
            case "KelvAFahr":
                this.setTitle("Kelvin a Fahrenheit");
                this.textoOperacion.setText("Kelvin a Fahrenheit");
                this.textoPrimerArgumento.setHint("Kelvin");
                this.textoResultado.setHint("Fahrenheit");
                break;
            case "MetACent":
                this.setTitle("Metros a Centimetros");
                this.textoOperacion.setText("Metros a Centimetros");
                this.textoPrimerArgumento.setHint("Metros");
                this.textoResultado.setHint("Centimetros");
                break;
            case "CentAMet":
                this.setTitle("Centimetros a Metros");
                this.textoOperacion.setText("Centimetros a Metros");
                this.textoPrimerArgumento.setHint("Centimetros");
                this.textoResultado.setHint("Metros");
                break;
            case "CentAInch":
                this.setTitle("Centimetros a Pulgadas");
                this.textoOperacion.setText("Centimetros a Pulgadas");
                this.textoPrimerArgumento.setHint("Centimetros");
                this.textoResultado.setHint("Pulgadas");
                break;
            case "InchACent":
                this.setTitle("Pulgadas a Centimetros");
                this.textoOperacion.setText("Pulgadas a Centimetros");
                this.textoPrimerArgumento.setHint("Pulgadas");
                this.textoResultado.setHint("Centimetros");
                break;
        }


        this.convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String operacion = Conversor.this.getOperacion();
                try{
                    Double arg = Double.parseDouble(Conversor.this.getTextoPrimerArgumento());
                    switch (operacion){
                        case "CentAKelv":
                            arg = arg + 273;
                            Conversor.this.setTextoResultado(arg+" °K");
                            break;
                        case "CentAFahr":
                            arg = (arg*(9/5))+32;
                            Conversor.this.setTextoResultado(arg+" °F");
                            break;
                        case "FahrACent":
                            arg = ((arg-32)*(5/9));
                            Conversor.this.setTextoResultado(arg+" °C");
                            break;
                        case "KelvAFahr":
                            arg = ((arg-273)*(9/5))+32;
                            Conversor.this.setTextoResultado(arg+" °F");
                            break;
                        case "MetACent":
                            arg = arg * (100);
                            Conversor.this.setTextoResultado(arg+" cm");
                            break;
                        case "CentAMet":
                            arg = arg / (100);
                            Conversor.this.setTextoResultado(arg+" m");
                            break;
                        case "CentAInch":
                            arg = arg/(2.54);
                            Conversor.this.setTextoResultado(arg+" inch");
                            break;
                        case "InchACent":
                            arg = arg * (2.54);
                            Conversor.this.setTextoResultado(arg+" cm");
                            break;
                    }
                }
                catch(Exception ex){

                }
            }
        });

        //no hace nada
        this.botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public String getOperacion() {
        return this.operacion;
    }

    public String getTextoPrimerArgumento(){
        return this.textoPrimerArgumento.getText().toString();
    }

    public void  setTextoResultado(String texto){
        this.textoResultado.setText(texto);
    }
}
