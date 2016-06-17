package app.com.br.calculoimc.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import app.com.br.calculoimc.entidade.Imc;
import app.com.br.calculoimc.util.Constantes;

/**
 * Created by Andre on 30/05/2016.
 */
public class ImcDAO extends SQLiteOpenHelper {


    public ImcDAO(Context context) {
        super(context, Constantes.BD_NOME, null, Constantes.BD_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS tb_imc ( ");
        sql.append(" id_imc INTEGER PRIMARY KEY AUTOINCREMENT,");
        sql.append(" peso REAL NOT NULL,");
        sql.append(" altura REAL NOT NULL,");
        sql.append(" resultado REAL NOT NULL,");
        sql.append(" tipo TEXT NOT NULL)");

        db.execSQL(sql.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public void insereImc(Imc imc) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = getContentValues(imc);
        db.insert("tb_imc", null, cv);
    }

    @NonNull
    private ContentValues getContentValues(Imc imc) {
        ContentValues cv = new ContentValues();
        cv.put("peso", imc.getPeso());
        cv.put("altura", imc.getAltura());
        cv.put("resultado", imc.getResultado());
        cv.put("tipo", imc.getTipo());
        return cv;
    }

    public List<Imc> listarImc(){
        List<Imc> list = new ArrayList<Imc>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query("tb_imc", null, null, null, null, null, "id_imc");
        while(c.moveToNext()){
            Imc imc = new Imc();
            setImcFromCursor(c, imc);
            list.add(imc);
        }
        return list;
    }

    private void setImcFromCursor(Cursor c, Imc imc) {
        imc.setIdImc(c.getInt(c.getColumnIndex("id_imc")));
        imc.setPeso(c.getDouble(c.getColumnIndex("peso")));
        imc.setAltura(c.getDouble(c.getColumnIndex("altura")));
        imc.setResultado(c.getDouble(c.getColumnIndex("resultado")));
        imc.setTipo(c.getString(c.getColumnIndex("tipo")));
    }

    public Imc consultaImcId(int id){
        Imc imc = new Imc();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query("tb_imc", null, "id_imc = ?", new String[]{String.valueOf(id)}, null, null, "id_imc");

        if(c.moveToNext()){
            setImcFromCursor(c, imc);
        }
        return imc;
    }

    public void removeImc(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("tb_imc", "id_imc = ?", new String[]{String.valueOf(id)});
    }
}
