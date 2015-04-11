package br.edu.puccampinas.sqlitesimples;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

import br.edu.puccampinas.sqlitesimples.adapters.AdapterConta;
import br.edu.puccampinas.sqlitesimples.database.DaoConta;
import br.edu.puccampinas.sqlitesimples.dominio.Conta;


public class ContasCadastradas extends ActionBarActivity {

    private ListView listContas;
    private DaoConta daoConta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contas_cadastradas);
        daoConta = new DaoConta(this);
        listContas = (ListView)this.findViewById(R.id.listContas);
    }

    @Override
    protected void onStart() {
        super.onStart();
        carregarContas();
    }

    private void carregarContas(){
        List<Conta> contas = daoConta.selectAll();
        AdapterConta adapterConta = new AdapterConta(ContasCadastradas.this,R.layout.listcontas_row,contas);
        listContas.setAdapter(adapterConta);
        adapterConta.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contas_cadastradas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_voltar) {
            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
