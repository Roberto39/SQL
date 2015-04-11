package br.edu.puccampinas.sqlitesimples;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.puccampinas.sqlitesimples.database.DaoConta;
import br.edu.puccampinas.sqlitesimples.dominio.Conta;


public class NovaConta extends ActionBarActivity {

    private EditText editUsuario;
    private EditText editSenha;
    private DaoConta daoConta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_conta);

        daoConta = new DaoConta(this);

        editUsuario = (EditText)this.findViewById(R.id.editUsuario);
        editSenha = (EditText)this.findViewById(R.id.editSenha);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nova_conta, menu);
        return true;
    }

    private void limparViews(){
        editUsuario.setText("");
        editSenha.setText("");
    }

    private void salvar(){
        if(editUsuario.getText().toString().trim().length() > 0){
            if(editSenha.getText().toString().trim().length() > 0){
                //cadastrar...
                Conta c = new Conta();
                c.setUsuario(editUsuario.getText().toString());
                c.setSenha(editSenha.getText().toString());
                Long insertedId = daoConta.insert(c);
                if(insertedId > -1){
                    Toast.makeText(this,"Nova conta ID = " + insertedId.toString(),Toast.LENGTH_LONG).show();
                    limparViews();
                }else{
                    Toast.makeText(this,"Erro ao inserir conta.", Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(this,"É necessário informar a senha.", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this,"É necessário informar o usuário.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        Boolean realizado = false;

        switch (id){
            case R.id.action_salvar:
                salvar();
                realizado = true;
                break;
            case R.id.action_voltar:
                this.finish();
                break;
        }
        return realizado;
    }
}
