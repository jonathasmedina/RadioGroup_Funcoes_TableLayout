package com.example.asus.radiogroup_funcoes_tablelayout;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.widget.*;

public class MainActivity extends Activity {

    EditText vTotal, recPess, opPorc;
    Button menosP, maisP, botLimp, botCalc;
    TextView svalGorj, stPagar, stpPess;
    RadioGroup radioGrupo;
    RadioButton radiO15, radiO20, radioOutro;
    Double porcentagem = 0D;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vTotal = (EditText) findViewById(R.id.vtotal);
        recPess = (EditText) findViewById(R.id.recpess);
        opPorc = (EditText) findViewById(R.id.opporc);
        botLimp = (Button) findViewById(R.id.botlimp);
        botCalc = (Button) findViewById(R.id.botcalc);
        menosP = (Button) findViewById(R.id.menos);
        maisP = (Button) findViewById(R.id.mais);
        svalGorj = (TextView) findViewById(R.id.svalgorj);
        stPagar = (TextView) findViewById(R.id.stpagar);
        stpPess = (TextView) findViewById(R.id.stppess);
        radioGrupo = (RadioGroup) findViewById(R.id.radiogrupo);
        radiO15 = (RadioButton) findViewById(R.id.radio15);
        radiO20 = (RadioButton) findViewById(R.id.radio20);
        radioOutro = (RadioButton) findViewById(R.id.radiooutro);

        recPess.setText("3");

        // List para ação nos botões

        botCalc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                calculo();

            }
        });

        // list

    }

    int radiochecked = -1;

    public void calculo() {
        try {
            Double valorT = Double.parseDouble(vTotal.getText().toString());
            Double pessoas = Double.parseDouble(recPess.getText().toString());

            if (valorT<1) {
                Toast.makeText(getApplicationContext(), " Insira Valor Total maior que zero",
                        Toast.LENGTH_SHORT).show();

            }
            if (radiochecked == -1)
                radiochecked = radioGrupo.getCheckedRadioButtonId();
            // radiochecked == R.id.radio15
            if (radiO15.isChecked()) {
                porcentagem = 0.15;
            } else if (radiO20.isChecked()) {
                porcentagem = 0.20;
            } else {
                porcentagem = Double.parseDouble("0."
                        + opPorc.getText().toString());

            }
            double valorGorjeta = valorT * porcentagem;
            double totalConta = valorT + valorGorjeta;
            double totalPessoa = totalConta / pessoas;

            // Set
            svalGorj.setText("" + valorGorjeta);
            stPagar.setText("" + totalConta);
            stpPess.setText("" + totalPessoa);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Insira um valor",
                    Toast.LENGTH_SHORT).show();
        }

        // Calculos



    }

    public void btmenos(View v) {
        String qtpessoas = recPess.getText().toString();
        if (qtpessoas.isEmpty()) {
            qtpessoas = "0";
        }
        Double qpessoas = Double.parseDouble(qtpessoas);
        if (qpessoas > 1) {
            recPess.setText((qpessoas - 1) + "");

        }

    }

    public void btmais(View v) {
        String qtpessoas = recPess.getText().toString();
        if (qtpessoas.isEmpty()) {
            qtpessoas = "0";
        }
        Double qpessoas = Double.parseDouble(qtpessoas);
        recPess.setText((qpessoas + 1) + "");
    }

    public void btlimpar(View v) {
        recPess.setText("3");
        opPorc.setText("");
        vTotal.setText("");
        vTotal.requestFocus();
        svalGorj.setText("S");
        stPagar.setText("S");
        stpPess.setText("S");

    }
}
