package app.com.br.calculoimc.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import app.com.br.calculoimc.DAO.ImcDAO;
import app.com.br.calculoimc.R;
import app.com.br.calculoimc.entidade.Imc;

/**
 * Created by Andre on 27/05/2016.
 */
public class FragmentListaIMC extends Fragment {

    private ListView lstImc;
    private List<Imc> listaImc;
    private ArrayAdapter adapter;
    private int posicaoSelecionada;
    private ImcDAO dao;
    private FloatingActionButton fab;
    Imc imc = new Imc();
    DecimalFormat decimalFormat = new DecimalFormat("##.##");

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragments_lista_imc, container, false);

        dao = new ImcDAO(getActivity().getApplicationContext());
        lstImc = (ListView) view.findViewById(R.id.lstImc);
        adapter = new ArrayAdapter(this.getContext(), android.R.layout.simple_list_item_1);

        setArrayAdapterImc();
        lstImc.setOnItemClickListener(clickListenerImc);

        fab = (FloatingActionButton) view.findViewById(R.id.fabDel);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imc = dao.consultaImcId(listaImc.get(posicaoSelecionada).getIdImc());
                int id = listaImc.get(posicaoSelecionada).getIdImc();
                dao.removeImc(id);
                setArrayAdapterImc();
                adapter.notifyDataSetChanged();
                dao.close();
//                Snackbar.make(view, "Excluíndo...", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        return view;
    }

    private void setArrayAdapterImc() {
        listaImc = dao.listarImc();
        List<String> valores = new ArrayList<String>();
        for(Imc i : listaImc){
            valores.add("Peso: " + i.getPeso() + " Altura: " + i.getAltura() + " IMC: " + decimalFormat.format(i.getResultado()) + "\nClassificação: " + i.getTipo());
        }
        adapter.clear();
        adapter.addAll(valores);
        lstImc.setAdapter(adapter);
    }

    private AdapterView.OnItemClickListener clickListenerImc = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Imc imc = dao.consultaImcId(listaImc.get(position).getIdImc());

            StringBuilder info = new StringBuilder();
            info.append("Peso: " + imc.getPeso());
            info.append("\nAltura: " + imc.getAltura());
            info.append("\nIMC: " + imc.getResultado());
            info.append("\nClassificação " + imc.getTipo());

            //Snackbar.make(view, imc.getIdImc() + "Selecionado", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
    };

}
