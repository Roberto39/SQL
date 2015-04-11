package br.edu.puccampinas.sqlitesimples;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Main extends ActionBarActivity implements View.OnClickListener {

    private Button btnNovaConta;
    private Button btnContasCadastradas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNovaConta = (Button)this.findViewById(R.id.btnNovaConta);
        btnNovaConta.setOnClickListener(this);

        btnContasCadastradas = (Button)this.findViewById(R.id.btnContasCadastradas);
        btnContasCadastradas.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        Intent i;

        switch (v.getId()){
            case R.id.btnNovaConta:
                i = new Intent(Main.this,NovaConta.class);
                startActivity(i);
                break;
            case R.id.btnContasCadastradas:
                i = new Intent(Main.this,ContasCadastradas.class);
                startActivity(i);
                break;
        }


    }
}
