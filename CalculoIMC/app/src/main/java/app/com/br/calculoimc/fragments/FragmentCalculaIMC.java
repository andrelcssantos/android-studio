package app.com.br.calculoimc.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import app.com.br.calculoimc.R;
import app.com.br.calculoimc.entidade.Imc;

/**
 * Created by Andre on 27/05/2016.
 */
public class FragmentCalculaIMC extends Fragment {

    private Button btnLimpar, btnCalcular;
    private TextView txtPeso, txtAltura, txtResultado;
    private TextInputLayout lytTxtPeso, lytTxtAltura;
    private FloatingActionButton fabAdd;
    private Imc imc;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragments_calcula_imc, container, false);

        txtPeso = (TextView) view.findViewById(R.id.edtPeso);
        txtAltura = (TextView) view.findViewById(R.id.edtAltura);
        txtResultado = (TextView) view.findViewById(R.id.edtResultado);
        lytTxtPeso = (TextInputLayout) view.findViewById(R.id.lytTxtPeso);
        lytTxtAltura = (TextInputLayout) view.findViewById(R.id.lytTxtAltura);
        txtResultado.setEnabled(false);

        //trata o botão calcular
        btnCalcular = (Button) view.findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(!validaCampos()){
                    return;
                }else if(txtPeso.getText().toString().isEmpty() && txtAltura.getText().toString().isEmpty()){
                    Snackbar.make(view, "Campos Obrigatórios!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }else if(txtPeso.getText().toString().isEmpty() || txtAltura.getText().toString().isEmpty()){
                    Snackbar.make(view, "Campos Obrigatórios!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }else{
                    calculaImc();
                }
            }
        });

        //trata o botão limpar
        btnLimpar = (Button) view.findViewById(R.id.btnLimpar);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                limpaCampos();
            }
        });

        //trata o floating button
        fabAdd = (FloatingActionButton) view.findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Gravando dados...", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        return view;
    }

    private boolean validaCampos(){
        if(txtPeso.getText().toString().trim().isEmpty()){
            lytTxtPeso.setError("Campo Peso Obrigatório!");
        }else{
            lytTxtPeso.setErrorEnabled(false);
        }
        if(txtAltura.getText().toString().trim().isEmpty()){
            lytTxtAltura.setError("Campo Altura Obrigatório!");
        }else{
            lytTxtAltura.setErrorEnabled(false);
        }
        return true;
    }

    public void calculaImc(){
        double peso = Double.parseDouble(txtPeso.getText().toString());
        double altura = Double.parseDouble(txtAltura.getText().toString());
        double resultado = (peso/Math.pow(altura,2));
        txtResultado.setText(String.format("%.2f",resultado));
    }

    public void limpaCampos(){
        txtPeso.setText("");
        txtAltura.setText("");
        txtResultado.setText("");
    }

    private Imc montaImc(){
        Imc imc = new Imc();
        imc.setPeso(Double.valueOf((String) txtPeso.getText()));
        imc.setAltura(Double.valueOf((String) txtAltura.getText()));
        imc.setPeso(Double.valueOf((String) txtPeso.getText()));
        imc.setResultado(Double.valueOf((String) txtResultado.getText()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date calculo = dateFormat.parse(dateFormat.toString());
            imc.setDtCalculo(calculo);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return imc;
    }

}
