package br.edu.puccampinas.sqlitesimples.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.puccampinas.sqlitesimples.R;
import br.edu.puccampinas.sqlitesimples.dominio.Conta;

/**
 * Created by mateusdias on 11/04/15.
 */
public class AdapterConta extends ArrayAdapter<Conta> {

    private int resource;
    private LayoutInflater inflater;

    public AdapterConta(Context context, int resourceId, List<Conta> contas){
        super(context,resourceId,contas);
        resource = resourceId;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;

        if(convertView == null){
            vi = inflater.inflate(resource,null);
        }

        Conta c = getItem(position);

        TextView tvContaId = (TextView)vi.findViewById(R.id.tvContaID);
        tvContaId.setText(c.getId().toString());

        TextView tvContaUsuario = (TextView)vi.findViewById(R.id.tvContaUsuario);
        tvContaUsuario.setText(c.getUsuario().toString());

        TextView tvContaSenha = (TextView)vi.findViewById(R.id.tvContaSenha);
        tvContaSenha.setText(c.getSenha().toString());

        return vi;

    }





















}
