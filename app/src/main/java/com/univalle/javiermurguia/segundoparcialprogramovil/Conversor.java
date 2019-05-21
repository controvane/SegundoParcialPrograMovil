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
        this.textoResultado.setFocusable(false);
        switch (this.operacion){
            case "CentAKelv":
                this.textoOperacion.setText("Centigrados a Kelvin");
                this.textoPrimerArgumento.setHint("Centigrados");
                this.textoResultado.setHint("Kelvin");
                break;
            case "CentAFahr":
                this.textoOperacion.setText("Centigrados a Fahrenheit");
                this.textoPrimerArgumento.setHint("Centigrados");
                this.textoResultado.setHint("Fahrenheit");
                break;
            case "FahrACent":
                this.textoOperacion.setText("Fahrenheit a Centigrados");
                this.textoPrimerArgumento.setHint("Fahrenheit");
                this.textoResultado.setHint("Centigrados");
                break;
            case "KelvAFahr":
                this.textoOperacion.setText("Kelvin a Fahrenheit");
                this.textoPrimerArgumento.setHint("Kelvin");
                this.textoResultado.setHint("Fahrenheit");
                break;
            case "MetACent":
                this.textoOperacion.setText("Metros a Centimetros");
                this.textoPrimerArgumento.setHint("Metros");
                this.textoResultado.setHint("Centimetros");
                break;
            case "CentAMet":
                this.textoOperacion.setText("Centimetros a Metros");
                this.textoPrimerArgumento.setHint("Centimetros");
                this.textoResultado.setHint("Metros");
                break;
            case "CentAInch":
                this.textoOperacion.setText("Centimetros a Pulgadas");
                this.textoPrimerArgumento.setHint("Centimetros");
                this.textoResultado.setHint("Pulgadas");
                break;
            case "InchACent":
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
                            Conversor.this.setTextoResultado(arg+"");
                            break;
                        case "CentAFahr":
                            arg = (arg*(9/5))+32;
                            Conversor.this.setTextoResultado(arg+"");
                            break;
                        case "FahrACent":
                            arg = ((arg-32)*(5/9));
                            Conversor.this.setTextoResultado(arg+"");
                            break;
                        case "KelvAFahr":
                            arg = ((arg-273)*(9/5))+32;
                            Conversor.this.setTextoResultado(arg+"");
                            break;
                        case "MetACent":
                            arg = arg * (100);
                            Conversor.this.setTextoResultado(arg+"");
                            break;
                        case "CentAMet":
                            arg = arg / (100);
                            Conversor.this.setTextoResultado(arg+"");
                            break;
                        case "CentAInch":
                            arg = arg/(2.54);
                            Conversor.this.setTextoResultado(arg+"");
                            break;
                        case "InchACent":
                            arg = arg * (2.54);
                            Conversor.this.setTextoResultado(arg+"");
                            break;
                    }
                }
                catch(Exception ex){

                }
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
