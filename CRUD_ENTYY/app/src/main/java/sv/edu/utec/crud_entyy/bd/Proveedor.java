package sv.edu.utec.crud_entyy.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import sv.edu.utec.crud_entyy.entidades.EntProvedor;

public class Proveedor extends DbHelper{
    Context context;
    public Proveedor(@Nullable Context context) {
        super(context);
        this.context=context;
    }

    public long insertProve(String nombre,String telefono,String correo){
        long id=0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues valores = new ContentValues();
            valores.put("NOMBPROV", nombre);
            valores.put("TELPROV", telefono);
            valores.put("MAILPROV", correo);

            id = db.insert(TBLNombrePRV, null, valores);
        }
        catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    public ArrayList<EntProvedor> mostrarProvedores(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList<EntProvedor> listaProve = new ArrayList<>();
        EntProvedor entProvedor = null;
        Cursor cursorProv=null;
        cursorProv= db.rawQuery("SELECT * FROM "+TBLNombrePRV,null);
        if(cursorProv.moveToFirst()){
            do{
                entProvedor= new EntProvedor();
                entProvedor.setId(cursorProv.getInt(0));
                entProvedor.setNombre(cursorProv.getString(1));
                entProvedor.setTelefono(cursorProv.getString(2));
                entProvedor.setMail(cursorProv.getString(3));
                listaProve.add(entProvedor);
            }
            while(cursorProv.moveToNext());
        }
        cursorProv.close();
        return listaProve;
    }
}
