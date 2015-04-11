package br.edu.puccampinas.sqlitesimples.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mateusdias on 11/04/15.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "exemplo.db";
    private static final int DATABASE_VERSION = 1;

    public SQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(getTableConta());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(dropTableConta());
    }

    private String getTableConta(){
        return "CREATE TABLE Conta(" +
                "id integer primary key autoincrement," +
                "usuario text not null," +
                "senha text not null);";
    }

    private String dropTableConta(){
        return "DROP TABLE Conta;";
    }

}
