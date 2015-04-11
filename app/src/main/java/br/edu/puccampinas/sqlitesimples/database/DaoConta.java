package br.edu.puccampinas.sqlitesimples.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.List;

import br.edu.puccampinas.sqlitesimples.dominio.Conta;

/**
 * Created by mateusdias on 11/04/15.
 */
public class DaoConta {

    private SQLiteHelper helper;
    private SQLiteDatabase db;
    private static final String TABLE_CONTA = "Conta";

    public DaoConta(Context context){
        helper = new SQLiteHelper(context);
    }

    public void open() throws SQLException{
        db = helper.getWritableDatabase();
    }

    public void close(){
        helper.close();
    }

    //Transforma uma conta em um mapa (ContentValues) e
    //usa o recurso da classe db (metodo insert)
    public Long insert(Conta c){
        open();
        Long insertedId = Long.valueOf(-1);

        ContentValues values = new ContentValues();
        values.put("usuario",c.getUsuario());
        values.put("senha",c.getSenha());

        try{
            insertedId = db.insert(TABLE_CONTA,null,values);
        }catch (SQLiteException ex){
            close();
        }
        close();
        return insertedId;
    }

    public List<Conta> selectAll(){
        List<Conta> contas = new ArrayList<>();
        open();
        try{
            Cursor c = db.rawQuery("Select * from Conta",null);
            if(c.getCount() > 0){
                c.moveToFirst();
                Conta conta;
                do{
                    conta = new Conta();
                    conta.setId(c.getLong(c.getColumnIndex("id")));
                    conta.setUsuario(c.getString(c.getColumnIndex("usuario")));
                    conta.setSenha(c.getString(c.getColumnIndex("senha")));
                    contas.add(conta);
                }while (c.moveToNext());
                c.close();
            }
        }catch (SQLiteException ex){
            close();
        }
        close();
        return contas;
    }

























}
