package app.com.br.calculoimc.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import app.com.br.calculoimc.R;
import app.com.br.calculoimc.entidade.Imc;

/**
 * Created by Andre on 27/05/2016.
 */
public class FragmentListaIMC extends Fragment {

    private ListView lstImc;
    private List<Imc> listaImc;
//    private ImcDAO imcDAO;
    private ArrayAdapter adapter;
    private int posicaoSelecionada;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragments_lista_imc, container, false);

        //conexao com BD
        //busca no BD pra trazer os imcs
        //popula o array

        String[] alunos = {"Andre", "Paula", "Valeria", "Domenico", "Livia", "Vander","Andre", "Paula", "Valeria", "Domenico", "Livia", "Vander"};
        lstImc = (ListView) view.findViewById(R.id.lstImc);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1, alunos);
        lstImc.setAdapter(adapter);

        return view;
    }
}
