package app.com.br.calculoimc.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import app.com.br.calculoimc.DAO.ImcDAO;
import app.com.br.calculoimc.R;
import app.com.br.calculoimc.entidade.Imc;
import app.com.br.calculoimc.util.ClassificacaoImc;

/**
 * Created by Andre on 27/05/2016.
 */
public class FragmentCalculaIMC extends Fragment {

    private Button btnLimpar, btnCalcular, btnGravar;
    private TextView txtPeso, txtAltura, txtResultado, txtTipo, txtFrase;
    private TextInputLayout lytTxtPeso, lytTxtAltura;
    Imc imc = new Imc();
    private ImcDAO dao;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragments_calcula_imc, container, false);

        txtFrase = (TextView) view.findViewById(R.id.txtFrase);
        txtTipo = (TextView) view.findViewById(R.id.txtTipo);
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
                    Snackbar.make(view, getResources().getString(R.string.camposObrig), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }else if(txtPeso.getText().toString().isEmpty() || txtAltura.getText().toString().isEmpty()){
                    Snackbar.make(view, getResources().getString(R.string.camposObrig), Snackbar.LENGTH_LONG).setAction("Action", null).show();
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
//        btnGravar = (Button) view.findViewById(R.id.btnGravar);
//        btnGravar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(!validaCampos()){
//                    return;
//                }else if(txtPeso.getText().toString().isEmpty() && txtAltura.getText().toString().isEmpty()){
//                    Snackbar.make(view, "Campos Obrigatórios!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
//                }else if(txtResultado.getText().toString().isEmpty()){
//                    Snackbar.make(view, "Para gravar precisa calcular!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
//                }else{
//                    dao = new ImcDAO(getActivity().getApplicationContext());
//                    dao.insereImc(imc);
//                    dao.close();
//                    Snackbar.make(view, "Gravando informações...", Snackbar.LENGTH_LONG).setAction("Action", null).show();
//                }
//            }
//        });

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

    public void calculaImc(){
        ClassificacaoImc classificacaoImc = new ClassificacaoImc();
        double peso = Double.parseDouble(txtPeso.getText().toString());
        double altura = Double.parseDouble(txtAltura.getText().toString());
        double resultado = (peso/Math.pow(altura, 2));
        txtResultado.setText(String.format("%.2f", resultado));
        montaImc(peso, altura, resultado, classificacaoImc.classificaImc(resultado), classificacaoImc.getFrase());
        txtTipo.setText(getResources().getString(Integer.parseInt(imc.getTipo())));
        txtTipo.setTextColor(Color.parseColor(classificacaoImc.getCor()));
        txtFrase.setText(getResources().getString(Integer.parseInt(classificacaoImc.getFrase())));
        txtFrase.setTextColor(Color.parseColor(classificacaoImc.getCor()));
    }

    public void limpaCampos(){
        txtPeso.setText("");
        txtAltura.setText("");
        txtResultado.setText("");
        txtTipo.setText("");
        txtFrase.setText("");
    }

    private Imc montaImc(double peso, double altura, double resultado, String tipo, String frase){
        imc.setPeso(peso);
        imc.setAltura(altura);
        imc.setResultado(resultado);
        imc.setTipo(tipo);
        imc.setFrase(frase);
        return imc;
    }
}
