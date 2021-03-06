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

import app.com.br.calculoimc.R;
import app.com.br.calculoimc.entidade.Rcq;
import app.com.br.calculoimc.util.ClassificacaoRcq;
import app.com.br.calculoimc.util.Sexo;

/**
 * Created by Andre on 27/05/2016.
 */
public class FragmentCalculaRCQ extends Fragment {

    private Button btnLimpar, btnCalcular;
    private TextView txtCintura, txtQuadril, txtResultado, txtTipo, txtIdade, txtFrase;
    private TextInputLayout lytTxtCintura, lytTxtQuadril;
    private RadioGroup rdgSexo;
    private Rcq rcq = new Rcq();
    private Sexo sexo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragments_calcula_rcq, container, false);

        txtFrase = (TextView) view.findViewById(R.id.txtFraseRcq);
        txtTipo = (TextView) view.findViewById(R.id.txtTipoRcq);
        txtCintura = (TextView) view.findViewById(R.id.edtCintura);
        txtQuadril = (TextView) view.findViewById(R.id.edtQuadril);
//        txtIdade = (TextView) view.findViewById(R.id.edtIdade);
        txtResultado = (TextView) view.findViewById(R.id.TxtResultadoRcq);
        lytTxtCintura = (TextInputLayout) view.findViewById(R.id.lytTxtCintura);
        lytTxtQuadril = (TextInputLayout) view.findViewById(R.id.lytTxtQuadril);
        rdgSexo = (RadioGroup) view.findViewById(R.id.rdgSexo);
        txtResultado.setEnabled(false);

        //trata o botão calcular
        btnCalcular = (Button) view.findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(!validaCampos()){
                    return;
                }else if(txtCintura.getText().toString().isEmpty() && txtQuadril.getText().toString().isEmpty()){
                    Snackbar.make(view, getResources().getString(R.string.camposObrig), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }else{
                    calculaRcq();
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
                limpaCamposRCQ();
            }
        });

        return view;
    }

    private boolean validaCampos(){
        if(txtCintura.getText().toString().trim().isEmpty()){
            lytTxtCintura.setError(getResources().getString(R.string.campoCintura));
        }else{
            lytTxtCintura.setErrorEnabled(false);
        }
        if(txtQuadril.getText().toString().trim().isEmpty()){
            lytTxtQuadril.setError(getResources().getString(R.string.campoQuadril));
        }else{
            lytTxtQuadril.setErrorEnabled(false);
        }
//        if(txtIdade.getText().toString().trim().isEmpty()){
//            txtIdade.setError(getResources().getString(R.string.campoIdade));
//        }
        return true;
    }

    private void calculaRcq(){
        ClassificacaoRcq classificacaoRcq = new ClassificacaoRcq();
        double cintura = Double.parseDouble(txtCintura.getText().toString());
        double quadril = Double.parseDouble(txtQuadril.getText().toString());
//        int idade = Integer.parseInt(txtIdade.getText().toString());

        switch (rdgSexo.getCheckedRadioButtonId()){
            case R.id.rdbFemi:
                sexo = Sexo.FEMININO;
                break;
            case R.id.rdbMasc:
                sexo = Sexo.MASCULINO;
                break;
        }

        txtResultado.setText(String.format("%.2f", trataValores(cintura, quadril)));

        montaRcq(cintura, quadril, trataValores(cintura, quadril), classificacaoRcq.classificaRcq(trataValores(cintura, quadril), sexo), classificacaoRcq.getFrase());
        txtTipo.setText(getResources().getString(Integer.parseInt(rcq.getTipo())));
        txtTipo.setTextColor(Color.parseColor(classificacaoRcq.getCor()));
        txtResultado.setTextColor(Color.parseColor(classificacaoRcq.getCor()));
        txtFrase.setText(getResources().getString(Integer.parseInt(classificacaoRcq.getFrase())));
        txtFrase.setTextColor(Color.parseColor(classificacaoRcq.getCor()));
    }

    private double trataValores(double cintura, double quadril) {
        double resultado = 0;
        if (quadril > 0 && cintura > 0) {
            resultado = (cintura / quadril);
        } else{
            resultado = resultado;
        }
        return resultado;
    }

    private void limpaCamposRCQ(){
        txtCintura.setText("");
        txtQuadril.setText("");
//        txtIdade.setText("");
        txtResultado.setText("");
        txtTipo.setText("");
        txtFrase.setText("");
        rdgSexo.check(R.id.rdbFemi);
    }

    private Rcq montaRcq(double cintura, double quadril, double resultado, String tipo, String frase){
        rcq.setCintura(cintura);
        rcq.setQuadril(quadril);
//        rcq.setIdade(idade);
        switch (rdgSexo.getCheckedRadioButtonId()){
            case R.id.rdbFemi:
                rcq.setSexo(Sexo.FEMININO);
                break;
            case R.id.rdbMasc:
                rcq.setSexo(Sexo.MASCULINO);
                break;
        }
        rcq.setResultado(resultado);
        rcq.setTipo(tipo);
        rcq.setFrase(frase);
        return rcq;
    }

}
