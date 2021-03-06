package app.com.br.calculoimc.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import app.com.br.calculoimc.DAO.ImcDAO;
import app.com.br.calculoimc.R;
import app.com.br.calculoimc.entidade.Imc;
import app.com.br.calculoimc.util.ClassificacaoImc;
import app.com.br.calculoimc.util.Sexo;

/**
 * Created by Andre on 27/05/2016.
 */
public class FragmentCalculaIMC extends Fragment {

    private Button btnLimpar, btnCalcular, btnGravar;
    private TextView txtPeso, txtAltura, txtResultado, txtTipo, txtFrase, txtPesoIdeal;
    private TextInputLayout lytTxtPeso, lytTxtAltura;
    private RadioGroup rdgSexo;
    Imc imc = new Imc();
    private Sexo sexo;
    private ImcDAO dao;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragments_calcula_imc, container, false);

        txtPesoIdeal = (TextView) view.findViewById(R.id.txtPesoIdeal);
        txtFrase = (TextView) view.findViewById(R.id.txtFrase);
        txtTipo = (TextView) view.findViewById(R.id.txtTipo);
        txtPeso = (TextView) view.findViewById(R.id.edtPeso);
        txtAltura = (TextView) view.findViewById(R.id.edtAltura);
        txtResultado = (TextView) view.findViewById(R.id.TxtResultadoRcq);
        lytTxtPeso = (TextInputLayout) view.findViewById(R.id.lytTxtPeso);
        lytTxtAltura = (TextInputLayout) view.findViewById(R.id.lytTxtAltura);
        rdgSexo = (RadioGroup) view.findViewById(R.id.rdg_sexo);
        txtResultado.setEnabled(false);

        //trata o botão calcular
        btnCalcular = (Button) view.findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(!validaCampos()){
                    return;
                }else if(txtPeso.getText().toString().isEmpty() && txtAltura.getText().toString().isEmpty()){
                    Snackbar.make(view, getResources().getString(R.string.camposObrig), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }else if(txtPeso.getText().toString().isEmpty() || txtAltura.getText().toString().isEmpty()){
                    Snackbar.make(view, getResources().getString(R.string.camposObrig), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }else{
                    calculaImc();
                }
            }
        });
        //esconde o teclado quando clica no botão
        btnCalcular = (Button) view.findViewById(R.id.btnCalcular);
        btnCalcular.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.onTouchEvent(event);
                InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
                return true;
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

        return view;
    }

    private boolean validaCampos(){
        if(txtPeso.getText().toString().trim().isEmpty()){
            lytTxtPeso.setError(getResources().getString(R.string.campoPeso));
        }else{
            lytTxtPeso.setErrorEnabled(false);
        }
        if(txtAltura.getText().toString().trim().isEmpty()){
            lytTxtAltura.setError(getResources().getString(R.string.campoAltura));
        }else{
            lytTxtAltura.setErrorEnabled(false);
        }
        return true;
    }

    private void calculaImc(){
        ClassificacaoImc classificacaoImc = new ClassificacaoImc();
        double peso = Double.parseDouble(txtPeso.getText().toString());
        double altura = Double.parseDouble(txtAltura.getText().toString());
        double pesoIdeal = 0;
        switch (rdgSexo.getCheckedRadioButtonId()){
            case R.id.rdb_female:
                pesoIdeal = (21 * Math.pow(altura, 2));
                break;
            case R.id.rdb_male:
                pesoIdeal = (22 * Math.pow(altura, 2));
                break;
        }
        txtResultado.setText(String.format("%.2f", trataValores(peso, altura)));
        montaImc(peso, altura, trataValores(peso, altura), classificacaoImc.classificaImc(trataValores(peso, altura)), classificacaoImc.getFrase(), pesoIdeal);
        txtTipo.setText(getResources().getString(Integer.parseInt(imc.getTipo())));
        txtTipo.setTextColor(Color.parseColor(classificacaoImc.getCor()));
        txtResultado.setTextColor(Color.parseColor(classificacaoImc.getCor()));
        txtFrase.setText(getResources().getString(Integer.parseInt(classificacaoImc.getFrase())));
        txtFrase.setTextColor(Color.parseColor(classificacaoImc.getCor()));
        if(trataValores(peso, altura) > 0){
            txtPesoIdeal.setText(getResources().getString(Integer.parseInt(classificacaoImc.getPesoIdeal())) + " " + String.format("%.2f", pesoIdeal));
            txtPesoIdeal.setTextColor(Color.parseColor(classificacaoImc.getCor()));
        }else{
            txtPesoIdeal.setText("");
            txtPesoIdeal.setTextColor(Color.parseColor("#ffffff"));
        }

    }

    private void limpaCampos(){
        txtPeso.setText("");
        txtAltura.setText("");
        txtResultado.setText("");
        txtTipo.setText("");
        txtFrase.setText("");
        txtPesoIdeal.setText("");
        rdgSexo.check(R.id.rdb_female);
    }

    private Imc montaImc(double peso, double altura, double resultado, String tipo, String frase, double pesoIdeal){
        imc.setPeso(peso);
        imc.setAltura(altura);
        imc.setResultado(resultado);
        imc.setTipo(tipo);
        imc.setFrase(frase);
        imc.setPesoIdeal(pesoIdeal);
        return imc;
    }

    private double trataValores(double peso, double altura){
        double resultado = 0;
        if(peso > 0 && altura > 0){
            resultado = (peso/Math.pow(altura, 2));
        }else{
            resultado = resultado;
        }
        return resultado;
    }
}
