package ifpb.edu.br.listviewapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements TextWatcher{


    @BindView(R.id.etBusca) EditText etBusca;
    @BindView(R.id.lvNomes) ListView lvNomes;
    ArrayAdapter<String> adapter;
    List<String> nomes;
    List<String> pesquisa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        nomes = new ArrayList<>();

        nomes.add("Gabriel Almeida");
        nomes.add("Romulo Ricardo");
        nomes.add("Fabricia Almeida");
        nomes.add("Marcio Lemos");
        nomes.add("Mariana Lira");
        nomes.add("Savio Azevedo");

        etBusca.addTextChangedListener(this);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, nomes);

        lvNomes.setAdapter(adapter);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        adapter.getFilter().filter(s);



    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}