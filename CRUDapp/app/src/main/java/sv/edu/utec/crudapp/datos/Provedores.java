package sv.edu.utec.crudapp.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import sv.edu.utec.crudapp.MensajesFragment;
import sv.edu.utec.crudapp.entidades.EntProvedores;

public class Provedores extends BaseHelper {
    Context contex;
    public Provedores(Context context) {
        super(context);
    }
    //Context context;



    /*
     "CODPROV INTEGER PRIMARY KEY AUTOINCREMENT ,"+
             "NOMPROV TEXT NOT NULL ,"+
             "TELPROV TEXT NOT NULL ,"+
             "CORPROV TEXT NOT NULL"
    */
    public long insertProvedor(String NOMPROV,String TELPROV, String CORPROV){

        long codigo=0;
        try {

          BaseHelper baseHelp = new BaseHelper(contex);
          SQLiteDatabase bd = baseHelp.getWritableDatabase();

          ContentValues valoresProv = new ContentValues();
          valoresProv.put("NOMPROV", NOMPROV);
          valoresProv.put("TELPROV", TELPROV);
          valoresProv.put("CORPROV", CORPROV);

            codigo= bd.insert(NOMBRE_TABLAPR, null, valoresProv);
          return codigo;
      }
      catch (Exception ex){
          ex.toString();
          return codigo=0;
      }

    }

    public ArrayList<EntProvedores> mostrarProvedor(){
        BaseHelper baseHelp = new BaseHelper(contex);
        SQLiteDatabase bd = baseHelp.getWritableDatabase();
        ArrayList<EntProvedores>listaProvedores=new ArrayList<>();
        EntProvedores entProvedores=null;
        Cursor cursorPrverdor;

        cursorPrverdor=bd.rawQuery("SELECT CODPROV,NOMPROV,TELPROV,CORPROV from "+NOMBRE_TABLAPR,null);
        if(cursorPrverdor.moveToFirst())
        {
            do{
                entProvedores= new EntProvedores();
                entProvedores.setCODPROV(cursorPrverdor.getInt(0));
                entProvedores.setNOMPROV(cursorPrverdor.getString(1));
                entProvedores.setTELPROV(cursorPrverdor.getString(2));
                entProvedores.setCORPROV(cursorPrverdor.getString(3));
                listaProvedores.add(entProvedores);
            }
            while(cursorPrverdor.moveToNext());
        }
        cursorPrverdor.close();
        return listaProvedores;
    }

}
